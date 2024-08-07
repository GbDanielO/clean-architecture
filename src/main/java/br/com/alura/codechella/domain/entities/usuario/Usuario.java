package br.com.alura.codechella.domain.entities.usuario;

import java.time.LocalDate;
import java.time.Period;

import br.com.alura.codechella.domain.Endereco;

public class Usuario {

	private Long id;
	private String cpf;
    private String nome;
    private LocalDate nascimento;
    private String email;
    
    private Endereco endereco;
    
    public Usuario() {}
    
	public Usuario(String cpf, String nome, LocalDate nascimento, String email) {

		if(cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
			throw new IllegalArgumentException("CPF fora do padrão");
		}
		
		// Calcula a idade com base na data de nascimento e a data atual
        int idade = Period.between(nascimento, LocalDate.now()).getYears();
        // Verifica se a idade é inferior a 18 anos e lança uma exceção se for
        if (idade < 18) {
            throw new IllegalArgumentException("Usuário deve ter pelo menos 18 anos de idade!");
        }
		
		this.cpf = cpf;
		this.nome = nome;
		this.nascimento = nascimento;
		this.email = email;
	}
	
	public Usuario(Long id, String cpf, String nome, LocalDate nascimento, String email) {
		this(cpf, nome, nascimento, email);
		this.id = id;
	}

	public Usuario(String cpf, String email) {
		this.cpf = cpf;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
    
}
