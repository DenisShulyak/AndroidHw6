package com.example.mylistproducts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }
    public void onClick(View v) {

        final EditText nameText = findViewById(R.id.product_name);
        final EditText derText = findViewById(R.id.product_der);

        String name = nameText.getText().toString();
        String text = derText.getText().toString();

        Intent intent = new Intent(this, ProductsActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("text", text);
        startActivity(intent);
    }
}
