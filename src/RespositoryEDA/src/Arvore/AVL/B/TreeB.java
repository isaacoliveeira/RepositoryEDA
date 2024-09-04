public class TreeB {

    private No raiz;

    public TreeB() { this.raiz = null; }

    public No getRaiz() { return raiz;}

    public void inserir(int[] elementos) {
        if (raiz == null) {
            raiz = new No();
            raiz.inserirElemento(elementos[0]);

        }
    }
    public void inserirElemento(No no, int elementos) {

    }
}