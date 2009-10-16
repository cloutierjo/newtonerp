package modules.userRightModule.actions;

import java.util.Hashtable;
import java.util.Vector;

import modules.userRightModule.entityDefinitions.User;
import modules.userRightModule.entityDefinitions.UserList;
import newtonERP.module.AbstractAction;
import newtonERP.module.AbstractEntity;
import newtonERP.orm.Orm;
import newtonERP.orm.Ormizable;
import newtonERP.orm.exceptions.OrmException;

/**
 * @author r3hallejo, r3lacasgu
 * 
 *         Action class that returns the user list
 */
public class GetUserList extends AbstractAction
{
    public AbstractEntity doAction(AbstractEntity entity,
	    Hashtable<String, String> parameters)
    {
	Vector<Ormizable> userVectorFromOrm;

	try
	{
	    userVectorFromOrm = Orm.select(new User(), null);

	} catch (OrmException e)
	{
	    userVectorFromOrm = new Vector<Ormizable>();
	    e.printStackTrace();
	}

	UserList userList = new UserList();

	for (Ormizable user : userVectorFromOrm)
	    userList.addUser((User) (user));

	return userList;
    }
}
