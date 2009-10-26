package newtonERP.module;

import java.util.Hashtable;
import java.util.Vector;

import modules.userRightModule.entityDefinitions.User;
import newtonERP.module.field.Field;
import newtonERP.module.field.Fields;
import newtonERP.orm.Orm;
import newtonERP.orm.exceptions.OrmException;

/**
 * @author cloutierJo
 * 
 */
public abstract class AbstractOrmEntity extends AbstractEntity
{
    private Hashtable<String, ListOfValue> listOfValueList;

    private Module currentModule;

    private AbstractAction currentAction;

    // oblige le redefinition pour les sous-classe de AbstractOrmEntity
    public abstract Fields initFields();

    /**
     * @return data ormizable
     */
    public final Hashtable<String, String> getOrmizableData()
    {
	return getFields().getHashTableFrom();
    }

    /**
     * @param parameters la hashTable de parametre qui sera transphormé en
     *            entity
     */
    public final void setOrmizableData(Hashtable<String, Object> parameters)
    {
	getFields().setFromHashTable(parameters);
    }

    /**
     * BaseAction New
     * 
     * @param parameters parametre suplementaire
     * @return todo: qu'Est-ce que l'on devrai retourné en general?
     * @throws Exception remonte
     */
    public abstract AbstractEntity newUI(Hashtable<String, String> parameters)
	    throws Exception;

    /**
     * enregistre l'entity en DB
     * 
     * @return this
     * @throws OrmException remonte
     */
    public final AbstractEntity newE() throws OrmException
    {
	Orm.insert(this);
	return this;
    }

    /**
     * BaseAction Delete
     * 
     * @param parameters parametre suplementaire
     * @return todo: qu'Est-ce que l'on devrai retourné en general?
     * @throws Exception remonte
     */
    public AbstractEntity deleteUI(Hashtable<String, String> parameters)
	    throws Exception
    {
	delete(getPrimaryKeyName() + "='" + getDataString(getPrimaryKeyName())
		+ "'");

	return getAfterDeleteReturnEntity();
    }

    /**
     * @return Entité retournée après effacement de cette entité
     * @throws Exception remonte
     */
    public abstract AbstractEntity getAfterDeleteReturnEntity()
	    throws Exception;

    /**
     * supprime l'entity en DB
     * 
     * @param whereClause the where clause for the query
     * 
     * @return this
     * @throws OrmException remonte
     */
    public final AbstractEntity delete(String whereClause) throws OrmException
    {
	Vector<String> whereParameter = new Vector<String>();
	whereParameter.add(whereClause);
	Orm.delete(this, whereParameter);

	return this; // todo: that a completly non-sense -> r3hallejo dit MDR,
	// true
    }

    /**
     * BaseAction Edit
     * 
     * @param parameters parametre suplementaire
     * @return todo: qu'Est-ce que l'on devrai retourné en general?
     * @throws Exception remonte
     */
    public abstract AbstractEntity editUI(Hashtable<String, String> parameters)
	    throws Exception;

    /**
     * met a jour l'entity en DB, l'ID doit etre présent
     * 
     * @param whereClause the where clause for the query
     * @return this
     * @throws OrmException remonte
     */
    public final AbstractEntity edit(String whereClause) throws OrmException
    {
	Vector<String> whereParameter = new Vector<String>();
	whereParameter.add(whereClause);
	Orm.update(this, whereParameter);

	return this;
    }

    /**
     * BaseAction Get
     * 
     * @param parameters parametre suplementaire
     * @return todo: qu'Est-ce que l'on devrai retourné en general?
     * @throws InvalidOperatorException if a wrong operator is set for the field
     *             datatype public abstract AbstractEntity
     *             getUI(Hashtable<String, String> parameters) throws
     *             InvalidOperatorException;
     */

