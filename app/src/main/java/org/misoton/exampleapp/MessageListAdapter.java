package org.misoton.exampleapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MessageListAdapter extends ArrayAdapter<Message> {
    private LayoutInflater layoutInflater;

    public MessageListAdapter(Context context, int resource, List<Message> objects) {
        super(context, resource, objects);

        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // アイテムのレイアウト内にあるViewの通りに宣言
    public class ViewHolder {
        ImageView iconImage;
        TextView userIdText;
        TextView userNameText;
        TextView tweetBodyText;
    }

    // 各itemのViewの設定
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Message item = getItem(position);
        ViewHolder holder;

        if (convertView == null) {
            // ここにアイテムのレイアウトを設定
            convertView = layoutInflater.inflate(R.layout.item_message, null);

            // ViewHolderの各要素にViewを結び付け
            holder = new ViewHolder();
            holder.iconImage = (ImageView) convertView.findViewById(R.id.item_tweet_icon_image);
            holder.userIdText = (TextView) convertView.findViewById(R.id.item_tweet_user_id_text);
            holder.userNameText = (TextView) convertView.findViewById(R.id.item_tweet_user_name_text);
            holder.tweetBodyText = (TextView) convertView.findViewById(R.id.item_tweet_body_text);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // onCreateでやるようなViewの*中身の*初期化をここで行う
        holder.iconImage.setImageBitmap(item.getIcon());
        holder.userIdText.setText(item.getUserId());
        holder.userNameText.setText(item.getUserName());
        holder.tweetBodyText.setText(item.getMessageBody());

        return convertView;
    }
}
