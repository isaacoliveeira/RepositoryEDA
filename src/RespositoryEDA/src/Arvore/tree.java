package src.Arvore;

public class tree {

    private No raiz;

    public tree() {
        this.raiz = null;
    }

    public No getRaiz() {
        return raiz;
    }

    public void inserir(int valor) {
        if (raiz == null) {
            raiz = new No(valor);
        } else {
            inserirRecursivo(raiz, valor);
        }
    }

    private void inserirRecursivo(No atual, int valor) {
        if (valor < atual.getValor()) {
            if (atual.getLeft() == null) {
                atual.setLeft(new No(valor));
            } else {
                inserirRecursivo(atual.getLeft(), valor);
            }
        } else {
            if (atual.getRight() == null) {
                atual.setRight(new No(valor));
            } else {
                inserirRecursivo(atual.getRight(), valor);
            }
        }
    }


    public void removerUltimo() {
        if (raiz.getRight() == null ) {
            raiz = null;
            return;
        }
        removerUltimo(raiz.getRight(), raiz);
    }

    private void removerUltimo(No no, No anterior) {
        if(no.getRight() == null) {
            if (no.getLeft() == null) {
                anterior.setRight(null);
                return;
            }
            anterior.setRight(no.getLeft());
            return;
        }
        removerUltimo(no.getRight(), anterior.getRight());
    }

    public void removerPrimeiro() {
        if (raiz == null) {
            System.out.println("A árvore está vazia.");
            return;
        }
        if (raiz.getLeft() == null) {
            raiz = null;
            return;
        }
        removerPrimeiro(raiz.getLeft(), raiz);
    }

    private void removerPrimeiro(No no, No anterior) {
        if (no.getLeft() == null) {
            if (no.getRight() == null) {
                anterior.setLeft(null);
            } else {
                anterior.setLeft(no.getRight());
            }
        } else {
            removerPrimeiro(no.getLeft(), no);
        }
    }

    public boolean buscar(int valor) {
        return buscar(raiz, valor);
    }

    public boolean buscar(No no, int valor) {
        if (no == null) {
            return false;
        }
        if (no.getValor() == valor) {
            return true;
        }
        if (valor < no.getValor()) {
            return buscar(no.getLeft(), valor);
        } else {
            return buscar(no.getRight(), valor);
        }
    }

    public void imprimirArvore() {
        imprimirArvore(raiz);
    }

    private void imprimirArvore(No atual) {
        if (atual != null) {
            System.out.println("Nó: " + atual.getValor());

            if (atual.getLeft() != null) {
                System.out.println("left: " + atual.getLeft().getValor());
            } else {
                System.out.println("left: Nenhum");
            }

            if (atual.getRight() != null) {
                System.out.println("direita: " + atual.getRight().getValor());
            } else {
                System.out.println("direita: Nenhum");
            }

            // Recursivamente imprimir os filhos
            imprimirArvore(atual.getLeft());
            imprimirArvore(atual.getRight());
        }
    }
}