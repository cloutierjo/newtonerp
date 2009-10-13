package modules.userRightModule.actions;

import java.util.Hashtable;
import java.util.Vector;

import modules.userRightModule.entityDefinitions.GroupRight;
import newtonERP.module.AbstractAction;
import newtonERP.module.AbstractEntity;
import newtonERP.orm.Orm;
import newtonERP.orm.Ormizable;
import newtonERP.orm.exceptions.OrmException;

/**
 * @author Gabriel Therrien
 * 
 * 	Action class used to edit a group right
 */
public class EditGroupRight extends AbstractAction
{

    @Override
    public AbstractEntity doAction(AbstractEntity entity,
	    Hashtable<String, String> parameters)
    {
	Vector<String> whereParameter = new Vector<String>();
	whereParameter.add("RightID="
		+ ((GroupRight) entity).getRightID());
	try
	{
	    Orm.update((Ormizable) entity, whereParameter);
	} catch (OrmException e)
	{
	    e.printStackTrace();
	}
	return null;
    }
}