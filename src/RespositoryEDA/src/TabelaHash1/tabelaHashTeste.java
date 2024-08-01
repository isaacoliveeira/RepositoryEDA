package src.RespositoryEDA.src.TabelaHash1;

public class tabelaHashTeste {
    public static void main(String[] args) {
        TabelaHash1 alunos = new TabelaHash1();
        alunos.inserirAluno(14, "joao");
        alunos.inserirAluno(145, "isaac");
        alunos.inserirAluno(212, "jeff");
        alunos.inserirAluno(168, "ramon");
        alunos.inserirAluno(424, "kaik");
        //.removerValor(14);
        //alunos.inserirAluno(5, "gaby");
        //alunos.inserirAluno(6, "rick");
        //alunos.inserirAluno(9, "vini");

        alunos.mostrar();
        
    }
}
