package com.agenda.compromissos.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.agenda.compromissos.R;
import com.facebook.stetho.Stetho;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Stetho.initializeWithDefaults(this);
    }

    public void carregarItemMenu(View v) {
        switch (v.getId()){
            case R.id.buttonInserir:
                carregarIntent(InserirActivity.class);
                break;

            case R.id.buttonBuscarPorData:
                carregarIntent(BuscarPorDataActivity.class);
                break;
        }
    }

    private void carregarIntent(Class classe) {
        Intent intent = new Intent(MainActivity.this, classe);
        startActivity(intent);
    }
}
