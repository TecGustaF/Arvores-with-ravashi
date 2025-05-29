package no;

public class No {
    public String valor;
    public No esquerda, direita;
    private int fatorBalanceamento; // agora é privado

    public No(String valor) {
        this.valor = valor;
        esquerda = direita = null;
        fatorBalanceamento = 0;
    }

    public int getFatorBalanceamento() {
        return fatorBalanceamento;
    }

    public void setFatorBalanceamento(int fatorBalanceamento) {
        this.fatorBalanceamento = fatorBalanceamento;
    }
}
