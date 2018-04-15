package com.urata.carteira.rendafixa.tesourodireto

import com.urata.carteira.Carteira
import com.urata.carteira.comum.CorretoraEnum
import groovy.transform.ToString
import groovy.transform.builder.Builder
import groovy.transform.builder.InitializerStrategy

import javax.persistence.*
import java.time.LocalDateTime

@Entity
@ToString
@Builder(builderStrategy = InitializerStrategy, builderMethodName = "builder")
class AplicacaoTesouroDireto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD")
    Long id

    @Version
    @Column(name = "NUM_VERSAO_REGISTRO", nullable = false)
    Long versao

    LocalDateTime dataAplicacao

    float taxaJuros

    BigDecimal valorAplicado

    BigDecimal precoUnitario

    BigDecimal valorCorretagem

    @Enumerated(EnumType.STRING)
    TipoTituloTesouroDiretoEnum tipoTituloTesouroDireto

    @Enumerated(EnumType.STRING)
    CorretoraEnum corretora

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="COD_CARTEIRA", foreignKey = @ForeignKey(name="FK_ATD_COD_CARTEIRA"))
    Carteira carteira

}
