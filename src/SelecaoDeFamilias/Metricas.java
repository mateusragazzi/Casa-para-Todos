package SelecaoDeFamilias;

import java.util.LinkedList;

class Metricas {
    static LinkedList<Ponto> metricasRenda = new LinkedList<>();

    static {
        metricasRenda.add(new Ponto(0, 0));
        metricasRenda.add(new Ponto(900, 5));
        metricasRenda.add(new Ponto(1500, 3));
        metricasRenda.add(new Ponto(2000, 1));
        metricasRenda.add(new Ponto((int) Double.POSITIVE_INFINITY, 0));
    }

    static LinkedList<Ponto> metricasIdade = new LinkedList<>();

    static {
        metricasIdade.add(new Ponto(0, 0));
        metricasIdade.add(new Ponto(29, 1));
        metricasIdade.add(new Ponto(44, 2));
        metricasIdade.add(new Ponto((int) Double.POSITIVE_INFINITY, 3));
    }

    static LinkedList<Ponto> metricasDependentes = new LinkedList<>();

    static {
        metricasDependentes.add(new Ponto(0, 0));
        metricasDependentes.add(new Ponto(2, 2));
        metricasDependentes.add(new Ponto((int) Double.POSITIVE_INFINITY, 3));
    }
}
