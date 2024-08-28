package src.TableHash;


public class ListaEncadeada {

    public Node primeiro;

    public ListaEncadeada(Node primeiro) {
        this.primeiro = null;
    }

    public void inserir(Aluno dados) {
        Node novo = new Node(dados) ;
        novo.proximo = primeiro;
        primeiro = novo;
    }

    public Aluno buscar(int matricula) {
        Node buscado = primeiro;
        while (buscado != null) {
            if (buscado.dados.getMatricula() == matricula) {
                return buscado.dados;
            }
            buscado = buscado.proximo;
        }
        return null;
    }

    public void remover(int matricula) {
        if ( primeiro == null) {
            return;
        }
        if (primeiro.dados.getMatricula() == matricula) {
            primeiro = primeiro.proximo;
            return;
        }
        Node atual = primeiro;
        while (atual.proximo != null) {
            if (atual.proximo.dados.getMatricula() == matricula) {
                atual.proximo = atual.proximo.proximo;
                //o proximo do atual vai ser o proximo que foi removido
                return;
            }
            //ele entra nessa linha caso o segundo depois do atual, nao seja igual a matricula pedida
            atual = atual.proximo;
        }
    }
    public void mostrar() {
        Node atual = primeiro;
        while (atual != null) {
            System.out.println("Matricula: " + atual.dados.getMatricula() + ", Aluno: " + atual.dados.getNome());
            atual = atual.proximo;
        }
    }


}
