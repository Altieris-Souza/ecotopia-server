package br.edu.up.front;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.List;


import br.edu.up.entidades.Proprietario;
import br.edu.up.persistencia.ProprietarioPersistencia;

public class AppProprietario {

	public AppProprietario() {
		int opt = 0;
		
		do {
			System.out.println("\n====================================");
			System.out.println("          MENU - PROPRIETARIO          ");
			System.out.println("====================================");
			System.out.println("\n1. Cadastrar novo proprietário: ");
			System.out.println("2. Listar proprietário: ");
			System.out.println("3. Excluir proprietário: ");
			System.out.println("4. Atualizar proprietário: ");
			System.out.println("5. Voltar ao menu anterior: ");
			System.out.println("\n====================================");
			
			opt = Console.readInt("\nEscolha uma opção: ");
			
			switch (opt) {
				case 1: 
					incluirProprietario();
					break;
					
				case 2: 
					listarProprietarios();		
					break;
					
				case 3: 
					excluirProprietario();		
					break;
					
				case 4: 
					alterarProprietario();		
					break;
			}
			
		} while (opt != 3);	
	}
	
	private static void incluirProprietario(){
		Proprietario objProprietario = new Proprietario();
		
		LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataAtualString = dataAtual.format(formatter);
		
		objProprietario.setCpf(Console.readString("\nInforme o CPF do proprietario: "));
		objProprietario.setNome(Console.readString("Informe o nome do proprietario: "));
		objProprietario.setData_nascimento(Console.readString("Informe a data de nascimento do proprietario: "));
		objProprietario.setData_criacao(dataAtualString);
		
		if(ProprietarioPersistencia.procurarPorCPF(objProprietario) == null) {
			ProprietarioPersistencia.incluir(objProprietario);
			System.out.println("\n\nProprietário cadastrado com sucesso!");
		} else {
			System.out.println("\n\nEsse CPF já consta em nossa base de dados.");
		}
	}
	
	private static void listarProprietarios(){
		
		Proprietario objProprietario = new Proprietario();
		
		objProprietario.setNome(Console.readString("\nInforme uma parte do nome que deseja listar: "));
		
		List<Proprietario> proprietarios = ProprietarioPersistencia.getProprietarios(objProprietario);
		
		if(!proprietarios.isEmpty()){
			System.out.println("\n====================================\n");
			System.out.println("PROPRIETÁRIOS ENCONTRADOS\n");
		
			for(Proprietario p : proprietarios){
				System.out.println("Nome: " + p.getNome());
				System.out.println("CPF: " + p.getCpf() + "\n");
			}
		}
		else{
			System.out.println("Proprietario(s) não encontrado(s) ou inexistente.");
		}
	}
	
	private static void excluirProprietario(){	
		Proprietario objProprietario = new Proprietario();
		
		objProprietario.setNome(Console.readString("\nInforme o nome do proprietario que deseja excluir: "));
		
		List<Proprietario> proprietarios = ProprietarioPersistencia.getProprietarios(objProprietario);
		
		if(!proprietarios.isEmpty()){
			ProprietarioPersistencia.excluirProprietario(proprietarios.get(0));
			System.out.println("Proprietario excluído com sucesso!!");
		}
		else{
			System.out.println("Proprietario(s) não encontrado(s) ou inexistente.");
		}
	}
	
	private static void alterarProprietario(){	
		Proprietario objProprietario = new Proprietario();
		
		objProprietario.setCpf(Console.readString("\nInforme o cpf do proprietario que deseja alterar: "));
		
		List<Proprietario> proprietario = ProprietarioPersistencia.procurarPorCPF(objProprietario);
		
		if(proprietario != null){
			
			System.out.println();
		}
		else{
			System.out.println("\nProprietario(s) não encontrado(s) ou inexistente.");
		}
	}
	
}
