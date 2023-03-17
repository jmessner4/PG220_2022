


import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class FicheSalaire implements Serializable {
	int id;
	double salaireBrut;
	double retenue;
	double prelevementSource;
	double salaireNet;
	FicheIdentite Identite;
	
	FicheSalaire(){
		this.id= 0;
		this.salaireBrut=2340;
		this.retenue=120;
		this.prelevementSource=468;
		this.salaireNet=this.salaireBrut-this.retenue-this.prelevementSource;
		this.Identite=new FicheIdentite("Julie","Messner","jmessner001@bordeaux-inp.fr","PDG","CDI",this.id);
	}
	
	FicheSalaire(int Id,double salaireB,double ret, double prlSrc,FicheIdentite Iden){
		this.id=Id;
		this.salaireBrut=salaireB;
		this.retenue=ret;
		this.prelevementSource=prlSrc;
		this.salaireNet=this.salaireBrut-this.retenue-this.prelevementSource;
		this.Identite=Iden;
	}
	
	FicheSalaire RecupSal(int id,ArrayList<FicheSalaire> liste_sal) {
		return liste_sal.get(id-1);
	}
	
	void AfficherSal(int id, ArrayList<FicheSalaire> liste_sal) {
		FicheSalaire sal = RecupSal(id,liste_sal);
		System.out.println("La fiche de salaire demandée est la n° " + sal.id + " pour le salarié " + sal.Identite.nom + " " + sal.Identite.prenom + " avec un salaire brut de " + sal.salaireBrut + " un salaire net de " + sal.salaireNet);
	}
	
}
