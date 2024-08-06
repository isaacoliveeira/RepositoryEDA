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
        if (raiz != null) {
            raiz = removerUltimo(raiz);
        }
    }

    private No removerUltimo(No atual) {
        if (atual.getRight() == null) {
            if (atual.getLeft() != null) {
                return atual.getLeft();
            } else {
                return null;
            }
        }
        atual.setRight(removerUltimo(atual.getRight()));
        return atual;
    }

    public void removerPrimeiro() {
        if (raiz != null) {
            raiz = removerPrimeiro(raiz);
        }
    }

    private No removerPrimeiro(No atual) {
        if (atual.getLeft() == null) {
            if (atual.getRight() != null) {
                return atual.getRight();
            } else {
                return null;
            }
        }
        atual.setLeft(removerPrimeiro(atual.getLeft()));
        return atual;
    }

    public void imprimirArvore() {
        imprimirArvore(raiz);
    }

    private void imprimirArvore(No atual) {
        if (atual != null) {
            System.out.println("Nó: " + atual.getValor());

            if (atual.getLeft() != null) {
                System.out.println("esquerda: " + atual.getLeft().getValor());
            } else {
                System.out.println("esquerda: Nenhum");
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