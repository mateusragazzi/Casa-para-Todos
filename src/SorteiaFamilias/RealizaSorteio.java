package SorteiaFamilias;

import ConstroiFamilias.CriaFamilias;
import ConstroiFamilias.Familia;

import java.util.Collections;
import java.util.List;

public class RealizaSorteio {
    private List<Familia> familias;

    public RealizaSorteio() {
        familias = criarFamilias();
        realizarSorteio(familias);
    }

    private List<Familia> criarFamilias() {
        CriaFamilias criaFamilias = new CriaFamilias();
        return criaFamilias.getFamilias();
    }

    private void realizarSorteio(List<Familia> familias) {
        for (Familia familia : familias) {
            familia.calcularPontuacao();
        }
        Collections.sort(familias);
    }
}
