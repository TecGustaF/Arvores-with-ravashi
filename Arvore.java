package arvore;

import no.No;
import java.util.LinkedList;
import java.util.Queue;

public class Arvore {
    public No raiz;

    public Arvore() {
        raiz = null;
    }

    //  MÉTODOS COM RECURSO (Queue/fila - busca por nível com LinkedList)

    public int contarNos(No node) {
        if (node == null) return 0;
        return 1 + contarNos(node.esquerda) + contarNos(node.direita);
    }

    public int contarNosFolha(No node) {
        if (node == null) return 0;
        if (node.esquerda == null && node.direita == null) return 1;
        return contarNosFolha(node.esquerda) + contarNosFolha(node.direita);
    }

    public void buscaPreOrdem(No node) {
        if (node != null) {
            System.out.print(node.valor + " ");
            buscaPreOrdem(node.esquerda);
            buscaPreOrdem(node.direita);
        }
    }

    public void buscaEmOrdem(No node) {
        if (node != null) {
            buscaEmOrdem(node.esquerda);
            System.out.print(node.valor + " ");
            buscaEmOrdem(node.direita);
        }
    }

    public void buscaPosOrdem(No node) {
        if (node != null) {
            buscaPosOrdem(node.esquerda);
            buscaPosOrdem(node.direita);
            System.out.print(node.valor + " ");
        }
    }

    public void buscaPorNivel(No node) {
        if (node == null) return;

        Queue<No> fila = new LinkedList<>();
        fila.add(node);

        while (!fila.isEmpty()) {
            No atual = fila.poll();
            System.out.print(atual.valor + " ");

            if (atual.esquerda != null) fila.add(atual.esquerda);
            if (atual.direita != null) fila.add(atual.direita);
        }
    }

    // MÉTODOS SEM RECURSO EXTERNO (só recursividade)

    public void buscaPorNivelSemRecurso(No node) {
        int h = altura(node);
        for (int i = 1; i <= h; i++) {
            imprimirNivel(node, i);
        }
    }

    public int altura(No node) {
        if (node == null) return 0;
        int esq = altura(node.esquerda);
        int dir = altura(node.direita);
        return 1 + Math.max(esq, dir);
    }

    public void imprimirNivel(No node, int nivel) {
        if (node == null) return;
        if (nivel == 1) {
            System.out.print(node.valor + " ");
        } else {
            imprimirNivel(node.esquerda, nivel - 1);
            imprimirNivel(node.direita, nivel - 1);
        }
    }
    
    // teste das AVL 
    
    busca pre ordem
    
    
    
    
    
}

