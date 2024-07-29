package src.RespositoryEDA.src.TabelaHash1;

public class TabelaHash1 {
    private Aluno1[] tabela = new Aluno1[5];
    private Aluno1 DELETED = new Aluno1("Deleted", -1);
    private Aluno1 elemento;
    //usamos esse DELETED para evitar colisões na hora da busca
    //pois se fossemos buscar o valor e la estivesse NULL
    //ele iria assumir que nao existe o item na tabela
    // e se deixarmos como -1 ele entendera que ali pode se ter um novo valor
    // e continuar a busca

    public TabelaHash1() {
    }

    public int calcularHash(int matricula){
        int divisor = tabela.length;
        int hash;

        if (matricula == tabela.length) {
            hash = tabela.length - 1;
        } else {
            hash = (matricula % divisor) - 1;
        }
        return hash;
    }

    public String pegarValor(int matricula) {
        int hash = calcularHash(matricula);
        for (int i = hash; i < tabela.length; i++) {
            elemento = tabela[i];
            if (elemento != null && elemento.getMatricula() == matricula) {
                return elemento.getNome1();
            }
        }
        return "Elemento não existe";
    }

    public void inserirAluno(int matricula, String nome1) {
        Aluno1 aluno = new Aluno1(nome1, matricula);
        int hash = calcularHash(matricula);
        if (!estaCheia()) {
            if (tabela[hash] == null || tabela[hash] == DELETED) {
                tabela[hash] = aluno;
            } else {
                while (tabela[hash] != null && tabela[hash] != DELETED) {
                    hash++;
                }
                tabela[hash] = aluno;
            }
        } else {
            redimencionar();
            if (tabela[hash] == null || tabela[hash] == DELETED) {
                tabela[hash] = aluno;
            } else {
                while (tabela[hash] != null && tabela[hash] != DELETED) {
                    hash++;
                }
                tabela[hash] = aluno;
            }
        }
        return;
    }

    private boolean estaCheia() {
        int contador = 0;
        for (int i = 0; i < tabela.length; i++) {
            if (tabela[i] != null && tabela[i] != DELETED) {
                contador++;
            }
        }
        if (contador == tabela.length) {
            return true; // esta cheia
        }
        return false;
    }

    public boolean removerValor(int matricula) {
        int hash = calcularHash(matricula);
        for (int i = hash; hash < tabela.length; i++) {
            elemento = tabela[i];
            if (elemento != null && elemento != DELETED) {
                tabela[i] = DELETED;
                return true;
            }
        }
        return false;
    }

    public void redimencionar() {
        Aluno1[] tabelaAntiga = tabela;
        tabela = new Aluno1[tabelaAntiga.length * 2];

        for (Aluno1 aluno : tabelaAntiga) {
            if (aluno != null || aluno != DELETED) {
                inserirAluno(aluno.getMatricula(), aluno.getNome1());
            }
        }
    }

    public void mostrar() {
        for (int i = 0; i < tabela.length; i++) {
            if (tabela[i] != null) {
                System.out.println(tabela[i].getNome1());
            } else {
                System.out.println(tabela[i]);
            }
        }
    }
}
