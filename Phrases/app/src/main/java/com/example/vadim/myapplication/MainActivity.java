package com.example.vadim.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    protected EditText phrase;
    protected Button addButton;
    protected RadioButton choose;
    protected TextView lol;
    protected Add add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phrase = findViewById(R.id.editText);
        addButton = findViewById(R.id.button2);
        choose = findViewById(R.id.radioButton);
        add = new Add();
        lol = findViewById(R.id.textView);
    }

    public void add(View view) {
        try {
            add.add(phrase.getText().toString(), "Vadim");
        } catch (IOException e) {
            lol.setText(e.toString());
        }
    }
}


