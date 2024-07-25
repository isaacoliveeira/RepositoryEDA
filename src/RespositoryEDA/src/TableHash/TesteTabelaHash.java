package src.RespositoryEDA.src.TableHash;

//
public class TesteTabelaHash {
    public static void main(String[] args) {
        TabelaHash tabelaHash = new TabelaHash();

        Aluno aluno1 = new Aluno ("João",123);
        Aluno aluno2 = new Aluno( "Maria",456);
        Aluno aluno3 = new Aluno( "José",789);
        Aluno aluno4 = new Aluno("isaac", 254);
        Aluno aluno5 = new Aluno("kaik", 287);

        tabelaHash.inserir(aluno1);
        tabelaHash.inserir(aluno2);
        tabelaHash.inserir(aluno3);
        tabelaHash.inserir(aluno5
        );

        tabelaHash.mostrar();

//
//        System.out.println("Nome do aluno com matrícula 123: " + tabelaHash.buscar(123));
//        System.out.println("Nome do aluno com matrícula 456: " + tabelaHash.buscar(456));
//
//        tabelaHash.inserir(aluno4);
//        System.out.println("Nome do aluno com matrícula 254: " + tabelaHash.buscar(254));
//
//        tabelaHash.remover(123);
//        System.out.println("Nome do aluno com matrícula 123 após remoção: " + tabelaHash.buscar(123));
    }
}
