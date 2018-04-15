package com.urata.carteira

import org.springframework.data.jpa.repository.JpaRepository

interface CarteiraRepository extends JpaRepository<Carteira, Long> {
}
