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
class ManipForma implements Serializable {

	@SuppressWarnings("unchecked")
	ArrayList<FicheEmployeForma> RecupForma() throws IOException {
		System.out.println("coucou 1\n");
		File fichier = new File("./factures.ser");
		ArrayList<FicheEmployeForma> liste_forma = new ArrayList<FicheEmployeForma>();
		System.out.println("coucou 2\n");
		if(!fichier.exists()) {
			fichier.createNewFile();
			//System.err.println("Fichier inexistant.");
			//System.exit(0);
		}
		try {
			FileInputStream fis = new FileInputStream(fichier);
			ObjectInputStream ois = new ObjectInputStream(fis);
			liste_forma = (ArrayList<FicheEmployeForma>) ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichier non trouvé.");
		} catch (IOException e) {
			liste_forma = new ArrayList<FicheEmployeForma>();
			System.out.println("Erreur I/O.");
		} catch (ClassNotFoundException e) {
			System.out.println("Erreur de chargement du fichier.");
		}
		return liste_forma;
	}
	
	@SuppressWarnings("unchecked")
	static ArrayList<FicheEmployeForma> GetListe() throws IOException {
		ArrayList<FicheEmployeForma> liste = new ArrayList<FicheEmployeForma>() ;
		File fichier = new File("./forma.ser");
		if(!fichier.exists()) {
			fichier.createNewFile();
			//System.err.println("Fichier inexistant.");
			//System.exit(0);
		}
		try {
			FileInputStream fis = new FileInputStream(fichier);
			ObjectInputStream ois = new ObjectInputStream(fis);
			liste = (ArrayList<FicheEmployeForma>) ois.readObject();
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
	
	static void SaveForma(ArrayList<FicheEmployeForma> liste) throws IOException {
		File fichier = new File("./forma.ser");
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
	
	static FicheEmployeForma RecupForma(int id, ArrayList<FicheEmployeForma> Liste){
		return Liste.get(id);
		
	}
	
	static void AfficherForm(int id,ArrayList<FicheEmployeForma> liste_form) {
		FicheEmployeForma form=RecupForma(id,liste_form);
		System.out.println("La fiche de formation de " +form.Iden.nom + " " + form.Iden.prenom + " est la suivante: " + form.Forma);
	}
	
}
