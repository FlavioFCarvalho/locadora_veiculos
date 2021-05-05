package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaModeloFiltroEmFabricanteECategoria {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

	  String jpql = "select mc.descricao from ModeloCarro mc where mc.fabricante.nome = 'Honda' and mc.categoria in ('SEDAN_MEDIO','SEDAN_GRANDE')";
	  List<String> modelos = em.createQuery(jpql, String.class).getResultList();
		for (String modelo : modelos) {
			System.out.println("Modelo: " + modelo);
		}
		
		em.close();
	}

}
