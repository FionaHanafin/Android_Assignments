package com.fiona;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bDiv,bMul,bAdd,bSub,bClear;
TextView equationText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setVariables();
    }

    public void doMath(View v){
       enableButtons();
        String equation;
        int temp1,temp2,total;
        Log.d("******************* doMath",equationText.getText().toString());
        equation = equationText.getText().toString();
        if (equation.contains("+")){
            temp1 = Integer.parseInt(equation.substring(0,equation.indexOf("+")));
            temp2 = Integer.parseInt(equation.substring(equation.indexOf("+")+1));
            total = temp1+temp2;
            equationText.setText(String.valueOf(total));
        }else if (equation.contains("-")){
            temp1 = Integer.parseInt(equation.substring(0,equation.indexOf("-")));
            temp2 = Integer.parseInt(equation.substring(equation.indexOf("-")+1));
            total = temp1-temp2;
            equationText.setText(String.valueOf(total));
        }else if (equation.contains("*")){
            temp1 = Integer.parseInt(equation.substring(0,equation.indexOf("*")));
            temp2 = Integer.parseInt(equation.substring(equation.indexOf("*")+1));
            total = temp1*temp2;
            equationText.setText(String.valueOf(total));
        }else if (equation.contains("/")){
            temp1 = Integer.parseInt(equation.substring(0,equation.indexOf("/")));
            temp2 = Integer.parseInt(equation.substring(equation.indexOf("/")+1));
            total = temp1/temp2;
            equationText.setText(String.valueOf(total));
        }
    }

    private  void setVariables(){
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        b0 = findViewById(R.id.button0);
        bDiv = findViewById(R.id.buttondiv);
        bAdd = findViewById(R.id.buttonadd);
        bMul = findViewById(R.id.buttonmul);
        bSub = findViewById(R.id.buttonsub);
        bClear = findViewById(R.id.buttonC);
        equationText = findViewById(R.id.equation);
    }

    public void updateEquation(View v){
        String temp = equationText.getText().toString();
        switch (v.getId()){
            case R.id.button0:
                temp = temp +"0";
                break;
            case R.id.button1:
                temp = temp +"1";
                break;
            case R.id.button2:
                temp = temp +"2";
                break;
            case R.id.button3:
                temp = temp +"3";
                break;
            case R.id.button4:
                temp = temp +"4";
                break;
            case R.id.button5:
                temp = temp +"5";
                break;
            case R.id.button6:
                temp = temp +"6";
                break;
            case R.id.button7:
                temp = temp +"7";
                break;
            case R.id.button8:
                temp = temp +"8";
                break;
            case R.id.button9:
                temp = temp +"9";
                break;
            case R.id.buttonC:
                temp = "";
                enableButtons();
                break;
            case R.id.buttondiv:
                temp = temp +"/";
                disableButtons();
                break;
            case R.id.buttonmul:
                temp = temp +"*";
                disableButtons();
                break;
            case R.id.buttonadd:
                temp = temp +"+";
                disableButtons();
                break;
            case R.id.buttonsub:
                temp = temp +"-";
                disableButtons();
                break;
        }
        equationText.setText(temp);
    }
    public void enableButtons(){
        bAdd.setEnabled(true);
        bDiv.setEnabled(true);
        bMul.setEnabled(true);
        bSub.setEnabled(true);
    }
    public void disableButtons(){
        bAdd.setEnabled(false);
        bMul.setEnabled(false);
        bDiv.setEnabled(false);
        bSub.setEnabled(false);
    }
}
