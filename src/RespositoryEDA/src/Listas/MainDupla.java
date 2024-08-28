package src.Listas;

public class MainDupla {
    public static void main(String[] args) {
        ListaEncadeadaDupla listaEncadeadaDupla = new ListaEncadeadaDupla();

        listaEncadeadaDupla.adicionar(1);
        listaEncadeadaDupla.adicionar(2);
        listaEncadeadaDupla.adicionar(3);
        listaEncadeadaDupla.adicionar(5);
        listaEncadeadaDupla.addIndex(4, 3);

        System.out.println("O tamanho é: " + listaEncadeadaDupla.getsize());
        System.out.println("O primeiro elemento: " + listaEncadeadaDupla.gethead().getValor());
        System.out.println("O último elemento é: " + listaEncadeadaDupla.getTail().getValor());
        System.out.println("o valor da posição buscada é " + listaEncadeadaDupla.get(0).getValor());

    }

}
