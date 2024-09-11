
public class TreeB {
    private No raiz;
    private int ordem;

    public TreeB(int ordem) {
        this.ordem = ordem;
        this.raiz = new No(ordem, true);
    }

    public No getRaiz() {
        return raiz;
    }

    public void inserir(int valor) {
        No raiz = this.raiz;
        if (raiz.getElementos().size() == ordem - 1) {
            No novaRaiz = new No(ordem, false);
            this.raiz = novaRaiz;
            novaRaiz.getFilhos().add(raiz);
            dividirFilho(novaRaiz, 0);
            inserirNaoCheio(novaRaiz, valor);
        } else {
            inserirNaoCheio(raiz, valor);
        }
    }

    private void inserirNaoCheio(No no, int chave) {
        int i = no.getElementos().size() - 1;
        if (no.isEhFolha()) {
            no.getElementos().add(0); // Adiciona um espaço no final
            while (i >= 0 && chave < no.getElementos().get(i)) {
                no.getElementos().set(i + 1, no.getElementos().get(i));
                i--;
            }
            no.getElementos().set(i + 1, chave);
        } else {
            while (i >= 0 && chave < no.getElementos().get(i)) {
                i--;
            }
            i++;
            No filho = no.getFilhos().get(i);
            if (filho.getElementos().size() == ordem - 1) {
                dividirFilho(no, i);
                if (chave > no.getElementos().get(i)) {
                    i++;
                }
            }
            inserirNaoCheio(no.getFilhos().get(i), chave);
        }
    }

    private void dividirFilho(No pai, int i) {
        No noCheio = pai.getFilhos().get(i);
        No novoNo = new No(ordem, noCheio.isEhFolha());
        int t = ordem / 2;

        // Adiciona o elemento do meio ao nó pai
        pai.getElementos().add(i, noCheio.getElementos().get(t - 1));
        pai.getFilhos().add(i + 1, novoNo);

        // Move a segunda metade dos elementos para o novo nó
        novoNo.getElementos().addAll(noCheio.getElementos().subList(t, noCheio.getElementos().size()));
        noCheio.getElementos().subList(t - 1, noCheio.getElementos().size()).clear();

        // Move a segunda metade dos filhos para o novo nó
        if (!noCheio.isEhFolha()) {
            novoNo.getFilhos().addAll(noCheio.getFilhos().subList(t, noCheio.getFilhos().size()));
            noCheio.getFilhos().subList(t, noCheio.getFilhos().size()).clear();
        }
    }

    public void imprimir() {
        imprimir(this.raiz, 0);
    }

    private void imprimir(No no, int nivel) {
        System.out.println("Nivel " + nivel + ": " + no.getElementos());
        if (!no.isEhFolha()) {
            for (No filho : no.getFilhos()) {
                imprimir(filho, nivel + 1);
            }
        }
    }

    public int numeroElemento(No no) {
        int count = 0;
        for (int i = 0; i < no.getElemento().length; i++) {
            if (no.getElemento()[i] != 0) {
                count++;
            }
        }
        return count;
    }
}
