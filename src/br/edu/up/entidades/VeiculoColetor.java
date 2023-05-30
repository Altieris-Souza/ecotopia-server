package br.edu.up.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VeiculoColetor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cod_coletor;
	private String placa;
	private String modelo;
	private String marca;
	private int ano;
	
	public int getCod_coletor() {
		return cod_coletor;
	}
	public void setCod_coletor(int cod_coletor) {
		this.cod_coletor = cod_coletor;
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
}
