
```
Business logic
{
	Modules
	{
		Sert à transformer l'information provenant des entités provenant de l'orm
		Sert à créer des entités sans qu'elle provienne directement de l'orm
		(conceptuellement, semblable à un JOIN SQL, mais implémenté très différement)
		Cette entité pourra être vue et/ou modifiée par le code du module
		Pourra aussi être sauvegardée par l'orm dans certains cas
		Exemple, création d'un rapport statistique sur les employés d'un département
		Le rapport sera visible
	
		Exemple de module: Horaires d'employé //horaire automatique vraiment high tech
		{
			Modification automatique d'horaire
			{
				On change l'horaire de boris
				On demande à l'orm tous les horaires de tous les employés du département de boris
				{
					L'orm retourne un vecteur d'entité d'horaire d'employé
				}
				
				Le module parse tous les horaire pour trouver les momement où il y a le moins d'employés
				Le module génère un entité de type horaire et l'envoie à l'orm
			}
		}
		
		reception d'action
		{
			trouve la bonne action
			l'éxécute
		}
		
	}

	Tâches automatisées
	{
		On change le département de l'employé Boris
		{
			Orm
			{
				Un employé est un entité
				Boris est un entité de type employé
			}
			
			L'orm passe en référence l'entité de boris au TaskManager
			{
				Le task manager recoit Boris et détermine que c'est un employé
				Le task manager traite les tâches associé à la classe Employé
				{
					Le task manager a la liste des tâches automatisées par la modification d'un entité de type employé
					Pour chaque Task
					{
						On teste la spécification de manière récrusive pour vérifier si elle est satisfaite
						
						Si satisfaite
						{
							On utilise l'entité de recherche (membre de Task) pour faire une
							recherche dans l'orm et cette recherche retourne un vecteur de résultat
							
							Pour chaque entité de résultat du vecteur
							{
								On execute l'action sur l'entité
							}
						}
					}
				}
			}
		}
	}
}
```