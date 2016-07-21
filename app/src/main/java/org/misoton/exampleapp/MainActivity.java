package org.misoton.exampleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView helloText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloText = (TextView) this.findViewById(R.id.main_hello_text);
        assert helloText != null;

        Button textChangeButton = (Button) this.findViewById(R.id.main_text_change_button);
        assert textChangeButton != null;

        textChangeButton.setOnClickListener(this);

        Button subActivityStartButton = (Button) this.findViewById(R.id.main_sub_activity_start_button);
        assert subActivityStartButton != null;
        subActivityStartButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_text_change_button:
                this.helloText.setText("Good Bye World!");
                break;

            case R.id.main_sub_activity_start_button:
                Intent intent = new Intent(this, SubActivity.class);
                intent.setAction(Intent.ACTION_VIEW);
                startActivity(intent);
                break;
        }
    }
}
