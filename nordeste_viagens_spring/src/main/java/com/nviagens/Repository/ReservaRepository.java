package com.nviagens.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nviagens.Model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
   
}
