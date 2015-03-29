


## Entity ##
<table border='1'>
<blockquote><tr>
<blockquote><td width='70%'> Gabriel Therrien </td>
<td>
<ul><li>ormizable<br>
</li><li>viewable<br>
</li><li>SearchCriteriable<br>
</li><li>Action<br>
</li><li>Task<br>
</li></ul></td>
</blockquote></tr>
<tr>
<blockquote><td>
<ul><li>elle ne fait pas vraiment d'action elle même, elle subit plutot les actions des autres classes<br>
</li></ul></td>
</blockquote></tr>
</table>
<h2>UserRightModule</h2>
<table border='1'>
<tr>
<blockquote><td width='70%'> Gabriel Therrien </td>
<td>
<ul><li>Viewer<br>
</li><li>User<br>
</li><li>Module<br>
</li><li>action<br>
</li><li>Entities<br>
</li></ul></td>
</blockquote></tr>
<tr>
<blockquote><td>
<ul><li>détermine les droits des utilisateur se qu'il ont le droit de /ne pas/voir et/ou modifier les choses<br>
</li></ul></td>
</blockquote></tr>
</table></blockquote>

## CompositeSpecification ##
<table border='1'>
<blockquote><tr>
<blockquote><td width='70%'>Guillaume</td>
<td>
<ul><li>ISpecification (interface)<br>
</li><li>CompositeSpecification (même classe récursivement)<br>
</li><li>AtomicSpecification<br>
</li><li>Task<br>
</li></ul></td>
</blockquote></tr>
<tr>
<blockquote><td>
<ul><li>Teste si la spécification est présentement satisfaite en testant ses sous-spécifications et en appliquant un opérateur "et" ou "ou"<br>
</li></ul></td>
</blockquote></tr>
</table></blockquote>

## AtomicSpecification ##
<table border='1'>
<blockquote><tr>
<blockquote><td width='70%'>Guillaume</td>
<td>
<ul><li>ISpecification (interface)<br>
</li><li>CompositeSpecification<br>
</li><li>Task<br>
</li></ul></td>
</blockquote></tr>
<tr>
<blockquote><td>
<ul><li>Teste si la spécification atomique est présentement satisfaite<br>
</li></ul></td>
</blockquote></tr>
</table></blockquote>

