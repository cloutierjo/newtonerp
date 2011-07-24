package modules.userRightModule.entityDefinitions; 
 // TODO: clean up that file

import java.util.Vector;

import newtonERP.module.AbstractOrmEntity;
import newtonERP.orm.associations.AccessorManager;
import newtonERP.orm.fields.Fields;
import newtonERP.orm.fields.field.Field;
import newtonERP.orm.fields.field.type.FieldInt;
import newtonERP.orm.fields.field.type.FieldString;

/**
 * Entity defenition class representing a user
 * 
 * @author r3hallejo cloutierJo
 */
public class User extends AbstractOrmEntity {
	// vers les entités
	// groups

	/**
	 */
	public User() {
		super();
		AccessorManager.addAccessor(this, new Groups());
		setVisibleName("Utilisateur");
	}

	@Override
	public Fields initFields() {
		Vector<Field<?>> fieldsData = new Vector<Field<?>>();
		fieldsData.add(new FieldInt("Numéro de user", getPrimaryKeyName()));
		fieldsData.add(new FieldString("Nom", "name"));
		FieldString pwd = new FieldString("Mot de passe", "password");
		pwd.setHidden(true);
		fieldsData.add(pwd);
		fieldsData.add(new FieldInt("Numéro de groupe", "groupsID"));
		return new Fields(fieldsData);
	}

	/**
	 * permet d'obtenir directement l'entity groups lie a cet user
	 * 
	 * @return le group lie
	 */
	public Groups getGroupsEntity() {
		return (Groups) getSingleAccessor("groupsID");
	}
}
