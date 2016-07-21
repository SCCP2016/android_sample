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

        final ListView messageListView = (ListView) this.findViewById(R.id.sub_message_list);
        assert messageListView != null;
        messageAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1);
        messageListView.setAdapter(messageAdapter);

        messageEdit = (EditText) this.findViewById(R.id.sub_message_edit);
        assert messageEdit != null;

        final Button submitButton = (Button) this.findViewById(R.id.sub_submit_button);
        assert submitButton != null;
        submitButton.setOnClickListener(this);

    }

    @Override
    public void onClick(@NonNull View v) {
        switch (v.getId()) {
            case R.id.sub_submit_button:
                String message = messageEdit.getText().toString();
                if (message.length() == 0) {
                    return;
                }
                messageAdapter.add(message);
                messageEdit.setText("");
                break;
        }
    }
}
