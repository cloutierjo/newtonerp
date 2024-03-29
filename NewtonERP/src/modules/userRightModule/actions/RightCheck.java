package modules.userRightModule.actions; 
 // TODO: clean up that file

import java.util.Hashtable;
import java.util.Vector;

import modules.userRightModule.entityDefinitions.Right;
import modules.userRightModule.entityDefinitions.User;
import newtonERP.module.AbstractAction;
import newtonERP.module.AbstractEntity;
import newtonERP.module.AbstractOrmEntity;
import newtonERP.orm.Orm;
import newtonERP.orm.associations.PluralAccessor;

/**
 * Action class that checks the right on an entity
 * 
 * @author cloutierJo
 */

@SuppressWarnings("deprecation")
public class RightCheck extends AbstractAction {
	@Override
	public AbstractEntity doAction(AbstractEntity entity, Hashtable<String, String> parameters) {
		Vector<String> search = new Vector<String>();
		search.add("name='" + parameters.get("name") + "'");

		Vector<AbstractOrmEntity> userList = Orm.getInstance().select(new User(), search);

		if(userList.size() < 1){
			return null;
		}

		User user = (User) userList.get(0);

		Right searchEntity = new Right();
		searchEntity.setData("moduleName", parameters.get("module"));
		searchEntity.setData("actionName", parameters.get("action"));
		if(parameters.get("entity") != null){
			searchEntity.setData("entityName", parameters.get("entity"));
		}

		PluralAccessor rightList = user.getGroupsEntity().getPluralAccessor("Right", searchEntity);

		if(rightList.size() > 0){
			return rightList.get(0);
		}
		return null;
	}
}
