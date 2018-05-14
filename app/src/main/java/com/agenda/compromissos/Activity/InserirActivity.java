package com.agenda.compromissos.Activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.agenda.compromissos.Factory.AppDatabase;
import com.agenda.compromissos.Model.Compromisso;
import com.agenda.compromissos.R;

public class InserirActivity extends Activity {

    private EditText editTitulo;
    private EditText editDescricao;
    private EditText editData;
    private EditText editImportancia;
    private Button buttonSalvar;
    private Button buttonVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir);

        AppDatabase appDatabase = AppDatabase.getDatabase(this);

        editTitulo = (EditText) findViewById(R.id.editTitulo);
        editDescricao = (EditText) findViewById(R.id.editDescricao);
        editData = (EditText) findViewById(R.id.editData);
        editImportancia = (EditText) findViewById(R.id.editImportancia);
    }

    public void gravarCompromisso(View v) {
        Compromisso compromisso = new Compromisso();
        AppDatabase appDatabase = AppDatabase.getDatabase(this);

        String titulo = editTitulo.getText().toString();
        String descricao = editDescricao.getText().toString();
        String data = editData.getText().toString();
        String importancia = editImportancia.getText().toString();

        compromisso.setTitulo(titulo);
        compromisso.setDescricao(descricao);
        compromisso.setDataCompromisso(data);
        compromisso.setImportancia(Integer.parseInt(importancia));
        compromisso.setRealizado(Integer.parseInt("0"));

        long result = appDatabase.compromissoDAO().insertCompromisso(compromisso);
        if(result > 0) {
            Toast.makeText(this, "Compromisso adicionado com sucesso.", Toast.LENGTH_LONG).show();
            editTitulo.setText("");
            editDescricao.setText("");
            editData.setText("");
            editImportancia.setText("");
        } else {
            Toast.makeText(this, "Compromisso não cadastrado.", Toast.LENGTH_SHORT).show();
        }
    }

}
