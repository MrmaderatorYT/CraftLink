package com.ccs.craftlink.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.ccs.craftlink.adapter.PlayerListAdapter;
import java.util.ArrayList;
import java.util.List;

import com.ccs.craftlink.R;
import com.ccs.craftlink.adapter.ChatAdapter;
import com.ccs.craftlink.model.ChatMessage;
import com.ccs.craftlink.model.MinecraftServer;
import com.ccs.craftlink.network.MinecraftConnection;
import com.ccs.craftlink.network.ServerManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class ChatFragment extends Fragment {
    private static final String TAG = "ChatFragment";

    private RecyclerView recyclerChat;
    private EditText etChatInput;
    private FloatingActionButton btnSend;
    private TextView tvConnectionStatus;
    private View viewConnectionStatus;
    private MaterialButton btnDisconnect;
    private ChatAdapter adapter;
    private ServerManager serverManager;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private MinecraftConnection lastConnection;
    private TextInputLayout tilSearch;
    private EditText etSearch;
    private boolean searchVisible = false;
    private View viewNotConnected;
    private View chatContent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated");

        serverManager = ServerManager.getInstance(requireContext());

        recyclerChat = view.findViewById(R.id.recycler_chat);
        etChatInput = view.findViewById(R.id.et_chat_input);
        btnSend = view.findViewById(R.id.btn_send);
        tvConnectionStatus = view.findViewById(R.id.tv_connection_status);
        viewConnectionStatus = view.findViewById(R.id.view_connection_status);
        btnDisconnect = view.findViewById(R.id.btn_disconnect);
        View btnPlayers = view.findViewById(R.id.btn_players);
        tilSearch = view.findViewById(R.id.til_search);
        etSearch = view.findViewById(R.id.et_search);
        viewNotConnected = view.findViewById(R.id.view_not_connected);
        chatContent = view.findViewById(R.id.chat_content);

        setupSearch();
        setupNotConnected();

        btnPlayers.setOnClickListener(v -> {
            MinecraftConnection connection = serverManager.getActiveConnection();
            if (connection != null) {
                BottomSheetDialog dialog = new BottomSheetDialog(requireContext());
                View dialogView = getLayoutInflater().inflate(R.layout.dialog_players, null);
                
                RecyclerView rv = dialogView.findViewById(R.id.rv_players);
                android.widget.TextView tvEmpty = dialogView.findViewById(R.id.tv_empty);
                
                rv.setLayoutManager(new LinearLayoutManager(requireContext()));
                List<String> names = new ArrayList<>(connection.getPlayerNames().values());
                if (names.isEmpty()) {
                    tvEmpty.setVisibility(View.VISIBLE);
                    rv.setVisibility(View.GONE);
                } else {
                    tvEmpty.setVisibility(View.GONE);
                    rv.setVisibility(View.VISIBLE);
                    rv.setAdapter(new PlayerListAdapter(names));
                }
                
                dialog.setContentView(dialogView);
                dialog.show();
            }
        });

        setupRecyclerView();
        setupInput();
        setupDisconnectButton();
        
        // If already connected, hook up immediately
        MinecraftConnection activeConn = serverManager.getActiveConnection();
        if (activeConn != null) {
            lastConnection = activeConn;
            observeChatMessages(activeConn);
            observeConnectionState(activeConn);
        }
        
        observeConnection();
        observeServers();
    }

    private void setupRecyclerView() {
        adapter = new ChatAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        layoutManager.setStackFromEnd(true);
        recyclerChat.setLayoutManager(layoutManager);
        recyclerChat.setAdapter(adapter);
    }

    private void setupInput() {
        btnSend.setOnClickListener(v -> sendMessage());

        etChatInput.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEND) {
                sendMessage();
                return true;
            }
            return false;
        });
    }

    private void setupSearch() {
        if (tilSearch == null || etSearch == null) return;

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterMessages(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        etSearch.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                filterMessages(etSearch.getText().toString());
                return true;
            }
            return false;
        });

        tilSearch.setEndIconOnClickListener(v -> {
            etSearch.setText("");
            toggleSearch(false);
        });
    }

    public void toggleSearch(boolean show) {
        searchVisible = show;
        if (tilSearch != null) {
            tilSearch.setVisibility(show ? View.VISIBLE : View.GONE);
            if (show) {
                etSearch.requestFocus();
            } else {
                etSearch.setText("");
                adapter.setMessages(adapter.getAllMessages());
            }
        }
    }

    private void filterMessages(String query) {
        if (query.isEmpty()) {
            adapter.setMessages(adapter.getAllMessages());
            return;
        }
        List<ChatMessage> filtered = new ArrayList<>();
        for (ChatMessage msg : adapter.getAllMessages()) {
            if (msg.getContent().toLowerCase().contains(query.toLowerCase()) ||
                    msg.getSender().toLowerCase().contains(query.toLowerCase())) {
                filtered.add(msg);
            }
        }
        adapter.setMessages(filtered);
    }

    private void setupNotConnected() {
        if (viewNotConnected == null) return;

        viewNotConnected.findViewById(R.id.btn_go_to_servers).setOnClickListener(v -> {
            if (getActivity() != null) {
                ((android.widget.FrameLayout) getActivity().findViewById(R.id.fragment_container))
                        .post(() -> {
                            com.google.android.material.bottomnavigation.BottomNavigationView bnv =
                                    getActivity().findViewById(R.id.bottom_navigation);
                            if (bnv != null) {
                                bnv.setSelectedItemId(R.id.nav_servers);
                            }
                        });
            }
        });

        updateConnectedState();
    }

    private void updateConnectedState() {
        MinecraftConnection conn = serverManager.getActiveConnection();
        boolean isConnected = conn != null && conn.isConnected();

        if (viewNotConnected != null) {
            viewNotConnected.setVisibility(isConnected ? View.GONE : View.VISIBLE);
        }
        if (chatContent != null) {
            chatContent.setVisibility(isConnected ? View.VISIBLE : View.GONE);
        }
    }

    private void setupDisconnectButton() {
        btnDisconnect.setOnClickListener(v -> {
            Log.d(TAG, "Disconnect button clicked");
            serverManager.disconnectFromServer();
        });
    }

    private void observeConnection() {
        disposables.add(serverManager.observeConnectionEvents()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(server -> {
                    Log.d(TAG, "Connection event: " + server.getName());
                    MinecraftConnection connection = serverManager.getActiveConnection();
                    if (connection != null) {
                        lastConnection = connection;
                        observeChatMessages(connection);
                        observeConnectionState(connection);
                    }
                }, e -> Log.e(TAG, "Connection event error", e)));
    }

    private void observeServers() {
        disposables.add(serverManager.observeServers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(servers -> {
                    boolean anyConnected = false;
                    for (MinecraftServer s : servers) {
                        if (s.isConnected()) anyConnected = true;
                    }
                    if (!anyConnected && lastConnection != null) {
                        updateUiDisconnected();
                    }
                }));
    }

    private void observeChatMessages(MinecraftConnection connection) {
        disposables.add(connection.getChatObservable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(message -> {
                    Log.d(TAG, "Chat message: " + message.getSender() + ": " + message.getContent());
                    adapter.addMessage(message);
                    recyclerChat.scrollToPosition(adapter.getItemCount() - 1);
                }, e -> Log.e(TAG, "Chat message error", e)));
    }

    private void observeConnectionState(MinecraftConnection connection) {
        disposables.add(connection.observeConnectionState()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(state -> {
                    Log.d(TAG, "Connection state: " + state);
                    updateConnectedState();
                    switch (state) {
                        case CONNECTING:
                            tvConnectionStatus.setText("Connecting...");
                            viewConnectionStatus.setBackgroundResource(R.drawable.bg_status_offline);
                            btnDisconnect.setVisibility(View.GONE);
                            adapter.addMessage(new ChatMessage("System", "Connecting to server...", ChatMessage.MessageType.SYSTEM));
                            break;
                        case CONNECTED:
                            tvConnectionStatus.setText("Connected");
                            viewConnectionStatus.setBackgroundResource(R.drawable.bg_status_online);
                            btnDisconnect.setVisibility(View.VISIBLE);
                            if (getView() != null) getView().findViewById(R.id.btn_players).setVisibility(View.VISIBLE);
                            adapter.addMessage(new ChatMessage("System", "Connected! Sending login...", ChatMessage.MessageType.SYSTEM));
                            break;
                        case AUTHENTICATING:
                            tvConnectionStatus.setText("Authenticating...");
                            viewConnectionStatus.setBackgroundResource(R.drawable.bg_status_online);
                            adapter.addMessage(new ChatMessage("System", "Authenticating...", ChatMessage.MessageType.SYSTEM));
                            break;
                        case PLAYING:
                            tvConnectionStatus.setText("Playing");
                            viewConnectionStatus.setBackgroundResource(R.drawable.bg_status_online);
                            btnDisconnect.setVisibility(View.VISIBLE);
                            if (getView() != null) getView().findViewById(R.id.btn_players).setVisibility(View.VISIBLE);
                            adapter.addMessage(new ChatMessage("System", "Joined server!", ChatMessage.MessageType.SYSTEM));
                            break;
                        case DISCONNECTED:
                            updateUiDisconnected();
                            break;
                        case ERROR:
                            tvConnectionStatus.setText("Error");
                            viewConnectionStatus.setBackgroundResource(R.drawable.bg_status_offline);
                            btnDisconnect.setVisibility(View.GONE);
                            adapter.addMessage(new ChatMessage("System", "Connection error!", ChatMessage.MessageType.SYSTEM));
                            break;
                    }
                }, e -> Log.e(TAG, "Connection state error", e)));
    }

    private void updateUiDisconnected() {
        tvConnectionStatus.setText("Disconnected");
        viewConnectionStatus.setBackgroundResource(R.drawable.bg_status_offline);
        btnDisconnect.setVisibility(View.GONE);
        if (getView() != null) getView().findViewById(R.id.btn_players).setVisibility(View.GONE);
    }

    private void sendMessage() {
        String message = etChatInput.getText().toString().trim();
        if (!message.isEmpty()) {
            MinecraftConnection connection = serverManager.getActiveConnection();
            if (connection != null && connection.isConnected()) {
                Log.d(TAG, "Sending chat: " + message);
                connection.sendChat(message);
                etChatInput.setText("");
            } else {
                Log.w(TAG, "Cannot send - not connected");
                adapter.addMessage(new ChatMessage("System", "Not connected to server!", ChatMessage.MessageType.SYSTEM));
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        disposables.clear();
    }
}
