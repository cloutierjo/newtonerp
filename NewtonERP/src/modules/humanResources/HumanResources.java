package modules.humanResources;

import modules.humanResources.entityDefinitions.Department;
import modules.humanResources.entityDefinitions.Employee;
import newtonERP.module.BaseAction;
import newtonERP.module.Module;

public class HumanResources extends Module
{

    /**
     * @throws Exception
     */
    public HumanResources() throws Exception
    {
	super();
	// setDefaultAction(new BaseAction("GetList", new Employee()));
	addGlobalActionMenuItem("Employés ", new BaseAction("GetList",
		new Employee()));
	addGlobalActionMenuItem("Départements", new BaseAction("GetList",
		new Department()));
    }

    @Override
    public String getVisibleName()
    {
	return "Ressources humaines";
    }

}
