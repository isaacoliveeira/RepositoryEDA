package src.HORTFRUIT;
public class NovoProduto {

    private Produto produto;
    private NovoProduto proximo;

    public NovoProduto(Produto produto) {
        this.produto = produto;
    }
    public Produto getProduto() {
        return produto;
    }
    public NovoProduto getProximo() {
        return proximo;
    }
    public void setProximo(NovoProduto proximo) {
        this.proximo = proximo;
    }
}
