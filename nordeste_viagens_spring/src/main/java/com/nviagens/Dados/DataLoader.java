package com.nviagens.Dados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.nviagens.Model.BuscaViagem;
import com.nviagens.Repository.BuscaViagemRepository;

public class DataLoader implements CommandLineRunner {

    @Autowired
    private final BuscaViagemRepository buscaViagemRepository;

    public DataLoader(BuscaViagemRepository buscaViagemRepository) {
        this.buscaViagemRepository = buscaViagemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Adicionando alguns dados de exemplo ao iniciar a aplicação
        BuscaViagem buscaViagem1 = new BuscaViagem("Recife", "1000R$");
        BuscaViagem buscaViagem2 = new BuscaViagem("Porto de Galinhas", "1200R$");
        BuscaViagem buscaViagem3 = new BuscaViagem("Fernando de Noronha", "3000R$");

        buscaViagemRepository.save(buscaViagem1);
        buscaViagemRepository.save(buscaViagem2);
        buscaViagemRepository.save(buscaViagem3);
    }
}
