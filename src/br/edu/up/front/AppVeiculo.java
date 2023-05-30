package br.edu.up.front;
import java.util.List;

import br.edu.up.entidades.VeiculoColetor;
import br.edu.up.persistencia.VeiculoPersistencia;

public class AppVeiculo {

	public AppVeiculo() {
		int opt = 0;
		
		do {
			System.out.println("\n====================================");
			System.out.println("            MENU - VEÍCULO            ");
			System.out.println("====================================");
			System.out.println("\n1. Cadastrar novo veículo: ");
			System.out.println("2. Listar veículos: ");
			System.out.println("3. Excluir veículo: ");
			System.out.println("4. Atualizar veículo: ");
			System.out.println("5. Voltar ao menu anterior: ");
			System.out.println("\n====================================");
			
			opt = Console.readInt("\nEscolha uma opção: ");
			
			switch (opt) {
				case 1: 
					incluirVeiculo();
					break;
					
				case 2:
					listarVeiculos();
					break;
					
				case 3: 
					excluirVeiculo();
					break;
			}
			
		} while (opt != 3);	
	}
	
	private static void incluirVeiculo(){
		VeiculoColetor objVeiculo = new VeiculoColetor();
		
		objVeiculo.setModelo(Console.readString("\nInforme o modelo do veículo: "));
		objVeiculo.setMarca(Console.readString("Informe a marca do veículo: "));
		objVeiculo.setPlaca(Console.readString("Informe a placa do veículo: "));
		objVeiculo.setAno(Console.readInt("Informe o ano do veículo: "));
		
		if(VeiculoPersistencia.procurarPorPlaca(objVeiculo) == null) {
			VeiculoPersistencia.incluir(objVeiculo);
			System.out.println("\n\nVeículo cadastrado com sucesso!");
		} else {
			System.out.println("\n\nJá existe um veículo com essa placa cadastrado em nossa base de dados");
		}
	}
	
	private static void listarVeiculos(){
		
		VeiculoColetor objVeiculo = new VeiculoColetor();
		
		objVeiculo.setModelo(Console.readString("\nInforme a placa do veículo que deseja buscar: "));
		
		List<VeiculoColetor> veiculos = VeiculoPersistencia.getVeiculos(objVeiculo);
		
		if(!veiculos.isEmpty()){
			System.out.println("\n====================================\n");
			System.out.println("DADOS DO VEÍCULO DE PLACA: " + veiculos.get(0).getPlaca() + "\n");
		
			System.out.println(veiculos.get(0).getMarca());
			System.out.println(veiculos.get(0).getModelo());
			System.out.println(veiculos.get(0).getAno());
		}
		else{
			System.out.println("Veículo(s) não encontrado(s) ou inexistentes.");
		}
	}
	
	private static void excluirVeiculo(){	
		VeiculoColetor objVeiculo = new VeiculoColetor();
		
		objVeiculo.setPlaca(Console.readString("\nInforme a placa do veículo que deseja excluir: "));
		
		List<VeiculoColetor> veiculos = VeiculoPersistencia.getVeiculos(objVeiculo);
		
		if(!veiculos.isEmpty()){
			VeiculoPersistencia.excluirVeiculo(veiculos.get(0));
			System.out.println("\nVeículo excluído com sucesso!!");
		}
		else{
			System.out.println("\nVeículo não encontrado ou inexistente.");
		}
	}
}
