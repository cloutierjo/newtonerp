## création du module set ##
  1. faire un checkout de '/trunk/modules/base'
  1. dans eclipse, sur le projet base faire clic droit/team/Branch or tag
  1. dans le champ URL s'assuré d'être dans un sous dossier de '/trunk/modules/' puis ajouté le nom du dossier/projet que vous voulez créé (de préférence sous un dossier a votre nom ex: '/trunk/modules/djo/contractManagement') il est important que se dossier n'existe pas encore
  1. suivant
  1. suivant
  1. entré un commentaire de commit et coché la case 'switch working copy to branch/tag
  1. finish

## post config ##
  1. renommé le projet a votre choix (clic droit sur le projet /refactor/rename) ne pas tenir conte des erreur
  1. mettre le serveur newtonERP dans le build path (clic droit sur le projet/propriété/java build path/project/add/sélectionné votre projet contenant le serveur NewtonERP)
  1. ajouté la référence au serveur (clic droit sur le projet/propriété/project references/sélectionné votre projet contenant le serveur NewtonERP)
  1. commit
  1. dans le fichier config.xml dur serveur modifier le modulesPath pour pointé vers le dossier bin qui est sous votre projet ex:[...]/workspace/ContractManagement/bin/ )

maintenant vous pouvez modifier le projet a votre souhait en partant du sampleModule présent dans votre nouveau projet

pour testé ou exécute votre module set il faut exécute le serveur NewtonERP il ne faut jamais essayer de lancé directement les modules ou le module set (il n'y a aucun main anyway...)

note: cette procédure fonctionne bien a cause de la gestion des branche de SVN il pourrais y avoir des problème si utilisé sur un autre système de gestion de version