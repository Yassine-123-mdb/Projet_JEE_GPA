package com.yassine.entities;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.yassine.util.JPAutil;

public class PhoneDao {
	private EntityManager entityManager = JPAutil.getEntityManager("PhoneGpa");


	public void ajouter(Phone p) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(p);
		tx.commit();
	}


	public void modifier(Phone p) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(p);
		tx.commit();
	}

//méthode Supprimer d'une entité à partir de la bd
	public void supprimer(Phone p) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		p = entityManager.merge(p); // important
		entityManager.remove(p);
		tx.commit();
	}

//méthode Consulter d'une entité à partir de la bd
	public Phone consulter(Phone p, Object id) {
		return entityManager.find(p.getClass(), id);
	}

//méthode pour lister tous les objets à partir de la bd
	public List<Phone> listerTous() {
		List<Phone> clients = entityManager.createQuery("select p from Phone p").getResultList();

		return clients;
	}

//méthode pour lister tous les client dont le nom contient un
//texte donné en paramètre (pnom)
	public List<Phone> listerParMarque(String marque) {
	    List<Phone> clients = entityManager.createQuery("select p from Phone p where p.marque like :pmarque").setParameter("pmarque", "%" + marque + "%").getResultList();
	    return clients;
	}
}