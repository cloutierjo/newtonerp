package newtonERP.orm;

import java.util.Hashtable;

import newtonERP.module.IEntity;
import newtonERP.orm.exceptions.OrmFieldNotFoundException;

/**
 * 
 * @author r3lacasgu, r3hallejo
 * 
 *         Interface representing the methods that every entity should
 *         implements in order for the orm to be able to save it in the database
 *         or do any other actions
 */
public interface Ormizable extends IEntity
{
    /**
     * Method used to format the entitie so the orm can save them
     * 
     * @return an Hastable of data
     * @throws OrmFieldNotFoundException
     */
    public Hashtable<String, String> getOrmizableData()
	    throws OrmFieldNotFoundException;

    /**
     * Method used to return a table name
     * 
     * @return the table name
     */
    public String getTableName();

    /**
     * Method used to return the primary key value of an Entity
     * 
     * @return the primary key value (an autoincrement value)
     */
    public int getPrimaryKeyValue();

    /**
     * Method used to return the search criterias generated by the views
     * 
     * @return the search criterias
     */
    public String getSearchCriteria();
}
