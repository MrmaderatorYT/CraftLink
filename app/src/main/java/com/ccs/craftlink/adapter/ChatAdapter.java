package com.ccs.craftlink.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ccs.craftlink.R;
import com.ccs.craftlink.model.ChatMessage;
import com.ccs.craftlink.utils.ChatColorParser;

import java.util.ArrayList;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_MESSAGE = 0;
    private static final int TYPE_SYSTEM = 1;

    private final List<ChatMessage> messages = new ArrayList<>();

    public void setMessages(List<ChatMessage> newMessages) {
        messages.clear();
        messages.addAll(newMessages);
        notifyDataSetChanged();
    }

    public void addMessage(ChatMessage message) {
        messages.add(message);
        notifyItemInserted(messages.size() - 1);
    }

    public List<ChatMessage> getAllMessages() {
        return new ArrayList<>(messages);
    }

    @Override
    public int getItemViewType(int position) {
        ChatMessage message = messages.get(position);
        return message.isSystem() ? TYPE_SYSTEM : TYPE_MESSAGE;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_SYSTEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_system, parent, false);
            return new SystemViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_message, parent, false);
            return new MessageViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ChatMessage message = messages.get(position);
        if (holder instanceof MessageViewHolder) {
            ((MessageViewHolder) holder).bind(message);
        } else if (holder instanceof SystemViewHolder) {
            ((SystemViewHolder) holder).bind(message);
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    static class MessageViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvSender;
        private final TextView tvContent;

        MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSender = itemView.findViewById(R.id.tv_sender);
            tvContent = itemView.findViewById(R.id.tv_content);
        }

        void bind(ChatMessage message) {
            tvSender.setText(ChatColorParser.parseLegacy(message.getSender()));
            tvContent.setText(ChatColorParser.parseLegacy(message.getContent()));
        }
    }

    static class SystemViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvMessage;

        SystemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMessage = itemView.findViewById(R.id.tv_system_message);
        }

        void bind(ChatMessage message) {
            tvMessage.setText(ChatColorParser.parseLegacy(message.getContent()));
        }
    }
}
