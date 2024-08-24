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
    }
}
