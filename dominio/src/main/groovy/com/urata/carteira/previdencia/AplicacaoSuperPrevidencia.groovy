package com.urata.carteira.previdencia

import com.urata.carteira.Carteira
import groovy.transform.ToString
import groovy.transform.builder.Builder
import groovy.transform.builder.InitializerStrategy

import javax.persistence.*
import java.time.LocalDateTime

@Entity
@ToString
@Builder(builderStrategy = InitializerStrategy, builderMethodName = "builder")
class AplicacaoSuperPrevidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD")
    Long id

    @Version
    @Column(name = "NUM_VERSAO_REGISTRO", nullable = false)
    Long versao

    LocalDateTime dataAplicacao

    BigDecimal valorAplicado

    @OneToMany(mappedBy = "aplicacaoSuperPrevidencia")
    List<PercentualParticipacaoSuperPrevidencia> planosPrevidencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="COD_CARTEIRA", foreignKey = @ForeignKey(name="FK_ASP_COD_CARTEIRA"))
    Carteira carteira
}