## Task ##
<table border='1'>
<blockquote><tr>
<blockquote><td width='70%'>Guillaume</td>
<td>
<ul><li>ISpecification (interface)<br>
</li><li>Action<br>
</li><li>TaskModule<br>
</li><li>TaskManager<br>
</li><li>Entity (pour critère de recherche pour créer vecteur d'entités affectées)<br>
</li></ul></td>
</blockquote></tr>
<tr>
<blockquote><td>
<ul><li>Lorsque que la tâche est activée, effectue action si la spécification est pas <b>(??)</b> satisfaite<br>
</li></ul></td>
</blockquote></tr>
</table></blockquote>

## TaskManager ##
<table border='1'>
<blockquote><tr>
<blockquote><td width='70%'>Guillaume</td>
<td>
<ul><li>Task<br>
</li><li>DataOrm<br>
</li></ul></td>
</blockquote></tr>
<tr>
<blockquote><td>
<ul><li>Active tous les tâches associées à une entiée fournie par l'Orm.<br>
</li><li>Gère de manière persistante les associations entre les types d'entités et les tâches associées<br>
</li></ul></td>
</blockquote></tr>
</table></blockquote>

## TaskModule ##
<table border='1'>
<blockquote><tr>
<blockquote><td width='70%'>Guillaume</td>
<td>
<ul><li>Module (TaskModule est une sous-classe de Module)<br>
</li><li>MainModule (TaskModule est une composante de MainModule)<br>
</li><li>TaskManager (TaskModule cré des tâches dans le taskManager)<br>
</li><li>TaskViewer (TaskViewer permet de voir les Tasks pour les modifier)<br>
</li><li>Action (ce sont les actions d'un module qui effectuent les modifications sur les entitées)<br>
</li></ul></td>
</blockquote></tr>
<tr>
<blockquote><td>
<ul><li>Permet de modifier/supprimer/créer des Tasks dans le TaskManager à l'aide du TaskViewer<br>
</li></ul></td>
</blockquote></tr>
</table></blockquote>

## TaskViewer ##
<table border='1'>
<blockquote><tr>
<blockquote><td width='70%'>Guillaume</td>
<td>
<ul><li>Viewer (TaskViewer est une composante de Viewer)<br>
</li><li>IViewer (TaskViewer implémente IViewer)<br>
</li><li>Task (TaskViewer permet de voir une Task)<br>
</li></ul></td>
</blockquote></tr>
<tr>
<blockquote><td>
<ul><li>Permet de voir une Task sous forme de "TreeView" de manière à pour la modifier<br>
</li></ul></td>
</blockquote></tr>
</table></blockquote>

## Action ##
<table border='1'>
<blockquote><tr>
<blockquote><td width='70%'>Guillaume</td>
<td>
<ul><li>Module (une action est une composante d'un module)<br>
</li><li>Task (une action peut être déclancher par une task si sa spécification est vraie)<br>
</li><li>Entity (paramètre de l'action)<br>
</li></ul></td>
</blockquote></tr>
<tr>
<blockquote><td>
<ul><li>Effectue une action "hard codée" en prenant pour argument une entité<br>
</li></ul></td>
</blockquote></tr>
</table>
<h2>ISpecification</h2>
<table border='1'>
<tr>
<blockquote><td width='70%'>.</td>
<td>
<ul><li>.........................................<br>
</li><li>.........................................<br>
</li><li>.........................................<br>
</li></ul></td>
</blockquote></tr>
<tr>
<blockquote><td>
<ul><li>.........................................<br>
</li><li>.........................................<br>
</li><li>.........................................<br>
</li></ul></td>
</blockquote></tr>
</table>
<h2>IViewer</h2>
<table border='1'>
<tr>
<blockquote><td width='70%'>.</td>
<td>
<ul><li>.........................................<br>
</li><li>.........................................<br>
</li><li>.........................................<br>
</li></ul></td>
</blockquote></tr>
<tr>
<blockquote><td>
<ul><li>.........................................<br>
</li><li>.........................................<br>
</li><li>.........................................<br>
</li></ul></td>
</blockquote></tr>
</table></blockquote>

## Viewable ##
> (visible par le main viewer)
<table border='1'>
<blockquote><tr>
<blockquote><td width='70%'> a déterminé </td>
<td>
</blockquote><ul><li>entity<br>
</li><li>viewer<br>
<blockquote></td>
</blockquote></li></ul></tr>
<tr>
<blockquote><td>
</blockquote></blockquote><ul><li>formatte les donnée pour etre compréhensible par le bon viewer<br>
<blockquote></td>
</blockquote></li></ul><blockquote></tr>
</table></blockquote>

## Viewer ##
<table border='1'>
<blockquote><tr>
<blockquote><td width='70%'> a déterminé </td>
<td>
<ul><li>autre viewer<br>
</li><li>viewable<br>
</li></ul></td>
</blockquote></tr>
<tr>
<blockquote><td>
</blockquote></blockquote><ul><li>crée le HTML dont il est responsable (donc pas une page complete)<br>
</li><li>appelle les autre viewer néscéssaire a la création de <b>son</b> html<br>
</li><li>une implementation de viewer peut contenir des méthode utilitaire internepour compartimenté le code<br>
</li><li>retourn le html créé<br>
<blockquote></td>
</blockquote></li></ul><blockquote></tr>
</table></blockquote>

## MainViewer ##
<table border='1'>
<blockquote><tr>
<blockquote><td width='70%'> a déterminé </td>
<td>
</blockquote><ul><li>servlet<br>
</li><li>specizedViewer<br>
<blockquote></td>
</blockquote></li></ul></tr>
<tr>
<blockquote><td>
</blockquote></blockquote><ul><li>créé le pageHeader, page footer<br>
</li><li>apelle le MenuViewer et le SpecializeViewer<br>
</li><li>retourne la page html complete<br>
<blockquote></td>
</blockquote></li></ul><blockquote></tr>
</table></blockquote>


## servlet ##
<table border='1'>
<blockquote><tr>
<blockquote><td width='70%'> a déterminé </td>
<td>
</blockquote><ul><li>CommandRouter<br>
</li><li>mainViewer<br>
<blockquote></td>
</blockquote></li></ul></tr>
<tr>
<blockquote><td>
</blockquote></blockquote><ul><li>recois les requette du client et les envoys a l'event listner<br>
</li><li>recois la réponse des module et l'envois a mainViewer<br>
</li><li>recois le html du mainViewer et l'envois au client<br>
<blockquote></td>
</blockquote></li></ul><blockquote></tr>
</table></blockquote>

Voir pages pour info sur servlet
http://www.exampledepot.com/egs/javax.servlet/com_mycompany_MyServlet.html
http://java.sun.com/products/servlet/articles/tutorial/
http://www.google.com.ca/search?q=tomcat+embedded

## Module ##
<table border='1'>
<blockquote><tr>
<blockquote><td width='70%'> a déterminé </td>
<td>
</blockquote><ul><li>Action<br>
</li><li>CommandRouter<br>
</li><li>Entity<br>
<blockquote></td>
</blockquote></li></ul></tr>
<tr>
<blockquote><td>
</blockquote></blockquote><ul><li>contient une reference static a l'orm<br>
</li><li>sert de model pour un module<br>
<blockquote></td>
</blockquote></li></ul><blockquote></tr>
</table></blockquote>


## Starter ##
<table border='1'>
<blockquote><tr>
<blockquote><td width='70%'> a déterminé </td>
<td>
</blockquote><ul><li>servlet<br>
</li><li>DataOrm ?<br>
<blockquote></td>
</blockquote></li></ul></tr>
<tr>
<blockquote><td>
<ul><li>sert a lancé l'aplication serveur<br>
</li><li>lance la vérification de dépendance<br>
</li><li>lance la vérification de nouveau module et fais faire les installation<br>
</li><li>lance le server (servlet)<br>
</li></ul></td>
</blockquote></tr>
</table></blockquote>

## CommandRouter ##
<table border='1'>
<blockquote><tr>
<blockquote><td width='70%'> a déterminé </td>
<td>
</blockquote><ul><li>Module<br>
</li><li>Servlet</li></ul></blockquote>

<blockquote></td>
</blockquote><blockquote></tr>
<tr>
<blockquote><td>
</blockquote></blockquote><ul><li>route le requête client vers le bon module<br>
<blockquote></td>
</blockquote></li></ul><blockquote></tr>
</table></blockquote>

## OrmizableEntity ##
<table border='1'>
<blockquote><tr>
<blockquote><td width='70%'> Jonathan Hallee </td>
<td>
<ul><li>Entity<br>
</li><li><b>DataOrm</b>
</li></ul></td>
</blockquote></tr>
<tr>
<blockquote><td>
<ul><li>methode requestData ou formatData<br>
</li><li>S'occupe de formater les donnes afin qu'elles soit Ok pour l'orm<br>
</li><li>Genre sous-forme de vecteur etc...<br>
</li></ul></td>
</blockquote></tr>
</table></blockquote>

## DataOrm ##
<table border='1'>
<blockquote><tr>
<blockquote><td width='70%'> Jonathan Hallee </td>
<td>
<ul><li>TaskManager<br>
</li><li>ProgramModule<br>
</li><li><b>Ormizable</b></li></ul></blockquote></blockquote>

<blockquote></td>
</blockquote><blockquote></tr>
<tr>
<blockquote><td>
<ul><li>Effectue les requetes de traitement (select, insert, update, delete...)<br>
</li><li>Retourne le ou les resultats<br>
</li><li>Mets a jour les module<br>
</li><li>Garde une table des plugins installes<br>
</li><li>Installe les modules, (premiere creation de la db)<br>
</li></ul></td>
</blockquote></tr>
</table></blockquote>

## OrmAction ##
<table border='1'>
<blockquote><tr>
<blockquote><td width='70%'> Jonathan Hallee </td>
<td>
<ul><li>DataOrm<br>
</li></ul></td>
</blockquote></tr>
<tr>
<blockquote><td>
<ul><li>Contient seulement une enum des actions possible de l'orm de base (ajout    etc...). Comme ca on passe a l'orm une OrmAction<br>
</li></ul></td>
</blockquote></tr>
</table>