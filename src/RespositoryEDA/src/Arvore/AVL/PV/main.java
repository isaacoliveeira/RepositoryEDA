package src.Arvore.AVL.PV;

public class main {
    public static void main(String[] args) {
        // Criar uma instância da árvore vermelha e preta
        TreePV arvore = new TreePV();

        // Inserir alguns elementos na árvore
        arvore.inserir(10);
        arvore.inserir(20);
        arvore.inserir(30);
        arvore.inserir(15);
        arvore.inserir(25);
        arvore.inserir(5);

        printer.printTree(arvore);
    }
}
