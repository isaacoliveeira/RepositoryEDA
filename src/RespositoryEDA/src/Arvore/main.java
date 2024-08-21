package src.Arvore;

public class main {
    public static void main(String[] args) {
        tree teste = new tree();
        teste.inserir(19);
        teste.inserir(5);
        teste.inserir(21);
        teste.inserir(24);
        teste.inserir(28);
        teste.inserir(4);
        printer.printTree(teste);
        teste.inserirBalaceado(19);
        teste.inserirBalaceado(5);
        teste.inserirBalaceado(21);
        teste.inserirBalaceado(24);
        teste.inserirBalaceado(28);
        teste.inserirBalaceado(4);
        printer.printTree(teste);
    }
}
