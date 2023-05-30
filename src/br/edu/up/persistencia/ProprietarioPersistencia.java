package br.edu.up.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.edu.up.entidades.Proprietario;

public class ProprietarioPersistencia {
	public static boolean incluir(Proprietario proprietario){
		try{
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(proprietario);
			manager.getTransaction().commit();
			return true;			
		}
		catch(Exception e){
			return false;
		}
	}
	
	public static List<Proprietario> procurarPorCPF(Proprietario proprietario){
		
		EntityManager manager = EntityManagerFactory.getInstance();
		
		Query consulta = manager.createQuery("from Proprietario where cpf = :param");
		
		consulta.setParameter("param", proprietario.getCpf());
		
		@SuppressWarnings("unchecked")
		List<Proprietario> proprietarios = consulta.getResultList();
		
		if(!proprietarios.isEmpty()){
			return proprietarios;
		}
		
		return null;
	}
	
	public static List<Proprietario> getProprietarios(Proprietario proprietario){
		EntityManager manager = EntityManagerFactory.getInstance();
		
		Query consulta = manager.createQuery("from Proprietario where nome like :param");
		
		consulta.setParameter("param", "%" + proprietario.getNome() + "%");
		
		@SuppressWarnings("unchecked")
		List<Proprietario> proprietarios = consulta.getResultList();
		
		return proprietarios;
	}
	
	public static boolean excluirProprietario(Proprietario proprietario){
		try{
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.remove(proprietario);
			manager.getTransaction().commit();
			return true;			
			
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
}
