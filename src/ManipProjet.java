package src;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class ManipProjet implements Serializable {


	@SuppressWarnings("unchecked")
	ArrayList<SuiviProjet> RecupInfoProjet() throws IOException {
		File fichier = new File("./suiviProjet.ser");
		ArrayList<SuiviProjet> listes_projets = new ArrayList<SuiviProjet>();
		if(!fichier.exists()) {
			fichier.createNewFile();
			//System.err.println("Fichier inexistant.");
			//System.exit(0);
		}
		try {
			FileInputStream fis = new FileInputStream(fichier);
			ObjectInputStream ois = new ObjectInputStream(fis);
			listes_projets = (ArrayList<SuiviProjet>) ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichier non trouvé.");
		} catch (IOException e) {
			listes_projets = new ArrayList<SuiviProjet>();
			System.out.println("Erreur I/O.");
		} catch (ClassNotFoundException e) {
			System.out.println("Erreur de chargement du fichier.");
		}
		return listes_projets;
	}
	
	@SuppressWarnings("unchecked")
	static ArrayList<SuiviProjet> GetListe() throws IOException {
		ArrayList<SuiviProjet> listes_projets = new ArrayList<SuiviProjet>() ;
		File fichier = new File("./suiviProjet.ser");
		if(!fichier.exists()) {
			fichier.createNewFile();
			System.err.println("Fichier inexistant.");
			System.exit(0);
		}
		try {
			FileInputStream fis = new FileInputStream(fichier);
			ObjectInputStream ois = new ObjectInputStream(fis);
			listes_projets = (ArrayList<SuiviProjet>) ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichier non trouvé.");
		} catch (IOException e) {
			//listes_projets = new ArrayList<SuiviProjet>();
			System.out.println("Erreur I/O.");
		} catch (ClassNotFoundException e) {
			System.out.println("Erreur de chargement du fichier.");
		}
		return listes_projets;
	}
	
	static void SaveProjet(ArrayList<SuiviProjet> listes_projets) throws IOException {
		File fichier = new File("./suiviProjet.ser");
		if(!fichier.exists()) {
			fichier.createNewFile();
			//System.err.println("Fichier inexistant.");
			//System.exit(0);
		}
		try {
			FileOutputStream fos = new FileOutputStream(fichier);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(listes_projets);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichier non trouvé.");
		} catch (IOException e) {
			listes_projets = new ArrayList<SuiviProjet>();
			System.out.println("Erreur I/O.");
		}
	}
	
	static SuiviProjet RecupInfoProjet(String nom, ArrayList<SuiviProjet> Liste){
		for (SuiviProjet projet : Liste) {
			if (nom.equals(projet.ProjectName)) {
				return projet;
			}
		}
		return null;
	}
	
	static void AfficherSuivi(String nom, ArrayList<SuiviProjet> Liste) {
		SuiviProjet projet = RecupInfoProjet(nom, Liste);
		if (projet == null) {
			System.out.println("Le projet " + nom + " n'existe pas.");
		}
		else {
			System.out.println("[" + projet.id + "] Le projet " + projet.ProjectName + " a pour chef de projet " + projet.ChefdeProjet + ".");
			if (projet.MemberList.size() == 0) {
				System.out.print("Il n'y a pas d'autre membres dans ce projet.");
			} else {
				System.out.print("Les membres de l'équipe sont : ");
				for (int i=0;i<projet.MemberList.size();i++) {
					System.out.print(projet.MemberList.get(i) + " |");
				}
			}
			System.out.println("");
			if (projet.ProjectStep.size()==0) {
				System.out.println("Il n'y a pas encore d'étapes effectuées.");
			} else {
				System.out.println("Les étapes effectuées sont:");
				for (int i=0;i<projet.ProjectStep.size();i++) {
					System.out.print(projet.ProjectStep.get(i));
					if (projet.currStep == i+1) {
						System.out.print(" <---------");
					}
					System.out.println("");
				}
			}
		}
	}
	
	
	
	static void AddMemberList(String nom, String member, ArrayList<SuiviProjet> Liste) {
		SuiviProjet projet = RecupInfoProjet(nom, Liste);
		if (projet == null) {
			System.out.println("Le projet " + nom + " n'existe pas.");
		}
		else {
			projet.MemberList.add(member);
			Liste.set(projet.id,projet);
			System.out.println("Le nouveau collaborateur est bien enregistré.");
		}
	}
	
	static void RetirerMemberList(String nom, String member, ArrayList<SuiviProjet> Liste) {
		SuiviProjet projet = RecupInfoProjet(nom, Liste);
		if (projet == null) {
			System.out.println("Le projet " + nom + " n'existe pas.");
		}
		else {
			for (int i=0;i<projet.MemberList.size();i++) {
				if (member.equals(projet.MemberList.get(i))) {
					projet.MemberList.remove(i);
					Liste.set(projet.id,projet);
					System.out.println("Le nouveau collaborateur est bien retiré du projet.");
					break;
				}
			}
		}
	}
	
	static void RetirerProjet(String nom, ArrayList<SuiviProjet> Liste) {
		SuiviProjet projet = RecupInfoProjet(nom, Liste);
		if (projet == null) {
			System.out.println("Le projet " + nom + " n'existe pas.");
		}
		else {
			Liste.remove(projet);
			System.out.println("Le projet est bien supprimé.");
		}
	}
	
	
	static void AddSteps(String nom, String step, ArrayList<SuiviProjet> Liste) {
		SuiviProjet projet = RecupInfoProjet(nom, Liste);
		if (projet == null) {
			System.out.println("Le projet " + nom + " n'existe pas.");
		}
		else {
			projet.ProjectStep.add(step);
			Liste.set(projet.id,projet);
			System.out.println("La nouvelle tâche est bien ajoutée au projet.");
		}
	}
	
	static void AfficherListe(ArrayList<SuiviProjet> Liste) {
		for (SuiviProjet projet : Liste) {
			System.out.println(" - " + projet.ProjectName);
		}
	}
	
	static void CurrStep(String nom, int numStep, ArrayList<SuiviProjet> Liste) {
		SuiviProjet projet = RecupInfoProjet(nom, Liste);
		if (projet == null) {
			System.out.println("Le projet " + nom + " n'existe pas.");
		}
		else {
			projet.currStep = numStep;
			Liste.set(projet.id,projet);
			System.out.println("La tâche en cours est bien mise à jour.");
		}
	}
}


