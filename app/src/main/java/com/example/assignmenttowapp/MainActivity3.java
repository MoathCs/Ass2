package com.example.assignmenttowapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import model.EquationDa;

public class MainActivity3 extends AppCompatActivity {

    private EditText editA;
    private EditText editB;
    private EditText editC;
    private Spinner spinnerTypeEq;
    private TextView formula;
    private TextView tx_res;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setUpViews();
        setupSharedPrefs();
    }

    private void setUpViews(){
        editA = findViewById(R.id.EditA);
        editB = findViewById(R.id.EditB);
        editC = findViewById(R.id.EditC);
        spinnerTypeEq = findViewById(R.id.spinnerTypeEq);
        formula = findViewById(R.id.formula);
        tx_res = findViewById(R.id.tx_res);

        spinnerTypeEq.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    formula.setText(getResources().getText(R.string.formula_ax_b));
                    editC.setVisibility(View.GONE);
                } else {
                    formula.setText(getResources().getText(R.string.formula_ax_2_bx_c));
                    editC.setVisibility(View.VISIBLE);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
    private void setupSharedPrefs(){ // build file and macke refrence in this file
        prefs= PreferenceManager.getDefaultSharedPreferences(this);
        editor=prefs.edit();
    }


    public void ptnOnClick(View view) {
        EquationDa eq = new EquationDa();
        String s1 = editA.getText().toString();
        String s2 = editB.getText().toString();
        String s3 = editC.getText().toString();
        double[] arr;
        if (spinnerTypeEq.getSelectedItem().toString().equals("linear equation")) {
            arr = eq.getData(0, Double.parseDouble(s1), Double.parseDouble(s2));
        } else {
            arr = eq.getData(Double.parseDouble(s1), Double.parseDouble(s2), Double.parseDouble(s3));
        }
        if (arr[0] < 0) {
            tx_res.setText("mems less 0 then no roots");

        } else {
            String str1 = arr[0] + " ";
            String str2 = arr[1] + " ";
            String str3 = arr[2] + " ";

            tx_res.setText("Mems= " + str1 + "\n" + "Root1= " + str2 + "\n" + "Root2=" + str3);
        }
        if (spinnerTypeEq.getSelectedItem().toString().equals("linear equation")) {
            if (arr[0] < 0) {
                editor.putString("No Root","No ROot");
            }
            editor.putString("coefficient_1 ",s1);
            editor.putString("coefficient_2 ",s2);
            editor.putString("memes", String.valueOf(arr[0]));
            editor.putString("Root", String.valueOf(arr[1]));
            } else {
            if (arr[0] < 0) {
                editor.putString("No Root","NO ROOT");
            }
            editor.putString("coefficient_1 ",s1);
            editor.putString("coefficient_2 ",s2);
            editor.putString("coefficient_3 ",s3);
            editor.putString("memes", String.valueOf(arr[0]));
            editor.putString("Root_1", String.valueOf(arr[1]));
            editor.putString("Root_2", String.valueOf(arr[2]));
        }
    }
}