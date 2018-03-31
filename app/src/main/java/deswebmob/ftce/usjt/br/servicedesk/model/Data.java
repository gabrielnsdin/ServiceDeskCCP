package deswebmob.ftce.usjt.br.servicedesk.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Gabriel on 22/03/2018.
 */

public class Data {

    public static ArrayList<Chamado> criarChamados() {
        ArrayList<Chamado> lista = new ArrayList<>();

        Fila fila = new Fila();
        fila.setId(7);
        fila.setNome("Desktops");

        Chamado chamado = new Chamado();
        chamado.setNumero(1);
        chamado.setDataAbertura(new Date());
        chamado.setStatus(Chamado.ABERTO);
        chamado.setDescricao("Computador quebrado");
        chamado.setFila(fila);

        lista.add(chamado);

/*      chamados.add("desktops: chamados1");
        chamados.add("Desktops: Computador da secretária quebrado.");
        chamados.add("Telefonia: Telefone não funciona.");
        chamados.add("Redes: Manutenção no proxy.");
        chamados.add("Servidores: Lentidão generalizada.");
        chamados.add("Novos Projetos: CRM");
        chamados.add("Manutenção Sistema ERP: atualizar versão.");
        chamados.add("Novos Projetos: Rede MPLS");
        chamados.add("Manutenção Sistema de Vendas: incluir pipeline.");
        chamados.add("Manutenção Sistema ERP: erro contábil");
        chamados.add("Novos Projetos: Gestão de Orçamento");
        chamados.add("Novos Projetos: Big Data");
        chamados.add("Manoel de Barros");
        chamados.add("Redes: Internet com lentidão");
        chamados.add("Novos Projetos: Chatbot");
        chamados.add("Desktops: troca de senha");
        chamados.add("Desktops: falha no Windows");
        chamados.add("Novos Projetos: ITIL V3");
        chamados.add("Telefonia: liberar celular");
        chamados.add("Telefonia: mover ramal");
        chamados.add("Redes: ponto com defeito");
        chamados.add("Novos Projetos: ferramenta EMM");*/
        return lista;
    }

    public static ArrayList<Chamado> buscarChamados(String chave) {
        ArrayList<Chamado> lista = criarChamados();
        ArrayList<Chamado> resultado = new ArrayList<>();

        if (chave == null || chave.length() == 0) {
            return lista;
        }

        for (Chamado chamado : lista) {
            if (chamado.getFila().getNome().toUpperCase().contains(chave.toUpperCase())) {
                resultado.add(chamado);
            }

        }
        return resultado;

    }
}
