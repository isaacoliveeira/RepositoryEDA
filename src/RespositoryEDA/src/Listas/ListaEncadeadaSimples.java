package src.RespositoryEDA.src.Listas;

public class ListaEncadeadaSimples {

    private Nodo head;
    private Nodo tail;
    private int size;


    public Nodo getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    public void setHead(Nodo head) {
        this.head = head;
    }

    public Nodo getTail() {
        return tail;
    }

    public void setTail(Nodo tail) {
        this.tail = tail;
    }


    public void add(int valor) {
        Nodo elemento = new Nodo(valor, null);
        if (this.size == 0 ) {
            this.head = elemento;
            elemento.setProximoElemento(head);
        } else {
            this.tail.setProximoElemento(elemento);
        }
        this.tail = elemento;
        size++;
    }

    public void addIndex(int valor, int index) {
        Nodo elemento = new Nodo(valor, null);
        if ( index == 0) {
            elemento.setProximoElemento(head);
            head = elemento;
        } else {
            Nodo elementoAnterior = this.head;
            for (int i = 0; i < index - 1; i++) {
                elementoAnterior = elementoAnterior.getProximoElemento();
            }
            elemento.setProximoElemento(elementoAnterior.getProximoElemento());
            elementoAnterior.setProximoElemento(elemento);
        }
        size++;
    }

    public void remove(int index) {
        Nodo atual = get(index);
        if (atual.getProximoElemento() == null) {
            Nodo anterior = get(index - 1);
            anterior.setProximoElemento(atual.getProximoElemento());
            tail = anterior;
        } else if (index == 0) {
            this.head = atual.getProximoElemento();
            //atual.setProximoElemento(null);
        } else {
            Nodo anterior = get(index - 1);
            anterior.setProximoElemento(atual.getProximoElemento());
            //atual.setProximoElemento(null);
        }
        size--;
    }

    public Nodo get(int posicao) {
        Nodo atual = this.head;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximoElemento();
        }
        return atual;
    }
}
