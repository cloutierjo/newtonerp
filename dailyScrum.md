
<a href='Hidden comment: 
voici le model de scrum a copier en entier si vous êtes le premier

.=jj/12/2009=

==Jonathan Hallee==
===1- qu"est-ce que j"ai fais (livré) depuis "hier"?===
* ...livré...
===2- qu"est-ce que je ferais (livré) aujourd"hui?===
* ...à livrer...
===3- est-ce que j"ai eu des difficultés particulières? (besoin d"aide ?)===
* ...problème, besoin d"aide, qui aidera...

==Guillaume Lacasse==
===1- qu"est-ce que j"ai fais (livré) depuis "hier"?===
* ...livré...
===2- qu"est-ce que je ferais (livré) aujourd"hui?===
* ...à livrer...
===3- est-ce que j"ai eu des difficultés particulières? (besoin d"aide ?)===
* ...problème, besoin d"aide, qui aidera...

==Pascal Lemay==
===1- qu"est-ce que j"ai fais (livré) depuis "hier"?===
* ...livré...
===2- qu"est-ce que je ferais (livré) aujourd"hui?===
* ...à livrer...
===3- est-ce que j"ai eu des difficultés particulières? (besoin d"aide ?)===
* ...problème, besoin d"aide, qui aidera...

==Gabriel Therrien==
===1- qu"est-ce que j"ai fais (livré) depuis "hier"?===
* ...livré...
===2- qu"est-ce que je ferais (livré) aujourd"hui?===
* ...à livrer...
===3- est-ce que j"ai eu des difficultés particulières? (besoin d"aide ?)===
* ...problème, besoin d"aide, qui aidera...

==Jonatan Cloutier==
===1- qu"est-ce que j"ai fais (livré) depuis "hier"?===
* ...livré...
===2- qu"est-ce que je ferais (livré) aujourd"hui?===
* ...à livrer...
===3- est-ce que j"ai eu des difficultés particulières? (besoin d"aide ?)===
* ...problème, besoin d"aide, qui aidera...

'></a>

# 24/09/2009 #

