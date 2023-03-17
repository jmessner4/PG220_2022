
import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class CoutSalaires  implements Serializable{
	
	double CoutSalaireTot;
	
	CoutSalaires() {
		this.CoutSalaireTot=0;
	}
	
			
	
	void CalculSalairesTotaux(ArrayList<FicheSalaire> liste_salaires) {
		for (int i=0;i<liste_salaires.size();i++) {
			this.CoutSalaireTot=this.CoutSalaireTot + liste_salaires.get(i).salaireBrut;
		}
	}
	
	void AfficherCoutSal() {
		System.out.println("Le coût total des salaires est de " + this.CoutSalaireTot + " euros.");
	}
	
}
