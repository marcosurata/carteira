package com.urata.carteira

import org.springframework.data.jpa.repository.JpaRepository

interface RepositorioCarteira extends JpaRepository<Carteira, Long> {
}