## Jonathan Hallee ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Interface Orm, Sgbdable et Ormizable avec guillaume en pair programming
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Implementation de la fonction ajout dans l'orm, testage de sqlite, tester l'architecture generale de l'orm pour s'assurer qu'il n'y a pas d'erreurs, faudra reparler de qui fait le starter
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * Me rapeller des hashtable et de mon sql. Les autoincrements etant donne que il y a pas de sequences dans sqlite **(je ne sais pas si c'est ce que tu cherche http://www.sqlite.org/autoinc.html )**

## Guillaume Lacasse ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Interface Orm, Sgbdable et Ormizable avec Kovalev en pair programming
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Classe abstraite du module, interfaces IAction
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * Complexité des paramètres de la classe action, a nécéssité qu'on s'entende sur le fait qu'une action doit avoir en paramêtre une entité et un hashtable de string de paramètres optionnel. J'ai eut du mal à concevoir qu'une entité puisse servir de définition de table mais ça va.

## Pascal Lemay ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Création du package module pour les futurs modules du projet. Création de la classe Abstraite Module; avec référence static à l'orm, Hashtable d'actions, vecteur d'entité + méthodes d'accès.Début de la méthode doAction.
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Poursuivre le travail sur la classe abstraite Module (méthode doAction) + l'interface IAction avec guillaume
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * Complexité de la structure de la méthode doAction() en mutation et de la classe Module également en mutation.Confusion sur leurs fonctionnements (paramètre...entités).ps Important de mieux analyser et de se consulter avant de coder sinon c'est le bordel.

## Gabriel Therrien ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * command routeur livré et le servelet
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * liste des fichier
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * non

## Jonatan Cloutier ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * travaillé avec Gabriel sur le command routeur et servlet
    * partir pascal sur le abstractModule
    * embded TomCat marche
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * pluggé le Embded TomCat sur notre Servlet
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * oui un bug de  sur le embded tomcat derniere version:corrigé en utilisant une version un peu plus ancienne

# 30/09/2009 #

## Jonathan Hallee ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Livrer comment ajouter un entity de base dans l'orm. Fonctionnel mais pas necessairement au point. C'est de base seulement. Valider la structure generale de l'orm. Creer une test entity afin de pouvoir mieux travailler
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Ajouter les recherches par entity dans l'orm
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * Ma structure SQL. J'aurai besoin d'aide afin de definir si on implemente les search criterias supplementaires pour que l'orm soit fonctionnel

## Guillaume Lacasse ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Module, IAction, IActionAble en pair programming avec Pascal
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * IModuleGetter, TestModule, MainViewer, Viewable et TestViewer
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * Il a fallu normaliser le fonctionnement de IAction et de IModuleGetter

## Pascal Lemay ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Poursuite du travail sur la classe abstraite Module (méthode doAction) + interfaces:, IAction, IActionAble en pair programming avec Guillaume
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Création de:IModuleGetter, TestModule, MainViewer, Viewable et TestViewer
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * un peu de confusion sur le fonctionnement(interactions)de:Module,IAction et IModuleGetter...mais là ça va.

## Gabriel Therrien ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * liste des fichier
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * crée des .jar pour instensier les modules
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * lire les informations a propos des .jar

## Jonatan Cloutier ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * finalement abandon de embdedTomCat il y a trop de truc pour que sa plante
    * remplacement par Jetty, fonctionne numéro1
    * le CommandRouteur et le starter son fonctionnel avec le Servlet
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * comlété le commandeRouteur
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * 

# 01/10/2009 #

## Jonathan Hallee ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Ajout de la fonction select dans l'orm
    * Ajout de la fonction delete dans l'orm
    * Ajout de mes commentaires un peu mieux.
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Livrer la fonction de update dans l'orm
    * Refactoring et clarification generale du code en vue de la prochaine etape : creation automatique de la db
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * Les Result set. Quand on les lit ils vont a la fin. J'avais oublie de ne pas les fermer pour pouvoir les lire sinon ca les mets a null

## Guillaume Lacasse ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Implémentation fonctionelle de Module abstrait, module test, Interface IModuleGetter et IAction
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Implémentation fonctionelle de MainViewer, viewer test et vieable
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * Je dois expliquer aux autres membres le fonctionnement des modules concrets.

## Pascal Lemay ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * collaboration avec guillaume pour l'implémentation de:Module abstrait,IModuleGetter et TestModule
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Me donner un crash cours sur les formulaires HTML en prévision de la création du main viewer et des autres viewers.
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * pas de problèmes pour l'instant.


## Gabriel Therrien ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * j'ai rien livrée
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * terminé la liste de fichier avec Jonatan
    * faire l'analise du module userRightModule avec Jonatan
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * pas de problèmes

## Jonatan Cloutier ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * réglé plusieurs problème de communication
    * début la conception de unitTest
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * terminé la liste de module avec Gabriel
    * faire l'analise du module userRightModule avec Gabriel
    * complété le unittestage du handled de servlet
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * 

# 07/10/2009 #

## Jonathan Hallee ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Fonction de update pour l'orm.
    * Clarification generale du code + entity creator
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Commencer l'implementation de la creation automatique des modules
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * Me rappeler la structure generale des exceptions. Liste de folders / fichers. Instancié dynamiquement

## Guillaume Lacasse ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Développement et refactoring des modules (enlevé moduleGetter)
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Tous les viewers du sprint 1
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * Bien se comprendre sur le fonctionnement des modules

## Pascal Lemay ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * crash course de XHTML et CSS pour viewers à venir
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * poursuite du crash course XHTML(Forms) et CSS
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * n/a

## Gabriel Therrien ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * des actions
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * des action
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * problème pour la primary key parce qu'il faut que je me connecte mais je ne peux pas me connecter a partir du UserRightModule se n'est vraiment plus se que je pensait je ne comprend vraiment pas comment vous voyer le userRight Module

## Jonatan Cloutier ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * list module fonctionne
    * handled et listModule unitesté
    * refactor de module (voir commit 415 et )
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * terminé le refactor
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * le jar loader, feature abandonné pour le moment
    * l'appelle de méthode par réflexion pour contré un problème d'accès au field private.....

# 08/10/2009 (fin sprint 1) #

## Jonathan Hallee ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Fini la creation automatique des modules dans la db. Corrige quelques bugs apparus lors de divers insert, et selects dans le entity creator
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Commencer l'implementation des unit tests pour le serveur
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * Demander a jo pour la liste des modules

## Guillaume Lacasse ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Implémentation du Viewer, ListViewer et PromptViewer ainsi que Viewable, PromptViewable et ListViewable
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Intégration des features du projet en pair programming avec Jonatan Cloutier
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * Viewers: identification des entités par la 1ère colonne, à refactorer dans sprint2

## Pascal Lemay ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * poursuite du crash course XHTML(Forms) et CSS
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Analyse pour (viewer principal, module Home) et (débuter le code si le temps)
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * Parfois un peu perdu dans le code analysé...gros manque de commentaires...

## Gabriel Therrien ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * des actions
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * des actions , get list et get one
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * getone et getlist

## Jonatan Cloutier ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * refactor du module terminé
    * divers bug corrigé
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * intégration du viewer
    * débuggage d'intégration presque assuré
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * manque de temp

# 21/10/2009 (début sprint 2, relance) #

## Jonathan Hallee ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * désimplémenter les préfixes de noms de colonnes que on avait mis a la hate le dernier cours
    * ajout de commentaires multiples
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * speech a gab ( ce que je sait plus des @author ca sert pas a rien, des @param sur des classes ca existe pas)
    * Voir les dernières modifications faites à l'orm avec Jo Cloutier.
    * Début d'un module
    * (Si jai mis mon nom en haut des classes qui étaient pas a moi cetait parce que il en avait pas donc changé le)
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * Pas que j'aie remarqué

## Guillaume Lacasse ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * ListViewable et ListViewer fait mais pas testé
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Tester listViewable et listViewer, rendre module de droit fonctionnel
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * J'ai du me mettre à jour pour refactor récent (ça a été pour le mieux)

## Pascal Lemay ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Le viewer principal
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Le errorViewer, et ce qu'il faut pour convertir en string le stacktrace passé comme paramètre au errorViewer
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * rien de majeur

## Gabriel Therrien ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * 
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * l'analyse du module vendor/costumer
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * voir la nouvelle structure des modules

## Jonatan Cloutier ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * terminé l'intégration (retrait des hack)
    * création automatique des droits
    * automatisé et simplifier la création de module
    * encadré les champ dans les entity, mettre les action de base dans les entity
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * discuté des entity viewable, des field présent dans entity ou juste dans ORMEntity, de la méthode get qui retourn 1 ou des entity?
    * géré les baseAction
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * encadré les champ pour pouvoir avoir d'autre variable dans une entity a été une torture... reste quelque petit détaille a réglé

# 22/10/2009 #

## Jonathan Hallee ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * updater les field pour les adapter au nouveau where
    * commentaires et débuts d'overload du where
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * finir la nouvelle implémentation du where
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * comprendre les nouveaux fields

## Guillaume Lacasse ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * ListViewer marche
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Rendre les boutons fonctionnels
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * Nouveaux types d'actions (BaseAction) je dois être sur de bien comprendre comment ça doit marcher

## Pascal Lemay ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Le errorViewer, et code dans le servlet pour convertir en string le stacktrace passé comme paramètre au errorViewer
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Début du module Home, action getHome,et Homeviewer
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * petit problème avec AbstractEntity ...(vide)

## Gabriel Therrien ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * l'analyse du module VendorCostumer
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * des entité liées au module CostumerVendor
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * nouvelle structure des entitées

## Jonatan Cloutier ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * discuté et réglé les problème présent
    * terminé BaseAction et faire makeLink
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * testé WhereBuilder avec Jonathan H.
    * gestion du serveur de fichier et des session
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * pas actuellement

# 28/10/2009 #

## Jonathan Hallee ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * fini l'implémentation du nouveau where builder
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * cours formatif sur entités, viewers, modules
    * commencer le module de gestion de ressources?
    * implémenter le field date
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * pas de particulier

## Guillaume Lacasse ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Multiples viewers foncitonnels, login, logout, gestion des users, groupes (lecture et écriture) et des droits (en lecture pour l'instant)
    * déplacement de responsabilité des entités vers AbstractEntity et AbstractOrmEntity
    * création de user, modification de user, validation coté client.
    * Menus et sous-menus.
    * List of value.
    * Champs cachés, champs readOnly
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * FlagPool doit être fonctionnel en mode écriture
    * modification de droit: si case invisible, aucun changement
    * modification de droit: si user name admin, UserRightModule: aucune désaffectation possible
    * validation de nom de colonne (éviter colonnes interdites par sqLite)
    * flagPool: selectAll/none
    * PromptViewable/AbstractOrmEntity/EntityList: textarea
    * ListViewer (page multiples)
    * truc pour champs uniques (par exemple, pour user)
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * Je devrais mettre plus de commentaires JavaDoc

## Pascal Lemay ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Module Home, action getHome,et Homeviewer
> ### 2- qu'est-ce que je ferai (livré) aujourd'hui? ###
    * Cours sur entités, viewers, modules
    * menu de login sur page principal(en haut à droite) et début de module...
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * pas pour l'instant

## Gabriel Therrien ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * 
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * finir costumer/vendor
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * les link entre les modules

## Jonatan Cloutier ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * defautAction fonctionnel ainsi que la page d'aceuil
    * retiré la plupart de printStackTrace pour faire remonté les exception
    * les session fonctionne, fais un partie de la gestion du loggin
    * serveur de fichier fonctionnel et fichier .css séparé du viewer (enfin)
    * BaseAction et début de leur implementation généraliser
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * formation sur la création de modules
    * terminé l'implémentation généraliste des baseAction
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * .N/A

# 29/10/2009 #

## Jonathan Hallee ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * ajout du date field
    * participation au cours formatif
    * fix de commentaires
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * finir le date field
    * débuter le schéma de db **de base** pour le module de gestion de ressources
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * trouver comment les dates sont gérées dans sqlite 3

## Guillaume Lacasse ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * GetList est maintenant une BaseAction
    * Écriture des flagPool donc gestion des droits 100% fonctionnel et module de gestion des droits utilisable à 100%
    * Ajout d'image de background par fichier CSS
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * linkage de table qui  doit permetre (entre autre) l'effacement en cascade
par exemple, si on delete un Group, alors les GroupRight WHERE GroupID = ce groupe doivent disparaître, rendre flagPool et ListOfValue automatique par linkage de table. Rendre automatique l'access aux accessors
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * je ne met pas assez de commentaires JavaDoc

## Pascal Lemay ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Cours sur entités, viewers, modules
    * menu de login sur page principal(en haut à droite)
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Commencer l'élaboration d'un modéle pour module Finances et comptabilité
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * La dualité de certains éléments dont j'ai besoin...
    * liens avec autres modules pas encore clairs.

## Gabriel Therrien ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * rien
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * travail avec les assesors
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * asseseurs

## Jonatan Cloutier ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * formation sur la création de modules
    * terminé l'implémentation généraliste des baseAction
    * ajout d'un retour de clé primaire sur insert de l'ORM (et sur le new de Entity)
    * correction de droit par rapport au default Action
    * le groupe Admin a automatiquement tout les droit a la création d'un module (entity)
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * je pense débuté le module de ressource humaine
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * N/A

# 04/11/2009 #

## Jonathan Hallee ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Ajout du module de gestion de ressources matérielles
    * Débugage multiple
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Commencer la partie livraison de module de gestion de ressources
    * parler a gab comment il veut faire pour sa facture avec les produits
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * Les accesseurs de table

## Guillaume Lacasse ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Implémentation d'une gestion simplifiée des accessors (relation entre les tables)
    * Implémentation et Intégration du module de clients / fournisseur: fonctionnel
    * Ajout d'un module de ressource humaines
    * Formatage de champ d'argent
    * Gestion automatique et manuelle des clefs naturelles
    * Ajouté possibilité de donner nom visible à une entité de définition
    * PromptViewer: Affichage des entités associées à l'entité en question par l'entremise des accessors
    * Débuggé la classe FlagPool pour qu'elle marche avec le module de ressources matérielles
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Tester et/ou implémenter accessor multiple dans l'autre sens
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * Quelques problèmes à utiliser FieldDate mais sans plus

## Pascal Lemay ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Élaboration d'un modéle pour module Finances et comptabilité
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Poursuite de l'analyse du modèle (cerner tous ce dont j'ai besoin)...
    * Débuter l'implantation
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * Complexe la comptabilité; de plus aucune référence analogue dans nos cours
    * contrairement à customerVendor et humanResource...
    * Des heures de plaisir à lire sur le sujet...

