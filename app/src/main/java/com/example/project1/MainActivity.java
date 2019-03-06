package com.example.project1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {



    public enum Operation {

        MULTIPLY,
        DIVIDE,
        ADD,
        SUBTRACT,
        SQUAREROOT,

    }

    Operation currentOperation;

    double result;
    double value1, value2 = 0.0;
    String currentEntry = "";

    boolean value1Bool = true;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });






        }







    //String displayNumber = t.getText().toString();
    //t.setText("0.0");

    public void buttonClicked (View v) {

        TextView t = findViewById(R.id.CalcView);
        Button b = findViewById(v.getId());
        String id = (b.getResources().getResourceName(b.getId())).split("/")[1];


        String displayText = b.getText().toString();
        t.setText(displayText);
        //t.setText(id);

        switch (id) {


            case "addButton":

                currentOperation = Operation.ADD;
                value1Bool = false;
                value1 = Double.parseDouble(currentEntry);
                currentEntry = "";
                break;


            case "multiplyButton":
                currentOperation = Operation.MULTIPLY;
                value1Bool = false;
                value1 = Double.parseDouble(currentEntry);
                currentEntry = "";
                break;


            case "subtractButton":
                currentOperation = Operation.SUBTRACT;
                value1Bool = false;
                value1 = Double.parseDouble(currentEntry);
                currentEntry = "";
                break;



            case "divideButton":
                currentOperation = Operation.DIVIDE;
                value1Bool = false;
                value1 = Double.parseDouble(currentEntry);
                currentEntry = "";
                break;



            case "percent":
                currentEntry = Double.toString(Double.parseDouble(currentEntry) * 0.01);
                //currentEntry = "%" + currentEntry;
                t.setText(currentEntry);
                break;




            case "decimalButton":
                currentEntry += ".";
                break;



            case "sqrt":
                currentOperation = Operation.SQUAREROOT;
                value1 = Double.parseDouble(currentEntry);
                break;



            case "equals":
                value2 = Double.parseDouble(currentEntry);
                currentEntry = "";

                calculate();
                break;


            case "clearButton":
                value1 = 0.0;
                value2 = 0.0;
                currentEntry = "";
                value1Bool = true;

                t.setText(currentEntry);
                break;


            case "signButton":
                    double d = 0.0 - Double.parseDouble(currentEntry);
                    currentEntry = Double.toString(d);
                    t.setText(currentEntry);

                break;


            default:
                currentEntry += b.getText().toString();
                //t.setText("Value 1: " + value1 + "       " + "Value 2: " + value2);
                t.setText(currentEntry);


        }




    }





    public void calculate() {

        TextView t = findViewById(R.id.CalcView);

        switch (currentOperation) {

            case MULTIPLY:
                result = value1 * value2;

                break;

            case DIVIDE:
                result = value1 / value2;
                break;

            case ADD:
                result = value1 + value2;
                break;

            case SUBTRACT:
                result = value1 - value2;
                break;

            case SQUAREROOT:
                result = Math.sqrt(value1);
                break;




        }

        t.setText(Double.toString(result));

    }









    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}






