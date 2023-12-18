package com.nviagens.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BuscaViagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String destino;
    private String preco;

    
    public BuscaViagem() {
    }

    public BuscaViagem(String destino, String preco) {
        this.destino = destino;
        this.preco = preco;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public BuscaViagem(Long id, String destino, String preco) {
		
		this.id = id;
		this.destino = destino;
		this.preco = preco;
	}

    
}
