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
        balancear(raiz);
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

    public int heigth(No valor) {
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

    private int maior(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }
    
    // Rotação à direita
    private No rightRotation(No valor) { // valor inicialmente é a raiz
        No x = valor.getLeft(); // filho esquerdo
        No y = x.getRight(); // filho direito do x
    
        // Realiza a rotação
        x.setRight(valor); //   a raiz passa a ser filho do filho
        valor.setLeft(y); // 
    
        // Atualiza as alturas
        valor.setHeight(1 + maior(heigth(valor.getLeft()), heigth(valor.getRight())));
        x.setHeight(1 + maior(heigth(x.getLeft()), heigth(x.getRight())));
    
        return x;
    }
    
    // Rotação à esquerda
    private No leftRotation(No valor) {
        No y = valor.getRight();
        No x = y.getLeft();
    
        // Realiza a rotação
        y.setLeft(valor);
        valor.setRight(x);
    
        // Atualiza as alturas
        valor.setHeight(1 + maior(heigth(valor.getLeft()), heigth(valor.getRight())));
        y.setHeight(1 + maior(heigth(y.getLeft()), heigth(y.getRight())));

        return y;
    }
    
    // Rotação Dupla à esquerda
    private No leftRightRotation(No valor) {
        valor.setLeft(leftRotation(valor.getLeft()));
        return rightRotation(valor);
    }
    
    // Rotação Dupla à direita
    private No rightLeftRotation(No valor) {
        valor.setRight(rightRotation(valor.getRight()));
        return leftRotation(valor);
    }
    
 
    private No balancear(No raiz) {
        if (raiz == null) {
            return null;
        }
    
        raiz.setHeight(1 + maior(heigth(raiz.getLeft()), heigth(raiz.getRight())));
    
        int balance = getBalance(raiz);
    
        if (balance > 1) { //entra aqui se estiver desbalanceada
            if (getBalance(raiz.getLeft()) >= 0) {
                return rightRotation(raiz);
            } else {
                raiz.setLeft(leftRotation(raiz.getLeft()));
                return rightRotation(raiz);
            }
        }
    
        if (balance < -1) {
            if (getBalance(raiz.getRight()) <= 0) {
                return leftRotation(raiz);
            } else {
                raiz.setRight(rightRotation(raiz.getRight()));
                return leftRotation(raiz);
            }
        }
        return raiz;
    }

    public void inserirBalanceado(int valor) {
        raiz = inserirNo(raiz, valor);
    }
    
    private No inserirNo(No raiz, int valor) {
        if (raiz == null) {
            return new No(valor);
        }
    
        if (valor < raiz.getValor()) {
            raiz.setLeft(inserirNo(raiz.getLeft(), valor));
        } else if (valor > raiz.getValor()) {
            raiz.setRight(inserirNo(raiz.getRight(), valor));
        } else {
            return raiz;
        }
    
        raiz.setHeight(1 + maior(heigth(raiz.getLeft()), heigth(raiz.getRight())));
    
        return balancear(raiz);
    }
    

    private No remover(No raiz, int valor) {
        if (raiz == null) {
            return null;
        }

        if (valor < raiz.getValor()) { // os nó nao possuem filhos
            raiz.setLeft(remover(raiz.getLeft(), valor));
        } else if (valor > raiz.getValor()) {   // os nó nao possuem filhos
            raiz.setRight(remover(raiz.getRight(), valor));
        } else { 
            if (raiz.getLeft() == null) {
                return raiz.getRight();
            } else if (raiz.getRight() == null) {
                return raiz.getLeft();
            }
            // nó com dois filhos
            No temp = menorValor(raiz.getRight());

            raiz.setValor(temp.getValor());

            raiz.setRight(remover(raiz.getRight(), temp.getValor()));;
        }
        
        raiz.setHeight(1 + maior(heigth(raiz.getLeft()), heigth(raiz.getRight())));

        return raiz;
    }

    private No menorValor(No valor) {
        No proximo = valor;
        while (proximo.getLeft() != null) {
            proximo = proximo.getLeft();
        }
        return proximo;
    }

    public void remover(int valor) {
        raiz = remover(raiz, valor);
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