package br.edu.up.entidades;

public class Salao {
	private int id;
	private String nome;
	private String porte;
	private String Cnpj;
	private float qtd_total_coletada;
	private int coletor;
	private int endereco;
	private int proprietario;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getPorte() {
		return porte;
	}
	public void setPorte(String porte) {
		this.porte = porte;
	}
	
	public String getCnpj() {
		return Cnpj;
	}
	public void setCnpj(String cnpj) {
		Cnpj = cnpj;
	}
	
	public float getQtd_total_coletada() {
		return qtd_total_coletada;
	}
	public void setQtd_total_coletada(float qtd_total_coletada) {
		this.qtd_total_coletada = qtd_total_coletada;
	}
	
	public int getColetor() {
		return coletor;
	}
	public void setColetor(int coletor) {
		this.coletor = coletor;
	}
	
	public int getEndereco() {
		return endereco;
	}
	public void setEndereco(int endereco) {
		this.endereco = endereco;
	}
	
	public int getProprietario() {
		return proprietario;
	}
	public void setProprietario(int proprietario) {
		this.proprietario = proprietario;
	}
}
