package deswebmob.ftce.usjt.br.servicedesk.model;

import java.io.Serializable;

/**
 * Created by Gabriel on 22/03/2018.
 */

public class Fila implements Serializable{
    private  int id ;
    private  String nome;
    private  String figura;

    public Fila(int id, String nome, String figura) {
        this.id = id;
        this.nome = nome;
        this.figura = figura;
    }

    public Fila() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFigura() {
        return figura;
    }

    public void setFigura(String figura) {
        this.figura = figura;
    }

    @Override
    public String toString() {
        return "Fila{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", figura='" + figura + '\'' +
                '}';
    }
}
