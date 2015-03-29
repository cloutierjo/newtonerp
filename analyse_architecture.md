L'ORM _(fait par nous-même car on ne peut pas utiliser d'orm, servira à rendre plus rapide l'ajout de modules de business logic)_

Nécessite  pour fonctionner une table listant les plugins (modules)
  * Au démarrage check des plugin installé, comparé avec une liste de plugin déjà installé:
    * Si plugin inexistant l'"installé", création de la structure en DB
    * Sinon rien...
  * Envois d'un objet "data" l'orm détermine le type d'objet (client...) puis mes a jour les donné dans les table concerné
    * Si un ID est présent UPDATE
    * Sinon INSERT
  * Possibilité d'envoyer un vecteur de "data" pour faire plusieurs update
  * SELECT:
    * Envois d'un objet "data" avec le(s) critère(s) de recherche à l'intérieur et retourne un vecteur d'objet "data" (même s'il n'y en a qu'un)
  * DELETE: Envois d'un objet "data" avec le(s) critère(s) de suppression (ou plusieurs, vecteur)
Gestion des User:
  * Sous forme de module OBLIGATOIRE
  * Gestion des droits d'accès a chacun des modules (via des groupe)
  * a la connection l'utilisateur recois une UniqueID
  * celle-ci doit être validé a chaque requête faite par le client
Architecture 3 tiers:
  * Coté serveur:
    * ORM
    * Busines logic
  * Coté client:
    * Viewer
Viewer
  * Contient plusieurs ItemViewer qui peuvent afficher les items qu'il peut afficher
  * Chaque vue possible d'un module est défini a L'intérieur du module lui-même
  * Les actions sont représentées par un élément de menu créé a partir d'un objet menuViewable
  * Le listner envois un signal au module pour effectuer une action sur celui-ci
  * Navigation entre les différent module a partir d'une barre de menu a gauche, elle doit être composé de la liste de tout les module utilisable par l'utilisateur actuel (treeview)
Workflow
  * Doit contenir un éditeur de spécification complexe (ET OU imbriquable)
    * Éditeur de spec textuel avec assistant graphique:
      * Liste des tables
      * Liste des champs par table
      * Liste des opérateurs
      * Valeur possible (si possible)
    * Doit "compilé" la spec
    * Doit créé des liens (event) dans chacun des éléments inclue dans la condition de la spec
    * Permet d'exécuté une action selon le résultat de la condition