package com.ccs.craftlink.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.ccs.craftlink.model.ChatMessage;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class ChatHistoryManager {
    private static final String TAG = "ChatHistoryManager";
    private static ChatHistoryManager instance;

    private final Context context;
    private final SharedPreferences prefs;
    private final Gson gson;
    private final BehaviorSubject<List<ChatMessage>> messages = BehaviorSubject.createDefault(new ArrayList<>());
    private static final int MAX_MESSAGES = 500;

    public static synchronized ChatHistoryManager getInstance(Context context) {
        if (instance == null) {
            instance = new ChatHistoryManager(context.getApplicationContext());
        }
        return instance;
    }

    private ChatHistoryManager(Context context) {
        this.context = context;
        this.prefs = context.getSharedPreferences("craftlink_chat", Context.MODE_PRIVATE);
        this.gson = new Gson();
        loadMessages();
    }

    public Observable<List<ChatMessage>> observeMessages() {
        return messages;
    }

    public List<ChatMessage> getMessages() {
        return new ArrayList<>(messages.getValue() != null ? messages.getValue() : new ArrayList<>());
    }

    public void addMessage(ChatMessage message) {
        List<ChatMessage> current = getMessages();
        current.add(message);

        if (current.size() > MAX_MESSAGES) {
            current = new ArrayList<>(current.subList(current.size() - MAX_MESSAGES, current.size()));
        }

        saveMessages(current);
        messages.onNext(current);
    }

    public void clearHistory() {
        messages.onNext(new ArrayList<>());
        prefs.edit().remove("messages").apply();
    }

    public List<ChatMessage> searchMessages(String query) {
        List<ChatMessage> result = new ArrayList<>();
        for (ChatMessage msg : getMessages()) {
            if (msg.getContent().toLowerCase().contains(query.toLowerCase()) ||
                    msg.getSender().toLowerCase().contains(query.toLowerCase())) {
                result.add(msg);
            }
        }
        return result;
    }

    private void loadMessages() {
        try {
            String json = prefs.getString("messages", "[]");
            Type type = new TypeToken<List<ChatMessage>>() {}.getType();
            List<ChatMessage> loaded = gson.fromJson(json, type);
            if (loaded != null) {
                messages.onNext(loaded);
            }
        } catch (Exception e) {
            messages.onNext(new ArrayList<>());
        }
    }

    private void saveMessages(List<ChatMessage> messageList) {
        prefs.edit().putString("messages", gson.toJson(messageList)).apply();
    }
}
