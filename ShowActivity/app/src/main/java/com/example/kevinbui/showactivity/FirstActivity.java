package com.example.kevinbui.showactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {

    private Button goToSecondButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        goToSecondButton = (Button)findViewById(R.id.showButtonID);
        goToSecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Goes from first activity to second
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("Message", "Hello from first activity");
                intent.putExtra("SecondMessage", "Hello again!");
                intent.putExtra("Value", 123);

                startActivity(intent);

                // startActivity(new Intent(FirstActivity.this, SecondActivity.class));
            }
        });
    }
}
