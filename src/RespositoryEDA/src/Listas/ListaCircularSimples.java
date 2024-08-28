package src.Listas;

public class ListaCircularSimples {

    private Nodo head;
    private Nodo tail;
    private int size;


    public ListaCircularSimples() {
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
        if (size == 0) {
            this.head = elemento;
        } else {
            Nodo anterior = get(size-1);
            elemento.setProximoElemento(head);
            anterior.setProximoElemento(elemento);
            head.setAnteriorElemento(elemento);
        }
        size++;
    }

    public void remover(int valor) {
        Nodo anterior = null;
        Nodo atual = this.head;
        Nodo proximo = atual.getProximoElemento();

        for (int i = 0; i < this.getsize(); i++) {
            if (atual.getValor() == valor) {
                if (size == 0) { //nao tiver elemento
                    this.head = null;
                } else if (atual == head) { //primeiro
                    proximo.setAnteriorElemento(atual.getAnteriorElemento());
                    atual.setProximoElemento(proximo);
                    head = proximo;
                } else if (atual.getProximoElemento() == head) {  //ultimo
                    Nodo ultimo = atual;
                    ultimo.setAnteriorElemento(anterior);
                    anterior.setProximoElemento(proximo);
                    head.setAnteriorElemento(anterior);
                    head = proximo;
                } else { //meio
                    proximo.setAnteriorElemento(atual.getAnteriorElemento());
                    anterior.setProximoElemento(proximo);
                }
                this.size--;
                break;
            }
            anterior = atual;
            atual = atual.getProximoElemento();
            proximo = atual.getProximoElemento();
        }
    }


    public void addIndex(int valor, int index) {
        Nodo elemento = new Nodo(valor, null);
        if (index == 0) {
            if (size == 0){
                head.setAnteriorElemento(elemento);
                elemento.setProximoElemento(head);
                head = elemento;
            } else {
                Nodo ultimo = head;
                while (ultimo.getProximoElemento() != head) {
                    ultimo = ultimo.getProximoElemento();
                }
                elemento.setProximoElemento(head);
                head = elemento;
                ultimo.setProximoElemento(head);
                head.setAnteriorElemento(ultimo);
            }
        } else {
            Nodo atual = head;
            for (int i=0; i < index - 1; i++) {
                atual = atual.getProximoElemento();
            }
            Nodo proximo = atual.getProximoElemento();
            proximo.setAnteriorElemento(elemento);
            atual.setProximoElemento(elemento);
            elemento.setProximoElemento(proximo);
            elemento.setAnteriorElemento(atual);

        }

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

