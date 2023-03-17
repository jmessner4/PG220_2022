

import java.io.Serializable;


@SuppressWarnings("serial")
public class FicheClient implements Serializable {
	int ID;
	String nom;
	String NomContact;
	String email;
	String commercial;
	
	FicheClient(){
		this.ID=0;
		this.nom="EntrepriseConnue";
		this.NomContact="Dupont";
		this.email="dupont@entconnue.com";
		this.commercial="Oui ?";
	}
	
	FicheClient(String nm,String nmcon,String mail, String Cmm){
		this.nom=nm;
		this.NomContact=nmcon;
		this.email=mail;
		this.commercial=Cmm;
	}
}
