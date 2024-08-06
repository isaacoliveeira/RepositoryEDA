package src.Arvore;

public class No {
    
    private int valor;
    No left;
    private No right;


    public No(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public No getLeft() {
        return left;
    }

    public No getRight() {
        return right;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setLeft(No left) {
        this.left = left;
    }
    
    public void setRight(No right) {
        this.right = right;
    }
}
