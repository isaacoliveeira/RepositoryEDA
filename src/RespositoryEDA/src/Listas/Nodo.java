package src.RespositoryEDA.src.Listas;

import src.RespositoryEDA.src.TableHash.Aluno;

public class Nodo {
    public Nodo proximo;
    public Aluno dados;
    private int valor;
    private Nodo proximoElemento;

    private Nodo anteriorElemento;


    public Nodo(int valor, Nodo proximoElemento) {
        this.valor = valor;
        this.proximoElemento = proximoElemento;
    }

    public Nodo(Aluno dados) {
    }

    public Nodo getAnteriorElemento() {
        return anteriorElemento;
    }

    public void setAnteriorElemento(Nodo anteriorElemento) {
        this.anteriorElemento = anteriorElemento;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodo getProximoElemento() {
        return proximoElemento;
    }

    public void setProximoElemento(Nodo proximoElemento) {
        this.proximoElemento = proximoElemento;
    }


//    @Override
//    public String toString() {
//        return "Node{" +
//                "valor=" + valor +
//                ", proximoElemento: " + proximoElemento +
//                "}";
//    }
}
