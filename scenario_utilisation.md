
```
: 
Démarrage du serveur
{
	-Connecte à DB
	-Installe nouveaux plugins
	{	
		Vérifie plugins
		Installe nouveaux plugins selon diponibilité
	}
	-Met en mode attente
	{
		Si requette, parse requète
	}
}

Traitements de requêtes
{
	Recherche d'entitée
	{
		Requête contient
		{
			Clef unique (genre de session http)
			Paramètres
			{
				Objet de critère de recherche
			}
		}
		
		On demande à l'orm un objet qui match les critères
		{
			Construit la requète SQL en se basant sur critères non-vides
			Execute la requète SQL
			Orm cré objet
			{
				peut être null ou vecteur
				vecteur contient objet(s) de meme classe que objet de critère
				pour chaque objet de vecteur
				{
					valeurs selon valeur de retour de requète SQL			
				}
			}
			Orm retourne objet
		}
		
		Serveur retourne objet de classe ServerMessage
		{
			Contient
			{
				Statut (ok, erreur)
				Objet de l'orm (vecteur) ou null
			}
		}
	}
	
	Ajout d'entitée
	{
		Requête contient
		{
			Clef unique (genre de session http)
			Paramètres
			{
				Objet à ajouter
			}
		}
		
		Orm
		{
			Validation des données selons critères
			{
				Critères de DB qui reflete critères de business logic
				
				Si non-validée
				{
					On lance une exception (catchée dans controlleur serveur)
				}
			}
		
			Construit requète à partir des données de l'objets paramètre
			Exécuter requète SQL
		}
		
		Serveur retourne objet de classe ServerMessage
		{
			Contient
			{
				Statut (ok ou erreur si exception (not found))
				pas d'objet d'orm car c'est un ajout donc null
			}
		}
	}
	
	Suppression d'entitée
	{
		Fonctionne comme recherche mais efface données au lieux de les retourner
		ServerMessage contient data nulle
	}
	
	Modification d'entitée
	{
		Requète contient
		{
			Objet de critère de recherche //(objet de même que classe l'entitiée à modifier)
			Objet de champ à modifier //(objet de même que classe l'entitiée à modifier)
		}
		
		Orm
		{
			On valide les champs à modifier
			{
				Si pas valide, lance exception
			}
			
			On construit requete SQL d'update
			{
				Cré WHERE selon objet de recherche
				Cré valeurs d'update selon objet "champ à modifier"
			}
		}
		
		Retourne objet ServerMessage
		{
			Statut:	Si exception, statut d'erreur, sinon, success
			Data: Si exception, contient metadata sur nature de l'erreur, sinon: null
		}
	}
}

Business logic
{
	Supression automatique d'employé en retard //cas fictif, fausse business logic
	{
		Lorsqu'un employé se log dans le module de punch
		{
			Entité de l'employée est modifiée pour contenir data sur heure d'arrivée
			Data de l'employé est associée à objet de specification de "Supression automatique d'employé en retard"
			
			Supression automatique d'employé en retard (objet de specification)
			{
				On parse l'entité de l'employé
				{
					on
				}
				
				On vérifie si Spécification est satisfaite
				{
					Est satisfaite si employé en retard
				}
				
				Si spéfication satisfait condition
				{
					On applique l'action de la spécification
					{
						On efface l'employé sur la table
					}
				}
			}
		}
	}
}

Business logic
{
	Liste de specifications
	{
		Specification A
		Specification B
		Specification C
	}
	
	Liste d'action
	{
		Action X
		Action Y
		Action Z
	}
	
	Liste de tasks
	{
		Task 1
		{
			isActive
			Specification A
			Action X
		}
		
		Task 2
		{
			isActive
			Specification B
			Action X
		}
		
		Task 3
		{
			isActive
			Specification C
			Action X
		}
		
		Task 4
		{
			isActive
			Specification A
			Action Y
		}
		
		Task 5
		{
			isActive
			Specification B
			Action Z
		}
		
		Task 6
		{
			isActive
			Specification C
			Action Y
		}
	}
}
;

```