package com.example.counter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private int count;
    private TextView countText;
    private Button countbtn, sendbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       countText = findViewById(R.id.countText);
       countbtn = findViewById(R.id.countbtn);
       sendbtn = findViewById(R.id.sendbtn);

       countbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               count++;
               countText.setText(String.valueOf(count));
           }
       });

       sendbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               sendMessage(count);
           }
       });

    }

    private void sendMessage(int count) {
        String message = "Count:" + count;
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=+996778097741"+"&text="+Uri.encode(message)));
        intent.setPackage("com.whatsapp");
        startActivity(intent);
    }
}