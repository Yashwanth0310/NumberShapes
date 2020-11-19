package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    class Number
    {
        int number;
        public boolean isSquare()
        {
            double squareRoot = Math.sqrt(number);
            if(squareRoot == Math.floor(squareRoot))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        public boolean isTriangular()
        {
            int x = 1;
            int triangularNo = 1;
            while (triangularNo<number)
            {
                x++;
                triangularNo = triangularNo+x;
            }
            if(triangularNo==number)
            {
                return true;
            }
            else
            {
                return false;
            }

        }
    }
    public void testNumber(View view){
        Number myNo = new Number();
        EditText editText = (EditText) findViewById(R.id.editTextNumber);
        String message;
        if(editText.getText().toString().isEmpty())
        {
            message = "PLEASE ENTER A NUMBER";
        }
        else {
            myNo.number = Integer.parseInt(editText.getText().toString());
            message = editText.getText().toString();
            if (myNo.isSquare() && myNo.isTriangular()) {
                message += " is Both Square and Triangular";
            } else if (myNo.isSquare()) {
                message += " is Square";
            } else if (myNo.isTriangular()) {
                message += " is Triangular";
            } else {
                message += " is neither Square nor Triangular";
            }
        }
        Toast.makeText(this, message , Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}