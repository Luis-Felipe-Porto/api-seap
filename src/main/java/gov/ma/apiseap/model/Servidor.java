package gov.ma.apiseap.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Servidor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull @NotEmpty @Length(min = 3, max = 400)
    private String nome;
    @NotNull @NotEmpty @Length(max = 30)
    private String matricula;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private LocalDate dataCadastro;
    @NotNull
    @ManyToOne(cascade=CascadeType.ALL)
    private Lotacao tipoLotacao;

    public String getNome() {
        return nome;
    }
    public String getMatricula() {
        return matricula;
    }
    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
    public void setTipoLotacao(Lotacao tipoLotacao) {
        this.tipoLotacao = tipoLotacao;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Lotacao getTipoLotacao() {
        return tipoLotacao;
    }
    
}
