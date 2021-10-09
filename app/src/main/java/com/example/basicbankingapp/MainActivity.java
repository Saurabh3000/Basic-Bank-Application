package com.example.basicbankingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
LinearLayout transaction;
LinearLayout customer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customer=findViewById(R.id.customer);
        transaction=findViewById(R.id.transaction);

        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(com.example.basicbankingapp.MainActivity.this,user_list.class));
            }
        });
        transaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(com.example.basicbankingapp.MainActivity.this, com.example.basicbankingapp.history_list.class));
            }
        });
    }
}