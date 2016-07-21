package org.misoton.exampleapp;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SubActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText messageEdit;
    private ArrayAdapter<Message> messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        // 投稿したメッセージを表示するListView
        final ListView messageListView = (ListView) this.findViewById(R.id.sub_message_list);
        assert messageListView != null;

        // メッセージを管理するArrayAdapterを生成してListViewに設定
        List<Message> messageList = new ArrayList<>();
        messageAdapter = new MessageListAdapter(this, 0, messageList);
        messageListView.setAdapter(messageAdapter);

        // メッセージを入力するEditText
        messageEdit = (EditText) this.findViewById(R.id.sub_message_edit);
        assert messageEdit != null;

        // メッセージを投稿するButton
        final Button submitButton = (Button) this.findViewById(R.id.sub_submit_button);
        assert submitButton != null;
        submitButton.setOnClickListener(this);

    }

    @Override
    public void onClick(@NonNull View v) {
        switch (v.getId()) {
            case R.id.sub_submit_button:
                // メッセージの本文を取得、空なら何もしない
                String messageText = messageEdit.getText().toString();
                if (messageText.length() == 0) {
                    return;
                }

                // たぬき画像の取得
                Resources r = this.getResources();
                Bitmap tanukiBitmap = BitmapFactory.decodeResource(r, R.drawable.tanuki);

                // メッセージを生成
                Message message = new Message("defaultId", "defaultName", messageText, tanukiBitmap);

                // メッセージをリストに追加
                messageAdapter.add(message);

                // 入力されたメッセージを消去
                messageEdit.setText("");
                break;
        }
    }
}
