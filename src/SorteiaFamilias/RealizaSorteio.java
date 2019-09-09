package SorteiaFamilias;

import ConstroiFamilias.CriaFamilias;
import ConstroiFamilias.Familia;
import java.util.Collections;
import java.util.List;

public class RealizaSorteio {

    public RealizaSorteio() {
        realizarSorteio(criarFamilias());
    }

    private List<Familia> criarFamilias() {
        return new CriaFamilias().getFamilias();
    }

    private void realizarSorteio(List<Familia> familias) {
        for (Familia familia : familias) {
            familia.calcularPontuacao();
        }
        Collections.sort(familias);
    }
}
