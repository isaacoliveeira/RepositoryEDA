package src.Arvore;

public class main {
    public static void main(String[] args) {
        tree teste = new tree();
        System.out.println();
        teste.inserirBalanceado(67);
        teste.inserirBalanceado(54);
        teste.inserirBalanceado(90);
        teste.inserirBalanceado(29);
        teste.inserirBalanceado(60);
        teste.inserirBalanceado(58);
        teste.remover(60);
        teste.remover(54);
        printer.printTree(teste);
        System.out.println();
        System.out.println();
        teste.imprimirArvore();
    }
}
