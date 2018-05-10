package com.agenda.compromissos;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.agenda.compromissos.DAO.CompromissoDAO;
import com.agenda.compromissos.Factory.AppDatabase;
import com.agenda.compromissos.Model.Compromisso;
import com.agenda.compromissos.Model.Importancia;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.agenda.compromissos", appContext.getPackageName());
    }

    @Test
    public void testeInsertBanco() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        AppDatabase app = AppDatabase.getDatabase(appContext);
        CompromissoDAO compromissoDAO = app.compromissoDAO();
        Compromisso compromisso = new Compromisso();

        compromisso.setTitulo("Compromisso Teste");
        compromisso.setDescricao("Descrição do compromisso teste");
        compromisso.setDataCompromisso("10052018");
        compromisso.setImportancia(2);
        compromisso.setRealizado(0);

        assertTrue(compromissoDAO.insertCompromisso(compromisso) > 0);

        Compromisso resultado = compromissoDAO.findByCompromisso(1);

        resultado.setImportancia(Importancia.Baixa.ordinal());
        assertTrue(compromissoDAO.updateCompromisso(resultado) > 0);


    }
}
