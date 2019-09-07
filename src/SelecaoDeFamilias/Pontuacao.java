package SelecaoDeFamilias;

import java.util.LinkedList;

public class Pontuacao extends Metricas implements Criterios {

    @Override
    public int criterioRenda(float rendaFamiliar) {
        return definePontuacao(metricasRenda, rendaFamiliar);
    }

    @Override
    public int criterioIdade(int idade) {
        return definePontuacao(metricasIdade, idade);
    }

    @Override
    public int criterioDependentes(int dependentes) {
        return definePontuacao(metricasDependentes, dependentes);
    }

    private int definePontuacao(LinkedList<Ponto> lista, float valor) {
        for (Ponto ponto : lista) {
            if (valor <= ponto.getLimite())
                return ponto.getValor();
        }
        return 0;
    }

}
