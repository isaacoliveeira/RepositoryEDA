package src.RespositoryEDA.src.TabelaHash1;

public class tabelaHashTeste {
    public static void main(String[] args) {
        TabelaHash1 alunos = new TabelaHash1();
        alunos.inserirAluno(1, "isaac");
        alunos.inserirAluno(2, "jeff");
        alunos.inserirAluno(3, "ramon");
        alunos.inserirAluno(4, "kaik");
        alunos.mostrar();
    }
}
