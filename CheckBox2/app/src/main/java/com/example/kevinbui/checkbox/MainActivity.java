package com.example.kevinbui.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox momCheckBox;
    private CheckBox dadCheckBox;
    private CheckBox sisterCheckBox;
    private Button showButton;
    private TextView showTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        momCheckBox = (CheckBox)findViewById(R.id.momCheckBoxID);
        dadCheckBox = (CheckBox)findViewById(R.id.dadCheckBoxID);
        sisterCheckBox = (CheckBox)findViewById(R.id.sisterCheckBoxID);
        showTextView = (TextView)findViewById(R.id.resultID);

        showButton = (Button)findViewById(R.id.showButtonID);
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(momCheckBox.getText().toString() + " status is: " +
                    momCheckBox.isChecked() + "\n"); // Get the text value of mom checkbox

                stringBuilder.append(dadCheckBox.getText().toString() + " status is: " +
                    dadCheckBox.isChecked() + "\n"); // Get the text value of dad checkbox

                stringBuilder.append(sisterCheckBox.getText().toString() + " status is: " +
                    sisterCheckBox.isChecked() + "\n"); // Get the text value of sister checkbox

                showTextView.setText(stringBuilder); // Sets the text view to what is in stringbuilder
            }
        });
    }
}
