package newtonERP.orm.associations;

import java.util.Collection;
import java.util.Hashtable;

import newtonERP.module.AbstractOrmEntity;
import newtonERP.module.generalEntity.FlagPool;
import newtonERP.orm.Orm;

/**
 * Cette classe gère les comportement d'association d'entités fates par le
 * FlagPool
 * @author Guillaume
 */
public class FlagPoolManager
{
    /**
     * @param flagPoolList liste de FlagPool
     * @param parameters paramêtres (mêmes type que dans doAction
     * @throws Exception
     */
    public static void applyFlagPoolChanges(AbstractOrmEntity sourceEntity,
	    Iterable<FlagPool> flagPoolList,
	    Hashtable<String, String> parameters) throws Exception
    {
	for (FlagPool flagPool : flagPoolList)
	    applyFlagPoolChanges(sourceEntity, flagPool, parameters);
    }

    private static void applyFlagPoolChanges(AbstractOrmEntity sourceEntity,
	    FlagPool flagPool, Hashtable<String, String> parameters)
	    throws Exception
    {
	flagPool.query(sourceEntity.getPrimaryKeyName(), sourceEntity
		.getPrimaryKeyValue());

	Collection<String> availableElementList = flagPool
		.getAvailableElementList().values();

	for (String availableElement : availableElementList)
	{

	    AbstractOrmEntity searchEntity = getSearchEntity(sourceEntity,
		    flagPool, availableElement);

	    if (parameters.containsKey(availableElement))
	    {
		Orm.insertUnique(searchEntity);
	    }
	    else
	    {
		Orm.delete(searchEntity);
	    }

	}

	flagPool.query(sourceEntity.getPrimaryKeyName(), sourceEntity
		.getPrimaryKeyValue());

    }

    private static AbstractOrmEntity getSearchEntity(
	    AbstractOrmEntity sourceEntity, FlagPool flagPool,
	    String elementName) throws Exception
    {
	if (elementName.contains("."))
	{
	    elementName = elementName.substring(
		    elementName.lastIndexOf('.') + 1).trim();
	}

	int keyIn = sourceEntity.getPrimaryKeyValue();
	int keyOut = Integer.parseInt(elementName);

	String intermediateKeyInName = flagPool.getIntermediateKeyIn();
	String intermediateKeyOutName = flagPool.getIntermediateKeyOut();

	AbstractOrmEntity searchEntity = flagPool
		.getIntermediateEntityDefinition().getClass().newInstance();
	searchEntity.setData(intermediateKeyInName, keyIn);
	searchEntity.setData(intermediateKeyOutName, keyOut);
	return searchEntity;
    }
}