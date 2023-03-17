


import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class SuiviProjet implements Serializable {
	int id;
	String ProjectName;
	String ChefdeProjet;
	ArrayList<String> MemberList;
	String datedebut;
	String datefin;
	int currStep;
	ArrayList<String> ProjectStep;
	
	SuiviProjet(String name, String chefname, String dated, String datef,ArrayList<SuiviProjet> Liste) {
		this.ProjectName = name;
		this.ChefdeProjet = chefname;
		this.datedebut = dated;
		this.datefin = datef;
		this.currStep = 0;
		this.id = getNewID(Liste);
		this.MemberList = new ArrayList<String>();
		this.ProjectStep = new ArrayList<String>();
	}
	
	static int getNewID(ArrayList<SuiviProjet> Liste) {
		int id = Liste.size();
		return id;
	}
	
<<<<<<< HEAD
	void AddSteps (ArrayList<String> Steps) {
		this.ProjectStep = Steps;
	}
	

	SuiviProjet RecupInfoProjet(int id, ArrayList<SuiviProjet> Liste_pro) {
		return Liste_pro.get(id);
	}
	
	void AfficherSuivi(int id, ArrayList<SuiviProjet> Liste_pro) {
		SuiviProjet pro = RecupInfoProjet(id,Liste_pro);
		System.out.println("Le projet " + ProjectName + "  a pour chef de projet " + ChefdeProjet + " les membres de l'equipe sont ");
		if (pro.MemberList.size() == 0) {
			System.out.println("il n'y a pas d'autre membre.");
		} else {
			for (int i=0;i<pro.MemberList.size();i++) {
			System.out.println(pro.MemberList.get(i));
			}
		}
		System.out.println("Les étapes effectuées sont:");
		if (pro.ProjectStep.size()==0) {
			System.out.println("il n'y a pas encore d'étapes effectuées.");
		} else {
			for (int i=0;i<pro.ProjectStep.size();i++) {
				System.out.println(pro.ProjectStep.get(i));
			}
		}
	}
=======
>>>>>>> 4da9872b13bf8fed9b1b57562df09cabf15cfbee
}
