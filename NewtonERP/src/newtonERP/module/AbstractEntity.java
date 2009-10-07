package newtonERP.module;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Hashtable;

/**
 * @author r3lemaypa, r3lacasgu, CloutierJo
 * 
 */
public class AbstractEntity
{

    /**
     * @param parameters Hashtable de parametre
     */
    public void getEntityFromHashTable(Hashtable<String, String> parameters)
    {
	String setName;
	Method methode;
	try
	{
	    for (String key : parameters.keySet())
	    {
		setName = "set" + key.substring(0, 1).toUpperCase()
			+ key.substring(1);
		methode = getClass().getMethod(
			setName,
			new Class[] { getClass().getDeclaredField(key)
				.getType() });

		if (getClass().getDeclaredField(key).getType()
			.equals(int.class))
		    methode.invoke(this, new Object[] { Integer
			    .parseInt(parameters.get(key)) });
		else
		    methode.invoke(this, new Object[] { parameters.get(key) });
	    }
	} catch (IllegalArgumentException e)
	{
	    throw new IllegalArgumentException(
		    "le type d'argument ne peut etre gere");
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
    }

    /**
     * @return Hashtable contenant chaqu'un des champ
     */
    public Hashtable<String, String> getHashTableFromEntity()
    {
	Field[] fields = getClass().getDeclaredFields();
	String getName;
	String value;
	Hashtable<String, String> hash = new Hashtable<String, String>();
	try
	{
	    for (int i = 0; i < fields.length; i++)
	    {
		getName = "get"
			+ fields[i].getName().substring(0, 1).toUpperCase()
			+ fields[i].getName().substring(1);
		value = getClass().getMethod(getName, null).invoke(this, null)
			.toString();
		hash.put(fields[i].getName(), value);
	    }
	} catch (Exception e)
	{
	    e.printStackTrace();
	}

	return hash;
    }

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
	if (!(getClass().isInstance(obj)))
	    return false;

	// vérification field a field
	Field[] fields = getClass().getDeclaredFields();
	String getName;
	String value1;
	String value2;
	try
	{
	    for (int i = 0; i < fields.length; i++)
	    {
		getName = "get"
			+ fields[i].getName().substring(0, 1).toUpperCase()
			+ fields[i].getName().substring(1);
		value1 = getClass().getMethod(getName, null).invoke(this, null)
			.toString();
		value2 = getClass().getMethod(getName, null).invoke(this, null)
			.toString();
		if (!value1.equals(value2))
		    return false;
	    }
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
	return true;
    }
}