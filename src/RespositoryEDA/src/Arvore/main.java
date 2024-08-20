package src.Arvore;

public class main {
    public static void main(String[] args) {
        tree teste = new tree();
        teste.inserirBalaceado(41);
        teste.inserirBalaceado(6);
        teste.inserirBalaceado(17);
        teste.inserirBalaceado(13);
        teste.inserirBalaceado(24);
        teste.inserirBalaceado(27);
        printer.printTree(teste);
    }
}
