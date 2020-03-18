package com.example.Le;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int sum;
    int sumcorect;
    boolean finish1;
    boolean finish2;
    ImageView ivr1;
    ImageView ivr2;
    String str;
    ImageView ivr3;
    TextView n1r1, n2r1, n1r2, n2r2, n1r3, n2r3;
    int num1, num2;
    Random rnd;
    boolean gamestart;
    Button check1, check2, check3, newgame;
    EditText etr1, etr2, etr3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rnd = new Random();
        num1 = 0;
        num2 = 0;
        gamestart = false;
        sum = 0;
        str = "";
        sumcorect = 0;
        finish1 = false;
        finish2 = false;


        //wedding the ImageView
        ivr1 = (ImageView) findViewById(R.id.ivr1);
        ivr2 = (ImageView) findViewById(R.id.ivr2);
        ivr3 = (ImageView) findViewById(R.id.ivr3);

        //wedding the editText
        etr1 = (EditText) findViewById(R.id.etr1);
        etr2 = (EditText) findViewById(R.id.etr2);
        etr3 = (EditText) findViewById(R.id.etr3);

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

    public void start(View view) {
        gamestart = true;
        sumcorect = 0;

        ivr1.setImageResource(R.drawable.whitebag);
        ivr2.setImageResource(R.drawable.whitebag);
        ivr3.setImageResource(R.drawable.whitebag);
        finish2 = false;
        finish1 = false;
        n1r1.setText("empty");
        n2r1.setText("empty");
        n2r2.setText("empty");
        n1r2.setText("empty");
        n2r3.setText("empty");
        n1r3.setText("empty");

        etr1.setText("");
        etr2.setText("");
        etr3.setText("");

        num1 = rnd.nextInt(100);
        num2 = rnd.nextInt(100);
        n1r1.setText(String.valueOf(num1));
        n2r1.setText(String.valueOf(num2));
    }

    public void check1(View view) {
        str = etr1.getText().toString();
        if (str.matches("") && (gamestart == true)) {
            Toast.makeText(this, "put the summery of the numbers above", Toast.LENGTH_SHORT).show();
        } else if ((gamestart == true) && (etr1.getText().toString() != "") && (finish1 == false)) {
            sum = Integer.parseInt(etr1.getText().toString());
            if (sum == num1 + num2) {
                sumcorect++;
                ivr1.setImageResource(R.drawable.correct);
            } else {
                ivr1.setImageResource(R.drawable.redx);
            }
            num1 = num1 + num2;
            num2 = rnd.nextInt(100);
            n1r2.setText(String.valueOf(num1));
            n2r2.setText(String.valueOf(num2));
            finish1 = true;

        }

    }

    public void check2(View view) {
        str = etr2.getText().toString();
        if (str.matches("") && (finish1 == true)) {
            Toast.makeText(this, "put the summery of the numbers above", Toast.LENGTH_SHORT).show();
        } else if ((finish1 == true) && (etr2.getText().toString() != "") && (finish2 == false)) {
            sum = Integer.parseInt(etr2.getText().toString());
            if (sum == num1 + num2) {
                sumcorect++;
                ivr2.setImageResource(R.drawable.correct);
            } else {
                ivr2.setImageResource(R.drawable.redx);
            }
            num1 = num2 + num1;
            num2 = rnd.nextInt(100);
            n1r3.setText(String.valueOf(num1));
            n2r3.setText(String.valueOf(num2));
            finish2 = true;
        }
    }

    public void check3(View view) {

        str = etr3.getText().toString();
        if (str.matches("") && (finish2 == true)) {
            Toast.makeText(this, "put the summery of the numbers above", Toast.LENGTH_SHORT).show();
        }
         else if ((finish2 == true)) {
            sum = Integer.parseInt(etr3.getText().toString());
            if (sum == num1 + num2) {
                sumcorect++;
                ivr3.setImageResource(R.drawable.correct);
            } else {
                ivr3.setImageResource(R.drawable.redx);
            }
            if (finish2 == true) {
                Toast.makeText(getApplicationContext(), "accurty = " + sumcorect + "/3  " +  String.format(Locale.US,"%.2f",(sumcorect / 3.0 * 100) ) + "%", Toast.LENGTH_LONG).show();
                finish2 = false;
                finish1 = false;
                gamestart = false;
            }

        }
    }
}
