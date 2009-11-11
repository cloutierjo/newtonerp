package modules.materialResourcesManagement.entityDefinitions;

import java.util.Vector;

import newtonERP.module.AbstractOrmEntity;
import newtonERP.module.field.Field;
import newtonERP.module.field.FieldDouble;
import newtonERP.module.field.FieldInt;
import newtonERP.module.field.Fields;
import newtonERP.viewers.viewables.PromptViewable;

/**
 * A longitude coordinate of a location
 * 
 * @author r3hallejo
 */
public class Longitude extends AbstractOrmEntity implements PromptViewable
{

    /**
     * Default constructor
     * 
     * @throws Exception a general exception
     */
    public Longitude() throws Exception
    {
	super();
	addNaturalKey("degrees");
	addNaturalKey("minutes");
	addNaturalKey("seconds");
    }

    @Override
    public Fields initFields() throws Exception
    {
	Vector<Field> fieldsInit = new Vector<Field>();
	fieldsInit.add(new FieldInt("Numero", getPrimaryKeyName()));
	fieldsInit.add(new FieldInt("Degrés", "degrees"));
	fieldsInit.add(new FieldInt("Minutes", "minutes"));
	fieldsInit.add(new FieldDouble("Secondes", "seconds"));
	return new Fields(fieldsInit);
    }

}