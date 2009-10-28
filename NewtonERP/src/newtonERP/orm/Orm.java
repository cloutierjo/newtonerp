package newtonERP.orm;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

import newtonERP.ListModule;
import newtonERP.module.AbstractEntity;
import newtonERP.module.AbstractOrmEntity;
import newtonERP.module.Module;
import newtonERP.module.exception.ModuleException;
import newtonERP.module.field.Field;
import newtonERP.module.field.FieldBool;
import newtonERP.module.field.FieldDouble;
import newtonERP.module.field.FieldInt;
import newtonERP.module.field.FieldString;
import newtonERP.orm.exceptions.OrmException;
import newtonERP.orm.sgbd.SgbdSqlite;
import newtonERP.orm.sgbd.Sgbdable;

/**
 * @author r3hallejo, r3lacasgu
 * 
 *         Basic class for the orm. It is used to put the objects in the databse
 *         using SqLite3 and its java binding. The orm will receive an entity
 *         from which the orm will perform various tasks such as generating the
 *         query and executing it obviously. Then it's gonna send the query to
 *         the SgbdSqlite class to execute it.
 * 
 *         Types for the database : Integer, Double (Number?), String, Boolean
 *         (Integer?)
 * 
 *         http://www.sqlite.org/lang_keywords.html
 * 
 *         Pour le nouveau where exemple : String where=
 *         "(champentité1 AND champ2entité1) OR (champ1entité2 AND champ2entité2))"
 *         ;
 */
public class Orm
{
    private static Sgbdable sgbd = new SgbdSqlite();
    private static String prefix = "Newton_";

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
    public static Vector<AbstractOrmEntity> select(
	    AbstractOrmEntity searchEntity, Vector<String> searchCriteriasParam)
	    throws OrmException
    {
	String sqlQuery = "SELECT * FROM " + prefix
		+ searchEntity.getClass().getSimpleName();

	if (searchCriteriasParam != null)
	    sqlQuery = buildWhereClauseForQuery(sqlQuery, searchCriteriasParam);

	// TODO: Remove the next line when it will be properly debugged
	System.out.println("SQL query produced : " + sqlQuery);

	ResultSet rs = sgbd.execute(sqlQuery, OrmActions.SEARCH);

	return EntityCreator.createEntitiesFromResultSet(rs, searchEntity);
    }

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
    public static Vector<AbstractOrmEntity> select(
	    Vector<AbstractOrmEntity> searchEntities) throws OrmException
    {
	String sqlQuery = "SELECT * FROM " + prefix
		+ searchEntities.get(0).getClass().getSimpleName();

	if (!searchEntities.isEmpty())
	    sqlQuery = buildWhereClauseForQuery(searchEntities, sqlQuery);

	// TODO: Remove the next line when it will be properly debugged
	System.out.println("SQL query produced : " + sqlQuery);

	ResultSet rs = sgbd.execute(sqlQuery, OrmActions.SEARCH);

	return EntityCreator.createEntitiesFromResultSet(rs, searchEntities
		.get(0));
    }

    /**
     * @param searchEntity the single search entity
     * @return the entities that have been selected in the db
     * @throws OrmException an exception that can occurin the orm
     */
    public static Vector<AbstractOrmEntity> select(
	    AbstractOrmEntity searchEntity) throws OrmException
    {
	Vector<AbstractOrmEntity> searchEntities = new Vector<AbstractOrmEntity>();
	searchEntities.add(searchEntity);
	return select(searchEntities);
    }

    /**
     * Method used to insert an entity in the databse based into the entity
     * passed in parameter
     * 
     * @param newEntity the entity to be inserted
     * @throws OrmException an exception that can occur into the orm
     */
    @SuppressWarnings("unchecked")
    public static void insert(AbstractOrmEntity newEntity) throws OrmException
    {
	Hashtable<String, String> data = newEntity.getOrmizableData();
	String sqlQuery = "INSERT INTO " + prefix
		+ newEntity.getClass().getSimpleName() + " (";
	String valuesQuery = " VALUES (";

	// We now iterate through the key set so we can add the fields to the
	// query
	Iterator keySetIterator = data.keySet().iterator();
	while (keySetIterator.hasNext())
	{
	    // Retrieve key
	    Object key = keySetIterator.next();

	    // If it's the end or not we add the key to the query with the
	    // right string ("," or not) and the value
	    if (!keySetIterator.hasNext())
	    {
		if (!key.toString().matches("PK.*"))
		{
		    sqlQuery += "'" + key.toString() + "') ";
		    valuesQuery += "'" + data.get(key).toString() + "') ";
		}
		else
		{
		    sqlQuery = sqlQuery.substring(0, sqlQuery.length() - 2);
		    sqlQuery += ")";

		    valuesQuery = valuesQuery.substring(0,
			    valuesQuery.length() - 2);
		    valuesQuery += ")";
		}
	    }
	    else
	    {
		if (!key.toString().matches("PK.*"))
		{
		    sqlQuery += "'" + key.toString() + "', ";
		    valuesQuery += "'" + data.get(key).toString() + "', ";
		}
	    }
	}

	sqlQuery += valuesQuery;

	// TODO: Remove the next line once this will be properly debugged
	System.out.println("SQL query produced : " + sqlQuery);

	sgbd.execute(sqlQuery, OrmActions.INSERT);
    }

