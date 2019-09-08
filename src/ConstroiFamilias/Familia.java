package ConstroiFamilias;

import java.util.HashMap;
import java.util.Objects;

public class Familia {
    private long status;
    private HashMap<Integer, Integrante> integrantes = new HashMap<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Familia familia = (Familia) o;
        return status == familia.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }

    public void setIntegrantes(Integrante integrante) {
        integrantes.put(integrante.getID(), integrante);
    }

    public Integer getID() {
        return hashCode();
    }

    public void setStatus(long status) {
        this.status = status;
    }
}
