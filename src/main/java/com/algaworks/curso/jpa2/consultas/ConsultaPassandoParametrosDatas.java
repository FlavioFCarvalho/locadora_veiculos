package com.algaworks.curso.jpa2.consultas;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TemporalType;

import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaPassandoParametrosDatas {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		String jpql = "select count(a) " + "from Aluguel a " + "where a.dataDevolucao BETWEEN :inicio AND :fim";

		// A contagem dos meses inicia-se com zero, Janeiro é zero, Fevereiro um e assim por diante.
		Calendar inicioCalendar = Calendar.getInstance();
		inicioCalendar.set(2021, 3, 07, 0, 0); 
		Date inicio = inicioCalendar.getTime();

		Calendar fimCalendar = Calendar.getInstance();
		fimCalendar.set(2021, 5, 07, 18, 0); 
		Date fim = fimCalendar.getTime();
	

		Long quantidadeDevolucoes = em.createQuery(jpql, Long.class)
				.setParameter("inicio", inicio, TemporalType.TIMESTAMP).setParameter("fim", fim, TemporalType.TIMESTAMP)
				.getSingleResult();

		System.out.println("Quantidade de devoluções: " + quantidadeDevolucoes);
	}

}