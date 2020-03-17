package com.example.Le;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView ivr1;
    ImageView ivr2;
    ImageView ivr3;
    TextView n1r1,n2r1,n1r2,n2r2,n1r3,n2r3;
    int num1,num2;
    Random rnd;
    Button check1,check2,check3,newgame;
    EditText r1,r2,r3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //wedding the ImageView
        ivr1 = (ImageView) findViewById(R.id.ivr1);
        ivr2 = (ImageView) findViewById(R.id.ivr2);
        ivr3 = (ImageView) findViewById(R.id.ivr3);

        // wedding the TextView
        n1r1 = (TextView) findViewById(R.id.n1r1);
        n2r1 = (TextView) findViewById(R.id.n2r1);
        n1r2 = (TextView) findViewById(R.id.n1r2);
        n2r2 = (TextView) findViewById(R.id.n2r2);
        n1r3 = (TextView) findViewById(R.id.n1r3);
        n2r3 = (TextView) findViewById(R.id.n2r3);

        //wedding the Button
        check1 = (Button) findViewById(R.id.btnr1);
        check2 = (Button) findViewById(R.id.btnr2);
        check3 = (Button) findViewById(R.id.btnr3);
        newgame = (Button) findViewById(R.id.newbtn);
    }
}
