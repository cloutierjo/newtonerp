package modules.userRightModule.entityDefinitions;

import java.util.Hashtable;

import newtonERP.orm.Ormizable;
import newtonERP.orm.exceptions.OrmFieldNotFoundException;
import newtonERP.viewers.ProfileViewable;

public class UserType implements Ormizable, ProfileViewable
{

    @Override
    public Hashtable<String, String> getOrmizableData()
	    throws OrmFieldNotFoundException
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public int getPrimaryKeyValue()
    {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public String getSearchCriteria()
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public String getTableName()
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void setOrmizableData(Hashtable<String, Object> parameters)
    {
	// TODO Auto-generated method stub

    }

}
