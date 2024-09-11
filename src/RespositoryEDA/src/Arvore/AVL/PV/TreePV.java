package src.Arvore.AVL.PV;

public class TreePV {
    private No raiz;
    No NULO;

    public No getRaiz() {
        return raiz;
    }

    public No getNULO() {
        return NULO;
    }

    public TreePV() {
        NULO = new No(0);
        NULO.color = false;
        raiz = NULO;
    }

    private void preOrdemHelper(No no) {
        if (no != NULO) {
            System.out.print(no.valor + " ");
            preOrdemHelper(no.left);
            preOrdemHelper(no.rigth);
        }
    }

    public void preOrdem() {
        preOrdemHelper(this.raiz);
        System.out.println();
    }

    // Pesquisa na árvore
    private No pesquisar(No no, int valor) {
        if (no == NULO || valor == no.valor) {
            return no;
        }
        if (valor < no.valor) {
            return pesquisar(no.left, valor);
        }
        return pesquisar(no.rigth, valor);
    }

    public No pesquisar(int valor) {
        return pesquisar(this.raiz, valor);
    }

    private void corrigirInsercao(No no) {
        No tio;
        while (no.parent.color) {
            if (no.parent == no.parent.parent.rigth) {
                tio = no.parent.parent.left;
                if (tio.color) {
                    no.parent.color = false;
                    tio.color = false;
                    no.parent.parent.color = true;
                    no = no.parent.parent;
                } else {
                    if (no == no.parent.left) {
                        no = no.parent;
                        rotacaorigth(no);
                    }
                    no.parent.color = false;
                    no.parent.parent.color = true;
                    rotacaoleft(no.parent.parent);
                }
            } else {
                tio = no.parent.parent.rigth;
                if (tio.color) {
                    no.parent.color = false;
                    tio.color = false;
                    no.parent.parent.color = true;
                    no = no.parent.parent;
                } else {
                    if (no == no.parent.rigth) {
                        no = no.parent;
                        rotacaoleft(no);
                    }
                    no.parent.color = false;
                    no.parent.parent.color = true;
                    rotacaorigth(no.parent.parent);
                }
            }
            if (no == raiz) {
                break;
            }
        }
        raiz.color = false; // Preto
    }

    private void rotacaoleft(No x) {
        No y = x.rigth;
        x.rigth = y.left;
        if (y.left != NULO) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            raiz = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.rigth = y;
        }
        y.left = x;
        x.parent = y;
    }

    private void rotacaorigth(No x) {
        No y = x.left;
        x.left = y.rigth;
        if (y.rigth != NULO) {
            y.rigth.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            raiz = y;
        } else if (x == x.parent.rigth) {
            x.parent.rigth = y;
        } else {
            x.parent.left = y;
        }
        y.rigth = x;
        x.parent = y;
    }

    // Inserir um nó na árvore
    public void inserir(int valor) {
        No no = new No(valor);
        no.parent = null;
        no.left = NULO;
        no.rigth = NULO;
        no.color = true; // VERMELHO por padrão

        No y = null;
        No x = this.raiz;

        while (x != NULO) {
            y = x;
            if (no.valor < x.valor) {
                x = x.left;
            } else {
                x = x.rigth;
            }
        }

        no.parent = y;
        if (y == null) {
            raiz = no;
        } else if (no.valor < y.valor) {
            y.left = no;
        } else {
            y.rigth = no;
        }

        if (no.parent == null) {
            no.color = false; // PRETO
            return;
        }

        if (no.parent.parent == null) {
            return;
        }

        corrigirInsercao(no);
    }
}