    /**
     * Method used to delete an entity from the database
     * 
     * @param searchEntity the entity to be researched
     * @param searchCriterias the search criterias for the where clause
     * @throws OrmException an exception that can occur into the orm
     */
    public static void delete(AbstractOrmEntity searchEntity,
	    Vector<String> searchCriterias) throws OrmException
    {
	String sqlQuery = "DELETE FROM " + prefix
		+ searchEntity.getClass().getSimpleName();

	sqlQuery = buildWhereClauseForQuery(sqlQuery, searchCriterias);

	// TODO: Remove the next line once this will be properly debugged
	System.out.println("Sql query produced : " + sqlQuery);

	sgbd.execute(sqlQuery, OrmActions.DELETE);
    }

    /**
     * Uses the new where builder
     * 
     * Method used to delete an entity from the database
     * 
     * @param searchEntities the entities from which we will build our where
     *            clause
     * @throws OrmException an exception that can occur in the orm
     */
    public static void delete(Vector<AbstractOrmEntity> searchEntities)
	    throws OrmException
    {
	String sqlQuery = "DELETE FROM " + prefix
		+ searchEntities.get(0).getClass().getSimpleName();

	sqlQuery = buildWhereClauseForQuery(searchEntities, sqlQuery);

	// TODO: Remove the next line once this will be properly debugged
	System.out.println("Sql query produced : " + sqlQuery);

	sgbd.execute(sqlQuery, OrmActions.DELETE);
    }

    /**
     * Method used to update / change an entity
     * 
     * @param entityContainingChanges the entity that has been changed and will
     *            be in the orm
     * @param searchCriterias the criterias used by the update
     * @throws OrmException an exception that can occur into the orm
     */
    public static void update(AbstractOrmEntity entityContainingChanges,
	    Vector<String> searchCriterias) throws OrmException
    {
	String sqlQuery = "UPDATE " + prefix
		+ entityContainingChanges.getClass().getSimpleName() + " SET ";
	Hashtable<String, String> data = entityContainingChanges
		.getOrmizableData();

	sqlQuery = buildSetClauseForQuery(data, sqlQuery);
	sqlQuery = buildWhereClauseForQuery(sqlQuery, searchCriterias);

	// TODO: Remove this once it will be properly debugged
	System.out.println("Sql query produced : " + sqlQuery);

	sgbd.execute(sqlQuery, OrmActions.UPDATE);
    }

    /**
     * Uses the new where builder
     * 
     * Method used to update / change an entity
     * 
     * @param searchEntities the entities from which we will build our where
     *            clause
     * @param entityContainingChanges the changes to apply
     * @throws OrmException an exception that can occur in the orm
     */
    public static void update(Vector<AbstractOrmEntity> searchEntities,
	    AbstractOrmEntity entityContainingChanges) throws OrmException
    {
	String sqlQuery = "UPDATE " + prefix
		+ entityContainingChanges.getClass().getSimpleName() + " SET ";
	Hashtable<String, String> data = entityContainingChanges
		.getOrmizableData();

	sqlQuery = buildSetClauseForQuery(data, sqlQuery);
	sqlQuery = buildWhereClauseForQuery(searchEntities, sqlQuery);

	// TODO: Remove this once it will be properly debugged
	System.out.println("Sql query produced : " + sqlQuery);

	sgbd.execute(sqlQuery, OrmActions.UPDATE);
    }

    /**
     * Use only for complex queries. Use buildWhereClauseForQuery instead
     * 
     * Method used to build the where clause for the delete, select and update
     * methods.
     * 
     * @param sqlQuery the non-finished sqlQuery that has been produced
     * @param searchCriterias the parameters of the where clause under form of
     *            strings
     * @return sqlQuery the sqlQuery with the where statement
     */
    private static String buildWhereClauseForQuery(String sqlQuery,
	    Vector<String> searchCriterias)
    {
	sqlQuery += " WHERE ";

	// We add each string to the sqlQuery
	for (String parameter : searchCriterias)
	    sqlQuery += parameter;

	return sqlQuery + ";";
    }

