package newtonERP.module.field;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Date field for entities
 * 
 * @author r3hallejo
 */
public class FieldTime extends FieldDateTime
{
    private static SimpleDateFormat dateFormatter = new SimpleDateFormat(
	    "HH:mm");

    /**
     * constructeur minimum
     * 
     * @param name nom du champ qui sera visible par l'utilisateur
     * @param shortName nom du champ qui sera utiliser a l'interne
     * @param data donne du champ
     */
    public FieldTime(String name, String shortName, GregorianCalendar data)
    {
	super(name, shortName, data);
    }

    /**
     * @param name nom du champ qui sera visible par l'utilisateur
     * @param shortName nom du champ qui sera utiliser a l'interne
     */
    public FieldTime(String name, String shortName)
    {
	super(name, shortName);
    }

    @Override
    public void setData(String date) throws ParseException
    {
	GregorianCalendar tempDate = new GregorianCalendar();
	tempDate.setTime(dateFormatter.parse(date));
	data = tempDate;
    }

    @Override
    public String getDataString(Boolean forOrm)
    {
	// TODO : Remove this code if no bug is reported with this class
	// if (data == null)
	// data = new GregorianCalendar();
	if (forOrm)
	    return super.getDataString(forOrm);
	if (data == null)
	    return null;
	return dateFormatter.format(data.getTime());
    }
}
