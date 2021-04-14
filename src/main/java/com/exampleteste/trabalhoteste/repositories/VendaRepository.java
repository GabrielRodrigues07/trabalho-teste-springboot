package com.exampleteste.trabalhoteste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exampleteste.trabalhoteste.entities.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long>{
}
