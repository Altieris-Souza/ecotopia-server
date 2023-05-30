package br.edu.up.front;

public class Principal {

	public static void main(String[] args) {
		
		int opt = 0;
		
		do {
			System.out.println("\n===================================");
			System.out.println("         BEM-VINDO AO MENU         ");
			System.out.println("===================================");
			System.out.println("\n1. Proprietário");
			System.out.println("2. Salão");
			System.out.println("3. Veículos");
			System.out.println("\n===================================");
			opt = Console.readInt("\nSelecione uma opção: ");
			
			switch(opt){
				case 1:
					new AppProprietario();
					break;
				
				case 2:
					new AppSalao();
					break;
					
				case 3:
					new AppVeiculo();
					break;
			}
			
		} while(opt != 5);
	}
}