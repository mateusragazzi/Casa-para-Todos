package SelecaoDeFamilias;

class CriteriosAtendidos {
    private float rendaTotalFamilia;
    private int dependentesMenoresDeDezoito, idadePretendente, totalDosCriteriosAtendidos;

    CriteriosAtendidos() {
        this.rendaTotalFamilia = 0;
        this.dependentesMenoresDeDezoito = 0;
        this.idadePretendente = 0;
        this.totalDosCriteriosAtendidos = 0;
    }

    void adicionaRendaFamiliar(float rendaTotalFamilia) {
        this.rendaTotalFamilia += rendaTotalFamilia;
    }

    void adicionaQuantidadeMenoresDeDezoito() {
        this.dependentesMenoresDeDezoito++;
    }

    float getRendaTotalFamilia() {
        return rendaTotalFamilia;
    }

    int getDependentesMenoresDeDezoito() {
        return dependentesMenoresDeDezoito;
    }

    int getIdadePretendente() {
        return idadePretendente;
    }

    void setIdadePretendente(int idadePretendente) {
        this.idadePretendente = idadePretendente;
    }

    public void aumentarQuantidade() {
        totalDosCriteriosAtendidos++;
    }
}
