package com.urata.carteira.rendavariavel.fundo

import com.urata.carteira.Carteira
import com.urata.carteira.CorretoraEnum
import groovy.transform.ToString
import groovy.transform.builder.Builder
import groovy.transform.builder.InitializerStrategy

import javax.persistence.*
import java.time.LocalDateTime

@Entity
@ToString
@Builder(builderStrategy=InitializerStrategy, builderMethodName = "builder")
class AplicacaoFundoRendaVariavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD")
    Long id

    @Version
    @Column(name = "NUM_VERSAO_REGISTRO", nullable = false)
    Long versao

    @Column(nullable = false)
    LocalDateTime dataAplicacao

    @Column(nullable = false)
    String nomeFundo

    @Column(nullable = false)
    BigDecimal valorAplicado

    BigDecimal valorCorretagem

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    TipoFundoEnum tipoFundo

    @Enumerated(EnumType.STRING)
    CorretoraEnum corretora

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="COD_CARTEIRA")
    Carteira carteira



}
