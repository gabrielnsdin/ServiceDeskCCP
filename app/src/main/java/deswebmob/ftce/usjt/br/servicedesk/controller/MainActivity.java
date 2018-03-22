package deswebmob.ftce.usjt.br.servicedesk.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import deswebmob.ftce.usjt.br.servicedesk.R;
/**
 * @author Gabriel do Nascimento 816113722
 */
public class MainActivity extends Activity {

    private EditText txtNome;
    public static final String FILA = "br.usjt.deswebmob.servicedesk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNome = findViewById(R.id.busca_fila);
    }
    public void buscarChamados(View view){
        String fila = txtNome.getText().toString();
        Intent intent = new Intent(this, ListarChamadosActivity.class);
        intent.putExtra(FILA, fila);
        startActivity(intent);

    }
}
