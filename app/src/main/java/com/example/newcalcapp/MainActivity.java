package com.example.newcalcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;


/* Thank you to Practical Coding on YT for help with writing updateText method & reccomendation
    of mxparser to evaluate math!
 */

public class MainActivity extends AppCompatActivity {

    private TextView priorCalculation;
    private EditText display;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        priorCalculation = findViewById(R.id.previousCalculationView);
        display = findViewById(R.id.displayEditText);
        display.setShowSoftInputOnFocus(false);

    }

    public void updateText(String strToAdd){
        String prevStr = display.getText().toString();

        int cursorPos = display.getSelectionStart();
        String leftStr = prevStr.substring(0, cursorPos);
        String rightStr = prevStr.substring(cursorPos);

        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(cursorPos + strToAdd.length());
    }

    public void zeroPush(View view){
        updateText(getResources().getString(R.string.zeroText));
    }

    public void decimalPush(View view){
        updateText(getResources().getString(R.string.decimalText));
    }

    public void equalsPush(View view){
        String userExp = display.getText().toString();

        priorCalculation.setText(userExp);

        userExp = userExp.replaceAll(getResources().getString(R.string.divideText), "/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiplyText), "*");

        Expression expression = new Expression(userExp);
        String result = String.valueOf(expression.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }

    public void onePush(View view){
        updateText(getResources().getString(R.string.oneText));
    }

    public void twoPush(View view){
        updateText(getResources().getString(R.string.twoText));
    }

    public void threePush(View view){
        updateText(getResources().getString(R.string.threeText));
    }

    public void addPush(View view){
        updateText(getResources().getString(R.string.addText));
    }

    public void fourPush(View view){
        updateText(getResources().getString(R.string.fourText));
    }

    public void fivePush(View view){
        updateText(getResources().getString(R.string.fiveText));
    }

    public void sixPush(View view){
        updateText(getResources().getString(R.string.sixText));
    }

    public void subtractPush(View view){
        updateText(getResources().getString(R.string.subtractText));
    }

    public void sevenPush(View view){
        updateText(getResources().getString(R.string.sevenText));
    }

    public void eightPush(View view){
        updateText(getResources().getString(R.string.eightText));
    }

    public void ninePush(View view){
        updateText(getResources().getString(R.string.nineText));
    }

    public void multiplyPush(View view){
        updateText(getResources().getString(R.string.multiplyText));
    }

    public void clearPush(View view){
        display.setText("");
        priorCalculation.setText("");
    }

    public void openParentheses(View view){
        updateText(getResources().getString(R.string.parenthesesOpenText));
    }

    public void closedParentheses(View view){
        updateText(getResources().getString(R.string.parenthesesCloseText));
    }

    public void dividePush(View view){
        updateText(getResources().getString(R.string.divideText));
    }

    public void backspacePush(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos !=0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }

    public void sinPush(View view){             //mxparser math collection
        updateText("sin(");
    }

    public void cosPush(View view){
        updateText("cos(");
    }

    public void tanPush(View view){
        updateText("tan(");
    }

    public void arcSinPush(View view){
        updateText("arcsin(");
    }

    public void arcCosPush(View view){
        updateText("arccos(");
    }

    public void arcTanPush(View view){
        updateText("arctan(");
    }

    public void logPush(View view){
        updateText("log(");
    }

    public void naturalLogPush(View view){
        updateText("ln(");
    }

    public void squareRootPush(View view){
        updateText("sqrt(");
    }

    public void ePush(View view){
        updateText("e");
    }

    public void piPush(View view){
        updateText("pi");
    }

    public void absolutePush(View view){
        updateText("abs(");
    }

    public void primePush(View view){
        updateText("ispr(");
    }

    public void squaredPush(View view){
        updateText("^(2)");
    }

    public void exponentPush(View view){
        updateText("^(");
    }












}