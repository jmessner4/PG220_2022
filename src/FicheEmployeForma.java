

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class FicheEmployeForma implements Serializable {
	FicheIdentite Iden;
	String Forma;
	int id;
	
	FicheEmployeForma(){
		this.id=0;
		FicheIdentite Identite=new FicheIdentite("Arnaud","Debouchage","adebouchage@bordeaux-inp.fr","technicien de surface en alternance","Alternance", this.id);
		this.Iden=Identite;
		this.Forma="Alternance";
	}
	
	
	FicheEmployeForma(int Id,FicheIdentite Identite,String Frm){
		this.id=Id;
		this.Iden=Identite;
		this.Forma=Frm;
	}
	
	FicheEmployeForma RecupSal(int id,ArrayList<FicheEmployeForma> liste_form) {
		return liste_form.get(id-1);
	}
	
	void AfficherForm(int id,ArrayList<FicheEmployeForma> liste_form) {
		FicheEmployeForma form=RecupSal(id,liste_form);
		System.out.println("La fiche de formation de " +form.Iden.nom + form.Iden.prenom + "est la suivante: " + form.Forma);
	}
}
