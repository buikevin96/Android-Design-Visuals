package com.example.kevinbui.showactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView showMessage;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // To get all the messages we are sending
        Bundle extras = getIntent().getExtras();

        showMessage = (TextView)findViewById(R.id.messageTextView);
        backButton = (Button)findViewById(R.id.backButton);

        // Check
        if (extras != null) {
            String message = extras.getString("Message"); // To get string message
            int myInt = extras.getInt("Value"); // To get int message

           // showMessage.setText(message); Shows message of string
            showMessage.setText("Message is " + message + " and : "  + String.valueOf(myInt));

        }

        // When button is clicked, send message to first activity
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = getIntent();
                returnIntent.putExtra("returnData", "From SecondActivity");
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });

    }
}
