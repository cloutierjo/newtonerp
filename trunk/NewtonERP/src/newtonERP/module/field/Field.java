package newtonERP.module.field;

import newtonERP.module.exception.FieldNotCompatibleException;
import newtonERP.module.exception.InvalidOperatorException;

/**
 * @author djo, r3hallejo
 * 
 *         Super class for entity fields used in the modules
 */
public abstract class Field
{
    private String name; // Name is the name that will be visible by the
			 // end-user
    private String shortName; // Short name is the name that will be used
			      // internally

    /**
     * default constructor
     */
    @SuppressWarnings("unused")
    private Field()
    {
	// on ne doit pas pouvoir initialiser un Field sans son name etshortName
    }

    /**
     * constructeur minimum
     * 
     * @param data donne du champ
     * @param name nom du champ qui sera visible par l'utilisateur
     * @param shortName nom du champ qui sera utiliser a l'interne
     */
    public Field(String name, String shortName)
    {
	this.name = name;
	// TODO: validate that shortName are really shortName
	this.shortName = shortName;
    }

    /**
     * @return the name
     */
    public String getName()
    {
	return name;
    }

    /**
     * @return the shortName
     */
    public String getShortName()
    {
	return shortName;
    }

    /**
     * @return the data
     */
    public abstract String getDataString();

    /**
     * @return the data
     */
    public abstract Object getData();

    /**
     * @param data the data to set
     */
    public abstract void setData(String data);

    /**
     * @param data the data to set
     * @throws FieldNotCompatibleException si le type ne correspond pas avec le
     *             champ demande
     */
    public abstract void setData(Object data)
	    throws FieldNotCompatibleException;

    /**
     * Validation on operators will be done in the fields types
     * 
     * @param operator the operator to set in the field
     * @throws InvalidOperatorException if an operator is wrong for the data
     *             type
     */
    public abstract void setOperator(String operator)
	    throws InvalidOperatorException;

    /**
     * @return the operator
     */
    public abstract String getOperator();

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj)
    {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (!(obj instanceof Field))
	    return false;
	Field other = (Field) obj;
	if (name == null)
	{
	    if (other.name != null)
		return false;
	}
	else if (!name.equals(other.name))
	    return false;
	if (shortName == null)
	{
	    if (other.shortName != null)
		return false;
	}
	else if (!shortName.equals(other.shortName))
	    return false;
	return true;
    }
}
