public class main {
    public static void main(String[] args) {
        TreeB arvoreB = new TreeB(4); // Exemplo de árvore B com ordem 4
        int[] chaves = {98,54,78,21,54,36,12,59,1,75};
        for (int chave : chaves) {
            arvoreB.inserir(chave);
        }
        arvoreB.imprimir();
    }
}