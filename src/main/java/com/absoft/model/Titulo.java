package com.absoft.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.NotEmpty;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity(value = "titulos", noClassnameStored = true)
public class Titulo implements BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    private ObjectId id;

    @NotEmpty(message = "Descrição é obrigatório!")
    @Size(max = 60, message = "A Descrição não pode conter mais de 60 caracteres.")
    private String descricao;

    @NotNull(message = "Data de vencimento é obrigatória!")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataVencimento;

    @NotNull(message = "Valor é obrigatório!")
    @DecimalMin(value = "0.01", message = "Valor não pode ser menor que 0,01")
    @NumberFormat(pattern = "#,##0.00")
    private BigDecimal valor;

    private StatusTitulo status;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public StatusTitulo getStatus() {
        return status;
    }

    public void setStatus(StatusTitulo status) {
        this.status = status;
    }

    public boolean isPendente() {
        return StatusTitulo.PENDENTE == this.status;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Titulo other = (Titulo) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

}
