package ModuloExterno;

import ConstroiFamilias.Familia;

import java.time.LocalDate;
import java.util.List;

public class RegistraSorteio {
    private List<Familia> familiasAtualizadas;
    private LocalDate dataAtual = LocalDate.now();

    public RegistraSorteio(List<Familia> familiasAtualizadas) {
        this.familiasAtualizadas = familiasAtualizadas;
    }

    public void registrar() {
        /* atualiza JSON
         *
         * "familias": [ {
         *     "integrantes": [],
         *     "status": 2,
         *     "beneficio": {
         *       "data-beneficio": "2019-09-10",
         *       "criterios": 2,
         *       "pontuacao_total": 5
         *     }
         *   }]
         *
         */
    }
}
