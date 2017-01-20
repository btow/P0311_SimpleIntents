package com.example.samsung.p0311_simpleintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUri;
    Button btnWeb, btnMap, btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUri = (EditText) findViewById(R.id.etUri);
        btnWeb = (Button) findViewById(R.id.btnWeb);
        btnMap = (Button) findViewById(R.id.btnMap);
        btnCall = (Button) findViewById(R.id.btnCall);

        btnWeb.setOnClickListener(this);
        btnMap.setOnClickListener(this);
        btnCall.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String parsedText = etUri.getText().toString();
        if (parsedText.equals("")) {
            Toast.makeText(this, "The datas string is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent;
        switch (v.getId()) {
            case R.id.btnWeb :
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + parsedText));
                startActivity(intent);
                break;
            case R.id.btnMap :
                intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:" + parsedText));
                startActivity(intent);
                break;
            case R.id.btnCall :
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + parsedText));
                startActivity(intent);
                break;
        }
    }
}
