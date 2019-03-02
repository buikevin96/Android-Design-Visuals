package com.example.kevinbui.showactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView showMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // To get all the messages we are sending
        Bundle extras = getIntent().getExtras();

        showMessage = (TextView)findViewById(R.id.messageTextView);

        // Check
        if (extras != null) {
            String message = extras.getString("Message"); // To get string message
            int myInt = extras.getInt("Value"); // To get int message

           // showMessage.setText(message); Shows message of string
            showMessage.setText("Message is " + message + " and : "  + String.valueOf(myInt));

        }

    }
}
