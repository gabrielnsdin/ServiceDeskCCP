package deswebmob.ftce.usjt.br.servicedesk.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import deswebmob.ftce.usjt.br.servicedesk.R;
import deswebmob.ftce.usjt.br.servicedesk.model.Chamado;
import deswebmob.ftce.usjt.br.servicedesk.model.ChamadoAdapter;
import deswebmob.ftce.usjt.br.servicedesk.model.Data;
/**
 * @author Gabriel do Nascimento 816113722
 */
public class ListarChamadosActivity extends Activity {
    public  static  final  String CHAMADO = "br.usjt.deswebmob.servicedesk.chamado";
    ArrayList<Chamado> chamados;
    ListView listView;
    Activity contexto;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_chamados);
        Intent intent = getIntent();
        String nomeFila = intent.getStringExtra(MainActivity.FILA);
        chamados = Data.buscarChamados(nomeFila);
        listView = findViewById(R.id.lista_chamados);
        ChamadoAdapter adapter = new ChamadoAdapter(this,chamados);

//                new ArrayAdapter<Chamado>(this,
//                android.R.layout.simple_list_item_1,chamados);
        listView.setAdapter(adapter);
        contexto = this;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int positon, long id){
                    Chamado chamado = chamados.get(positon);
                    Intent intent1 = new Intent( contexto ,DetalheChamadoActivity.class);
                    intent1.putExtra(CHAMADO,chamado.getDescricao());
                    startActivity(intent1);
                }
            }
        );

    };
}
