package gov.ma.apiseap.dto;

import java.time.LocalDate;

import gov.ma.apiseap.model.Lotacao;

public class ServidorDto {

    private String nome;

    private String matricula;

    private LocalDate dataCadastro;

    private Lotacao tipoLotacao;
    

    public ServidorDto(String nome, String matricula, LocalDate dataCadastro, Lotacao tipoLotacao) {
        this.nome = nome;
        this.matricula = matricula;
        this.dataCadastro = dataCadastro;
        this.tipoLotacao = tipoLotacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Lotacao getTipoLotacao() {
        return tipoLotacao;
    }

    public void setTipoLotacao(Lotacao tipoLotacao) {
        this.tipoLotacao = tipoLotacao;
    }

    
}
