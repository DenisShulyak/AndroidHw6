package com.example.mylistproducts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.state.ConstraintReference;

import java.util.ArrayList;
import java.util.Iterator;

public class ProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this);
        textView.setTextSize(20);
        textView.setPadding(16, 16, 16, 16);

        Bundle arguments = getIntent().getExtras();

        if(arguments!=null){
            String name = arguments.get("name").toString();
            String text = arguments.get("text").toString();
            if(getLastElement(Products.products) == null){
            Products.products.add(new Product(1,name, text));
            }
            else {
                Products.products.add(new Product(getLastElement(Products.products).id+1,name, text));
            }

        }
            String t = "";
            for (Product p:Products.products
                 ) {
                t += p.id +") Название: " + p.name + "\nОписание: " + p.text + "\n";
            }
            t+= "Нажмите чтобы вернуться.";
            textView.setText(t);

        setContentView(textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProductsActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        /*Button b = findViewById(R.id.button_main);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProductsActivity.this, MainActivity.class);
                startActivity(i);
            }
        });*/

    }
    public static Product getLastElement(ArrayList<Product> elements) {
        Product product = new Product();
        for (Product p: elements
             ) {
            product = p;
        }

        return product;
    }
}