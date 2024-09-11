package src.Arvore.AVL;


public class No {
    
    private int valor;
    private No left;
    private No right;
    private int height;


    public No(int valor) {
        this.valor = valor;
        this.height = 1;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
}