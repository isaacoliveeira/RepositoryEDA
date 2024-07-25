package src.RespositoryEDA.src.Listas;

public class ListaCircularDupla {
    private Nodo head;
    private Nodo tail;
    private int size;


    public ListaCircularDupla() {
        this.size = 0;
    }

    public Nodo gethead() {
        return head;
    }

    public void sethead(Nodo head) {
        this.head = head;
    }

    public Nodo gettail() {
        return tail;
    }

    public void settail(Nodo tail) {
        this.tail = tail;
    }

    public int getsize() {
        return size;
    }

    public void setsize(int size) {
        this.size = size;
    }

    public void add(int valor) {
        Nodo elemento = new Nodo(valor, null);
        if (this.head == null && this.tail == null) {
            this.head = elemento;
            this.tail = elemento;
        } else {
            this.tail.setProximoElemento(elemento);
            this.tail = elemento;
        }
        head.setAnteriorElemento(tail);
        tail.setProximoElemento(head);
        size++;
    }

    public void remover(int valor) {
        Nodo anterior = null;
        Nodo atual = this.head;
        for (int i = 0; i < this.getsize(); i++) {
            if (atual.getValor() == valor) {
                if (this.size == 0) {
                    this.head = null;
                    this.tail = null;
                } else if (atual == head) {
                    this.head = atual.getProximoElemento();
                    atual.setProximoElemento(null);
                } else if (atual == tail) {
                    tail = anterior;
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


    public void addIndex(int valor, int index) {
        Nodo elemento = new Nodo(valor, null);
        if (index == 0) {
            if (size == 0) {
                elemento.setProximoElemento(head);
                head = elemento;
                tail = elemento;
            } else {
                elemento.setProximoElemento(head);
                head.setAnteriorElemento(elemento);
                head = elemento;
            }
        } else {
            Nodo atual = head;
            for (int i = 0; i < index - 1; i++) {
                atual = atual.getProximoElemento();
            }
            Nodo proximo = atual.getProximoElemento();
            elemento.setProximoElemento(proximo);
            elemento.setAnteriorElemento(atual);
            atual.setProximoElemento(elemento);
            proximo.setAnteriorElemento(elemento);

            if (index == size) {
                tail = elemento;
            }
        }
        head.setAnteriorElemento(tail);
        tail.setProximoElemento(head);
        size++;
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

}
