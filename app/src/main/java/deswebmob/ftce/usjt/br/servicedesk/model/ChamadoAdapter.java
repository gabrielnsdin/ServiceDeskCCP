package deswebmob.ftce.usjt.br.servicedesk.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import deswebmob.ftce.usjt.br.servicedesk.R;

/**
 * Created by Gabriel on 22/03/2018.
 */

public class ChamadoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Chamado> chamados;

    public ChamadoAdapter(Context context, ArrayList<Chamado> chamados) {
        this.context = context;
        this.chamados = chamados;
    }


    @Override
    public int getCount() {
        return chamados.size();
    }

    @Override
    public Object getItem(int position) {
        return chamados.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view = convertView;

        if (view == null){
            LayoutInflater inflater  = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view  = inflater.inflate(R.layout.linha_chamado,viewGroup,false);

            ImageView imagem = view.findViewById(R.id.imagem_filas);
            TextView  numero =  view.findViewById(R.id.num_status_chamado);
            TextView datas  = view.findViewById(R.id.num_fechamento_chamado);
            TextView descricao = view.findViewById(R.id.decricao_chamado);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.setNumero(numero);
            viewHolder.setDatas(datas);
            viewHolder.setDescricao(descricao);
            viewHolder.setImagem(imagem);
            view.setTag(viewHolder);
        }

        Chamado chamado = chamados.get(position);

        ViewHolder viewHolder = (ViewHolder) view.getTag();

        viewHolder.getImagem().setImageDrawable(Util.getDrawableDinamic(context, chamado.getFila().getFigura()));

        viewHolder.getNumero().setText(String.format("numero: %d -stattus :%s",chamado.getNumero(), chamado.getStatus()));
        viewHolder.getDatas().setText(String.format("abertura: %tD - fechamento: %tD",chamado.getDataAbertura(),chamado.getDataFechamento()));
        viewHolder.getDescricao().setText(chamado.getDescricao());



        return view;
    }
}
