package com.ccs.craftlink.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ccs.craftlink.R;
import com.ccs.craftlink.network.MinecraftConnection;
import com.ccs.craftlink.network.ServerManager;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class MovementFragment extends Fragment {

    private TextView tvCoordinates;
    private com.ccs.craftlink.view.MinimapView minimapView;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private long lastJumpTime = 0;
    private float lastTouchX, lastTouchY;
    private View viewNotConnected;
    private View movementContent;
    private ServerManager serverManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movement, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        serverManager = ServerManager.getInstance(requireContext());

        tvCoordinates = view.findViewById(R.id.tvCoordinates);
        minimapView = view.findViewById(R.id.minimapView);
        viewNotConnected = view.findViewById(R.id.view_not_connected);
        movementContent = view.findViewById(R.id.movement_content);

        setupNotConnected();

        view.findViewById(R.id.btnForward).setOnClickListener(v -> moveRelative(0, 0, 1));
        view.findViewById(R.id.btnBackward).setOnClickListener(v -> moveRelative(0, 0, -1));
        view.findViewById(R.id.btnLeft).setOnClickListener(v -> moveRelative(1, 0, 0));
        view.findViewById(R.id.btnRight).setOnClickListener(v -> moveRelative(-1, 0, 0));

        view.findViewById(R.id.btnCrouch).setOnClickListener(v -> moveRelative(0, -1, 0));

        View btnJump = view.findViewById(R.id.btnJump);
        btnJump.setOnClickListener(v -> {
            long currentTime = System.currentTimeMillis();
            MinecraftConnection connection = serverManager.getActiveConnection();
            if (currentTime - lastJumpTime < 300) {
                // Double tap
                if (connection != null) connection.toggleFlying();
            } else {
                moveRelative(0, 1, 0);
            }
            lastJumpTime = currentTime;
        });

        minimapView.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case android.view.MotionEvent.ACTION_DOWN:
                    lastTouchX = event.getX();
                    lastTouchY = event.getY();
                    return true;
                case android.view.MotionEvent.ACTION_MOVE:
                    float dx = event.getX() - lastTouchX;
                    float dy = event.getY() - lastTouchY;
                    MinecraftConnection connection = serverManager.getActiveConnection();
                    if (connection != null) {
                        connection.rotateCamera(dx * 0.5f, dy * 0.5f);
                    }
                    lastTouchX = event.getX();
                    lastTouchY = event.getY();
                    return true;
            }
            return false;
        });

        observeCoordinates();
    }

    private void setupNotConnected() {
        if (viewNotConnected == null) return;

        viewNotConnected.findViewById(R.id.btn_go_to_servers).setOnClickListener(v -> {
            if (getActivity() != null) {
                com.google.android.material.bottomnavigation.BottomNavigationView bnv =
                        getActivity().findViewById(R.id.bottom_navigation);
                if (bnv != null) {
                    bnv.setSelectedItemId(R.id.nav_servers);
                }
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
        if (movementContent != null) {
            movementContent.setVisibility(isConnected ? View.VISIBLE : View.GONE);
        }
    }

    private void observeCoordinates() {
        MinecraftConnection connection = serverManager.getActiveConnection();
        if (connection != null) {
            minimapView.setWorldTracker(connection.getWorldTracker());

            disposables.add(connection.getPositionObservable()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(pos -> {
                        tvCoordinates.setText(String.format("X=%.2f Y=%.2f Z=%.2f", pos[0], pos[1], pos[2]));
                        minimapView.updatePlayerPosition(pos[0], pos[2]);
                    }, Throwable::printStackTrace));
        }
    }

    private void moveRelative(double dx, double dy, double dz) {
        MinecraftConnection connection = serverManager.getActiveConnection();
        if (connection != null) {
            connection.moveRelative(dx, dy, dz);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        disposables.clear();
    }
}
