package src.RespositoryEDA.src.Listas;

public class Main {
    public static void main(String[] args) {
        ListaEncadeadaSimples listaEncadeadaSimples = new ListaEncadeadaSimples();
        listaEncadeadaSimples.add(1);
        listaEncadeadaSimples.add(2);
        listaEncadeadaSimples.addIndex(3, 2);
        listaEncadeadaSimples.add(4);
//        System.out.println(listaEncadeadaSimples.getTail().getProximoElemento());
//        System.out.println(listaEncadeadaSimples.getHead());


        System.out.println("O tamanho da lista é: "+ listaEncadeadaSimples.getSize());
        System.out.println("O primeiro elemento é:" + listaEncadeadaSimples.getHead().getValor());
        System.out.println("O ultimo elemento é:" + listaEncadeadaSimples.getTail().getValor());

    }
}
