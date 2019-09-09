package SelecaoDeFamilias.Metricas;

import java.util.LinkedList;

public class MetricasDePontuacao {
    protected final LinkedList<IntervalosDeMetricas> metricasRenda = new LinkedList<>();
    protected final LinkedList<IntervalosDeMetricas> metricasIdade = new LinkedList<>();
    protected final LinkedList<IntervalosDeMetricas> metricasDependentes = new LinkedList<>();

    protected MetricasDePontuacao() {
        defineMetricasRenda();
        defineMetricaIdadePretendente();
        defineMetricaQuantidadeDeDependentes();
    }

    private void defineMetricasRenda() {
        metricasRenda.add(new IntervalosDeMetricas(0, 0));
        metricasRenda.add(new IntervalosDeMetricas(900, 5));
        metricasRenda.add(new IntervalosDeMetricas(1500, 3));
        metricasRenda.add(new IntervalosDeMetricas(2000, 1));
        metricasRenda.add(new IntervalosDeMetricas((int) Double.POSITIVE_INFINITY, 0));
    }

    private void defineMetricaIdadePretendente() {
        metricasIdade.add(new IntervalosDeMetricas(0, 0));
        metricasIdade.add(new IntervalosDeMetricas(29, 1));
        metricasIdade.add(new IntervalosDeMetricas(44, 2));
        metricasIdade.add(new IntervalosDeMetricas((int) Double.POSITIVE_INFINITY, 3));
    }

    private void defineMetricaQuantidadeDeDependentes() {
        metricasDependentes.add(new IntervalosDeMetricas(0, 0));
        metricasDependentes.add(new IntervalosDeMetricas(2, 2));
        metricasDependentes.add(new IntervalosDeMetricas((int) Double.POSITIVE_INFINITY, 3));
    }
}
