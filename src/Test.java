<<<<<<< HEAD



=======
package src;
>>>>>>> 4da9872b13bf8fed9b1b57562df09cabf15cfbee
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choix du test entre 1 et 5 ou fin pour arrêter les tests.");
		String lu=sc.nextLine();
		while(!lu.equals("fin")) {
			
			if(lu.equals("1")) {
				
				//Calcul des factures
				Factures Fac1 = new Factures();
				Factures Fac2 = new Factures(1,"03/01/2022","04/05/2022","Tutu",1,300);
				ArrayList<Factures> liste_fac = new ArrayList<Factures>();
				Fac1.Addfacture(liste_fac);
				Fac2.Addfacture(liste_fac);
				ManipFactures.AfficherFactGlobal(1,liste_fac);
				
			
				//Calcul des recettes
				Recette Rec = new Recette();
				Rec.CalculRecette(liste_fac);
				Rec.AfficherCoutSal();
			}
			
			if(lu.equals("2")) {
				
				//Création des fiches de salaires
				FicheSalaire FchSal1 = new FicheSalaire();
				FicheIdentite Iden1 = new FicheIdentite("Maya","Legris","mlegris@bordeaux-inp.fr","Chargée de marketing","CDD", 2);
				FicheSalaire FchSal2 = new FicheSalaire(1,2520.34,200,540.25, Iden1);
				ArrayList<FicheSalaire> liste_sal = new ArrayList<FicheSalaire>();
				liste_sal.add(FchSal1);
				liste_sal.add(FchSal2);
				
				ManipSalaires.AfficherSal(1,liste_sal);
				
				//Coût des salaires au total
				CoutSalaires Ctsal = new CoutSalaires();
				Ctsal.CalculSalairesTotaux(liste_sal);
				Ctsal.AfficherCoutSal();
			}
			
			if(lu.equals("3")) {
				
				//Création des fiches de formations
				FicheEmployeForma FchForm1 = new FicheEmployeForma();
				FicheIdentite Iden1 = new FicheIdentite("Maya","Legris","mlegris@bordeaux-inp.fr","Chargée de marketing","CDD",2);
				FicheEmployeForma FchForm2 = new FicheEmployeForma(1,Iden1,"Formation découvrir la suite office");
				ArrayList<FicheEmployeForma> liste_form = new ArrayList<FicheEmployeForma>();
				liste_form.add(FchForm1);
				liste_form.add(FchForm2);
				FchForm1.AfficherForm(1,liste_form);
				ManipForma.AfficherForm(1, liste_form);
			}
			
			if(lu.equals("4")) {
				
				//Création de suivi de projet
				SuiviProjet Suivi1 = new SuiviProjet("Colibri","Croguennec","05/01/2023","15/01/2023");
				ArrayList<String> Members = new ArrayList<String>();
				Members.add("Penot");
				Suivi1.AddMemberList(Members);
				ArrayList<String> Steps = new ArrayList<String>();
				Steps.add("Création du nom");
				Steps.add("Choix du panier");
				Suivi1.AddSteps(Steps);
				ArrayList<SuiviProjet> liste_pro = new ArrayList<SuiviProjet>();
				liste_pro.add(Suivi1);
				Suivi1.AfficherSuivi(0,liste_pro);
				
			}
			
			if(lu.equals("5")) {
				
				//Création des fiches clients
				FicheClient Cli1 = new FicheClient();
				FicheClient Cli2 = new FicheClient("Google","Doe","google@gmail.com","Albert");
				ArrayList<FicheClient> liste_cli= new ArrayList<FicheClient>();
				liste_cli.add(Cli1);
				liste_cli.add(Cli2);
				ManipClient.AfficherClient(0, liste_cli);
				ManipClient.AfficherClient(1, liste_cli);
			}
			
			System.out.println("Choix du test entre 1 et 5 ou fin pour arrêter les tests. Pour faire les essais d'entrées de données, veuillez utiliser le fichier MainLogiciel.");
			lu = sc.nextLine();
			
			
		}
		sc.close();
	}
}
