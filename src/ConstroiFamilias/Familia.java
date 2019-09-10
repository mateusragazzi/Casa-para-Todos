package ConstroiFamilias;

import SelecaoDeFamilias.Pontuacao;
import java.util.HashMap;

public class Familia implements Comparable<Familia> {
    private long status;
    private final HashMap<Integer, Integrante> integrantes = new HashMap<>();
    private Pontuacao pontos;

    private int getPontos() {
        return pontos.getPontuacaoTotal();
    }

    public HashMap<Integer, Integrante> getIntegrantes() {
        return integrantes;
    }

    void setIntegrantes(Integrante integrante) {
        integrantes.put(integrante.getID(), integrante);
    }

    public void setStatus(long novoStatus) {
        this.status = novoStatus;
    }

    public long getStatus() {
        return status;
    }

    public void calcularPontuacao() {
        pontos = new Pontuacao(integrantes);
    }

    @Override
    public int compareTo(Familia outraFamilia) {
        return Integer.compare(outraFamilia.getPontos(), this.getPontos());
    }
}
