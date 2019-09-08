package ConstroiFamilias;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Integrante {
    private int ID;
    private String nome, cpf, dataNascimento, tipo;
    private int idade;
    private long renda;

    public Integrante(String nome, String cpf, String dataNascimento, String tipo) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.tipo = tipo;
        this.idade = calcularIdade();
        this.ID = hashCode();
    }

    public void setRenda(long renda) {
        this.renda = renda;
    }

    public int getID() {
        return ID;
    }

    public int calcularIdade() {
        LocalDate dataNascimento = retornaDataProcessada();
        LocalDate dataAtual = LocalDate.now();
        Period diferenca = Period.between(dataNascimento, dataAtual);
        return diferenca.getYears();
    }

    private LocalDate retornaDataProcessada() {
        String[] dataProcessada = dataNascimento.split("-");
        int ano = Integer.parseInt(dataProcessada[0]);
        int mes = Integer.parseInt(dataProcessada[1]);
        int dia = Integer.parseInt(dataProcessada[2]);
        return LocalDate.of(ano, mes, dia);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Integrante that = (Integrante) o;
        return idade == that.idade &&
                nome.equals(that.nome) &&
                cpf.equals(that.cpf) &&
                dataNascimento.equals(that.dataNascimento) &&
                tipo.equals(that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cpf, dataNascimento, tipo, idade);
    }
}
