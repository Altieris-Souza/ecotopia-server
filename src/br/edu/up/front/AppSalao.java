package br.edu.up.front;

import br.edu.up.persistencia.ProprietarioPersistencia;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.edu.up.entidades.Proprietario;
import java.time.LocalDate;

public class AppSalao {
	
	public AppSalao() {
		int opt = 0;
		
		do {
			System.out.println("\n====================================");
			System.out.println("            MENU - SALÃO            ");
			System.out.println("====================================");
			System.out.println("\n1. Cadastrar novo Salão: ");
			System.out.println("2. Listar Salões: ");
			System.out.println("3. Excluir Salão: ");
			System.out.println("4. Atualizar Salão: ");
			System.out.println("5. Voltar ao menu anterior: ");
			System.out.println("\n====================================");
			
			opt = Console.readInt("\nEscolha uma opção: ");
			
			switch (opt) {
				case 1: 
					break;
			}
			
		} while (opt != 3);	
	}
	
}


















