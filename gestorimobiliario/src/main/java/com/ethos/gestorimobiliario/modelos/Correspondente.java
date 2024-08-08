package com.ethos.gestorimobiliario.modelos;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.beanutils.BeanUtils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "correspondente")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Correspondente extends Pessoa {

    @ManyToOne
    @JoinColumn(name = "correspondente_bancario_id")
    private CorrespondenteBancario correspondenteBancario;

    public void copiarAtributosDe(Pessoa pessoa) {
        try {
            BeanUtils.copyProperties(this, pessoa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
