package com.urata.usuario

import com.urata.carteira.Carteira
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.builder.Builder
import groovy.transform.builder.InitializerStrategy

import javax.persistence.*
import java.time.LocalDateTime

@Entity
@ToString
@EqualsAndHashCode(includes = ['id'])
@Builder(builderStrategy=InitializerStrategy)
class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD")
    Long id

    @Version
    @Column(name = "NUM_VERSAO_REGISTRO", nullable = false)
    Long versao

    @OneToOne(mappedBy = "usuario")
    Carteira carteira

    String nome
    String login
    String senha

    @Column(name = "DATA_CADASTRO")
    LocalDateTime dataCadastro
}
