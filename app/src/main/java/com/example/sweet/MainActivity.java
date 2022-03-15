package com.example.sweet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.sweet.base.Manager;

public class MainActivity extends AppCompatActivity {
    EditText numberGrams, prise;
    TextView nameProduct;
    TextView tevi;
    Manager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberGrams = findViewById(R.id.numberGrams);
        prise = findViewById(R.id.prise);
        tevi = findViewById(R.id.tevi);
        nameProduct = findViewById(R.id.nameProduct);
        manager = new Manager(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        manager.openBase();
    }



    public void onButtonGram(View view){
        String a=numberGrams.getText().toString();
        String b=prise.getText().toString();
        Integer c =Integer.parseInt(a);
        Integer d =Integer.parseInt(b);
        double i2=c.doubleValue();

        double i3=d / i2;
        tevi.setText(String.valueOf(i3));
        manager.insertBase(nameProduct.getText().toString(), i3);
    }
    public void onButtonPrise(View view){
        Intent intent=new Intent(this, PriseProductActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        manager.closeDb();
    }
}