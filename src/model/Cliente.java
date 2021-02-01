package model;

import java.util.Date;

public class Cliente {
	private String nome;
	private String rg;
	private String cpf;
	private String celular;
	private String email;
	private String nome_mae;
	private String nome_pai;
	private Date dataNsc;
	private Date dataCad;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNomeMae() {
		return nome_mae;
	}
	public void setNomeMae(String nome_mae) {
		this.nome_mae = nome_mae;
	}
	public String getNomePai() {
		return nome_pai;
	}
	public void setNomePai(String nome_pai) {
		this.nome_pai = nome_pai;
	}
	public Date getDataNsc() {
		return dataNsc;
	}
	public void setDataNsc(Date dataNsc) {
		this.dataNsc = dataNsc;
	}
	public Date getDataCad() {
		return dataCad;
	}
	public void setDataCad(Date dataCad) {
		this.dataCad = dataCad;
	}
	
	
	
}
