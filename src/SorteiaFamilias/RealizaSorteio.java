package SorteiaFamilias;

import ConstroiFamilias.CriaFamilias;
import ConstroiFamilias.Familia;
import ModuloExterno.RegistraSorteio;

import java.util.Collections;
import java.util.List;

public class RealizaSorteio {
    private int quantidadeDeVagas = 2;
    private List<Familia> familias;

    public RealizaSorteio() {
        familias = criarFamilias();
        realizarSorteio();
        atualizaFamilias();
        comunicaModuloExterno();
    }

    private List<Familia> criarFamilias() {
        return new CriaFamilias().getFamilias();
    }

    private void realizarSorteio() {
        for (Familia familia : familias) {
            familia.calcularPontuacao();
        }
        Collections.sort(familias);
    }

    private void atualizaFamilias() {
        int i = 0;
        while (i < familias.size() && quantidadeDeVagas > 0) {
            if (familias.get(i).getStatus() == 0) {
                familias.get(i).setStatus(2);
                quantidadeDeVagas--;
            }
            i++;
        }
    }

    private void comunicaModuloExterno() {
        RegistraSorteio sorteio = new RegistraSorteio(familias);
        sorteio.registrar();
    }
}
