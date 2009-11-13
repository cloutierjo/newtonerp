package modules.taskModule.entityDefinitions;

import java.util.Vector;

import newtonERP.module.AbstractOrmEntity;
import newtonERP.orm.field.Field;
import newtonERP.orm.field.FieldBool;
import newtonERP.orm.field.FieldInt;
import newtonERP.orm.field.FieldString;
import newtonERP.orm.field.FieldText;
import newtonERP.orm.field.Fields;
import newtonERP.viewers.viewables.PromptViewable;

/**
 * entité représentant une task
 * @author Guillaume Lacasse
 * 
 */
public class Task extends AbstractOrmEntity implements PromptViewable
{
    /**
     * @throws Exception si création fail
     */
    public Task() throws Exception
    {
	super();
	setVisibleName("Tâche automatisée");
	addNaturalKey(getPrimaryKeyName());
	addNaturalKey("name");
    }

    @Override
    public Fields initFields() throws Exception
    {
	Vector<Field> fieldList = new Vector<Field>();

	fieldList.add(new FieldInt("Numéro", getPrimaryKeyName()));
	fieldList.add(new FieldBool("Est active", "isActive"));

	new FieldBool("Est active", "isActive", true);

	fieldList.add(new FieldString("Description courte", "name"));
	fieldList.add(new FieldText("Description longue", "description"));
	return new Fields(fieldList);
    }
}