    /**
     * This is the new where builder!
     * 
     * Method used to build the where clause for the query
     * 
     * @param sqlQuery the non-finished sqlQuery
     * @param searchEntities the entities used for the search
     * @return the sqlQuery
     */
    private static String buildWhereClauseForQuery(
	    Vector<AbstractOrmEntity> searchEntities, String sqlQuery)
    {
	int entityPosition = 0;
	sqlQuery += " WHERE ";

	for (AbstractOrmEntity entity : searchEntities)
	{
	    entityPosition += 1;
	    sqlQuery += "( ";

	    for (Field field : entity.getFields().getFields())
	    {
		if (field.getData() != null)
		{
		    sqlQuery += field.getShortName() + " "
			    + field.getOperator() + " '"
			    + field.getDataString() + "'";

		    sqlQuery += " AND ";
		}
	    }

	    sqlQuery = sqlQuery.substring(0, sqlQuery.length() - 4);

	    if (entity.getFields().getFields().size() < entityPosition)
		sqlQuery += " OR ";

	    sqlQuery += ")";
	}
	return sqlQuery += ";";
    }

    /**
     * Method used internally by the update method to build the set statement
     * 
     * @param data the data from the entities
     * @param sqlQuery the non-finished sqlQuery
     * @return the sqlQuery
     */
    private static String buildSetClauseForQuery(
	    Hashtable<String, String> data, String sqlQuery)
    {
	Iterator<String> keySetIterator = data.keySet().iterator();

	while (keySetIterator.hasNext())
	{
	    // Retrieve key
	    Object key = keySetIterator.next();

	    if (!key.toString().matches("PK.*"))
	    {
		sqlQuery += key.toString() + "='" + data.get(key) + "', ";
	    }
	}

	return sqlQuery.substring(0, sqlQuery.length() - 2);
    }

    /**
     * Creates the non-existent table from the modules in the database
     * 
     * @throws ModuleException an exception coming either from the module or the
     *             query wrongly builded
     * @throws OrmException an exception that can occur in the orm
     */
    public static void createNonExistentTables() throws ModuleException,
	    OrmException
    {
	Hashtable<String, String> modules = ListModule.getAllModules();

	for (String key : modules.keySet())
	{
	    try
	    {
		Module module = ListModule.getModule(key);
		Collection<AbstractOrmEntity> moduleEntities = module
			.getEntityDefinitionList().values();

		// For each entity in the list of module entities
		for (AbstractOrmEntity entity : moduleEntities)
		{
		    // Be sure to create the table only if it doesn't already
		    // exists
		    String sqlQuery = "CREATE TABLE IF NOT EXISTS ";
		    Collection<Field> fields = ((AbstractEntity) entity)
			    .getFields().getFields();

		    sqlQuery += prefix + entity.getClass().getSimpleName()
			    + " ( ";

		    // For each field into my entity
		    for (Field field : fields)
		    {
			// If it is a primary because it matches PK, else we
			// check the datatypes and match them with a datatype
			// good for the database
			if (field.getShortName().matches("PK.*"))
			{
			    sqlQuery += field.getShortName()
				    + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
			}
			else if (field instanceof FieldDouble)
			{
			    sqlQuery += field.getShortName()
				    + " DOUBLE PRECISION, ";
			}
			else if (field instanceof FieldString)
			{
			    sqlQuery += field.getShortName() + " STRING, ";
			}
			else if (field instanceof FieldBool)
			{
			    sqlQuery += field.getShortName() + " INTEGER, ";
			}
			else if (field instanceof FieldInt)
			{
			    sqlQuery += field.getShortName() + " INTEGER, ";
			}
		    }
		    sqlQuery = sqlQuery.substring(0, sqlQuery.length() - 2)
			    + " );";

		    // TODO: Remove the next line when properly debugged
		    System.out.println("Sql query produced : " + sqlQuery);

		    sgbd.execute(sqlQuery, OrmActions.CREATE);

		    sqlQuery = "";
		}
	    } catch (ModuleException e)
	    {
		// PrintStackTrace nécéssaire pour afficher l'information de
		// l'exception précédente. Il faudrait mettre l'ancien
		// stackTrace dans le nouveau
		e.printStackTrace();
		throw new ModuleException(
			"Erreur à la construction de la requête pour créer les tables : "
				+ e.getMessage());
	    }
	}
    }

    /**
     * Used to initialize the connection
     * 
     * @throws OrmException an exception that can occur in the orm
     */
    public static void connect() throws OrmException
    {
	sgbd.connect();
    }

    /**
     * Used to disconnect from the db
     * 
     * @throws OrmException an exception that can occur in the orm
     */
    public static void disconnect() throws OrmException
    {
	sgbd.disconnect();
    }
}
