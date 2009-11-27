package newtonERP.orm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

import newtonERP.common.ListModule;
import newtonERP.module.AbstractEntity;
import newtonERP.module.AbstractOrmEntity;
import newtonERP.module.Module;
import newtonERP.module.exception.ModuleException;
import newtonERP.orm.exceptions.OrmException;
import newtonERP.orm.field.Field;
import newtonERP.orm.field.Fields;
import newtonERP.orm.field.type.FieldBool;
import newtonERP.orm.field.type.FieldDateTime;
import newtonERP.orm.field.type.FieldDouble;
import newtonERP.orm.field.type.FieldInt;
import newtonERP.orm.field.type.FieldString;
import newtonERP.orm.sgbd.SgbdSqlite;
import newtonERP.orm.sgbd.Sgbdable;

/**
 * Basic class for the orm. It is used to put the objects in the databse using
 * SqLite3 and its java binding. The orm will receive an entity from which the
 * orm will perform various tasks such as generating the query and executing it
 * obviously. Then it's gonna send the query to the SgbdSqlite class to execute
 * it.
 * 
 * http://www.sqlite.org/lang_keywords.html
 * 
 * TODO: Drop a module (maybe a an array of the entities to drop?)
 * 
 * @author r3hallejo, r3lacasgu
 */
public class Orm
{
    private static Sgbdable sgbd = new SgbdSqlite();
    private static String prefix = "Newton_";

    /**
     * Alter table
     * 
     * @param entity the entity containing the new field
     * @param field the field to add
     * @return ?
     * @throws OrmException an exception that can occur in the orm
     */
    public static ResultSet addColumnToTable(AbstractOrmEntity entity,
	    Field<?> field) throws OrmException
    {
	String sqlQuery = "ALTER TABLE " + prefix + entity.getSystemName()
		+ " ADD COLUMN ";

	if (field instanceof FieldDouble)
	{
	    sqlQuery += " " + field.getShortName() + " DOUBLE PRECISION;";
	}
	else if (field instanceof FieldString || field instanceof FieldDateTime)
	{
	    sqlQuery += " " + field.getShortName() + " STRING;";
	}
	else if (field instanceof FieldBool || field instanceof FieldInt)
	{
	    sqlQuery += " " + field.getShortName() + " INTEGER;";
	}

	// TODO: Remove the next line when it will be properly debugged
	System.out.println("SQL query produced : " + sqlQuery);

	return sgbd.execute(sqlQuery, OrmActions.OTHER);

	// todo: mettre une valeur par defaut dans la colone ajoute
    }

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
		+ searchEntity.getSystemName();

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
		+ searchEntities.get(0).getSystemName();

	if (!searchEntities.isEmpty())
	    sqlQuery += buildWhereClauseForQuery(searchEntities) + ";";

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
     * Select. Use only if you are sure that it will return only 1 entity (or
     * that you want the first entity)
     * 
     * @param searchEntity the entity from which we will perform our search
     * @return the first entity from the result set
     * @throws OrmException an exception that can occur in the orm
     */
    public static AbstractOrmEntity selectUnique(AbstractOrmEntity searchEntity)
	    throws OrmException
    {
	return select(searchEntity).get(0);
    }

    /**
     * Select. Use only if you are sure that it will return only 1 entity (or
     * that you want the first entity)
     * 
     * @param searchEntities the entity from which we will perform our search
     * @return the first entity from the result set
     * @throws OrmException an exception that can occur in the orm
     */
    public static AbstractOrmEntity selectUnique(
	    Vector<AbstractOrmEntity> searchEntities) throws OrmException
    {
	return select(searchEntities).get(0);
    }

