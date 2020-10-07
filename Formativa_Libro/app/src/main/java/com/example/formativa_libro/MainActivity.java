package com.example.formativa_libro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ListView listView;
    List<String> listlibros = new ArrayList<>();
    ArrayAdapter<String> libadapter;

    EditText codigo, nombre, autor;
    Button ingresar, cancelar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        codigo = findViewById(R.id.edtcodigo);
        nombre = findViewById(R.id.edtnombre);
        autor= findViewById(R.id.edtautor);
        ingresar = findViewById(R.id.btningresar);
        cancelar = findViewById(R.id.btncancelar);
        ingresar.setOnClickListener(this);
        cancelar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String lcodigo = codigo.getText().toString();
        String lnombre = nombre.getText().toString();
        String lautor=autor.getText().toString();

            switch (v.getId()){

                case R.id.btningresar:
                    if(TextUtils.isEmpty(codigo.getText().toString()) ||  TextUtils.isEmpty(nombre.getText().toString())
                            ||  TextUtils.isEmpty(autor.getText().toString())){
                        Toast.makeText(getApplicationContext(), "Datos Requeridos", Toast.LENGTH_LONG).show();
                    }else {

                    listlibros.add("Codigo: " + lcodigo + ", Nombre: " + lnombre + ", Autor: " + lautor);
                    libadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listlibros);
                    listView.setAdapter(libadapter);

                    codigo.setText("");
                    nombre.setText("");
                    autor.setText("");

                }
                case R.id.btncancelar:

                    codigo.setText("");
                    nombre.setText("");
                    autor.setText("");
            }
    }
}