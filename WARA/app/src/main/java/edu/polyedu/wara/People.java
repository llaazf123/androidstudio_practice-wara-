package edu.polyedu.wara;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class People extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page4);
        Button cancel = (Button) findViewById(R.id.cancel);
        Button finish = (Button) findViewById(R.id.finish);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        page3.class);

                String user1Str, user2Str, user3Str, user4Str, user5Str;
                EditText user1, user2, user3, user4, user5;
                user1 = (EditText) findViewById(R.id.user1);
                user2 = (EditText) findViewById(R.id.user2);
                user3 = (EditText) findViewById(R.id.user3);
                user4 = (EditText) findViewById(R.id.user4);
                user5 = (EditText) findViewById(R.id.user5);

                user1Str = user1.getText().toString();
                user2Str = user2.getText().toString();
                user3Str = user3.getText().toString();
                user4Str = user4.getText().toString();
                user5Str = user5.getText().toString();

                intent.putExtra("user1", user1Str);
                intent.putExtra("user2", user2Str);
                intent.putExtra("user3", user3Str);
                intent.putExtra("user4", user4Str);
                intent.putExtra("user5", user5Str);

                startActivityForResult(intent, 0);

            }

        });
    }
}