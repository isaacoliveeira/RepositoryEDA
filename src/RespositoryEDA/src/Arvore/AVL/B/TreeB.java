package src.Arvore.AVL.B;

public class TreeB {

    private No raiz;
    private int ordem;

    public TreeB(int ordem) { this.raiz = null; this.ordem = ordem; }

    public No getRaiz() { return raiz;}

    public void inserir(int valor) {
        if (raiz == null) {
            raiz = new No(ordem, true);
            raiz.getElemento()[0] = valor;
        } else {

        }
    }

    public void inserirElemento(No no, int elementos) {

    }

    public int numeroElemento(No no) {
        int count = 0;
        for (int i = 0; i < no.getElemento().length; i++) {
            if (no.getElemento()[i] != 0) {
                count++;
            }
        }
        return count;
    }
}
