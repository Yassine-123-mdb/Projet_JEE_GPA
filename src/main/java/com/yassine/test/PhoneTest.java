package com.yassine.test;

import com.yassine.entities.Phone;
import com.yassine.entities.PhoneDao;


public class PhoneTest {

	public static void main(String[] args) {
		//créer un objet client
		Phone p = new Phone();
		p.setMarque("Meddeb Yassine");
		p.setCouleur("Houaria");
		p.setPrix(1500);
		p.setRam("8gb");
		p.setStockage("256gb");
		//ajouter l'objet client à la BD
		PhoneDao PhDao = new PhoneDao();
		PhDao.ajouter(p);
		System.out.println("Appel de la méthode listerTous");
		for (Phone ph : PhDao.listerTous())
		System.out.println(ph.getId()+" "+ph.getMarque()+" "+ph.getCouleur()+" "+ph.getPrix()+" "+ph.getRam()+" "+ph.getStockage());
		System.out.println("Appel de la méthode listerParMarque");
		for (Phone ph : PhDao.listerParMarque("nadh"))

		System.out.println(ph.getId()+" "+ph.getMarque()+" "+ph.getCouleur()+" "+ph.getPrix()+" "+ph.getRam()+" "+ph.getStockage());

		//tester les autres méthodes de la classe ClientDao
		}
		

}
