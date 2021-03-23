package com.example.a108590027_hw5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "CalculatorActivity";
    private Calculator mCalc;
    private EditText mAnum;
    private EditText mBnum;
    private TextView mResult;
    private double a, b;
    private String  result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCalc = new Calculator();
        mAnum = findViewById(R.id.editText_a);
        mBnum = findViewById(R.id.editText_b);
        mResult = findViewById(R.id.Text_result);
    }

    public double getNumber(EditText src){
        double res = Double.parseDouble(src.getText().toString());
        return res;
    }

    public void addNumber(View View){
        compute(Calculator.Operator.ADD);
    }

    public void subNumber(View View){
        compute(Calculator.Operator.SUB);
    }

    public void divNumber(View View){
        try {
            compute(Calculator.Operator.DIV);
        } catch (IllegalArgumentException iae) {
            Log.e(TAG, "IllegalArgumentException", iae);
            mResult.setText(getString(R.string.computationError));
        }
    }

    public void powNumber(View View){
        compute(Calculator.Operator.POW);
    }

    public void mulNumber(View View){
        compute(Calculator.Operator.MUL);
    }

    public void compute(Calculator.Operator act){
        try{
            a = getNumber(mAnum);
            b = getNumber(mBnum);
        }catch (NumberFormatException nfe) {
            Log.e(TAG, "NumberFormatException", nfe);
            mResult.setText(getString(R.string.computationError));
            return;
        }
        switch (act){
            case ADD:
                result = Double.toString(mCalc.add(a, b));
                break;
            case SUB:
                result = Double.toString(mCalc.sub(a, b));
                break;
            case DIV:
                result = Double.toString(mCalc.div(a, b));
                break;
            case MUL:
                result = Double.toString(mCalc.mul(a, b));
                break;
            case POW:
                result = Double.toString(mCalc.power(a, b));
                break;
            default:
                result = getString(R.string.computationError);
                break;
        }
        mResult.setText(result);
    }
}