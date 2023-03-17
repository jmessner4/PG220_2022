package erp_git;


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
class ManipSalaires implements Serializable {

	@SuppressWarnings("unchecked")
	ArrayList<FicheSalaire> RecupSalaire() throws IOException {
		System.out.println("coucou 1\n");
		File fichier = new File("./salaire.ser");
		ArrayList<FicheSalaire> liste_fact = new ArrayList<FicheSalaire>();
		System.out.println("coucou 2\n");
		if(!fichier.exists()) {
			fichier.createNewFile();
			//System.err.println("Fichier inexistant.");
			//System.exit(0);
		}
		try {
			FileInputStream fis = new FileInputStream(fichier);
			ObjectInputStream ois = new ObjectInputStream(fis);
			liste_fact = (ArrayList<FicheSalaire>) ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichier non trouvé.");
		} catch (IOException e) {
			liste_fact = new ArrayList<FicheSalaire>();
			System.out.println("Erreur I/O.");
		} catch (ClassNotFoundException e) {
			System.out.println("Erreur de chargement du fichier.");
		}
		return liste_fact;
	}
	
	@SuppressWarnings("unchecked")
	static ArrayList<FicheSalaire> GetListe() throws IOException {
		ArrayList<FicheSalaire> liste = new ArrayList<FicheSalaire>() ;
		File fichier = new File("./factures.ser");
		if(!fichier.exists()) {
			fichier.createNewFile();
			//System.err.println("Fichier inexistant.");
			//System.exit(0);
		}
		try {
			FileInputStream fis = new FileInputStream(fichier);
			ObjectInputStream ois = new ObjectInputStream(fis);
			liste = (ArrayList<FicheSalaire>) ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichier non trouvé.");
		} catch (IOException e) {
			System.out.println("Erreur I/O.");
		} catch (ClassNotFoundException e) {
			System.out.println("Erreur de chargement du fichier.");
		}
		return liste;
	}
	
	static void SaveFact(ArrayList<FicheSalaire> liste) throws IOException {
		File fichier = new File("./salaire.ser");
		if(!fichier.exists()) {
			fichier.createNewFile();
			//System.err.println("Fichier inexistant.");
			//System.exit(0);
		}
		try {
			FileOutputStream fos = new FileOutputStream(fichier);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(liste);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichier non trouvé.");
		} catch (IOException e) {
			System.out.println("Erreur I/O.");
		}
	}
	
	static FicheSalaire RecupSal(int id, ArrayList<FicheSalaire> Liste){
		return Liste.get(id);
		
	}
	
	static void AfficherSal(int id, ArrayList<FicheSalaire> Liste) {
		FicheSalaire sal = RecupSal(id, Liste);
		System.out.println("La fiche de salaire demandée est la fiche n°" + id + " pour l'employé " +sal.Identite.nom + " " + sal.Identite.prenom + ". Son salaire est de " + sal.salaireBrut + " euros en salaire brut et de " + sal.salaireNet +" euros en salaire net \n");;
		
	}
	
}