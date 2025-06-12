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

    //arvores rubro negra

public class RedBlackTree {

    private final Node NIL;
    private Node root;

    public RedBlackTree() {
        NIL = new Node(-1);
        NIL.color = Color.BLACK;
        NIL.left = NIL.right = NIL.parent = null;
        root = NIL;
    }

    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;

        if (y.left != NIL) {
            y.left.parent = x;
        }

        y.parent = x.parent;

        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }

        y.left = x;
        x.parent = y;
    }

    private void rightRotate(Node y) {
        Node x = y.left;
        y.left = x.right;

        if (x.right != NIL) {
            x.right.parent = y;
        }

        x.parent = y.parent;

        if (y.parent == null) {
            root = x;
        } else if (y == y.parent.right) {
            y.parent.right = x;
        } else {
            y.parent.left = x;
        }

        x.right = y;
        y.parent = x;
    }

    public void insert(int key) {
        Node node = new Node(key);
        node.left = node.right = node.parent = NIL;

        Node y = null;
        Node x = root;

        while (x != NIL) {
            y = x;
            if (node.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;

        if (y == null) {
            root = node;
        } else if (node.key < y.key) {
            y.left = node;
        } else {
            y.right = node;
        }

        node.left = node.right = NIL;
        node.color = Color.RED;

        insertFix(node);
    }

    private void insertFix(Node k) {
        while (k.parent != null && k.parent.color == Color.RED) {
            if (k.parent == k.parent.parent.left) {
                Node u = k.parent.parent.right;
                if (u != null && u.color == Color.RED) {
                    k.parent.color = Color.BLACK;
                    u.color = Color.BLACK;
                    k.parent.parent.color = Color.RED;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotate(k);
                    }
                    k.parent.color = Color.BLACK;
                    k.parent.parent.color = Color.RED;
                    rightRotate(k.parent.parent);
                }
            } else {
                Node u = k.parent.parent.left;
                if (u != null && u.color == Color.RED) {
                    k.parent.color = Color.BLACK;
                    u.color = Color.BLACK;
                    k.parent.parent.color = Color.RED;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotate(k);
                    }
                    k.parent.color = Color.BLACK;
                    k.parent.parent.color = Color.RED;
                    leftRotate(k.parent.parent);
                }
            }
        }
        root.color = Color.BLACK;
    }

    private static class Node {
        int key;
        Color color;
        Node left, right, parent;

        public Node(int key) {
            this.key = key;
            this.color = Color.RED;
        }
    }

    private enum Color {
        RED, BLACK
    }
}


    
    
    
    
}

