package src.HORTFRUIT;



public class Hortfruit {
    private NovoProduto primeiro;

    public void adicionarProduto(String nome, int quantidade) {
        Produto novoProduto = new Produto(nome, quantidade);
        NovoProduto novoNo = new NovoProduto(novoProduto);

        if (primeiro == null) {
            primeiro = novoNo;
        } else {
            NovoProduto atual = primeiro;
            NovoProduto anterior = null;

            while (atual != null && atual.getProduto().getNome().compareTo(novoProduto.getNome()) < 0) {
                anterior = atual;
                atual = atual.getProximo();
            }

            if (atual != null && atual.getProduto().getNome().equals(novoProduto.getNome())) {
                atual.getProduto().setQuantidade(atual.getProduto().getQuantidade() + quantidade);
            } else {
                if (anterior == null) {
                    novoNo.setProximo(primeiro);
                    primeiro = novoNo;
                } else {
                    anterior.setProximo(novoNo);
                    novoNo.setProximo(atual);
                }
            }
        }
    }

    public void listarProdutos() {
        NovoProduto atual = primeiro;
        while (atual != null) {
            System.out.println(atual.getProduto());
            atual = atual.getProximo();
        }
    }

    public void retirarProduto(String nome, int quantidade) {
        NovoProduto atual = primeiro;
        NovoProduto anterior = null;

        while (atual != null && !atual.getProduto().getNome().equals(nome.toUpperCase())) {
            anterior = atual;
            atual = atual.getProximo();
        }

        if (atual == null) {
            System.out.println("Produto não encontrado.");
        } else {
            int quantidadeAtual = atual.getProduto().getQuantidade();
            if (quantidade > quantidadeAtual) {
                System.out.println("Quantidade insuficiente. Quantidade disponível: " + quantidadeAtual);
            } else {
                atual.getProduto().setQuantidade(quantidadeAtual - quantidade);
                if (atual.getProduto().getQuantidade() == 0) {
                    if (anterior == null) {
                        primeiro = atual.getProximo();
                    } else {
                        anterior.setProximo(atual.getProximo());
                    }
                }
            }
        }
    }

    public void checarProduto(String nome) {
        NovoProduto atual = primeiro;

        while (atual != null && !atual.getProduto().getNome().equals(nome.toUpperCase())) {
            atual = atual.getProximo();
        }

        if (atual == null) {
            System.out.println("Produto não encontrado.");
        } else {
            System.out.println("Produto encontrado. Quantidade: " + atual.getProduto().getQuantidade());
        }
    }
}
