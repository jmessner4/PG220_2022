<<<<<<< HEAD
=======
package src;

import java.io.Serializable;
>>>>>>> 4da9872b13bf8fed9b1b57562df09cabf15cfbee


@SuppressWarnings("serial")
public class Formation implements Serializable {
	String EtatForma;
	String TypeForma;
	double CoutForma;
	
	Formation(){
		this.EtatForma="Continue";
		this.TypeForma="Alternance";
		this.CoutForma=721.95;
	}
	
	Formation(String Et,String Type, Double cout){
		this.EtatForma=Et;
		this.TypeForma=Type;
		this.CoutForma=cout;
	}
	
	
}
