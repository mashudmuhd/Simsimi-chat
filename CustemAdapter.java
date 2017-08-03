package com.example.mashudmuhd.androidsimsi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.mashudmuhd.androidsimsi.Models.ChatModel;
import com.example.mashudmuhd.androidsimsi.R;
import com.github.library.bubbleview.BubbleTextView;

import java.util.List;

/**
 * Created by MASHUDMUHD on 7/24/2017.
 */

public class CustemAdapter extends BaseAdapter {

    private List<ChatModel> list_chat_models;

    public CustemAdapter(List<ChatModel> list_chat_models, Context context) {
        this.list_chat_models = list_chat_models;
        this.context = context;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    private Context context;
    private LayoutInflater layoutInflater;

    @Override
    public int getCount() {
        return list_chat_models.size();
    }

    @Override
    public Object getItem(int position) {
        return list_chat_models.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
     View view = convertView;
         if (view == null){
             if (list_chat_models.get(position).isSend)
                 view = layoutInflater.inflate(R.layout.list_item_messagesend,null);
             else
                 view = layoutInflater.inflate(R.layout.list_item_message_recive,null);

             BubbleTextView text_message = (BubbleTextView)view.findViewById(R.id.text_message);
             text_message.setText(list_chat_models.get(position).message);
         }
         return view;
    }
}
