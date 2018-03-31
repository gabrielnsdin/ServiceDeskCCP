package deswebmob.ftce.usjt.br.servicedesk.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.util.ArrayList;

import deswebmob.ftce.usjt.br.servicedesk.R;
import deswebmob.ftce.usjt.br.servicedesk.model.Chamado;
import deswebmob.ftce.usjt.br.servicedesk.model.ChamadoNetwork;

/**
 * @author Gabriel do Nascimento 816113722
 */
public class MainActivity extends Activity {

    public static final String CHAMADOS = "br.usjt.deswebmob.servicedesk.chamados";
    private EditText txtFila;
    Context contexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtFila = findViewById(R.id.busca_fila);
        contexto = this;
    }

    public void buscarChamados(View view) {
        String fila = txtFila.getText().toString();
        new DownloadJsonChamados().execute("http://192.168.1.102:8080/arqsw_sdesk_a4/chamado");

    }

    private class DownloadJsonChamados extends AsyncTask<String, Void, ArrayList<Chamado>> {

        @Override
        protected ArrayList<Chamado> doInBackground(String... strings) {

            ArrayList<Chamado> chamados = new ArrayList<>();
            try {
                chamados = ChamadoNetwork.buscarChamados(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return chamados;
        }

        protected void onPostExecute(ArrayList<Chamado> chamados){
            Intent intent = new Intent(contexto, ListarChamadosActivity.class);
            intent.putExtra(CHAMADOS, chamados);
            startActivity(intent);
        }

    }
}
