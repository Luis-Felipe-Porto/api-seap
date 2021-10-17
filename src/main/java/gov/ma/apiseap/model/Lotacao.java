package gov.ma.apiseap.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

@Entity
public class Lotacao implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull @NotBlank @Length(max = 200)
    private String descricao;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private LocalDate dataDeCadastro;

    
    public Lotacao(@NotBlank @Length(max = 200) String descricao, LocalDate dataDeCadastro) {
        this.descricao = descricao;
        this.dataDeCadastro = dataDeCadastro;
    }
    
    public Lotacao() {
    }

    public String getDescricao() {
        return descricao;
    }
    public LocalDate getDataDeCadastro() {
        return dataDeCadastro;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }  
}
