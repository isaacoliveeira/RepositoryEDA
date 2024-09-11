package src.Arvore.AVL.PV;

public class No {
    int valor;
    No left, rigth, parent;
    boolean color;

    //false = preto
    //true = red

    public No(int valor) {
        this.valor = valor;
        this.left = null;
        this.rigth = null;
        this.parent = null;
        this.color = true;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public No getLeft() {
        return left;
    }

    public void setLeft(No left) {
        this.left = left;
    }

    public No getRigth() {
        return rigth;
    }

    public void setRigth(No rigth) {
        this.rigth = rigth;
    }

    public No getParent() {
        return parent;
    }

    public void setParent(No parent) {
        this.parent = parent;
    }

    public boolean isRed() {
        return color;
    }

    public boolean isBlack() {
        return !color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    
}