    /**
     * Method used to insert an entity in the databse based into the entity
     * passed in parameter
     * 
     * @param newEntity the entity to be inserted
     * @return valeur de a cle primaire
     * @throws Exception si insertion fail
     */
    @SuppressWarnings("unchecked")
    public static int insert_temp(AbstractOrmEntity newEntity) throws Exception
    {
	String sqlQuery = "INSERT INTO " + prefix + newEntity.getSystemName()
		+ " (";
	String valuesQuery = " VALUES (";

	// We now iterate through the data so we can add the fields to the query
	Iterator dataIterator = newEntity.getFields().iterator();
	while (dataIterator.hasNext())
	{
	    // Retrieve key
	    Field<?> field = (Field) dataIterator.next();
	    if (!dataIterator.hasNext())
	    {
		if (field.getCalcul() == null)
		{
		    if (!field.getShortName().matches("PK.*")
			    && field.getData() != null)
		    {
			sqlQuery += "'" + field.getShortName() + "') ";
			valuesQuery += "'" + field.getDataString(true) + "') ";
		    }
		    else
		    {
			sqlQuery = sqlQuery.substring(0, sqlQuery.length() - 2);
			sqlQuery += ")";

			valuesQuery = valuesQuery.substring(0, valuesQuery
				.length() - 2);
			valuesQuery += ");";
		    }
		}
		else
		{
		    sqlQuery = sqlQuery.substring(0, sqlQuery.length() - 2);
		    sqlQuery += ")";

		    valuesQuery = valuesQuery.substring(0,
			    valuesQuery.length() - 2);
		    valuesQuery += ");";
		}
	    }
	    else
	    {
		if (field.getCalcul() == null)
		{
		    if (!field.getShortName().matches("PK.*")
			    && field.getData() != null)
		    {
			sqlQuery += "'" + field.getShortName() + "', ";
			valuesQuery += "'" + field.getDataString(true) + "', ";
		    }
		}
		else
		{
		    sqlQuery = sqlQuery.substring(0, sqlQuery.length() - 2);
		    sqlQuery += ")";

		    valuesQuery = valuesQuery.substring(0,
			    valuesQuery.length() - 2);
		    valuesQuery += ");";
		}
	    }
	}

	sqlQuery += valuesQuery;

	// TODO: Remove the next line once this will be properly debugged
	System.out.println("SQL query produced : " + sqlQuery);

	ResultSet rs = sgbd.execute(sqlQuery, OrmActions.INSERT);

	try
	{
	    return rs.getInt(1);
	} catch (SQLException e)
	{
	    // s'il n'y a pas de cle primaire dans cette table, on ne throw donc
	    // pas cette exception
	    return 0;
	}
    }

    /**
     * Method used to insert an entity in the databse based into the entity
     * passed in parameter
     * 
     * @param newEntity the entity to add
     * @return le id de clé primaire ajoutée
     * @throws OrmException an exception that can occur in the orm
     */
    public static int insert(AbstractOrmEntity newEntity) throws OrmException
    {
	String sqlQuery = "INSERT INTO " + prefix + newEntity.getSystemName()
		+ "( ";

	Iterator<?> keyIterator = newEntity.getFields().iterator();

	while (keyIterator.hasNext())
	{
	    Field<?> field = (Field<?>) keyIterator.next();

	    if (!field.getShortName().matches("PK.*"))
	    {
		if (field.getCalcul() == null && field.getData() != null)
		{
		    sqlQuery += "'" + field.getShortName() + "', ";
		}
	    }

	}

	sqlQuery = sqlQuery.substring(0, sqlQuery.length() - 2);
	sqlQuery += ") VALUES (";

	Iterator<?> dataIterator = newEntity.getFields().iterator();

	while (dataIterator.hasNext())
	{
	    Field<?> field = (Field<?>) dataIterator.next();

	    if (!field.getShortName().matches("PK.*"))
	    {
		if (field.getCalcul() == null && field.getData() != null)
		{
		    sqlQuery += "'" + field.getDataString(true) + "', ";
		}
	    }
	}

	sqlQuery = sqlQuery.substring(0, sqlQuery.length() - 2);
	sqlQuery += ");";

	// TODO: Remove the next line once this will be properly debugged
	System.out.println("SQL query produced : " + sqlQuery);

	ResultSet rs = sgbd.execute(sqlQuery, OrmActions.INSERT);

	try
	{
	    return rs.getInt(1);
	} catch (SQLException e)
	{
	    // s'il n'y a pas de cle primaire dans cette table, on ne throw donc
	    // pas cette exception
	    return 0;
	}
    }

