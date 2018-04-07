package com.urata.carteira.rendavariavel.papel

import org.springframework.data.jpa.repository.JpaRepository

interface RepositorioOrdemCompraPapelRendaVariavel extends JpaRepository<OrdemCompraPapelRendaVariavel, Long>{

    List<OrdemCompraPapelRendaVariavel> findByPapelRendaVariavelId(Long idPapel)

}