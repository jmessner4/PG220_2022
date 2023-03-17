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
class ManipClient implements Serializable {

	@SuppressWarnings("unchecked")
	ArrayList<FicheClient> RecupClient() throws IOException {
		System.out.println("coucou 1\n");
		File fichier = new File("./client.ser");
		ArrayList<FicheClient> liste_client = new ArrayList<FicheClient>();
		System.out.println("coucou 2\n");
		if(!fichier.exists()) {
			fichier.createNewFile();
			//System.err.println("Fichier inexistant.");
			//System.exit(0);
		}
		try {
			FileInputStream fis = new FileInputStream(fichier);
			ObjectInputStream ois = new ObjectInputStream(fis);
			liste_client = (ArrayList<FicheClient>) ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichier non trouvé.");
		} catch (IOException e) {
			liste_client = new ArrayList<FicheClient>();
			System.out.println("Erreur I/O.");
		} catch (ClassNotFoundException e) {
			System.out.println("Erreur de chargement du fichier.");
		}
		return liste_client;
	}
	
	@SuppressWarnings("unchecked")
	static ArrayList<FicheClient> GetListe() throws IOException {
		ArrayList<FicheClient> liste = new ArrayList<FicheClient>() ;
		File fichier = new File("./client.ser");
		if(!fichier.exists()) {
			fichier.createNewFile();
			//System.err.println("Fichier inexistant.");
			//System.exit(0);
		}
		try {
			FileInputStream fis = new FileInputStream(fichier);
			ObjectInputStream ois = new ObjectInputStream(fis);
			liste = (ArrayList<FicheClient>) ois.readObject();
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
	
	static void SaveClient(ArrayList<FicheClient> liste) throws IOException {
		File fichier = new File("./client.ser");
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
	
	static FicheClient RecupClient(int id, ArrayList<FicheClient> Liste){
		return Liste.get(id);
		
	}
	
	static void AfficherClient(int id,ArrayList<FicheClient> liste_client) {
		FicheClient client=RecupClient(id,liste_client);
		System.out.println("Le client est " + client.NomContact + " pour l'entreprise " + client.nom + " démarché par " + client.commercial +". Son adresse mail est la suivante: " + client.email + "\n");
	}
	
}