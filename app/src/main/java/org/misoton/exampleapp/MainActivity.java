package org.misoton.exampleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView helloText;

    private RetroFitApi getRestApi() {
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint("http://api.openweathermap.org").build();
        return adapter.create(RetroFitApi.class);
    }

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

        Button weatherButton = (Button) this.findViewById(R.id.main_tomorrow_weather_button);
        assert weatherButton != null;
        weatherButton.setOnClickListener(this);
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

            case R.id.main_tomorrow_weather_button:
                RetroFitApi api = getRestApi();
                String location = "Aizuwakamatsu";
                int count = 1;
                String appId = "e8ff51846c54c3f0a02ed50d7184c466";
                api.daily(location, count, appId, new RequestCallback<Weather>(new RequestListener<Weather>() {
                    @Override
                    public void onSuccess(Weather response) {
                        Toast.makeText(MainActivity.this, response.list.get(0).weather.get(0).main, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(RetrofitError error) {
                        Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_LONG).show();
                    }
                }));
                break;
        }
    }
}
