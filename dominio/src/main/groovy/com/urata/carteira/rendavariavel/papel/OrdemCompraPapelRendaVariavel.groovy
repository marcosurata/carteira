package com.urata.carteira.rendavariavel.papel

import com.urata.carteira.Carteira
import com.urata.carteira.CorretoraEnum
import groovy.transform.ToString
import groovy.transform.builder.Builder
import groovy.transform.builder.InitializerStrategy

import javax.persistence.*
import java.time.LocalDateTime

@Entity
@ToString
@Builder(builderStrategy = InitializerStrategy, builderMethodName = "builder")
class OrdemCompraPapelRendaVariavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD")
    Long id

    @Version
    @Column(name = "NUM_VERSAO_REGISTRO", nullable = false)
    Long versao

    @Column(nullable = false)
    LocalDateTime dataCompra

    @Column(nullable = false)
    double quantidade

    @Column(nullable = false)
    BigDecimal precoUnitario

    BigDecimal valorCorretagem

    @OneToOne
    @JoinColumn(name = "COD_PAPEL")
    PapelRendaVariavel papelRendaVariavel

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    CorretoraEnum corretora

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="COD_CARTEIRA")
    Carteira carteira


}
