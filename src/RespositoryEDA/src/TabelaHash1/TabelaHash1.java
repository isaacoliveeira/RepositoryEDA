package src.RespositoryEDA.src.TabelaHash1;

public class TabelaHash1 {
    public Aluno1[] tabela;
    public static final int TAMANHO = 10;
    private Aluno1 DELETED = new Aluno1("Deleted", -1);
    //usamos esse DELETED para evitar colisões na hora da busca
    //pois se fossemos buscar o valor e la estivesse NULL
    //ele iria assumir que nao existe o item na tabela
    // e se deixarmos como -1 ele entendera que ali pode se ter um novo valor
    // e continuar a busca

    public TabelaHash1() {
        tabela = new Aluno1[TAMANHO];
    }

    public int calcularHash(int matricula, int TAMANHO){
        return matricula % TAMANHO;
    }

    public String pegarValor(int matricula) {

        return null;
    }

    public void inserirAluno(int matricula, String nome1) {
        if (estaCheia()) {
            redimencionar();

        }
        return;
    }

    private boolean estaCheia() {
        return false;
    }

    public void removerValor(int matricula) {
        //nao retorna null caso remova, retorna um, por exemplo -1, para indicar que foi removido
        return;
    }

    public void redimencionar() {
        Aluno1[] tabelaAntiga = tabela;
        tabela = new Aluno1[tabelaAntiga.length * 2];
    }

}
