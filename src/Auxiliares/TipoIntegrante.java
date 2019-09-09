package Auxiliares;

public enum TipoIntegrante {
    Pretendente, Cônjuge, Dependente;

    public TipoIntegrante getTipoPorString(String tipoComoString) {
        switch (tipoComoString) {
            case "Pretendente":
                return TipoIntegrante.Pretendente;
            case "Cônjuge":
                return TipoIntegrante.Cônjuge;
            case "Dependente":
                return TipoIntegrante.Dependente;
        }
        return null;
    }
}