    /**
     * trouve l'entity selon les critere disponible, retourne le premier trouve
     * 
     * @param whereClause the where clause for the query
     * @return this
     * @throws OrmException remonte
     */
    public final Vector<AbstractOrmEntity> get(String whereClause)
	    throws OrmException
    {
	Vector<AbstractOrmEntity> retUserList = null;
	Vector<String> whereParameter = new Vector<String>();
	whereParameter.add(whereClause);
	retUserList = Orm.select(new User(), whereParameter);

	return retUserList;
    }

    /**
     * @param entities the entities from which we are going to select our data
     *            (where clause)
     * @return the selected entities
     * @throws OrmException remonte
     */
    public final Vector<AbstractOrmEntity> get(
	    Vector<AbstractOrmEntity> entities) throws OrmException
    {
	Vector<AbstractOrmEntity> retEntities = null;
	retEntities = Orm.select(entities);

	return retEntities;
    }

    /**
     * @param entity
     * @return the selected entities
     * @throws OrmException remonte
     */
    public final Vector<AbstractOrmEntity> get(AbstractOrmEntity entity)
	    throws OrmException
    {
	Vector<AbstractOrmEntity> entities = new Vector<AbstractOrmEntity>();
	entities.add(entity);
	return get(entities);
    }

    /**
     * @return liste de KeyValuePair de fields et de leur valeurs
     * @throws OrmException remonte
     */
    public final Hashtable<String, String> getInputList() throws OrmException
    {
	return getFields().getHashTableFrom();
    }

    /**
     * @param inputName nom d'un field
     * @return nom complete d'un field
     */
    public final String getLabelName(String inputName)
    {
	return getFields().getField(inputName).getName();
    }

    /**
     * @return Nom de la clef primaire
     */
    public final String getPrimaryKeyName()
    {
	String firstLetter = (getClass().getSimpleName().charAt(0) + "")
		.toLowerCase();

	return "PK" + firstLetter + getClass().getSimpleName().substring(1)
		+ "ID";
    }

    /**
     * @return Valeur de la clef primaire
     */
    public final String getPrimaryKeyValue()
    {
	String primaryKeyName = getPrimaryKeyName();
	Fields fields = getFields();
	Field field = fields.getField(primaryKeyName);

	if (field == null)
	    return null;

	String value = field.getDataString();
	return value;
    }

    /**
     * Implémentation par default
     * @return Caption par default d'un bouton de modification pour cette entité
     */
    public String getButtonCaption()
    {
	return "Enregistrer";
    }

    /**
     * Implémentation par default pouvant être overridée dans l'entité
     * @return Description
     */
    public String getPromptMessage()
    {
	return "Profil d'un " + getClass().getSimpleName();
    }

    /**
     * @param currentModule Défini le module utilisé en ce moment pour cette
     *            entité
     */
    public final void setCurrentModule(Module currentModule)
    {
	this.currentModule = currentModule;
    }

    public final AbstractAction getCurrentAction()
    {
	return currentAction;
    }

    public final Module getCurrentModule()
    {
	return currentModule;
    }

    /**
     * @param currentAction Action qui sera utilisée
     */
    public final void setCurrentAction(AbstractAction currentAction)
    {
	this.currentAction = currentAction;
    }

    /**
     * @param labelName
     * @param fieldKeyName
     * @param foreignDescriptionKey
     * @param foreignEntity
     */
    public final void addListOfValue(String labelName, String fieldKeyName,
	    String foreignDescriptionKey, AbstractOrmEntity foreignEntity)
    {
	ListOfValue listOfValue = new ListOfValue(labelName, foreignEntity
		.getPrimaryKeyName(), foreignDescriptionKey, foreignEntity);

	if (listOfValueList == null)
	    listOfValueList = new Hashtable<String, ListOfValue>();

	listOfValueList.put(fieldKeyName, listOfValue);
    }

    /**
     * @param fieldKeyName
     * @return If list of value exist, return it, else, return null
     */
    public ListOfValue tryMatchListOfValue(String fieldKeyName)
    {
	if (listOfValueList == null)
	    return null;

	return listOfValueList.get(fieldKeyName);
    }
}