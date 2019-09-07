package Testes;

import SelecaoDeFamilias.Pontuacao;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TestePontuacao extends Pontuacao {

    @Test
    void testaFamiliaSetePontos() {
        int pontoIdade = criterioIdade(32); // 2pts
        int pontoRenda = criterioRenda(1040.50f); // 3pts
        int pontoDependentes = criterioDependentes(2); // 2pts
        int result = pontoDependentes + pontoIdade + pontoRenda;
        Assert.assertEquals(7, result);
    }

    @Test
    void testaFamiliaQuatroPontos() {
        int pontoIdade = criterioIdade(18); // 1pts
        int pontoRenda = criterioRenda(900.57f); // 3pts
        int pontoDependentes = criterioDependentes(0); // 0pts
        int result = pontoDependentes + pontoIdade + pontoRenda;
        Assert.assertEquals(4, result);
    }

    @Test
    void testaRendaAteNovecentos() {
        Assert.assertEquals(criterioRenda(1), 5);
        Assert.assertEquals(criterioRenda(400), 5);
        Assert.assertEquals(criterioRenda(899.99f), 5);
    }

    @Test
    void testaRendaDeNovecentosAteMilQuinhentos() {
        Assert.assertEquals(criterioRenda(901), 3);
        Assert.assertEquals(criterioRenda(1230), 3);
        Assert.assertEquals(criterioRenda(1500f), 3);
    }

    @Test
    void testaRendaDeMilQuinhentosAteDoisMil() {
        Assert.assertEquals(criterioRenda(1500.1f), 1);
        Assert.assertEquals(criterioRenda(1750), 1);
        Assert.assertEquals(criterioRenda(2000), 1);
    }

    @Test
    void testaRendaValoresForaDoIntervalo() {
        Assert.assertEquals(criterioRenda(-80), 0);
        Assert.assertEquals(criterioRenda(7500), 0);
    }

    @Test
    void testaIdadeAteTrinta() {
        Assert.assertEquals(criterioIdade(12), 1);
        Assert.assertEquals(criterioIdade(29), 1);
        Assert.assertEquals(criterioIdade(30), 2);
    }

    @Test
    void testaIdadeDeTrintaAteQuarentaeCinco() {
        Assert.assertEquals(criterioIdade(30), 2);
        Assert.assertEquals(criterioIdade(39), 2);
        Assert.assertEquals(criterioIdade(44), 2);
        Assert.assertEquals(criterioIdade(45), 3);
    }

    @Test
    void testaIdadeDeQuarentaeCinco() {
        Assert.assertEquals(criterioIdade(45), 3);
        Assert.assertEquals(criterioIdade(75), 3);
    }

    @Test
    void testaIdadeValoresForaDoIntervalo() {
        Assert.assertEquals(criterioIdade(-10), 0);
        Assert.assertEquals(criterioIdade(5000), 3);
    }

    @Test
    void testaDependentesAteDois() {
        Assert.assertEquals(criterioDependentes(0), 0);
        Assert.assertEquals(criterioDependentes(1), 2);
        Assert.assertEquals(criterioDependentes(2), 2);
    }

    @Test
    void testaDependentesAPartirDeDois() {
        Assert.assertEquals(criterioDependentes(3), 3);
        Assert.assertEquals(criterioDependentes(5), 3);
    }

    @Test
    void testaDependentesValoresForaDoIntervalo() {
        Assert.assertEquals(criterioDependentes(-1), 0);
    }
}