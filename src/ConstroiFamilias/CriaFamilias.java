package ConstroiFamilias;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CriaFamilias {

    private HashMap<Integer, Familia> familias = new HashMap<>();

    public CriaFamilias() {
        JSONParser leitor = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) leitor.parse(new FileReader("src/Auxiliares/familias.json"));
            JSONArray familiasArray = (JSONArray) jsonObject.get("familias");
            for (Object objetoArray : familiasArray) {
                JSONArray integrantesArray = (JSONArray) ((JSONObject) objetoArray).get("integrantes");
                Familia familia = new Familia();
                familia.setStatus((long) ((JSONObject) objetoArray).get("status"));
                for (Object objetoIntegrante : integrantesArray) {
                    JSONObject integrante = (JSONObject) objetoIntegrante;
                    String nome = (String) integrante.get("nome");
                    String cpf = (String) integrante.get("cpf");
                    String tipo = (String) integrante.get("tipo");
                    String dataDeNascimento = (String) integrante.get("dataDeNascimento");
                    Integrante novoIntegrante = new Integrante(nome, cpf, dataDeNascimento, tipo);
                    if (integrante.get("renda") != null)
                        novoIntegrante.setRenda((long) integrante.get("renda"));
                    familia.setIntegrantes(novoIntegrante);
                }
                familias.put(familia.getID(), familia);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
