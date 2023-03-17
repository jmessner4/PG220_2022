

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
class ManipFactures implements Serializable {

	@SuppressWarnings("unchecked")
	ArrayList<Factures> RecupFactures() throws IOException {
		System.out.println("coucou 1\n");
		File fichier = new File("./factures.ser");
		//File fichier = new File("factures.ser");
		ArrayList<Factures> liste_fact = new ArrayList<Factures>();
		System.out.println("coucou 2\n");
		if(!fichier.exists()) {
			try{
				fichier.createNewFile();
			} catch (IOException e){
				System.out.print("Erreur d'écriture");
			}
			
			//fichier.createNewFile();
			////System.err.println("Fichier inexistant.");
			////System.exit(0);
		}
		try {
			FileInputStream fis = new FileInputStream(fichier);
			ObjectInputStream ois = new ObjectInputStream(fis);
			liste_fact = (ArrayList<Factures>) ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichier non trouvé.");
		} catch (IOException e) {
			liste_fact = new ArrayList<Factures>();
			System.out.println("Erreur I/O.");
		} catch (ClassNotFoundException e) {
			System.out.println("Erreur de chargement du fichier.");
		}
		return liste_fact;
	}
	
	@SuppressWarnings("unchecked")
	static ArrayList<Factures> GetListe() throws IOException {
		ArrayList<Factures> liste = new ArrayList<Factures>();
		File fichier = new File("./factures.ser");
		if(!fichier.exists()) {
			try{
				fichier.createNewFile();
			} catch (IOException e){
				System.out.print("Erreur d'écriture");
			}
			//fichier.createNewFile();
			////System.err.println("Fichier inexistant.");
			////System.exit(0);
		}
		try {
			FileInputStream fis = new FileInputStream(fichier);
			ObjectInputStream ois = new ObjectInputStream(fis);
			liste = (ArrayList<Factures>) ois.readObject();
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
	
	static void SaveFact(ArrayList<Factures> liste) throws IOException {
		File fichier = new File("./factures.ser");
		if(!fichier.exists()) {
			try{
				fichier.createNewFile();
			} catch (IOException e){
				System.out.print("Erreur d'écriture");
			}
			//fichier.createNewFile();
			////System.err.println("Fichier inexistant.");
			////System.exit(0);
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
	
	static Factures RecupFact(int id, ArrayList<Factures> Liste){
		return Liste.get(id);
		
	}
	
	static void AfficherFactGlobal(int id, ArrayList<Factures> Liste) {
		Factures fact = RecupFact(id, Liste);
		System.out.println("La facture demandée est la facture n°" + id + " pour le client " +fact.nomclient + " éditée le " + fact.dateemission + " pour le bon de commande n°" + fact.idbonclient+ " du " + fact.dataachat + " pour un montant HT de " + fact.prixht + "€ soit " + fact.prixttc+"€ TTC\n");
		
	}
	
}
