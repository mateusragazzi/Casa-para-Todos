package SelecaoDeFamilias.Metricas;

public class IntervalosDeMetricas {
    private final int limite;
    private final int valor;

    IntervalosDeMetricas(int limite, int valor) {
        this.limite = limite;
        this.valor = valor;
    }

    public int getLimite() {
        return limite;
    }

    public int getValor() {
        return valor;
    }
}
