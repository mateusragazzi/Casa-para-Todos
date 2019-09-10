package ConstroiFamilias;

import Auxiliares.TipoIntegrante;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CriaFamilias {

    private final List<Familia> familias = new ArrayList<>();

    public CriaFamilias() {
        lerArquivoFamilias();
    }

    /*
     * Ao iniciar o cadastro, a familia começa com status = 3 (incompleto)
     * Se uma residencia for adicionada, seu status é atualizado para 1 (já possui imóvel)
     * Ao tentar finalizar o cadastro, verifica-se a duplicidade de cadastro e valida o item 2 (familia já contemplada)
     * Se tudo estiver ok, a familia ganha status 0 (cadastro válido)
     */
    private void lerArquivoFamilias() {
        JSONParser leitor = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) leitor.parse(new FileReader("src/Auxiliares/familias.json"));
            JSONArray familiasArray = (JSONArray) jsonObject.get("familias");
            for (Object objetoArray : familiasArray) {
                long statusDaFamilia = (long) ((JSONObject) objetoArray).get("status");
                // familias que possuem status diferentes são ignoradas neste momento
                if (statusDaFamilia == 0) {
                    JSONArray listaDeIntegrantes = (JSONArray) ((JSONObject) objetoArray).get("integrantes");
                    familias.add(lerNovaFamilia(listaDeIntegrantes, statusDaFamilia));
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private Familia lerNovaFamilia(JSONArray listaDeIntegrantes, long statusDaFamilia) {
        Familia familia = new Familia();
        familia.setStatus(statusDaFamilia);
        for (Object objetoIntegrante : listaDeIntegrantes) {
            JSONObject integrante = (JSONObject) objetoIntegrante;
            familia.setIntegrantes(criaNovoIntegrante(integrante));
        }
        return familia;
    }

    private Integrante criaNovoIntegrante(JSONObject integrante) {
        String nome = (String) integrante.get("nome");
        String cpf = (String) integrante.get("cpf");
        TipoIntegrante tipo = TipoIntegrante.valueOf((String) integrante.get("tipo"));
        String dataDeNascimento = (String) integrante.get("dataDeNascimento");
        Integrante novoIntegrante = new Integrante(nome, cpf, dataDeNascimento, tipo);
        if (integrante.get("renda") != null)
            novoIntegrante.setRenda((long) integrante.get("renda"));
        return novoIntegrante;
    }

    public List<Familia> getFamilias() {
        return familias;
    }
}
