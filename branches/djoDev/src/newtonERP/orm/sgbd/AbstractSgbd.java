package newtonERP.orm.sgbd;

import java.sql.ResultSet;
import java.util.Vector;

import newtonERP.module.AbstractOrmEntity;
import newtonERP.orm.OrmActions;
import newtonERP.orm.exceptions.OrmException;
import newtonERP.orm.field.Field;

/**
 * @author BeeERP team Représente tous les SGBD et leurs implémentations et
 *         déclatations communes
 */
public abstract class AbstractSgbd
{
    /**
     * Method that executes the sql query passed in paramter plus de action from
     * the OrmAction
     * 
     * @param request l'action a effectue
     * @param action the OrmActions that will be done
     * @return le resultat sous forme d'un result set
     * @throws OrmException an exception that can occur in the orm
     */
    public abstract ResultSet execute(String request, OrmActions action)
	    throws OrmException;

    /**
     * Method used to initialize the connection to the databse
     * 
     * @throws OrmException an exception that can occur in the orm
     */
    public abstract void connect() throws OrmException;

    /**
     * Method used to disconnect from the database
     * 
     * @throws OrmException an exception that can occur in the orm
     */
    public abstract void disconnect() throws OrmException;

    /**
     * Alter table
     * 
     * @param entity the entity containing the new field
     * @param field the field to add
     * @return ?
     * @throws OrmException an exception that can occur in the orm
     */
    public abstract ResultSet addColumnToTable(AbstractOrmEntity entity,
	    Field<?> field) throws OrmException;

    /**
     * Use only for complex queries. Use the select that takes only a vector of
     * entities instead
     * 
     * Method used to do search queries done from the views to the databse. The
     * search criterias that has been passed in parameter are a list of string
     * that has been generated by the view modules
     * 
     * @param searchEntity the entity that has to be researched
     * @param searchCriteriasParam the search criterias formatted into strings
     * @return a vector of ormizable entities
     * @throws OrmException an exception that can occur in the orm
     */
    public abstract ResultSet select(AbstractOrmEntity searchEntity,
	    Vector<String> searchCriteriasParam) throws OrmException;

    /**
     * Uses the new where builder
     * 
     * Method used to do search queries done from the views to the databse. The
     * search criterias that has been passed in parameter are a list of string
     * that has been generated by the view modules
     * 
     * @param searchEntities the entities from which we will perform the search
     * @return the entities
     * @throws OrmException an exception that can occur in the orm
     */
    public abstract ResultSet select(Vector<AbstractOrmEntity> searchEntities)
	    throws OrmException;

    /**
     * Method used to insert an entity in the databse based into the entity
     * passed in parameter
     * 
     * @param newEntity the entity to add
     * @return le id de clé primaire ajoutée
     * @throws Exception si ça fail
     */
    public abstract int insert(AbstractOrmEntity newEntity) throws Exception;

    /**
     * Method used to delete an entity from the database
     * 
     * @param searchEntity the entity to be researched
     * @param searchCriterias the search criterias for the where clause
     * @throws Exception si effacement fail
     */
    public abstract void delete(AbstractOrmEntity searchEntity,
	    Vector<String> searchCriterias) throws Exception;

    /**
     * Uses the new where builder
     * 
     * Method used to delete an entity from the database
     * 
     * @param searchEntities the entities from which we will build our where
     *            clause
     * @throws Exception si effacement fail
     */
    public abstract void delete(Vector<AbstractOrmEntity> searchEntities)
	    throws Exception;

    /**
     * Method used to update / change an entity
     * 
     * @param entityContainingChanges the entity that has been changed and will
     *            be in the orm
     * @param searchCriterias the criterias used by the update
     * @throws Exception si update fail
     */
    public abstract void update(AbstractOrmEntity entityContainingChanges,
	    Vector<String> searchCriterias) throws Exception;

    /**
     * Uses the new where builder
     * 
     * Method used to update / change an entity
     * 
     * @param searchEntities the entities from which we will build our where
     *            clause
     * @param entityContainingChanges the changes to apply
     * @throws Exception si update fail
     */
    public abstract void update(Vector<AbstractOrmEntity> searchEntities,
	    AbstractOrmEntity entityContainingChanges) throws Exception;

    /**
     * @param entitySystemName nom système d'une entité
     * @return true si l'entité a une table dans la base de donnée, sinon false
     * @throws Exception si ça fail
     */
    public abstract boolean isEntityExists(String entitySystemName)
	    throws Exception;

    /**
     * Sert à ajouter un index dans la table SQL de l'entité pour un field en
     * particulier
     * @param entityName nom de l'entité
     * @param fieldName nom du field
     * @throws Exception si ça fail
     */
    public abstract void createIndex(String entityName, String fieldName)
	    throws Exception;

    /**
     * Créer une table pour un type d'entité
     * @param entity entité
     * @throws OrmException si ça fail
     */
    public abstract void createTableForEntity(AbstractOrmEntity entity)
	    throws OrmException;

    /**
     * Uses the new where builder
     * 
     * Method used to update / change an entity
     * 
     * @param searchEntity the entities from which we will build our where
     *            clause
     * @param entityContainingChanges the changes to apply
     * @throws Exception si update fail
     */
    public abstract void updateUnique(AbstractOrmEntity searchEntity,
	    AbstractOrmEntity entityContainingChanges) throws Exception;

    /**
     * Use only for complex queries. Use the select that takes only a vector of
     * entities instead
     * 
     * Method used to do search queries done from the views to the databse. The
     * search criterias that has been passed in parameter are a list of string
     * that has been generated by the view modules
     * 
     * @param searchEntity the entity that has to be researched
     * @param searchCriteriasParam the search criterias formatted into strings
     * @param limit limite de résultat
     * @param offset offset du début des résultats
     * @param orderBy ordre facultatif
     * @return a vector of ormizable entities
     * @throws OrmException an exception that can occur in the orm
     */
    public abstract ResultSet select(AbstractOrmEntity searchEntity,
	    Vector<String> searchCriteriasParam, int limit, int offset,
	    String orderBy) throws OrmException;

    /**
     * @param searchEntity entité de recherche
     * @return nombre d'occurence du type de l'entité de recherche
     * @throws Exception si ça fail
     */
    public int count(AbstractOrmEntity searchEntity) throws Exception
    {
	return count(searchEntity, null);
    }

    /**
     * @param searchEntity entité de recherche
     * @param searchParameterList paramêtres de recherche
     * @return nombre d'occurence du type de l'entité de recherche
     * @throws Exception si ça fail
     */
    public abstract int count(AbstractOrmEntity searchEntity,
	    Vector<String> searchParameterList) throws Exception;

    /**
     * Fait un backup de la DB
     */
    public abstract void doBackup();

    /**
     * @return timestamp en ms où le dernier backup à été fait
     */
    public abstract long getLatestBackupTime();
}
