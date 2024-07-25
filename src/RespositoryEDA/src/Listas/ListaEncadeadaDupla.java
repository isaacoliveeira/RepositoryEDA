package src.RespositoryEDA.src.Listas;

public class ListaEncadeadaDupla {
    private Nodo head;
    private Nodo Tail;
    private int size;


    public ListaEncadeadaDupla() {
        this.size = 0;
    }

    public Nodo gethead() {
        return head;
    }

    public void sethead(Nodo head) {
        this.head = head;
    }

    public Nodo getTail() {
        return Tail;
    }

    public void setTail(Nodo Tail) {
        this.Tail = Tail;
    }

    public int getsize() {
        return size;
    }

    public void setsize(int size) {
        this.size = size;
    }

    public void adicionar(int valor) {
        Nodo elemento = new Nodo(valor, null);
        if (this.head == null && this.Tail == null) {
            this.head = elemento;
            this.Tail = elemento;
        } else {
            this.Tail.setProximoElemento(elemento);
            this.Tail = elemento;
        }
        size++;
    }

    public void remover(int valor) {
        Nodo anterior = null;
        Nodo atual = this.head;
        for (int i = 0; i < this.getsize(); i++) {
            if (atual.getValor() == valor) {
                if (this.size == 0) {
                    this.head = null;
                    this.Tail = null;
                } else if (atual == head) {
                    this.head = atual.getProximoElemento();
                    atual.setProximoElemento(null);
                } else if (atual == Tail) {
                    Tail = anterior;
                } else {
                    anterior.setProximoElemento(atual.getProximoElemento());
                    atual = null;
                }
                this.size--;
                break;
            }
            anterior = atual;
            atual = atual.getProximoElemento();
        }
    }

    public Nodo get(int posicao) {
        Nodo atual = this.head;
        for ( int i=0; i < posicao; i++) {
            if (atual.getProximoElemento() != null) {
                atual = atual.getProximoElemento();
            }
        }
        return atual;
    }

    public void addIndex(int valor, int index) {
        Nodo elemento = new Nodo(valor, null);
        if (index == 0) {
            elemento.setProximoElemento(head);
            head = elemento;
        } else {
            Nodo anterior = new Nodo(valor, null);
            for ( int i = 0; i < index; i++) {
                elemento = elemento.getProximoElemento();
            }
            elemento.setProximoElemento(elemento.getProximoElemento());
            elemento.setProximoElemento(elemento);
        }
        size++;
    }

}
