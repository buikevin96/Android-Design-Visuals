package com.example.kevinbui.sharedprefs;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button saveButton;
    private TextView result;
    private EditText enterMessage;
    private SharedPreferences myPrefs;
    private static final String PREFS_NAME = "myPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveButton = (Button)findViewById(R.id.saveButton);
        result = (TextView)findViewById(R.id.resultTextView);
        enterMessage = (EditText)findViewById(R.id.enterName);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPrefs = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = myPrefs.edit();

                editor.putString("message", enterMessage.getText().toString());
                editor.commit();
            }
        });

        // Get data back
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, 0);

        if (prefs.contains("message")) {
            String message = prefs.getString("message", "Not Found");
            result.setText("Message: " + message);
        }

    }
}
