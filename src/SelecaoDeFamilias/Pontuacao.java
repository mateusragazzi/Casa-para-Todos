package SelecaoDeFamilias;

import ConstroiFamilias.Integrante;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Pontuacao extends Metricas implements Criterios {
    private int pontuacaoTotal, criteriosAtendidos;

    public Pontuacao() {
    }

    public Pontuacao(HashMap<Integer, Integrante> integrantes) {
        coletaCriterios(integrantes);
    }

    private void coletaCriterios(HashMap<Integer, Integrante> integrantes) {
        float rendaTotalFamilia = 0;
        int dependentesMenoresDeDezoito = 0, idadePretendente = 0;
        for (Map.Entry<Integer, Integrante> objetoIntegrante : integrantes.entrySet()) {
            Integrante integrante = objetoIntegrante.getValue();
            switch (integrante.getTipo()) {
                case "Pretendente":
                    idadePretendente = integrante.getIdade();
                    break;
                case "Dependente":
                    if (integrante.getIdade() < 18)
                        dependentesMenoresDeDezoito++;
                    break;
            }
            rendaTotalFamilia += integrante.getRenda();
        }
        criterioRenda(rendaTotalFamilia);
        criterioIdade(idadePretendente);
        criterioDependentes(dependentesMenoresDeDezoito);
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

    private int definePontuacao(LinkedList<Ponto> lista, float valor) {
        for (Ponto ponto : lista) {
            if (valor <= ponto.getLimite()) {
                atualizaPontuacaoFinal(ponto.getValor());
                return ponto.getValor();
            }
        }
        return 0;
    }

    private void atualizaPontuacaoFinal(int valor) {
        pontuacaoTotal += valor;
        criteriosAtendidos++;
    }

    public int getPontuacaoTotal() {
        return pontuacaoTotal;
    }

    public int getCriteriosAtendidos() {
        return criteriosAtendidos;
    }

}
