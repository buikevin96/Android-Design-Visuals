package com.example.kevinbui.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private AlertDialog.Builder alertDialog;
    private Button showDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDialog = (Button)findViewById(R.id.showDialogID);
        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the actual dialog (alert dialog)
                alertDialog = new AlertDialog.Builder(MainActivity.this);

                // Building the alert
                alertDialog.setTitle(getResources().getString(R.string.title)); // Sets the title
                alertDialog.setIcon(android.R.drawable.btn_star_big_on); // Set Icon

                // Set Message
                alertDialog.setMessage(getResources().getString(R.string.message)); // Sets the message

                // Set Cancelable
                alertDialog.setCancelable(false); // User cannot touch off the window to exit, must press yes or no

                // Set positive button
                alertDialog.setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // What happens when the user clicks Yes
                        MainActivity.this.finish(); // Exit out window activity
                    }
                });

                alertDialog.setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // What happens when the user clicks No
                        dialog.cancel();
                    }
                });

                // Create the actual dialog
                AlertDialog dialog = alertDialog.create();

                //show the dialog
                dialog.show();

            }
        });
    }
}
