package com.nviagens.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(min = 4)
    private String nome;

    @NotBlank
    @Pattern(regexp = "\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}")
    private String telefoneRes;

    @NotBlank
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")
    private String cpfRes;

   
    private String checkRes;

    @NotBlank
    @Size(min = 1)
    private String quantidadePessoas;

    @NotBlank
    @Size(min = 4)
    private String destinoRes;


   
	
		public Reserva() {
	
	}


	public Reserva(Long id, @NotBlank @Size(min = 4) String nome,
			@NotBlank @Pattern(regexp = "\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}") String telefoneRes,
			@NotBlank @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}") String cpfRes, String checkRes,
			@NotBlank @Size(min = 1) String quantidadePessoas, @NotBlank @Size(min = 4) String destinoRes) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefoneRes = telefoneRes;
		this.cpfRes = cpfRes;
		this.checkRes = checkRes;
		this.quantidadePessoas = quantidadePessoas;
		this.destinoRes = destinoRes;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTelefoneRes() {
		return telefoneRes;
	}


	public void setTelefoneRes(String telefoneRes) {
		this.telefoneRes = telefoneRes;
	}


	public String getCpfRes() {
		return cpfRes;
	}


	public void setCpfRes(String cpfRes) {
		this.cpfRes = cpfRes;
	}


	public String getCheckRes() {
		return checkRes;
	}


	public void setCheckRes(String checkRes) {
		this.checkRes = checkRes;
	}


	public String getQuantidadePessoas() {
		return quantidadePessoas;
	}


	public void setQuantidadePessoas(String quantidadePessoas) {
		this.quantidadePessoas = quantidadePessoas;
	}


	public String getDestinoRes() {
		return destinoRes;
	}


	public void setDestinoRes(String destinoRes) {
		this.destinoRes = destinoRes;
	}
}
	