package com.nviagens.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotBlank
    @Size(min = 4)
    private String nameCad;
    
    @NotBlank
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}") 
    private String cpfCad;
    
    @NotBlank
    @Pattern(regexp = "\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}")
    private String phoneCad;
    
    @NotBlank
    @Pattern(regexp = "\\d{5}-\\d{3}")
    private String cepCad;
    
    @NotBlank
    @Size(min = 4)
    private String endCad;

    @NotBlank
    @Email
    private String emailCad;
    
    @NotBlank
    @Size(min = 4)
    private String senhaCad;
    
    public Usuario() {
    }

    public Usuario(String nameCad, String cpfCad, String phoneCad, String cepCad, String endCad, String emailCad, String senhaCad) {
        this.nameCad = nameCad;
        this.cpfCad = cpfCad;
        this.phoneCad = phoneCad;
        this.cepCad = cepCad;
        this.endCad = endCad;
        this.emailCad = emailCad;
        this.senhaCad = senhaCad;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameCad() {
		return nameCad;
	}

	public void setNameCad(String nameCad) {
		this.nameCad = nameCad;
	}

	public String getCpfCad() {
		return cpfCad;
	}

	public void setCpfCad(String cpfCad) {
		this.cpfCad = cpfCad;
	}

	public String getPhoneCad() {
		return phoneCad;
	}

	public void setPhoneCad(String phoneCad) {
		this.phoneCad = phoneCad;
	}

	public String getCepCad() {
		return cepCad;
	}

	public void setCepCad(String cepCad) {
		this.cepCad = cepCad;
	}

	public String getEndCad() {
		return endCad;
	}

	public void setEndCad(String endCad) {
		this.endCad = endCad;
	}

	public String getEmailCad() {
		return emailCad;
	}

	public void setEmailCad(String emailCad) {
		this.emailCad = emailCad;
	}

	public String getSenhaCad() {
		return senhaCad;
	}

	public void setSenhaCad(String senhaCad) {
		this.senhaCad = senhaCad;
	}

   
}
