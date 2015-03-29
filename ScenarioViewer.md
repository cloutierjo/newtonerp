
```
Événement lancé d'un module de vue ou d'un menu (clic sur un lien)
{
		le servelet reçois une requette de type :
		{
			GET: ?module=Employer&action=showEmp&Value=172 (montre l'employer 172)
			{
				le servlet transfere les donnés de la requette a l'eventListner
				l'eventListener cherche le bon module, l'instanci et appelle l'action en lui passant en paramettre les values
				le module exécute l'action demandé puis retourne une viewableEntity
				qui est retourné au servlet
			}
			POST: ?module=Employer&action=modEmp&Value=172 (change les donné de l'employer 172)
				  name:john, timeWork=8...
			{
				le servlet transfere les donnés de la requette a l'eventListner en ajoutant une hashTable contenant les donné du POST
				l'eventListener cherche le bon module, l'instanci et appelle l'action en lui passant en paramettre les values et le hashTable
				le module exécute l'action demandé puis retourne une viewableEntity
				qui est retourné au servlet
			}
		}
		le servlet appelle le mainViewer(class static) avec l'entity en parametre
		{
			le mainViewer apelle les viewer(class static) spécifique permettent d'Affiché l'entity
			{
				viewer spécifique créé le code HTML a affiché, peut apellé d'autre viewer si néscéssaire
			}
			le main viewer ajoute le code html d'entete et de pied de page ainsi que celui des menus
			retourne au finale la code HTML au servelet 
		}
		le servlet envois la page au client 
}


```