import java.util.ArrayList;

class No {
    private int ordem;
    private ArrayList<Integer> elementos;
    private ArrayList<No> filhos; 
    private boolean ehFolha; 

    public No(int ordem, boolean ehFolha) {
        this.ordem = ordem;
        this.elementos = new ArrayList<>();
        this.filhos = new ArrayList<>();
        this.ehFolha = ehFolha;
    }

    public int getOrdem() {
        return ordem;
    }

    public ArrayList<Integer> getElementos() {
        return elementos;
    }

    public ArrayList<No> getFilhos() {
        return filhos;
    }

    public boolean isEhFolha() {
        return ehFolha;
    }

    public void setEhFolha(boolean ehFolha) {
        this.ehFolha = ehFolha;
    }
}
