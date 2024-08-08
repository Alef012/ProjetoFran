package com.ethos.gestorimobiliario.modelos;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
public class Cliente extends Pessoa{
                       
}