## Gabriel Therrien ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * le module costumer/vendor
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * travailler sur un autre module ou travailler sur les links
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * links

## Jonatan Cloutier ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * cleanup de certaine partie du code rendu obsolete
    * ajout de dateTime et Time
    * ajustement pour prendre en compte l'ordre des champ effectif dans la db, les vue son a ajusté par guillaume
    * début du module de ressource humaine
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * corrigé bug date
    * corrigé bug de type incorrect du driver sqlite
    * faire le querryer vide (utilisant this)
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * je ne crois pas

# 05/11/2009 #

## Jonathan Hallee ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * merger la customerInvoice et la vendorInvoice ensemble
    * Ajout de données d'exemple
    * Deplacer l'adresse dans un module dit "Commun"
    * Modification de la clé naturelle de l'invoice
    * Ajout d'une entité country et state
    * Ajout d'un commentaire de shipping
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * linker les factures avec les produits (et éventuellement gerer et faire les validations sur les quantitées)
    * linker les livraisons avec les shippers
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * pas que je me sache

## Guillaume Lacasse ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Viewers: affichage des champs par ordre de création
    * Accessors: fonctionnels dans tous les sens et visibles dans les vues
    * Formattage d'argent dans les clefs naturelles
    * List of value avec clefs naturelles récursives
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * -list viewer, mettre dans l'ordre d'insertion
    * accessor singulier critérié
    * accessor pluriel critérié
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * faudait régler le bug d'insertion de dates

