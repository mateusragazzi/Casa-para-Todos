package SelecaoDeFamilias;

import ConstroiFamilias.Integrante;
import SelecaoDeFamilias.Metricas.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Pontuacao extends MetricasDePontuacao implements Criterios {
    private int pontuacaoTotal;
    private CriteriosAtendidos criteriosAtendidos;

    protected Pontuacao() {}

    public Pontuacao(HashMap<Integer, Integrante> integrantes) {
        criteriosAtendidos = verificaCriterios(integrantes);
        calculaPontuacaoNosCriterios(criteriosAtendidos);
    }

    private CriteriosAtendidos verificaCriterios(HashMap<Integer, Integrante> integrantes) {
        CriteriosAtendidos criterios = new CriteriosAtendidos();
        for (Map.Entry<Integer, Integrante> objetoIntegrante : integrantes.entrySet()) {
            Integrante integrante = objetoIntegrante.getValue();
            switch (integrante.getTipo()) {
                case Pretendente:
                    criterios.setIdadePretendente(integrante.getIdade());
                    break;
                case Dependente:
                    if (integrante.getIdade() < 18)
                        criterios.adicionaQuantidadeMenoresDeDezoito();
                    break;
            }
            criterios.adicionaRendaFamiliar(integrante.getRenda());
        }
        return criterios;
    }

    private void calculaPontuacaoNosCriterios(CriteriosAtendidos criteriosAtendidos) {
        criterioRenda(criteriosAtendidos.getRendaTotalFamilia());
        criterioIdade(criteriosAtendidos.getIdadePretendente());
        criterioDependentes(criteriosAtendidos.getDependentesMenoresDeDezoito());
    }

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

    private int definePontuacao(LinkedList<IntervalosDeMetricas> lista, float valor) {
        for (IntervalosDeMetricas ponto : lista) {
            if (valor <= ponto.getLimite()) {
                atualizaPontuacaoFinal(ponto.getValor());
                return ponto.getValor();
            }
        }
        return 0;
    }

    private void atualizaPontuacaoFinal(int valor) {
        if(valor > 0) {
            pontuacaoTotal += valor;
            criteriosAtendidos.aumentarQuantidade();
        }
    }

    public int getPontuacaoTotal() {
        return pontuacaoTotal;
    }

}
