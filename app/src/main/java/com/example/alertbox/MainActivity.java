package com.example.alertbox;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declare
Button buttonclose;

AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //call the buttons inside the main function
        buttonclose = (Button)findViewById(R.id.btnclose);
        //set builder
        builder = new AlertDialog.Builder(this);
        
    }

    public void CloseApp(View view) {
        builder.setMessage(R.string.dialog_message)
                .setCancelable(false)
                .setPositiveButton("Yes close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //call a method help close the application
                        finish();
                        Toast.makeText(MainActivity.this, "You closed the App", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        Toast.makeText(MainActivity.this, "Thanks for Sticking around", Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog alertdialog = builder.create();
        alertdialog.setTitle(R.string.dialog_title);
        alertdialog.show();
    }
}
