package src.TableHash;

public class TabelaHash {
    private ListaEncadeada[] tabela;

    //private int tamanho;
    private static final int TAMANHO = 7;

    public TabelaHash() {
        tabela = new ListaEncadeada[TAMANHO];
        for (int i = 0; i < TAMANHO; i++) {
            tabela[i] = new ListaEncadeada(null);
        }
    }

    private int calcularHash(int matricula) {
        return matricula % 7;
    }

    public void inserir(Aluno aluno) {
        int posicao = calcularHash(aluno.getMatricula());
        tabela[posicao].inserir(aluno);
    }

    public Aluno buscar(int matricula) {
        int posicao = calcularHash(matricula);
        return tabela[posicao].buscar(matricula);
    }

    public void remover(int matricula) {
        int posicao = calcularHash(matricula);
        tabela[posicao].remover(matricula);
    }

    public void mostrar() {
        for (int i = 0; i < TAMANHO; i++) {
//            System.out.println("Índice " + i + ":");
            tabela[i].mostrar();
        }
    }
}


