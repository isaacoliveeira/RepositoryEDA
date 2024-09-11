package src.Arvore.AVL.PV;

import java.util.ArrayList;
import java.util.List;

public class printer {

    public static void printTree(TreePV arvore) {
        if (arvore == null || arvore.getRaiz() == arvore.getNULO()) {
            System.out.println("A árvore está vazia.");
            return;
        }
        List<List<String>> linhas = new ArrayList<>();
        List<No> nivel = new ArrayList<>();
        List<No> proximo = new ArrayList<>();
        nivel.add(arvore.getRaiz());
        int nn = 1;
        int maisLargo = 0;

        while (nn != 0) {
            List<String> linha = new ArrayList<>();
            nn = 0;

            for (No n : nivel) {
                if (n == arvore.getNULO()) {
                    linha.add(null);
                    proximo.add(null);
                    proximo.add(null);
                } else {
                    String cor = n.isRed() ? "R" : "B"; // R para vermelho e B para preto
                    String aa = String.format("%d(%s)", n.getValor(), cor);
                    linha.add(aa);
                    if (aa.length() > maisLargo) maisLargo = aa.length();

                    proximo.add(n.getLeft());
                    proximo.add(n.getRigth());

                    if (n.getLeft() != arvore.getNULO()) nn++;
                    if (n.getRigth() != arvore.getNULO()) nn++;
                }
            }

            if (maisLargo % 2 == 1) maisLargo++;

            linhas.add(linha);

            List<No> temp = nivel;
            nivel = proximo;
            proximo = temp;
            proximo.clear();
        }

        int espacoPorPeca = linhas.get(linhas.size() - 1).size() * (maisLargo + 4);
        for (int i = 0; i < linhas.size(); i++) {
            List<String> linha = linhas.get(i);
            int espacoHorizontal = (int) Math.floor(espacoPorPeca / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < linha.size(); j++) {
                    // Divisores de Nó
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (linha.get(j - 1) != null) {
                            c = (linha.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < linha.size() && linha.get(j) != null) c = '└';
                        }
                    }
                    System.out.print(c);

                    // Linhas e Espaços
                    if (linha.get(j) == null) {
                        for (int k = 0; k < espacoPorPeca - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {
                        for (int k = 0; k < espacoHorizontal; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < espacoHorizontal; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }

            // Imprimir linha de números
            for (int j = 0; j < linha.size(); j++) {
                String f = linha.get(j);
                if (f == null) f = "";
                int espaco1 = (int) Math.ceil(espacoPorPeca / 2f - f.length() / 2f);
                int espaco2 = (int) Math.floor(espacoPorPeca / 2f - f.length() / 2f);

                // Um número
                for (int k = 0; k < espaco1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < espaco2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            espacoPorPeca /= 2;
        }
    }
}
