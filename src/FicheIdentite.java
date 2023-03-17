


import java.io.Serializable;
import java.util.ArrayList;


@SuppressWarnings("serial")
public class FicheIdentite implements Serializable {
	String prenom;
	String nom;
	String email;
	String posteActuel;
	String typeContrat;
	int id;
	
	FicheIdentite(String prenom, String nom, String email, String posteActuel, String typeContrat, int id) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.posteActuel = posteActuel;
		this.typeContrat = typeContrat;
		this.id = id;
	}
	
	static int getNewID(ArrayList<FicheIdentite> Liste) {
		int id = Liste.size();
		return id;
	}
	

	public int getIDPoste(String poste) {
		if (poste.equals("Directeur Général") || poste.equals("Directrice Générale"))
			return 1;
		// ETAGE 2
		else if (poste.equals("Directeur de Production") || poste.equals("Directrice de Production"))
			return 11;
		else if (poste.equals("Directeur Financier") || poste.equals("Directrice Financière"))
			return 12;
		else if (poste.equals("Directeur des RH") || poste.equals("Directrice des RH"))
			return 13;
		else if (poste.equals("Directeur Commercial") || poste.equals("Directrice Commerciale"))
			return 14;
		else if (poste.equals("Directeur Juridique") || poste.equals("Directrice Juridique"))
			return 15;
		// ETAGE 3
		else if (poste.equals("Directeur Logistique") || poste.equals("Directrice Logistique"))
			return 111;
		// FIN
		return 0;
	}
	
}
