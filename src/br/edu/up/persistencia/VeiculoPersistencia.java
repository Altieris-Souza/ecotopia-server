package br.edu.up.persistencia;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.up.entidades.VeiculoColetor;

public class VeiculoPersistencia {
	
	public static List<VeiculoColetor> procurarPorPlaca(VeiculoColetor veiculo){
		
		EntityManager manager = EntityManagerFactory.getInstance();
		
		Query consulta = manager.createQuery("from VeiculoColetor where placa = :param");
		
		consulta.setParameter("param", veiculo.getPlaca());
		
		@SuppressWarnings("unchecked")
		List<VeiculoColetor> veiculos = consulta.getResultList();
		
		if(!veiculos.isEmpty()){
			return veiculos;
		}
		
		return null;
	}
	
	public static boolean incluir(VeiculoColetor veiculo){
		try{
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(veiculo);
			manager.getTransaction().commit();
			return true;			
		}
		catch(Exception e){
			return false;
		}
	}
	
	public static List<VeiculoColetor> getVeiculos(VeiculoColetor veiculo){
		EntityManager manager = EntityManagerFactory.getInstance();
		
		Query consulta = manager.createQuery("from VeiculoColetor where placa like :param");
		
		consulta.setParameter("param", "%" + veiculo.getPlaca() + "%");
		
		@SuppressWarnings("unchecked")
		List<VeiculoColetor> veiculos = consulta.getResultList();
		
		return veiculos;
	}
	
	public static boolean excluirVeiculo(VeiculoColetor veiculo){
		try{
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.remove(veiculo);
			manager.getTransaction().commit();
			return true;			
			
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
