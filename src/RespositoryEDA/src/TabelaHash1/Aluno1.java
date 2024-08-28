package src.TabelaHash1;

public class Aluno1 {

    private String nome1;

    private int matricula;

    public Aluno1(String nome1, int matricula) {
        this.nome1 = nome1;
        this.matricula = matricula;
    }

    public String getNome1() {
        return nome1;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setNome1(String nome1) {
        this.nome1 = nome1;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String toString() {
        return "Nome: " + nome1 + "\nMatricula: " + matricula;
    }
}
