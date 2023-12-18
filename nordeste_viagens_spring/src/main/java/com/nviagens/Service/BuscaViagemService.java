package com.nviagens.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nviagens.Model.BuscaViagem;
import com.nviagens.Repository.BuscaViagemRepository;

@Service
public class BuscaViagemService {

    @Autowired
    private BuscaViagemRepository buscaViagemRepository;

    public List<BuscaViagem> buscarPorDestino(String destino) {
        return buscaViagemRepository.findByDestino(destino);
    }
    
    public List<BuscaViagem> buscarPorPreco(String preco) {
        return buscaViagemRepository.findByPreco(preco);
    }

    // Remove esse método, já que não há mais findByDestinoAndPreco no repositório
}
