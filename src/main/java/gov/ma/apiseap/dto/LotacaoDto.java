package gov.ma.apiseap.dto;

import java.time.LocalDate;

public class LotacaoDto {


    private String descricao;

    private LocalDate dataDeCadastro;
    
    public LotacaoDto(String descricao, LocalDate dataDeCadastro) {
        this.descricao = descricao;
        this.dataDeCadastro = dataDeCadastro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(LocalDate dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    
}
