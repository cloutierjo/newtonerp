package newtonERP.module;

import java.util.Hashtable;

/**
 * @author r3lacasgu cloutierJo
 * 
 *         Class representing an abstract action
 */
public abstract class AbstractAction
{
    private AbstractEntity entityUsable;
    private Module ownedByModul;

    protected AbstractAction()
    {
	entityUsable = null;
    }

    /**
     * Default constructor for the action
     * 
     * @param entityUsable le type d'entité qui sera utiliser par la methode
     */
    protected AbstractAction(AbstractEntity entityUsable)
    {
	this.entityUsable = entityUsable;
    }

    /**
     * Abstract method that will be used to perform the actions FIXME : Why is
     * it throwing a ModuleException when it shooting this exception?
     * 
     * @param parameters list de parametre utilisable par l'action, une partie
     *            d'entre eux sera transforme en entite
     * @return l,entite resultante de l'action
     * @throws Exception remonte
     */
    public final AbstractEntity perform(Hashtable<String, String> parameters)
	    throws Exception
    {

	AbstractEntity entity = null;
	try
	{
	    entity = entityUsable.getClass().newInstance();
	    entity.getFields().setFromHashTable(parameters);
	} catch (NullPointerException e)
	{
	    // ne rien faire si cette exception est lancé, laissé le bloc
	    // présent
	}
	return doAction(entity, parameters);
    }

    /**
     * Abstract method that will be reused by all the actions
     * 
     * @param entity entite a utiliser a l'intérieur du doAction
     * @param parameters list de parametre autre que l'entite
     * @return l'entite resultante
     * @throws Exception
     */
    protected abstract AbstractEntity doAction(AbstractEntity entity,
	    Hashtable<String, String> parameters) throws Exception;

    /**
     * @return the entityUsable
     */
    public AbstractEntity getEntityUsable()
    {
	return entityUsable;
    }

    /**
     * @param ownedByModul the ownedByModul to set
     */
    public void setOwnedByModul(Module ownedByModul)
    {
	this.ownedByModul = ownedByModul;
    }

    /**
     * @return the ownedByModul
     */
    public Module getOwnedByModul()
    {
	return ownedByModul;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (!(obj instanceof AbstractAction))
	    return false;
	AbstractAction other = (AbstractAction) obj;
	if (entityUsable == null)
	{
	    if (other.entityUsable != null)
		return false;
	}
	else if (!entityUsable.equals(other.entityUsable))
	    return false;
	if (ownedByModul == null)
	{
	    if (other.ownedByModul != null)
		return false;
	}
	else if (!ownedByModul.equals(other.ownedByModul))
	    return false;
	return true;
    }

}