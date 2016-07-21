package org.misoton.exampleapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class SubActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText messageEdit;
    private ArrayAdapter<String> messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        // 投稿したメッセージを表示するListView
        final ListView messageListView = (ListView) this.findViewById(R.id.sub_message_list);
        assert messageListView != null;

        // メッセージの文字列を管理するArrayAdapter
        messageAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1);
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
                // メッセージを取得、空なら何もしない
                String message = messageEdit.getText().toString();
                if (message.length() == 0) {
                    return;
                }

                // メッセージをリストに追加
                messageAdapter.add(message);

                // 入力されたメッセージを消去
                messageEdit.setText("");
                break;
        }
    }
}
