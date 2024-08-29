package src.Arvore.AVL.B;


public class No {

    private int[] elementos;
    private No[] filhos;
    private No pai;
    private boolean ehFolha;
    private int ordem;
    
    public No(int ordem) {

        this.ordem = ordem;
        this.elementos = new int[ordem - 1];
        this.filhos = new No[ordem];
        this.ehFolha = false;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public int[] getElementos() {
        return elementos;
    }

    public void setElementos(int[] elementos) {
        this.elementos = elementos;
    }

    public No[] getFilhos() {
        return filhos;
    }

    public void setFilhos(No[] filhos) {
        this.filhos = filhos;
    }

    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

    public boolean isEhFolha() {
        return ehFolha;
    }

    public void setEhFolha(boolean ehFolha) {
        this.ehFolha = ehFolha;
    }
}
