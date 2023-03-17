


import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Recette implements Serializable{
	
	double Total_Rec;
	
	Recette(){
		this.Total_Rec=0;
	}
	
	void CalculRecette(ArrayList<Factures> liste_facture) {
		int i=0;
		while(i<liste_facture.size()) {
			this.Total_Rec=this.Total_Rec+liste_facture.get(i).prixttc;
			i++;			
		}
	}
	
	void AfficherCoutSal() {
		System.out.println("Les recettes total sontde " + this.Total_Rec + " euros.");
	}

	
}
