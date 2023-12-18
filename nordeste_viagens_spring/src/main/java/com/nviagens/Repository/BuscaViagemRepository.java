package com.nviagens.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nviagens.Model.BuscaViagem;

@Repository
public interface BuscaViagemRepository extends JpaRepository<BuscaViagem, Long> {

    List<BuscaViagem> findByDestino(String destino);

    List<BuscaViagem> findByPreco(String preco);
}
