package com.nviagens.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nviagens.Model.FaleConosco;

@Repository
public interface FaleConoscoRepository extends JpaRepository<FaleConosco, Long> {
    
}
