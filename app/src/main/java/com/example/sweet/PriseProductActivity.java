package com.example.sweet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.sweet.base.Manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.sql.StatementEvent;

public class PriseProductActivity extends AppCompatActivity {
    private Manager manager;
    private TextView textViewResult;

    //содержит в себе все 1граммы
    private ArrayList<Double> gramArray = new ArrayList<>();
    //содержит в себе все спинеры выбраные пользователем
    private ArrayList<Spinner> spinners= new ArrayList<Spinner>();
    //содержит в себе порядковый номер в arrayList каждого спинера
    private ArrayList<Integer> local1 = new ArrayList<>();
    //БАЗА содержит в себе 1грамм выбраного пользователем элемента
    private ArrayList<Double> oneGramUser = new ArrayList<>();
    //
    private ArrayList<View> editView = new ArrayList<View>();
    //БАЗА значение editText
    private  ArrayList<Integer> editListGram= new ArrayList<>();
    //финальный лист с результатом!!!
    private ArrayList<Double> finalList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prise_product);
        manager = new Manager(this);
        textViewResult = findViewById(R.id.textViewResult);

    }

    @Override
    protected void onResume() {
        super.onResume();
        manager.openBase();

    }


    public void onButtonPriseTwo(View view){
        for(Spinner s : spinners){
            Integer d= s.getSelectedItemPosition();
            local1.add(d);

        }
        for(int i=0; i<local1.size(); i++){

            oneGramUser.add(gramArray.get(local1.get(i)));
        }


        String [] item = new String[editView.size()];
        for(int i=0; i<editView.size();i++){
            item[i] = ((EditText) editView.get(i).findViewById(R.id.editText))
                    .getText().toString();
        }
        for(String s : item) {
            editListGram.add(Integer.valueOf(s));
        }



        for(int i=0; i<oneGramUser.size();i++){
            Double r = oneGramUser.get(i)*editListGram.get(i);
            finalList.add(r);
        }
        Double finalCount= finalList.stream().mapToDouble(Double::doubleValue).sum();
        textViewResult.setText(String.valueOf(finalCount+ " руб"));

    }


    public void onButtonAddSpinner(View view){
        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.rel2);
        Spinner spinner = new Spinner(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.spinner_adapter_one, manager.readBaseName());
        adapter.setDropDownViewResource(R.layout.spiner_adapter_two);
        spinner.setAdapter(adapter);
        mainLayout.addView(spinner);
        spinners.add(spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int position, long id) {
                gramArray = manager.readBaseGram();
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        LinearLayout mainLayout2 = (LinearLayout) findViewById(R.id.lin2);
        final View view1 = getLayoutInflater().inflate(R.layout.custom_edit_text, null);
        EditText editText = (EditText) view1.findViewById(R.id.editText);
        View line = (View) view1.findViewById(R.id.line);
        editView.add(view1);
        mainLayout2.addView(view1);




    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        manager.closeDb();
    }
}