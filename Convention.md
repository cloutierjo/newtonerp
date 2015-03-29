# CONVENTIONALISATION #

## Commentaires ##

Dans chacune de vos classes vous mettez un commentaire **javadoc** en header avec un @author et une **breve** description et usage de la classe. Les auteurs sont les deux programmeurs.

Pour chaque methode autre que les getter et les setter mettre un commentaire javadoc

## Style de code ##

Bon je pense que tout le monde sait coder mais je crois qu'il serait important de mentionner certains points :
  * Utilisez des noms longs pour les methodes (privilegiez cela a 10 lignes de commentaires)  **djo: sans exagération**
  * Utilisez des noms longs pour les variables meme si elles sont internes (pas de variable  nommee t ou f on comprend rien) exception pour les compteur tres local (ex: for)

Utopique :
  * Des méthodes de 20 lignes ou moins (djo: faire attention a ne pas séparé pour rien... je pense surtout aux viewer, j'aurais tendance a dire que l'on doit faire un méthode si un bout de code de plus de 2-3 ligne se répète a quelque occasion ou si on très plusieurs élément différent dans un même méthode: chacun peuvent être fait dans des méthode différente)

Etant donne que ce ne sera pas necessairement nous qui allons faire tout le code pour nos modules, essayez de le rendre comprenable pour les autres! Passez du temps a le **refactorer**, vous vous comprendrez vous meme et ce ne sera pas long se "remettre dedans" Commenter les bout qui comporte une complexité anormal, mais nécessaires

Si vous sentez le besoin, établissez des procédures pour le bon fonctionnement de votre classe ( genre 1. faites ceci 2. faites cela... ) Toute les classe abstraite et les interface doivent comporté une explication de comment implementer(ou _extender_) la classe/interface avec si nécessaires un exemple, mettre ses explication en JavaDoc de class ou méthode selon le cas, mais pas en commentaire simple

Egalement, si vous en sentez le besoin, il y a une classe statique nommee **Logger** dans le package newtonERP.logging, par laquelle vous pouvez utiliser afin de logger vos messages d'erreurs afin de les revoirs plus tard. Voir la classe pour plus d'information Svp ne pas laissé de trace de ligne de loggage qui serve au débuggage dans les source commité ou si elle doivent l'etre mettez un commentaire //TODO: a la suite de celui-ci, par contre  **SI** on doit avoir des endroit qui log dans la version finale ne pas metre de commentaire //TODO:

## Nommage ##

Tout ce qui est non-vu par autrui doit etre en **anglais**, nom de varible, fonction, classes. Les view seront en **francais**, seulement ce qui est visible par le End User

Commentaires en Français. svp **aucun** accent.
Verifiez votre orthographe svp.

## Autres ##

Utiliser l'auto format d'eclipse qui va etre setter selon notre convention

Evidemment on oublie pas n'importe qu'elle autre convention de Java dont les suivantes :
  * Les packages commencent par des minuscules
  * Les classes par des majuscules
  * Fonctions par des minuscules
  * Variables par des minuscules
  * Interfaces par des majuscules

### Proposition de convention pour le nomage des interfaces ###
Lorsqu'on peut nommer une interface en terminant par "able", on le fait. Si ça a l'aire illogique, on lui donne un nom qui commence par I. Par exemple: Ormizable vs IModule (on imaginerais bizarement Modulable car c'est pas le module qui se fait moduler). J'attends votre accord pour rendre cette convention officielle. -Guillaume

Utilitaire de code review integré dans google code. Mettre un commentaire et si positif, neutre ou négatif

Exemple de code

```
public void setTest() 
{
    blabla

    if () 
    {
        blabla
    }
    else if ()
    {
    }

    do
    {
    } while ();

    while ()
    {
    }

    if (x == 1 && y == 1 && z == 1 && a == 1 && b == 1
        || x == 2 && y == 2 && z == 2 && a == 2 && b == 2)
    {
        cout << "mofo";
    }
}
```