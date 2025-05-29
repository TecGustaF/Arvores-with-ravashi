package main;

import arvore.Arvore;
import no.No;

public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();

        arvore.raiz = new No("A");
        arvore.raiz.esquerda = new No("B");
        arvore.raiz.direita = new No("C");
        arvore.raiz.esquerda.esquerda = new No("D");
        arvore.raiz.esquerda.direita = new No("E");
        arvore.raiz.direita.direita = new No("F");

        System.out.println("Total de nós: " + arvore.contarNos(arvore.raiz));
        System.out.println("Total de nós folha: " + arvore.contarNosFolha(arvore.raiz));

        System.out.print("Pré-ordem: ");
        arvore.buscaPreOrdem(arvore.raiz);
        System.out.println();

        System.out.print("Em ordem: ");
        arvore.buscaEmOrdem(arvore.raiz);
        System.out.println();

        System.out.print("Pós-ordem: ");
        arvore.buscaPosOrdem(arvore.raiz);
        System.out.println();

        System.out.print("Por nível: ");
        arvore.buscaPorNivel(arvore.raiz);
        System.out.println();
    }
}
