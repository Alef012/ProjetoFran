package com.jcgontijo.paineldecontrole.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "financeiro")
@Getter
@Setter
@ToString
@Builder
public class Financeiro extends Pessoa{
    
}
