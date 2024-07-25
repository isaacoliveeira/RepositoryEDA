package src.RespositoryEDA.src.Listas;

public class MainListaCircular {
    public static void main(String[] args) {
//
//        ListaCircularDupla listaCircularDupla = new ListaCircularDupla();
//        listaCircularDupla.add(8);
//        listaCircularDupla.add(3);
//        listaCircularDupla.add(5);
//        listaCircularDupla.add(7);
//        listaCircularDupla.addIndex(14,2);
//        listaCircularDupla.remover(3);
//
//
//        System.out.println("Tamanho: " + listaCircularDupla.getsize());
//        System.out.println("O primerio elemento é: " + listaCircularDupla.gethead().getValor());
//        System.out.println("O último elemento é: " + listaCircularDupla.gettail().getValor());
//        System.out.println("O próximo elemento do último é: " + listaCircularDupla.gettail().getProximoElemento().getValor());
//        System.out.println("O elemento anterior do primeiro é: " + listaCircularDupla.gethead().getAnteriorElemento().getValor());
//        System.out.println("O próximo elemento do primeiro é: " + listaCircularDupla.gethead().getProximoElemento().getValor());
//        System.out.println(listaCircularDupla.get(0).getValor());
//        System.out.println(listaCircularDupla.get(1).getValor());
//        System.out.println(listaCircularDupla.get(2).getValor());
//        System.out.println(listaCircularDupla.get(3).getValor());
//        System.out.println(listaCircularDupla.get(4).getValor());

        ListaCircularSimples listaCircularSimples = new ListaCircularSimples();
        listaCircularSimples.add(5);
        listaCircularSimples.add(2);
        listaCircularSimples.add(3);
        listaCircularSimples.add(1);
        listaCircularSimples.add(4);
        listaCircularSimples.remover(4);
        listaCircularSimples.remover(1);
        listaCircularSimples.add(8);
//        listaCircularSimples.remover(2);



        System.out.println("Tamanho: " + listaCircularSimples.getsize());
        System.out.println("Primeiro elemento: "+ listaCircularSimples.gethead().getValor());
        System.out.println("Segundo elemento: " + listaCircularSimples.gethead().getProximoElemento().getValor());
        System.out.println("Ultimo elemento da lista: " + listaCircularSimples.gethead().getAnteriorElemento().getValor());
        System.out.println("O Anterior do primeiro é: " + listaCircularSimples.gethead().getAnteriorElemento().getValor());

    }
}
