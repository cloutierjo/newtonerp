Voici le tableau de priorité tel qu'établis en classe.
le temps donné est en heure pour une personne nous avons donc de disponible pour chaque sprint 5\*15h= 75h, évidement de cela il faut soustraire un certain temps d'administration et de débuggage/imprévue

**la page commence a etre large, il faudrait voir si on peu simplifier**

| **priorité** | **pokerScore** | **nom de la classe**  | **temp (h)** | **sprint (#)** | date Début | date fin **fonctionnel** |  **Développeur(s)** | **Spécialiste(s) externe(s)** | **status** |
|:--------------|:---------------|:----------------------|:-------------|:---------------|:------------|:-------------------------|:---------------------|:-------------------------------|:-----------|
| 1 | 0 | starter | 1 | 1 | mer 23 | mer 23 | Jonathan H | joclou | ajout au besoin |
| 2 | 0,5 | DataOrm | 8 | 1 | mer 23 | jeu 1 | Jonathan H Guillaume | Jo Cloutier | Fonctionnel |
| 2 | 0,5 | Entity | 1 | 1 | mer 23 | jeu 1 | Jonathan H Guillaume  | Jo Cloutier | Fonctionnel |
| 2 | 0,5 | OrmizableEntity | 2 | 1 | mer 23 | jeu 1 | Jonathan H Guillaume | Jo Cloutier | Fonctionnel |
| 5 | 1 | Module | 3 | 1 | mer 23 | jeu 24 | Pascal joclou | Guillaume | présumer fonctionnel |
| 6 | 1,5 | Action | 1 | 1 | mer 23 | jeu 24 | Pascal joclou | Guillaume | présumer fonctionnel |
| 6 | 1,5 | IModuleGetter | 1 | 1 | mer 23 | jeu 24 | Pascal joclou | Guillaume | présumer fonctionnel |
| 7 | 2 | commandRouter | 7 | 1 | mer 23 | mer 30 | joclou Gab | Jonathan H | terminer |
| 7 | 2 | ListModule | 7 | 1 | mer 23 | mer 30 | joclou Gab | Jonathan H | fonctionnel (ajouté le jar loader si possible un moment donnée) |
| 8 | 2,1 | servlet | 7 | 1 | mer 23 | mer 30 | joclou Gab | Jonathan H | fonctionnel, en attente du mainViewer|
| 9 | 2,2 | IViewer | 4 | 1 | mer 30  | mer 7 | Pascal Guillaume | joclou |  |
| 9 | 2,2 | viewable | 1 | 1 | mer 30  | mer 7 | Pascal Guillaume | joclou |  |
| 9 | 2,2 | mainViewer | 6 | 1 | mer 30  | mer 7 | Pascal Guillaume | joclou |  |
| 13 | 3 | UserRightModule | 7 | 1 | jeu 1 | mer 7 | Gabriel joclou | Jonathan H | débuté |
| -- | -- | -- | 48 | 1 | mer 23 | jeu 8 |  |  |  |
| 14 | 5 | Task | 17 | 2 | - | - | Guillaume Pascal | joclou Jonathan H |  |
| 14 | 5 | AtomicSpecification | " | 2 | - | - | Guillaume Pascal | joclou Jonathan H |  |
| 14 | 5 | CompositeSpecification | " | 2 | - | - | Guillaume Pascal | joclou Jonathan H |  |
| 14 | 5 | Ispecification | " | 2 | - | - | Guillaume Pascal | joclou Jonathan H |  |
| 18 | 5,2 | TaskModule | 5 | 2 | - | - | joclou Jonathan H | Guillaume |  |
| 18 | 5,2 | TaskViewer | 5 | 2 | - | - | joclou Jonathan H | Guillaume |  |
| 20 | 5,3 | TaskManager | 5 | 2 | - | - | joclou Jonathan H | Guillaume |  |
| -- | -- | -- | 32 | 1 | - | - |   |  |  |
| any |  | [...] Modules spécialisés | 5 | any | - | - | tout le monde |  |  |

le reste du temps du sprint 2 ainsi que le sprint 3 sera principalement allouer a écrire des modules dont la priorité sera déterminé plus tard dans le processus et un certain déboggage de l'architecture pour en assuré sa stabilité. Les modules étant des éléments "simple" et indépendant il ne devrait pas causé de problème difficile a réglé ni grave du point de l'application complète (le reste fonctionnera tout de même)
dès qu'une personne ne peut avancé parce qu'elle doit attendre quelqu'un d'autre elle doit faire des module s'il n'y a rien de plus constructif a faire (débuggage, aide..)