package com.anshul.buzzme;



import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anshul.buzzme.databinding.RowChatLeftBinding;
import com.anshul.buzzme.databinding.RowChatRightBinding;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;
import java.util.List;

public class AdapterChat extends RecyclerView.Adapter{

    Context context;
    List<ModelChat> list;
    String imageurl;

    int SENDER_VIEW_TYPE=1;
    int RECEIVER_VIEW_TYPE=0;

    public AdapterChat(Context context, List<ModelChat> list,String imageurl) {
        this.context = context;
        this.list = list;
        this.imageurl=imageurl;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==SENDER_VIEW_TYPE)
        {
            View view= LayoutInflater.from(context).inflate(R.layout.row_chat_right,parent,false);
            return new SenderViewHolder(view);
        }
        else
        {
            View view= LayoutInflater.from(context).inflate(R.layout.row_chat_left,parent,false);
            return new ReceiverViewHolder(view);

        }
    }

    @Override
    public int getItemViewType(int position) {
        if(list.get(position).getSender().equals(FirebaseAuth.getInstance().getUid()))
        {
            return SENDER_VIEW_TYPE;
        }
        else
        {
            return  RECEIVER_VIEW_TYPE;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ModelChat modelChat = list.get(position);
        if(holder.getClass() == SenderViewHolder.class)
        {
            String message=modelChat.getMessage();
            String type=modelChat.getType();
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(Long.parseLong(modelChat.getTimestamp()));
            String timedate = DateFormat.format("dd/MM/yyyy hh:mm aa", calendar).toString();
            ((SenderViewHolder) holder).binding.timetv.setText(timedate);
            if(type.equals("text"))
            {
                ((SenderViewHolder) holder).binding.msgc.setVisibility(View.VISIBLE);
                ((SenderViewHolder) holder).binding.images.setVisibility(View.GONE);
                ((SenderViewHolder) holder).binding.msgc.setText(message);
            }
            else
            {
                ((SenderViewHolder) holder).binding.msgc.setVisibility(View.GONE);
                ((SenderViewHolder) holder).binding.images.setVisibility(View.VISIBLE);
                Glide.with(context).load(message).into(((SenderViewHolder) holder).binding.images);
            }
        }
        else
        {
            String message=modelChat.getMessage();
            String type=modelChat.getType();
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(Long.parseLong(modelChat.getTimestamp()));
            String timedate = DateFormat.format("dd/MM/yyyy hh:mm aa", calendar).toString();
            ((ReceiverViewHolder)holder).binding.timetv.setText(timedate);
            if(type.equals("text"))
            {
                ((ReceiverViewHolder) holder).binding.msgc.setVisibility(View.VISIBLE);
                ((ReceiverViewHolder) holder).binding.images.setVisibility(View.GONE);
                ((ReceiverViewHolder) holder).binding.msgc.setText(message);
            }
            else
            {
                ((ReceiverViewHolder) holder).binding.msgc.setVisibility(View.GONE);
                ((ReceiverViewHolder) holder).binding.images.setVisibility(View.VISIBLE);
                Glide.with(context).load(message).into(((ReceiverViewHolder) holder).binding.images);
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class SenderViewHolder extends RecyclerView.ViewHolder{

        RowChatRightBinding binding;

        public SenderViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=RowChatRightBinding.bind(itemView);
        }
    }

    public class ReceiverViewHolder extends RecyclerView.ViewHolder {

        RowChatLeftBinding binding;

        public ReceiverViewHolder(@NonNull View itemView) {
            super(itemView);

            binding=RowChatLeftBinding.bind(itemView);
        }
    }
}




