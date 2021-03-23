package com.example.a108590027_hw5_1;

import android.util.Log;
import java.lang.Math;

public class Calculator {

    public enum Operator {ADD, SUB, DIV, MUL, POW}

    public double add(double a, double b){
        return a+b;
    }

    public double sub(double a, double b){
        return a-b;
    }

    public double div(double a, double b){
        return a/b;
    }

    public double mul(double a, double b){
        return a*b;
    }

    public double power(double a, double b){
        return Math.pow(a, b);
    }
}
