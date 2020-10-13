package com.example.mycalculator;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int count = 1;
    private TextView Screen;
    private String input, output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Screen = (TextView) findViewById(R.id.tv);
    }
    public void ButtonClick(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();

        switch (data) {

            case "CE":
            case "BS":
                count = 1;
                input = "0";
                break;
            case "C":
                if (input.length() > 0) {
                    String newText = input.substring(0, input.length()-1);
                    input = newText;
                }
                break;
            case "+/-":
                if (count == 1) {
                    input="-"+input;
                }
                else input = input.substring(1,input.length()-1);
                count++;
                break;
            case "=":
                Solve();
                count = 1;
                break;

            default:
                if (input == null) {
                    input="";
                }
                if (data.equals("+") || data.equals("-") || data.equals("x") || data.equals("÷") ) {
                    Solve();
                }
                input += data;
        }
        Screen.setText(input);
    }

    public void Solve() {
        if (input.split("x").length==2) {
            String number[] = input.split("x");
            try {
                double mul = Double.parseDouble(number[0])*Double.parseDouble(number[1]);
                input = mul+"";
            }
            catch (Exception e) {
            }
        }
        else if (input.split("\\+").length==2) {
            String number[] = input.split("\\+");
            try {
                double add = Double.parseDouble(number[0])+Double.parseDouble(number[1]);
                input = add+"";
            }
            catch (Exception e) {
            }
        }
        else if (input.split("\\÷").length==2) {
            String number[] = input.split("\\÷");
            try {
                double div = Double.parseDouble(number[0])/Double.parseDouble(number[1]);
                input = div+"";
            }
            catch (Exception e) {
            }
        }
        else if (input.split("\\-").length==2) {
            String number[] = input.split("\\-");
            try {
                double sub = Double.parseDouble(number[0])-Double.parseDouble(number[1]);
                input = sub+"";
            }
            catch (Exception e) {
            }
        }

        String n[] = input.split("\\.");
        if (n.length > 1) {
           if (n[n.length - 1].equals("0")) {
               input = n[0];
            }
        }
        Screen.setText(input);

        if(input.contains("-")) {
            input = input.substring(1,input.length()-1);
        }
    }
}

