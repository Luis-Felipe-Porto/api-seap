package gov.ma.apiseap.model;

import java.time.LocalDate;

public class Servidor {
    private String nome;
    private String matricula;
    private LocalDate dataCadastro;
    private Lotacao lotacao;
    
    public Servidor(String nome, String matricula, LocalDate dataCadastro, Lotacao lotacao) {
        this.nome = nome;
        this.matricula = matricula;
        this.dataCadastro = dataCadastro;
        this.lotacao = lotacao;
    }
    public String getNome() {
        return nome;
    }
    public String getMatricula() {
        return matricula;
    }
    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
    public Lotacao getLotacao() {
        return lotacao;
    }
}
