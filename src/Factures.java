

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Factures implements Serializable {
	int id;
	String dateemission;
	String dataachat;
	String nomentreprise;
	String nomclient;
	int idbonclient;
	double prixht;
	double prixttc;
	
	Factures() {
		this.id = 0;
		this.dateemission = "01/01/2001";
		this.dataachat = "01/01/2001";
		this.nomentreprise = "POO'Lettes Corp";
		this.nomclient = "Toto";
		this.idbonclient = 0;
		this.prixht = 100;
		this.prixttc = 120;
	}
	
	Factures(int id,String dateemission, String dataachat, String nomc, int idbon, double prix) {
		this.id = id;
		this.dateemission = dateemission;
		this.dataachat = dataachat;
		this.nomentreprise = "POO'Lettes Corp";
		this.nomclient = nomc;
		this.idbonclient = idbon;
		this.prixht = prix;
		this.prixttc = prix + 20*prix/100;
	}
	
	void Addfacture(ArrayList<Factures> Liste) {
		Liste.add(this);
	}
	
	Factures RecupFact(int id, ArrayList<Factures> Liste){
		return Liste.get(id-1);
		
	}
	
	void AfficherFact(int id, ArrayList<Factures> Liste) {
		Factures fact = RecupFact(id, Liste);
		System.out.println("La facture demandée est la facture n° " + id + " pour le client " +fact.nomclient);
		
	}		
}