## Pascal Lemay ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Analyse pour modèle de finances...
    * Débuter l'implantation
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Poursuivre l'implantation de module finances.
    * Bien linker mes entités avec les autres entités dont j'ai besoin.
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * rien de particulier

## Gabriel Therrien ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * firm- et firm invoice
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * actions de costumer vendor
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * ...problème, besoin d'aide, qui aidera...

## Jonatan Cloutier ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * corrigé bug date
    * corrigé bug de type incorrect du driver sqlite
    * faire le querryer vide (utilisant this
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * réglé bug de date II
    * faire fonctionné les horaire avec une vue convenable
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * n/a

# 11/11/2009 #

## Jonathan Hallee ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * ajout d'un module d'entretiens de la machinerie
    * changer les locations pour arranger avec latitudes, longitudes en vue de si on a le temps au sprint 4 (ce qui m'étonnerais quand meme) de travailler avec la google api
    * quelques changements au niveau de customer vendor (dont dans merchant que j'ai renommé, enlevé le phone qui est contenu dans l'adresse)
    * Trouvé pourquoi la connection a sqlite étais si lente. C'etait le logger utiliser, j'ai donc supprimer ca.
    * Touch-up ici et la
    * Debut de linkage des factures avec invoices lines et products. Méthode pour calculer le total faite. Devra être appelée par une task. De meme que les actions update de quantités
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * actions de calculer le total de l'invoice
    * actions de updater les quantités en db lors de l'ajout d'une invoiceLine
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * pas que je sache

## Guillaume Lacasse ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Optimisation de performance d'accesseurs multiples
    * Simplification de requête d'accesseur multiples
    * Cré classe generique NaturalMap (genre d'Hashtable ordonné)
    * EditUI: après edit, retourne sur edit
    * Promtp viewable, lien de retour
    * Formatage d'argent aligné à droite
    * List of value maintenant dans l'ordre d'insertion
    * Corrigé bug ordre de vue des accesseur simples
    * Corrigé des fautes
    * Classe groups et user: ajout d'exemple d'utilisation d'accesseurs simples et multiples.
    * Ajout de gestion d'exception lors d'obtention d'accesseur multiples qui dit quels accesseurs sont disponibles selon le contexte
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Commencer module de spécification
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * Complexité des accesseurs multiples

## Pascal Lemay ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Modifications dans l'implantation du module finances.
    * Création de ses entités de base + links avec entités d'autres modules...
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Ajouter d'autres entités utiles (module finance).
    * Débuter l'élaboration d'actions de gestion.
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * no...

## Gabriel Therrien ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * une seule facture a la place de 3 factures
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * module de marketing
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * pas de probs

## Jonatan Cloutier ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * réglé bug de date II
    * vue fonctionnel des horaire
    * fermeture automatique des 2ieme instance de serveur
    * ajout de ActionLink
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * faire le rowSpan pour les plage horaire continue
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * comprendre les LOV et les principes des vue

# 12/11/2009 #

## Jonathan Hallee ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Pair programming avec pascal pour ces actions
    * action calculate total invoice
    * action reorder products
    * action update product quantities
    * ajout des entités invoiceTaxLine et tax
    * Début du module production (Machines, etc pour la ligne de production)
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * méthode searchUnique pour l'orm pour dans les cas ou on envoie une recherche et que on sait explicitement que ca retournera un seul résultat.
    * Continuer le module de production
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * ...problème, besoin d'aide, qui aidera...

## Guillaume Lacasse ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * TaskModule, ActionEntity, TaskEntity, SpecificationEntity, Operateur de Spécification
    * FieldBool: visible et fonctionnels avec radioButton
    * Ajouté accesseur multiple critérié, voir action RightCheck du userRightModule
    * Ajouté attribut de long textes
    * Reglé bug de memory leak
    * Cleané code de DisplayUnpaidService (pour Pascal et Kovalev)
    * Refactor getClass().getSimpleName() -> getSystemName() pour gérer actions, entités et modules dynamique, de base et statiques polymorphiquement
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Faire les premières spécifications atomiques
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * J'ai eu des conflit de svn (faut bien que je trouve quelque chose de négatif à dire)

## Pascal Lemay ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Débuter l'élaboration d'actions de gestion.
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Poursuivre le travail sur les actions de gestion.
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * Un peu avec les accesseurs, mais là c'est OK.

## Gabriel Therrien ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * ...livré...
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * ...à livrer...
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * ...problème, besoin d'aide, qui aidera...

## Jonatan Cloutier ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * faire le rowSpan pour les plage horaire continue
    * ménage de package
    * ButtonLinkViewer et LinkViewer pour standardisé les lien
    * généralisé timetableViewer
    * début du BaseViewer
    * retrait du paralélisme d'info
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * correction de bug avec le currencyFormat
    * débuté les champ calculé
    * completé BaseViewer et l'intégré
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * ...problème, besoin d'aide, qui aidera...

# 18/11/2009 #

## Jonathan Hallee ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * ajout d'un attribut sur textField qui s'appelle isVeryLong. Donc si vous mettez ca ca va vous faire un textField vraiment gros. (Utiliser pour des grosses descriptions etc)
    * Ajout de la méthode searchUnique dans l'orm qui nous retourne toujours une seule entité
    * Ajout de la méthode updateUnique dans l'orm qui nous épargne a avoir a gérer les vecteurs avec le new where builder.
    * CalculateInvoiceTotal marche parfaitement avec les taxes. On calcule avec un boutton qui a été ajouter sur la liste des factures
    * Update product quantities l'action marche. Validation que si on a assez de produits en stock.
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * continuer module de production (location d'équipement)
    * voir si on doit gérer que les produits on été updater en db sur la facture
    * finir de hardcoder l'action qui update la invoice a chaque nouveau InvoiceLine
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * c'est pas un peu bad de juste rediriger les actions des bouttons modifier vers getList si on ne veut pas pouvoir modifier?

## Guillaume Lacasse ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Implémentation du module de tâches
    * Optimization des accesseurs multiples critériés
    * Corrections de bug HTML pour rendre projet conforme aux standards W3C
    * Ajout de la classe PluralAccessor qui remplace Vector

&lt;AbstractOrmEntity&gt;


    * Vue des accesseurs multiples affiche maintenant accesseurs vides
    * Ajouté un actionLink dans les vues d'accesseurs multiples pour créer une entité étrangère selon critères d'accesseurs
    * TaskManager intégré au projet. Il reste à rendre fonctionnel l'exécution d'une tâche et le test d'une spécification.
    * Création d'un cache pour rendre le TaskManager plus performant
    * Nouvelle methode dans AbstractOrmEntity: methode save
    * Nouvelle methode dans AbstractOrmEntity: methode assign
    * TaskManager est fonctionnel!!!
    * Cré une task qui cré automatiquement des users pour les employés qui n'en on pas.
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * GetList: Pages multiples et vues critériées
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * Le J a planté.

## Pascal Lemay ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Actions de gestion: (DisplayUnpaidService), et (début de payingService)
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Poursuivre payingService
    * Débuter payingSupplier
    * Action de débiter d'un compte bancaire
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * Un peu ; il m'a fallu expérimenter pas mal donc pas mal de temps pour peu de résultat...

## Gabriel Therrien ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * des acceseur aux dans marketing
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * module de marketing
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * finir de penser les actions
## Jonatan Cloutier ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * retiré le paralélisme d'information entre les entity et les field
    * standardisé l'affichage de field
    * simplifier le prompt viewer
    * correction du bug de textField non affiché (mauvaise erreur de ma part)
    * listViewer est maintenant completement transphormé en grid viewer
    * buttonLinkViewer créé maintenant de réel boutton
    * création du base viewer fonctionnel pour le GridViewer et le PromptViewer
    * ajustement du currency format
    * change encoding du server les accent marche
    * correction du bug de null pointer dans horaire
    * correciton du ownedByModule (fonctionne toujours maintenant)
    * correction de ' en DB (me dire s'il y a d'autre probleme du genre)
    * correction du bug double PrintButton dans le promptViewer
    * refactor de GridCaseData
    * ajout des lien vers les foreignEntity dans le listViewer
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * faire les champs calculé
    * faire les validateur
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * dont remember...

# 19/11/2009 #

## Jonathan Hallee ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * gestion d'horaire pour équipements
    * régler bugs sur actions
    * fini de hardcoder les tasks pour calcul de facture
    * gérer les update product quantity dépendamment si c'est un customer ou non
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * ajouter le alter table pour l'orm
    * modifier la facture pour les besoins de pascal
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * pas de particulier

## Guillaume Lacasse ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Débuggé task manager
    * Setté clef naturelles d'entité du module de module
    * Refactor de tous les entités: c'est field qui gère les clefs naturelles
    * Déplacé et simplifié tâches hardcodées de initDB de customer vendor vers initDb de TaskModule
    * Module: ajouté comportement par default si aucun élément de menu d'action global n'a été spécifié
    * Module: prise en charge des cas ou aucune action par default n'a été définie (le comportement par default sera de prendre la première entité et de faire un GetList dessus)
    * Module Système: Ajouté entité d'accesseur
    * Générateur de code pour classe de module fonctionnel
    * Début de générateur de code pour classe d'entité
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Vues critériées
    * Module softcodage de module
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * ...problème, besoin d'aide, qui aidera...

## Pascal Lemay ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * PayingService (à terminer)
    * PayingSupplier (à terminer)
    * DebitFromBankAccount(à terminer)
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Terminer si possible les trois actions metionnées plus haut
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * oui, petit problème pour récupération d'un field,trop long à expliquer ici...
    * à voir avec jo.

## Gabriel Therrien ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * 
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * finir le module de marketing
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * ...problème, besoin d'aide, qui aidera...

## Jonatan Cloutier ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * généralisation de field
    * début de validateur et de champ calculé
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * terminé les validateur et de champ calculé
    * commencer le taskViewer
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * ...problème, besoin d'aide, qui aidera...

# 26/11/2009 #

## Jonathan Hallee ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * refait le insert de l'orm
    * regler bug dans le alter table
    * fait la task demandée par pascal (pas optimisée par contre)
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * module gestion ressources matérielles, work orders avec les produits, generes automatiquement
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * N/A

## Guillaume Lacasse ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Ajouté task pour appeler action d'ajout de colonnes pour field dynamique
    * Action qui call l'Orm pour ajouter des colonnes aux tables
    * Implémenté TaskManager: straight search
    * bool readonly: field dynamic false si généré, true si créé manuellement
    * field viewer: field bool: prise en charge de field hidden et readonly
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * orm add column ne doit pas se refaire si colonne existe (géré dans action)
    * task manager: appelé par orm, pas command router
    * ?Fields entity: pas deletable?
    * Softcodage de module doit être fonctionnel et montrable en présentation
    * FieldViewer: field currency readonly
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * besoin d'un viewer Sqlite qui affiche les nouvelles colonnes

## Pascal Lemay ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Actions de gestion :
    * PayingService
    * PayingSupplier
    * DebitFromBankAccount
    * NewSupplierTransaction
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Actions liées aux paiement des employés (à voir avec jo.C)
    * Task pour générer les talons de paye
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * Pour actions de paiement,j'ai du rechercher moi même la transaction par l'orm pour
    * avoir le 'data' car je n'y avais pas accès par l'entité reçu en paramètre.

## Gabriel Therrien ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * 
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * finir le module de marketing
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * les task et les actions

## Jonatan Cloutier ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * finalisé les validateur et de champ calculé
    * optimisation du grid Viewer
    * début d'intégration des field dynamique
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * terminé d'intégré les field dynamique
    * les task viewer
    * beaucoups d'autre point sur ma task list (a venir)
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * les task et les actions

# 02/12/2009 #

## Jonathan Hallee ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * work orders se crée automatiquement
    * work orders se ferment et ajoutent les produits en db
    * tasks reliées au work orders faites
    * ajouter un shipping status
    * Action OpenShipping
    * Action CloseShipping
    * Ajouter les tasks reliées
    * debut de project management (module de business)
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * cancel shipping et invoices, debugger supplierTransaction
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * RAS

## Guillaume Lacasse ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Task manager: est maintenant appelé lors des new donc les task direct search
devrait marcher correctement.
    * AddFieldToOrm Prise en charge des cas ou champ déjà dans DB
    * Fait en sorte que delete d'entité de field impossible (c'est ce qu'on veut)
    * Code generator: stub de code d'action: complet
    * Remis entité d'accesseurs qui avaient accidentellement été enlevés.
    * Il est maintenant possible de générer le code source d'un module qui marche, ses entité et les stubs de ses actions
    * field entity: remis deletable pour qu'on puisse effacer les fiels d'un module
généré
    * field entity: dynamic: pas read only pour qu'on puisse faire des field statiques
dans modules générés
    * Effacement de fieldEntity: seulement possible si l'entité auquel il appartient
n'a jamais été créé en tant que table dans la base de donnée.
    * Rendu impossible de déplacer field, entité et action.
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Softcodage de module doit être fonctionnel et montrable en présentation
    * Création dynamique de table pour entités sans avoir à recréer DB
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * ...problème, besoin d'aide, qui aidera...

## Pascal Lemay ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Actions et entités liées au paiement d'employés:
    * Entités: PayableEmployee,FederalWageBracket,ProvincialalWageBracket
    * Actions: PayingEmployee,PayingEmployees,
    * Actions: CreateUpdatePayableEmployee,CalculateFederalTax
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * Entité de période de paie PayablePeriode
    * Modifier PayableEmployee en fonction de PayablePeriode
    * modifier CalculateFederalTax en CalculateTaxAndSalary
    * modifier CreateUpdatePayableEmployee -> CreatePayableEmployee (call action de jo.C)
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * Aucun commentaires...

## Gabriel Therrien ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * ...livré...
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * ...à livrer...
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * ...problème, besoin d'aide, qui aidera...

## Jonatan Cloutier ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * terminé d'intégré les field dynamique
    * place automatiquement la date de fin lors de la création d'un plage horaire a
partir d'une horaire
    * affichage des messages d'erreur de la validation
    * permettre de retiré des global action et des spécifique action
    * ajouté la possibilité de masqué un module au utilisateur(attribut visible dans module)
    * ajout d'un horaire multiple
    * ajout d'un début très sommaire de schéma de base de donnée
    * ajout d'un image viewer pour affiché seulement une image
    * correction des problème de parse sur le currency field ([bug 26](https://code.google.com/p/newtonerp/issues/detail?id=6))
    * correction des probleme de calcul sur les currecy field ([bug 28](https://code.google.com/p/newtonerp/issues/detail?id=8))
    * validation de type et des cast  (parse) sur les setField
    * affichage des message d'erreur provenant des validateur, et présence d'un message par défaut (erreur inconnue)
    * les validateur peuvent maintenant validé en fonction de d'autre champ de l'entity
    * révision du langage javaScript et apprentissage de l'utilisation du xml (DOM) en java
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * terminé le module de ressource humaine pour permettre les paye ainsi que les quelque élément manquant
    * débuté l'export/import XML (taskViewer)
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * aprendre le java xml et trouvé les ressource pour l'utilisé
    * problème de théorie des graph pour le schéma de base de donnée (a réglé si on en a le temp)
    * difficulté a mettre en oeuvre les horaire multiple

# 03/12/2009 #

## Jonathan Hallee ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * cancel shipping
    * ajouter checks sur new supplier transaction
    * Touch ups sur mes actions
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * ...à livrer...
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * ...problème, besoin d'aide, qui aidera...

## Guillaume Lacasse ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Création de champ dynamique, si aucune clef primaire dans entité d'entité,
valeur par default (qu'on peut changer): nom de la futur clef primaire de
l'entité
    * GetList de Field, ActionEntity et EntityEntity: enlevé bouton nouveau car les
nouveaux field, actionEntity et EntityEntity doivent être créés par le bouton
[+] de leur parent.
    * Module de module: Création d'entité: lors de génération de code d'entité, ajout
de droits pour nouvelles entitées.
    * Module de module: création automatique des droits lors de création d'action sur module existant.
    * FieldEntity: champ de clef primaire: nom visible par default lors de création de clef primaire
    * Séparation de méthodes dans classe Orm
    * Ajout automatique d'indexe sur clef étrangère pour accélérer les requêtes select de relation 1 à plusieurs
    * Implémentation d'un cache spécialisé qui accélère les dynamic fields
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * ...à livrer...
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * ...problème, besoin d'aide, qui aidera...

## Pascal Lemay ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * Entité de période de paie PayablePeriode
    * Modifier PayableEmployee en fonction de PayablePeriode
    * modifier CalculateFederalTax en CalculateTaxAndSalary
    * modifier CreateUpdatePayableEmployee -> CreatePayableEmployee (call action de jo.C)
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * ...à livrer...
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * ...problème, besoin d'aide, qui aidera...

## Gabriel Therrien ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * ...livré...
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * ...à livrer...
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * ...problème, besoin d'aide, qui aidera...

## Jonatan Cloutier ##
> ### 1- qu'est-ce que j'ai fais (livré) depuis "hier"? ###
    * ...livré...
> ### 2- qu'est-ce que je ferais (livré) aujourd'hui? ###
    * ...à livrer...
> ### 3- est-ce que j'ai eu des difficultés particulières? (besoin d'aide ?) ###
    * ...problème, besoin d'aide, qui aidera...