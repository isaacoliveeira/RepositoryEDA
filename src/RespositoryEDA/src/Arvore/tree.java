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

    private boolean buscar(No no, int valor) {
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

    public void preOrdemRec() {
        preOrdem(raiz);
    }

    private void preOrdem(No raiz) {
        if (raiz != null) {
            System.out.println(raiz.getValor() + " ");
            preOrdem(raiz.getLeft());
            preOrdem(raiz.getRight());
        }
    }

    public void ordemRec() {
        ordem(raiz);
    }

    private void ordem(No raiz) {
        if (raiz != null) {
            ordem(raiz.getLeft());
            System.out.println(raiz.getValor());
            ordem(raiz.getRight());
        }
    }

    public void posOrdem() {
        posOrdem(raiz);
    }

    private void posOrdem(No raiz) {
        if (raiz != null) {
            posOrdem(raiz.getLeft());
            posOrdem(raiz.getRight());
            System.out.println(raiz.getValor());
        }
    }

    private int heigth(No valor) {
        if (valor == null) {
            return 0;
        }
        return valor.getHeight();
    }
    
    private int getBalance(No valor) {
        if (valor == null) { 
            return 0;
        }
        return heigth(valor.getLeft()) - heigth(valor.getRight());
    }
    
    // Rotação à direita (Right Rotation)
    private No rightRotation(No valor) {
        No x = valor.getLeft();
        No y = x.getRight();
    
        // Realiza a rotação
        x.setRight(valor);
        valor.setLeft(y);
    
        // Atualiza as alturas
        valor.setHeight(1 + Math.max(heigth(valor.getLeft()), heigth(valor.getRight())));
        x.setHeight(1 + Math.max(heigth(x.getLeft()), heigth(x.getRight())));
    
        return x;
    }
    
    // Rotação à esquerda (Left Rotation)
    private No leftRotation(No valor) {
        No y = valor.getRight();
        No x = y.getLeft();
    
        // Realiza a rotação
        y.setLeft(valor);
        valor.setRight(x);
    
        // Atualiza as alturas
        valor.setHeight(1 + Math.max(heigth(valor.getLeft()), heigth(valor.getRight())));
        y.setHeight(1 + Math.max(heigth(y.getLeft()), heigth(y.getRight())));
    
        return y;
    }
    
    // Rotação Dupla à esquerda (Left-Right Rotation)
    private No leftRightRotation(No valor) {
        valor.setLeft(rightRotation(valor.getLeft()));
        return leftRotation(valor);
    }
    
    // Rotação Dupla à direita (Right-Left Rotation)
    private No rightLeftRotation(No valor) {
        valor.setRight(leftRotation(valor.getRight()));
        return rightRotation(valor);
    }

    // private int heigth(No valor) {
    //     if (valor == null) {
    //         return 0;
    //     }
    //     return valor.getHeight();
    // }
    
    // private int getBalance(No valor) {
    //     if (valor == null) {
    //         return 0;
    //     }
    //     return heigth(valor.getLeft()) - heigth(valor.getRight());
    // }
    
    // // Rotação à direita (Right Rotation)
    // private No rightRotation(No valor) {
    //     No x = valor.getLeft();
    //     No y = x.getRight();
    
    //     // Realiza a rotação
    //     x.setRight(valor);
    //     valor.setLeft(y);
    
    //     // Atualiza as alturas
    //     valor.setHeight(1 + Math.max(heigth(valor.getLeft()), heigth(valor.getRight())));
    //     x.setHeight(1 + Math.max(heigth(x.getLeft()), heigth(x.getRight())));
    
    //     return x;
    // }
    
    // // Rotação à esquerda (Left Rotation)
    // private No leftRotation(No valor) {
    //     No y = valor.getRight();
    //     No x = y.getLeft();
    
    //     // Realiza a rotação
    //     y.setLeft(valor);
    //     valor.setRight(x);
    
    //     // Atualiza as alturas
    //     valor.setHeight(1 + Math.max(heigth(valor.getLeft()), heigth(valor.getRight())));
    //     y.setHeight(1 + Math.max(heigth(y.getLeft()), heigth(y.getRight())));
    
    //     return y;
    // }
    
    // // Rotação Dupla à esquerda (Left-Right Rotation)
    // private No leftRightRotation(No valor) {
    //     valor.setLeft(leftRotation(valor.getLeft()));
    //     return rightRotation(valor);
    // }
    
    // // Rotação Dupla à direita (Right-Left Rotation)
    // private No rightLeftRotation(No valor) {
    //     valor.setRight(rightRotation(valor.getRight()));
    //     return leftRotation(valor);
    // }
    

    private No inserirBalaceado(No raiz, int valor) {
        if (raiz == null) {
            raiz = new No(valor);
        }

        if (valor < raiz.getValor()) {
            raiz.setLeft(inserirBalaceado(raiz.getLeft(), valor));
        } else if (valor > raiz.getValor()) {
            raiz.setRight(inserirBalaceado(raiz.getRight(), valor));
        } else {
            return raiz;
        }

        raiz.setHeight(1 + Math.max(heigth(raiz.getLeft()), heigth(raiz.getRight())));

        int balanco = getBalance(raiz); // altura

        if (balanco > 1 && valor < raiz.getLeft().getValor()) {
            return rightRotation(raiz);
        }

        if (balanco < -1 && valor > raiz.getRight().getValor()) {
            return leftRotation(raiz);
        }

        if (balanco > 1 && valor > raiz.getLeft().getValor()) {
            return leftRightRotation(raiz);
        }

        if (balanco < -1 && valor < raiz.getRight().getValor()) {
            return rightLeftRotation(raiz);
        }

        return raiz;
    }

    public void inserirBalaceado(int valor) {
        raiz = inserirBalaceado(raiz, valor);
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