    /**
     * Insert an entity if no entity matches current field
     * 
     * @param newUniqueEntity New unique entity to insert
     * @throws Exception si insertion fail
     */
    public static void insertUnique(AbstractOrmEntity newUniqueEntity)
	    throws Exception
    {
	if (select(newUniqueEntity).size() < 1)
	    insert(newUniqueEntity);
    }

    /**
     * Method used to delete an entity from the database
     * 
     * @param searchEntity the entity to be researched
     * @param searchCriterias the search criterias for the where clause
     * @throws Exception si effacement fail
     */
    public static void delete(AbstractOrmEntity searchEntity,
	    Vector<String> searchCriterias) throws Exception
    {
	String sqlQuery = "DELETE FROM " + prefix
		+ searchEntity.getSystemName();

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
     * @throws Exception si effacement fail
     */
    public static void delete(Vector<AbstractOrmEntity> searchEntities)
	    throws Exception
    {
	String sqlQuery = "DELETE FROM " + prefix
		+ searchEntities.get(0).getSystemName();

	sqlQuery += buildWhereClauseForQuery(searchEntities) + ";";

	// TODO: Remove the next line once this will be properly debugged
	System.out.println("Sql query produced : " + sqlQuery);

	sgbd.execute(sqlQuery, OrmActions.DELETE);
    }

    /**
     * Using new where builder
     * 
     * Method used to delete an entity from the database
     * 
     * @param searchEntity the entity from which we will build our where
     * @throws Exception si effacement fail
     */
    public static void delete(AbstractOrmEntity searchEntity) throws Exception
    {
	Vector<AbstractOrmEntity> searchEntities = new Vector<AbstractOrmEntity>();
	searchEntities.add(searchEntity);
	delete(searchEntities);
    }

    /**
     * Method used to update / change an entity
     * 
     * @param entityContainingChanges the entity that has been changed and will
     *            be in the orm
     * @param searchCriterias the criterias used by the update
     * @throws Exception si update fail
     */
    public static void update(AbstractOrmEntity entityContainingChanges,
	    Vector<String> searchCriterias) throws Exception
    {
	String sqlQuery = "UPDATE " + prefix
		+ entityContainingChanges.getSystemName() + " SET ";

	sqlQuery = buildSetClauseForQuery(entityContainingChanges.getFields(),
		sqlQuery);
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
     * @throws Exception si update fail
     */
    public static void update(Vector<AbstractOrmEntity> searchEntities,
	    AbstractOrmEntity entityContainingChanges) throws Exception
    {
	String sqlQuery = "UPDATE " + prefix
		+ entityContainingChanges.getSystemName() + " SET ";

	sqlQuery = buildSetClauseForQuery(entityContainingChanges.getFields(),
		sqlQuery);
	sqlQuery += buildWhereClauseForQuery(searchEntities) + ";";

	// TODO: Remove this once it will be properly debugged
	System.out.println("Sql query produced : " + sqlQuery);

	sgbd.execute(sqlQuery, OrmActions.UPDATE);
    }

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
    public static void updateUnique(AbstractOrmEntity searchEntity,
	    AbstractOrmEntity entityContainingChanges) throws Exception
    {
	String sqlQuery = "UPDATE " + prefix
		+ entityContainingChanges.getSystemName() + " SET ";

	sqlQuery = buildSetClauseForQuery(entityContainingChanges.getFields(),
		sqlQuery);
	sqlQuery = buildWhereClauseForQuery(searchEntity, sqlQuery);

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
	sqlQuery += " WHERE ( ";

	// We add each string to the sqlQuery
	for (String parameter : searchCriterias)
	    sqlQuery += parameter;

	return sqlQuery + " );";
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
	    Vector<AbstractOrmEntity> searchEntities)
    {
	String whereClause = "";
	int entityPosition = 0;
	boolean addedCriteriaToWhereCondition = false;
	whereClause += " WHERE ";

	for (AbstractOrmEntity entity : searchEntities)
	{
	    // Si les fields de
	    // cette entité
	    // ne contiennent que des null
	    if (!entity.getFields().containsValues())
		continue;

	    entityPosition += 1;
	    whereClause += "( ";

	    for (Field<?> field : entity.getFields().getFields())
	    {
		if (field.getCalcul() == null && field.getData() != null)
		{
		    whereClause += field.getShortName() + " "
			    + field.getOperator() + " '"
			    + field.getDataString(true) + "'";

		    whereClause += " AND ";
		}
	    }

	    whereClause = whereClause.substring(0, whereClause.length() - 4);

	    if (entity.getFields().getFields().size() < entityPosition)
		whereClause += " OR ";

	    whereClause += ")";
	    // au moins un field était
	    // utilisable donc on cré
	    // un where
	    addedCriteriaToWhereCondition = true;
	}

	if (addedCriteriaToWhereCondition)
	    return whereClause; // On retourne la clause du where car elle n'est
	// pas vide
	return "";// Sinon, aucune clause where ne doit être ajoutée
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
	    AbstractOrmEntity searchEntity, String sqlQuery)
    {
	sqlQuery += " WHERE ( ";

	for (Field<?> field : searchEntity.getFields().getFields())
	{
	    if (field.getCalcul() == null && field.getData() != null)
	    {
		sqlQuery += field.getShortName() + " " + field.getOperator()
			+ " '" + field.getDataString(true) + "'";

		sqlQuery += " AND ";
	    }
	}

	sqlQuery = sqlQuery.substring(0, sqlQuery.length() - 4);

	return sqlQuery += ");";
    }

    /**
     * Method used internally by the update method to build the set statement
     * 
     * @param fields the data from the entities
     * @param sqlQuery the non-finished sqlQuery
     * @return the sqlQuery
     */
    private static String buildSetClauseForQuery(Fields fields, String sqlQuery)
    {
	Iterator<Field<?>> dataIterator = fields.iterator();

	while (dataIterator.hasNext())
	{
	    // Retrieve key
	    Field<?> data = dataIterator.next();
	    if (!data.getShortName().matches("PK.*")
		    && data.getCalcul() == null && data.getData() != null)
	    {
		sqlQuery += data.getShortName() + "='"
			+ data.getDataString(true) + "', ";
	    }
	}

	return sqlQuery.substring(0, sqlQuery.length() - 2);
    }

    /**
     * Creates the non-existent table from the modules in the database
     * @throws Exception remonte
     */
    public static void createNonExistentTables() throws Exception
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
		    Collection<Field<?>> fields = ((AbstractEntity) entity)
			    .getFields().getFields();

		    sqlQuery += prefix + entity.getSystemName() + " ( ";

		    // For each field into my entity
		    for (Field<?> field : fields)
		    {
			// If it is a primary because it matches PK, else we
			// check the datatypes and match them with a datatype
			// good for the database
			// TODO : Jo je ne comprend pas pourquoi tu fesait ca,
			// bref ca buggait car il arrivait sur le if, ce n'était
			// pas vrai alors il n'insérait aucun champs. Svp dire
			// c'est quoi tu veut faire. La je l'ai enlevé, anyway
			// ca sert a rien de faire un if avec aucun traitement
			// non?
			if (field.getCalcul() != null)
			{
			    // do not do anything
			}
			else if (field.getShortName().matches("PK.*"))
			{
			    sqlQuery += field.getShortName()
				    + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
			}
			else if (field instanceof FieldDouble)
			{
			    sqlQuery += field.getShortName()
				    + " DOUBLE PRECISION, ";
			}
			else if (field instanceof FieldString
				|| field instanceof FieldDateTime)
			{
			    sqlQuery += field.getShortName() + " STRING, ";
			}
			else if (field instanceof FieldBool
				|| field instanceof FieldInt)
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

    /**
     * To execute a custom query
     * 
     * @param sqlQuery the executed
     * @throws Exception si exécution fail
     */
    public static void executeCustomQuery(String sqlQuery) throws Exception
    {
	sgbd.execute(sqlQuery, OrmActions.OTHER);
    }
}
