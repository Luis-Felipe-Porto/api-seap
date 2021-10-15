package gov.ma.apiseap.model;

import java.time.LocalDate;

public class Lotacao {
    private String descricao;
    private LocalDate dataDeCadastro;
    public Lotacao(String descricao, LocalDate dataDeCadastro) {
        this.descricao = descricao;
        this.dataDeCadastro = dataDeCadastro;
    }
    public String getDescricao() {
        return descricao;
    }
    public LocalDate getDataDeCadastro() {
        return dataDeCadastro;
    }
}
