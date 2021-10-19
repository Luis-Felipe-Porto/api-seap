package gov.ma.apiseap.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Servidor implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull @NotEmpty @Length(min = 3, max = 400)
    private String nome;
    @NotNull @NotEmpty @Length(max = 30)
    private String matricula;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private LocalDate dataCadastro;
    @NotNull
    @ManyToOne(cascade=CascadeType.ALL)
    private Lotacao tipoLotacao;
    
    public Servidor(@NotNull @NotEmpty @Length(min = 3, max = 400) String nome,
            @NotNull @NotEmpty @Length(max = 30) String matricula, LocalDate dataCadastro,
            @NotNull Lotacao tipoLotacao) {
        this.nome = nome;
        this.matricula = matricula;
        this.dataCadastro = dataCadastro;
        this.tipoLotacao = tipoLotacao;
    }
    
    public Servidor() {
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
