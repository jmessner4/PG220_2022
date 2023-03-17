


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
public class ManipIdentite implements Serializable {


	@SuppressWarnings("unchecked")
	ArrayList<FicheIdentite> RecupIdentites() throws IOException {
		File fichier = new File("./ficheIdentite.ser");
		ArrayList<FicheIdentite> liste_identites = new ArrayList<FicheIdentite>();
		if(!fichier.exists()) {
			fichier.createNewFile();
			//System.err.println("Fichier inexistant.");
			//System.exit(0);
		}
		try {
			FileInputStream fis = new FileInputStream(fichier);
			ObjectInputStream ois = new ObjectInputStream(fis);
			liste_identites = (ArrayList<FicheIdentite>) ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichier non trouvé.");
		} catch (IOException e) {
			liste_identites = new ArrayList<FicheIdentite>();
			//System.out.println("Erreur I/O.");
		} catch (ClassNotFoundException e) {
			System.out.println("Erreur de chargement du fichier.");
		}
		return liste_identites;
	}
	
	@SuppressWarnings("unchecked")
	static ArrayList<FicheIdentite> GetListe() throws IOException {
		ArrayList<FicheIdentite> liste_identites = new ArrayList<FicheIdentite>() ;
		File fichier = new File("./ficheIdentite.ser");
		if(!fichier.exists()) {
			fichier.createNewFile();
			//System.err.println("Fichier inexistant.");
			//System.exit(0);
		}
		try {
			FileInputStream fis = new FileInputStream(fichier);
			ObjectInputStream ois = new ObjectInputStream(fis);
			liste_identites = (ArrayList<FicheIdentite>) ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichier non trouvé.");
		} catch (IOException e) {
			liste_identites = new ArrayList<FicheIdentite>();
			//System.out.println("Erreur I/O.");
		} catch (ClassNotFoundException e) {
			System.out.println("Erreur de chargement du fichier.");
		}
		return liste_identites;
	}
	
	static void SaveIdentite(ArrayList<FicheIdentite> liste_identites) throws IOException {
		File fichier = new File("./ficheIdentite.ser");
		if(!fichier.exists()) {
			fichier.createNewFile();
			//System.err.println("Fichier inexistant.");
			//System.exit(0);
		}
		try {
			FileOutputStream fos = new FileOutputStream(fichier);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(liste_identites);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichier non trouvé.");
		} catch (IOException e) {
			liste_identites = new ArrayList<FicheIdentite>();
			//System.out.println("Erreur I/O.");
		}
	}
	
	static FicheIdentite RecupIdentite(String nom, String prenom, ArrayList<FicheIdentite> Liste){
		for (FicheIdentite indiv : Liste) {
			if (nom.equals(indiv.nom) && prenom.equals(indiv.prenom)) {
				return indiv;
			}
		}
		return null;
	}
	
	static void AfficherIdentite(String nom, String prenom, ArrayList<FicheIdentite> Liste) {
		FicheIdentite identite = RecupIdentite(nom, prenom, Liste);
		if (identite == null) {
			System.out.println(prenom + " " + nom + " n'existe pas.");
		}
		else {
			System.out.println("ID : " + identite.id + "\nPrénom : " + identite.prenom + "\nNom : " + identite.nom + "\nEmail : " + identite.email + "\nPoste actuel : " + identite.posteActuel + "\nType de contrat : " + identite.typeContrat);
		}
	}
	
	static void RetirerIdentite(String nom, String prenom, ArrayList<FicheIdentite> Liste) {
		FicheIdentite identite = RecupIdentite(nom, prenom, Liste);
		if (identite == null) {
			System.out.println(prenom + " " + nom + " n'existe pas.");
		}
		else {
			Liste.remove(identite);
		}
	}
	
	
	static void AfficherHierarchie(ArrayList<FicheIdentite> Liste) {
		for (FicheIdentite indiv : Liste) {
			System.out.println("["+indiv.id+"]"+indiv.prenom + " " + indiv.nom + " : " + indiv.posteActuel + " (" + indiv.getIDPoste(indiv.posteActuel) + ")");
		}
	}
	
}

