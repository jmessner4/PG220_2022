
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainLogiciel {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		ArrayList<Factures> liste_fact = ManipFactures.GetListe(); 
		ArrayList<FicheIdentite> liste_identites = ManipIdentite.GetListe();
		ArrayList<SuiviProjet> liste_projets = ManipProjet.GetListe();
		
		System.out.println("Bienvenue sur votre ERP ! Que souhaitez-vous faire aujourd'hui ?\nChoisissez une commande ou appuyer sur H pour avoir la liste des commandes disponibles.");
		String cmd = sc.nextLine();
		while(!cmd.equals("Out")){
			if(cmd.equals("H")) {
				System.out.println("Liste des commandes possibles : \n - F rentrer dans le mode facturation \n - RH pour entrer dans le mode gestion RH \n - C pour entrer dans le mode comptabilité\n - P pour entrer dans le mode suivi de projet \n - Out pour quitter l'application\n");
			}
			else if(cmd.equals("F")) {
				//Les factures
				System.out.println("Appuyez sur H pour voir la liste des commandes possibles");
				cmd = sc.nextLine();
				while(!cmd.equals("OutMode")) {
					if(cmd.equals("H")) {
						System.out.println("Liste des commandes possibles : \n -NF permet de créer une nouvelle facture\n -SaF peremt de sauvegarder les factures\n -ShF permet d'afficher les factures\n -ShFid permet d'afficher une facture spécifique\n -OutMode permet de quitter le menu actuel\n");
					} else if(cmd.equals("NF")) {
						//Création d'une nouvelle facture
						System.out.println("Veuillez entrer les informations suivantes :\n - date d'émission de la facture\n");
						int id = liste_fact.size()+1;
						String datee = sc.nextLine();
						System.out.println("- date d'achat\n");
						String datea = sc.nextLine();
						System.out.println("- nom du client\n");
						String name = sc.nextLine();
						System.out.println("- identifiant du bon de commande (cela doit être un nombre)\n");
						String idcstr = sc.nextLine();
						boolean Chiffre = true;
                        for (int i = 0; i < idcstr.length(); i++) {
                            if ((idcstr.charAt(i) < 48 || idcstr.charAt(i) > 57)) {
                            	System.out.println(idcstr);
                            	Chiffre = false;
                            }
                        }
                        while(("".equals(idcstr)) || (Chiffre == false)){
                        	System.out.println("Ne convient pas. Veuillez saisir un nombre entier.\n - identifiant du bon de commande (cela doit être un nombre)\n");
                        	idcstr = sc.nextLine();
                        	Chiffre = true;
                        	for (int i = 0; i < idcstr.length(); i++) {
                                if ((idcstr.charAt(i) >= 48 && idcstr.charAt(i) <= 57)) {
                                	Chiffre = true;
                                }
                            }
                        }
						
						int idc = Integer.parseInt(idcstr);
						System.out.println("- prix hors taxes\n");
						String prixhtstr = sc.nextLine();
						int prixht = Integer.parseInt(prixhtstr);
						Factures new_fact = new Factures(id, datee, datea, name, idc, prixht);
						liste_fact.add(new_fact);
						
					} else if(cmd.equals("SaF")) {

						// Sauvegarder les factures
					        ManipFactures.SaveFact(liste_fact);
						System.out.println("Vous avez sauvegardé la liste des factures existantes.\n");
						
					} else if(cmd.equals("ShF")) {
						//Affichage des factures
						Factures ftmp = new Factures();
						for(int i=0; i<liste_fact.size(); i++) {
							ftmp = liste_fact.get(i);
							System.out.println("Numéro de facture : "+ftmp.id+" Date d'émission : " + ftmp.dateemission + " Nom client : " + ftmp.nomclient+" Prix TTC : "+ftmp.prixttc+"\n");
						}
					} else if(cmd.equals("ShFid")) {
						//Affichage d'une facture précise
						System.out.println("Veuillez indiquer le numéro de la facture souahitée");
						String numstr = sc.nextLine();
						int num = Integer.parseInt(numstr);
						ManipFactures.AfficherFactGlobal(num, liste_fact);
					}
					cmd = sc.nextLine();
				}
			}
			else if(cmd.equals("RH")) {
				//Gestion RH
				System.out.println("Appuyez sur H pour voir la liste des commandes possibles");
				cmd = sc.nextLine();
				while(!cmd.equals("OutMode")) {
					if(cmd.equals("H")) {
						System.out.println("Liste des commandes possibles : \n - SH permet d'afficher la hiérarchie \n - ADD permet d'ajouter un nouveau collaborateur \n - FE permet d'afficher la fiche d'informations d'un collaborateur \n - RM permet de retirer un collaborateur \n - MF permet de modifer des informations de la fiche employé \n - S permet de sauvegarder les données \n - OutMode permet de quitter le menu actuel");
					} else if(cmd.equals("SH")){
						//Ici on s'occupe d'afficher la hiérarchie
						if(liste_identites.size() == 0){
							System.out.println("Il n'y a encore personne dans l'entreprise. Veuillez saisir ADD pour ajouter une nouvelle identité.");
						}
						ManipIdentite.AfficherHierarchie(liste_identites);
						
						
					} else if(cmd.equals("ADD")) {
						//Ajout d'un nouveau collaborateur
						// Prénom
						System.out.println("Veuillez entrer les informations suivantes du nouvel employé :\n - Prénom");
						String prenom = sc.nextLine();
						boolean Chiffre = false;
                        for (int i = 0; i < prenom.length(); i++) {
                            if ((prenom.charAt(i) >= 48 && prenom.charAt(i) <= 57)) {
                            	Chiffre = true;
                            }
                        }
                        while(("".equals(prenom)) || (Chiffre == true)){
                        	System.out.println("Ne convient pas. Veuillez saisir votre prénom sans espace ou sans chiffre.\n - Prénom\n");
                        	prenom = sc.nextLine();
                        	Chiffre = false;
                        	for (int i = 0; i < prenom.length(); i++) {
                                if ((prenom.charAt(i) >= 48 && prenom.charAt(i) <= 57)) {
                                	Chiffre = true;
                                }
                            }
                        }
                        
                        // Nom
						System.out.println("\n- Nom");
						String nom = sc.nextLine();
						Chiffre = false;
                        for (int i = 0; i < nom.length(); i++) {
                        	if ((nom.charAt(i) >= 48 && nom.charAt(i) <= 57)) {
                            	Chiffre = true;
                            }
                        }
                        while(("".equals(nom)) || (Chiffre == true)){
                        	System.out.println("Ne convient pas. Veuillez saisir votre nom sans espace ou sans chiffre.\n - Nom \n");
                        	nom = sc.nextLine();
                        	Chiffre = false;
                        	for (int i = 0; i < nom.length(); i++) {
                        		 if ((nom.charAt(i) >= 48 && nom.charAt(i) <= 57)) {
                                 	Chiffre = true;
                                 }
                            }
                        }
                        
                        // Mail
						System.out.println("\n- Adresse mail");
						String email = sc.nextLine();
						while(!(email.matches(".+@.+"))){
                        	System.out.println("Veuillez saisir une adresse mail valide. \n - Adresse mail\n");
                        	email = sc.nextLine();
                        }
						
						// Nom du poste
						System.out.println("\n- Nom du poste");
						String postname = sc.nextLine();
						Chiffre = false;
                        for (int i = 0; i < postname.length(); i++) {
                        	if ((postname.charAt(i) >= 48 && postname.charAt(i) <= 57)) {
                            	Chiffre = true;
                            }
                        }
                        
                        while(("".equals(postname)) || (Chiffre == true)){
                        	System.out.println("Ne convient pas. Veuillez saisir votre nom du poste correctement.\n - Nom du poste\n");
                        	postname = sc.nextLine();
                        	Chiffre = false;
                        	for (int i = 0; i < postname.length(); i++) {
                        		if ((postname.charAt(i) >= 48 && postname.charAt(i) <= 57)) {
                                 	Chiffre = true;
                                 }
                            }
                        }
                        
                        // Type de contrat
						System.out.println("\n- Type de contrat (CDD, CDI, stage...)");
						String contrat = sc.nextLine();
						Chiffre = false;
                        for (int i = 0; i < contrat.length(); i++) {
                        	if ((contrat.charAt(i) >= 48 && contrat.charAt(i) <= 57)) {
                            	Chiffre = true;
                            }
                        }
                        
                        while(("".equals(contrat)) || (Chiffre == true)){
                        	System.out.println("Ne convient pas. Veuillez saisir votre type de contrat correctement : CDD ou CDI ou Stage \n -Type de contrat\n");
                        	contrat = sc.nextLine();
                        	Chiffre = false;
                        	for (int i = 0; i < contrat.length(); i++) {
                        		if ((contrat.charAt(i) >= 48 && contrat.charAt(i) <= 57)) {
                                 	Chiffre = true;
                                 }
                            }
                        }
                        
						int id = liste_identites.size()+1;
						FicheIdentite new_indiv = new FicheIdentite(prenom,nom,email,postname,contrat,id);
						liste_identites.add(new_indiv);
						ManipIdentite.SaveIdentite(liste_identites);
						System.out.println("La nouvelle identité est bien enregistrée.\n");
						
					} else if(cmd.equals("FE")) {
						//Afficher la fiche d'information d'un employé
						System.out.println("Veuillez indiquer les informations suivantes de l'employé concerné :\nPrénom : ");
						String prenom = sc.nextLine();
						boolean Chiffre = false;
                        for (int i = 0; i < prenom.length(); i++) {
                            if ((prenom.charAt(i) >= 48 && prenom.charAt(i) <= 57)) {
                            	Chiffre = true;
                            }
                        }
                        while(("".equals(prenom)) || (Chiffre == true)){
                        	System.out.println("Ne convient pas. Veuillez saisir votre prénom sans espace ou sans chiffre.\n - Prénom\n");
                        	prenom = sc.nextLine();
                        	Chiffre = false;
                        	for (int i = 0; i < prenom.length(); i++) {
                                if ((prenom.charAt(i) >= 48 && prenom.charAt(i) <= 57)) {
                                	Chiffre = true;
                                }
                            }
                        }
						
						System.out.println("Nom : ");
						String nom = sc.nextLine();
						Chiffre = false;
                        for (int i = 0; i < nom.length(); i++) {
                        	if ((nom.charAt(i) >= 48 && nom.charAt(i) <= 57)) {
                            	Chiffre = true;
                            }
                        }
                        while(("".equals(nom)) || (Chiffre == true)){
                        	System.out.println("Ne convient pas. Veuillez saisir votre nom sans espace ou sans chiffre.\n - Nom \n");
                        	nom = sc.nextLine();
                        	Chiffre = false;
                        	for (int i = 0; i < nom.length(); i++) {
                        		 if ((nom.charAt(i) >= 48 && nom.charAt(i) <= 57)) {
                                 	Chiffre = true;
                                 }
                            }
                        }
						ManipIdentite.AfficherIdentite(nom, prenom, liste_identites);
						
					} else if(cmd.equals("RM")) {
						//Retirer un employé de l'organisation
						System.out.println("Veuillez indiquer les informations suivantes de l'employé concerné :\nPrénom : ");
						String prenom = sc.nextLine();
						boolean Chiffre = false;
                        for (int i = 0; i < prenom.length(); i++) {
                            if ((prenom.charAt(i) >= 48 && prenom.charAt(i) <= 57)) {
                            	Chiffre = true;
                            }
                        }
                        while(("".equals(prenom)) || (Chiffre == true)){
                        	System.out.println("Ne convient pas. Veuillez saisir votre prénom sans espace ou sans chiffre.\n - Prénom\n");
                        	prenom = sc.nextLine();
                        	Chiffre = false;
                        	for (int i = 0; i < prenom.length(); i++) {
                                if ((prenom.charAt(i) >= 48 && prenom.charAt(i) <= 57)) {
                                	Chiffre = true;
                                }
                            }
                        }
						System.out.println("Nom : ");
						String nom = sc.nextLine();
						Chiffre = false;
                        for (int i = 0; i < nom.length(); i++) {
                        	if ((nom.charAt(i) >= 48 && nom.charAt(i) <= 57)) {
                            	Chiffre = true;
                            }
                        }
                        while(("".equals(nom)) || (Chiffre == true)){
                        	System.out.println("Ne convient pas. Veuillez saisir votre nom sans espace ou sans chiffre.\n - Nom \n");
                        	nom = sc.nextLine();
                        	Chiffre = false;
                        	for (int i = 0; i < nom.length(); i++) {
                        		 if ((nom.charAt(i) >= 48 && nom.charAt(i) <= 57)) {
                                 	Chiffre = true;
                                 }
                            }
                        }
                        
						ManipIdentite.RetirerIdentite(nom, prenom, liste_identites);
						ManipIdentite.SaveIdentite(liste_identites);
						System.out.println(prenom + " " + nom + " a été licencié.");
						
					} else if(cmd.equals("MF")) {
						//Modifier la fiche d'un employé
						System.out.println("Veuillez indiquer les informations suivantes de l'employé concerné :\nPrénom : ");
						String prenom = sc.nextLine();
						boolean Chiffre = false;
                        for (int i = 0; i < prenom.length(); i++) {
                            if ((prenom.charAt(i) >= 48 && prenom.charAt(i) <= 57)) {
                            	Chiffre = true;
                            }
                        }
                        while(("".equals(prenom)) || (Chiffre == true)){
                        	System.out.println("Ne convient pas. Veuillez saisir votre prénom sans espace ou sans chiffre.\n - Prénom\n");
                        	prenom = sc.nextLine();
                        	Chiffre = false;
                        	for (int i = 0; i < prenom.length(); i++) {
                                if ((prenom.charAt(i) >= 48 && prenom.charAt(i) <= 57)) {
                                	Chiffre = true;
                                }
                            }
                        }
						System.out.println("Nom : ");
						String nom = sc.nextLine();
						Chiffre = false;
                        for (int i = 0; i < nom.length(); i++) {
                        	if ((nom.charAt(i) >= 48 && nom.charAt(i) <= 57)) {
                            	Chiffre = true;
                            }
                        }
                        while(("".equals(nom)) || (Chiffre == true)){
                        	System.out.println("Ne convient pas. Veuillez saisir votre nom sans espace ou sans chiffre.\n - Nom \n");
                        	nom = sc.nextLine();
                        	Chiffre = false;
                        	for (int i = 0; i < nom.length(); i++) {
                        		 if ((nom.charAt(i) >= 48 && nom.charAt(i) <= 57)) {
                                 	Chiffre = true;
                                 }
                            }
                        }
						
						System.out.println("Veuillez modifier les informations suivantes de l'employé :\n - Prénom\n");
						String prenom2 = sc.nextLine();
						for (int i = 0; i < prenom2.length(); i++) {
                            if ((prenom2.charAt(i) >= 48 && prenom2.charAt(i) <= 57)) {
                            	Chiffre = true;
                            }
                        }
                        while(("".equals(prenom2)) || (Chiffre == true)){
                        	System.out.println("Ne convient pas. Veuillez saisir votre prénom sans espace ou sans chiffre.\n - Prénom\n");
                        	prenom2 = sc.nextLine();
                        	Chiffre = false;
                        	for (int i = 0; i < prenom2.length(); i++) {
                                if ((prenom2.charAt(i) >= 48 && prenom2.charAt(i) <= 57)) {
                                	Chiffre = true;
                                }
                            }
                        }
						
						System.out.println("- Nom\n");
						String nom2 = sc.nextLine();
						Chiffre = false;
                        for (int i = 0; i < nom2.length(); i++) {
                        	if ((nom2.charAt(i) >= 48 && nom2.charAt(i) <= 57)) {
                            	Chiffre = true;
                            }
                        }
                        while(("".equals(nom2)) || (Chiffre == true)){
                        	System.out.println("Ne convient pas. Veuillez saisir votre nom sans espace ou sans chiffre.\n - Nom \n");
                        	nom2 = sc.nextLine();
                        	Chiffre = false;
                        	for (int i = 0; i < nom2.length(); i++) {
                        		 if ((nom2.charAt(i) >= 48 && nom2.charAt(i) <= 57)) {
                                 	Chiffre = true;
                                 }
                            }
                        }
						
						System.out.println("- Adresse mail\n");
						String email = sc.nextLine();
						while(!(email.matches(".+@.+"))){
                        	System.out.println("Veuillez saisir une adresse mail valide. \n - Adresse mail\n");
                        	email = sc.nextLine();
                        }
						
						System.out.println("- Nom du poste\n");
						String postname = sc.nextLine();
						Chiffre = false;
                        for (int i = 0; i < postname.length(); i++) {
                        	if ((postname.charAt(i) >= 48 && postname.charAt(i) <= 57)) {
                            	Chiffre = true;
                            }
                        }
                        
                        while(("".equals(postname)) || (Chiffre == true)){
                        	System.out.println("Ne convient pas. Veuillez saisir votre nom du poste correctement.\n - Nom du poste\n");
                        	postname = sc.nextLine();
                        	Chiffre = false;
                        	for (int i = 0; i < postname.length(); i++) {
                        		if ((postname.charAt(i) >= 48 && postname.charAt(i) <= 57)) {
                                 	Chiffre = true;
                                 }
                            }
                        }
						
						System.out.println("- Type de contrat (CDD, CDI, stage...)\n");
						String contrat = sc.nextLine();
						Chiffre = false;
                        for (int i = 0; i < contrat.length(); i++) {
                        	if ((contrat.charAt(i) >= 48 && contrat.charAt(i) <= 57)) {
                            	Chiffre = true;
                            }
                        }
                        
                        while(("".equals(contrat)) || (Chiffre == true)){
                        	System.out.println("Ne convient pas. Veuillez saisir votre type de contrat correctement : CDD ou CDI ou Stage \n -Type de contrat\n");
                        	contrat = sc.nextLine();
                        	Chiffre = false;
                        	for (int i = 0; i < contrat.length(); i++) {
                        		if ((contrat.charAt(i) >= 48 && contrat.charAt(i) <= 57)) {
                                 	Chiffre = true;
                                 }
                            }
                        }
						
						ManipIdentite.RetirerIdentite(nom, prenom, liste_identites);
						int id = liste_identites.size()+1;
						FicheIdentite modif_indiv = new FicheIdentite(prenom2,nom2,email,postname,contrat,id);
						liste_identites.add(modif_indiv);
						ManipIdentite.SaveIdentite(liste_identites);
						System.out.println("Les modifications sont bien enregistrées.\n");
						
					} else if(cmd.equals("S")) {
						//Sauvegarde
						ManipIdentite.SaveIdentite(liste_identites);
						System.out.println("Les données sont bien sauvegardées.\n");
					}
					
					cmd = sc.nextLine();
				}
			}
			else if(cmd.equals("C")) {
				//Comptabilité
				cmd = sc.nextLine();
				while(!cmd.equals("OutMode")) {
					if(cmd.equals("H")) {
						System.out.println("Liste des commandes possibles : \n - OutMode permet de quitter le menu actuel");
					}
					cmd = sc.nextLine();
				}
			}
			else if(cmd.equals("P")) {
				//Suivi de projet
				cmd = sc.nextLine();
				while(!cmd.equals("OutMode")) {
					if(cmd.equals("H")) {
						System.out.println("Liste des commandes possibles : \n - L permet d'afficher la liste des projets \n - FE permet d'afficher la fiche d'informations d'un projet \n - N permet d'ajouter un nouveau projet \n - ADD permet d'ajouter un nouveau collaborateur sur un projet \n - RM permet de retirer un collaborateur d'un projet \n - TA permet de rajouter une tâche dans le projet \n - AC permet d'incrémenter le numéro de la tâche actuelle \n - S permet de sauvegarder les données \n - OutMode permet de quitter le menu actuel");
					} else if(cmd.equals("L")){
						//Ici on s'occupe d'afficher la hiérarchie
						ManipProjet.AfficherListe(liste_projets);
						
					} else if(cmd.equals("FE")) {
						//Afficher la fiche d'information d'un projet
						System.out.println("Veuillez indiquer le nom du projet : \n");
						String nom = sc.nextLine();
						ManipProjet.AfficherSuivi(nom, liste_projets);
					
					} else if(cmd.equals("N")) {
						//Ajout d'un nouveau projet
						System.out.println("Veuillez entrer les informations suivantes :\n - Nom du projet");
						String nom = sc.nextLine();
						System.out.println("\n- Chef de projet");
						String chef = sc.nextLine();
						System.out.println("\n- Date de début");
						String dated = sc.nextLine();
						System.out.println("\n- Date de fin");
						String datef = sc.nextLine();
						SuiviProjet new_projet = new SuiviProjet(nom,chef,dated,datef,liste_projets);
						liste_projets.add(new_projet);
						ManipProjet.SaveProjet(liste_projets);
						System.out.println("Le nouveau projet est bien enregistré.\n");
					
					} else if(cmd.equals("R")) {
						//Supprime un projet
						System.out.println("Veuillez entrer le nom du projet : \n");
						String nom = sc.nextLine();
						ManipProjet.RetirerProjet(nom,liste_projets);
						ManipProjet.SaveProjet(liste_projets);
						
					} else if(cmd.equals("ADD")) {
						//Ajout d'un nouveau collaborateur sur un projet
						System.out.println("Veuillez entrer les informations suivantes :\n - Nom du projet");
						String nom = sc.nextLine();
						System.out.println("\n- Nom et prénom du membre à ajouter");
						String membre = sc.nextLine();
						ManipProjet.AddMemberList(nom,membre,liste_projets);
						ManipProjet.SaveProjet(liste_projets);
					
						
					} else if(cmd.equals("RM")) {
						//Retirer un employé d'un projet
						System.out.println("Veuillez entrer les informations suivantes :\n - Nom du projet");
						String nom = sc.nextLine();
						System.out.println("\n- Nom et prénom du membre à ajouter");
						String membre = sc.nextLine();
						ManipProjet.RetirerMemberList(nom,membre,liste_projets);
						ManipProjet.SaveProjet(liste_projets);
						
						
					} else if(cmd.equals("TA")) {
						// Rajouter une tâche dans le projet
						System.out.println("Veuillez entrer les informations suivantes :\n - Nom du projet");
						String nom = sc.nextLine();
						System.out.println("\n- Nom de la nouvelle tâche");
						String step = sc.nextLine();
						ManipProjet.AddSteps(nom,step,liste_projets);
						ManipProjet.SaveProjet(liste_projets);
						
					
					} else if(cmd.equals("AC")) {
						// Incrémenter le numéro de la tâche actuelle
						System.out.println("Veuillez entrer les informations suivantes :\n - Nom du projet");
						String nom = sc.nextLine();
						System.out.println("\n- Numéro de la tâche en cours");
						String step_num = sc.nextLine();
						int num = Integer.parseInt(step_num);
						ManipProjet.CurrStep(nom,num,liste_projets);
						ManipProjet.SaveProjet(liste_projets);
						
					} else if(cmd.equals("S")) {
						//Sauvegarde
						ManipIdentite.SaveIdentite(liste_identites);
						System.out.println("Les données sont bien sauvegardées.\n");
					}
					cmd = sc.nextLine();
				}
			}
			else
				System.out.println("Veuillez saisir une commande existante, appuyez sur H pour voir la liste des commandes possibles");
			cmd = sc.nextLine();
		}
		sc.close();
		System.out.println("Au revoir.");
		System.exit(0);
	}
}
