package modules.userRightModule.entityDefinitions;

import java.text.ParseException;
import java.util.Vector;

import newtonERP.module.AbstractOrmEntity;
import newtonERP.module.exception.FieldNotFoundException;
import newtonERP.module.field.Field;
import newtonERP.module.field.FieldInt;
import newtonERP.module.field.Fields;
import newtonERP.orm.Orm;
import newtonERP.orm.exceptions.OrmException;

/**
 * Entity defenition representing a group right for the users
 * @author djo
 */
public class GroupsRight extends AbstractOrmEntity
{
    private static Right rightDefinition;

    /**
     * @throws Exception remonte
     */
    public GroupsRight() throws Exception
    {
	rightDefinition = new Right();
    }

    /**
     * @param groups ID du groupe
     * @param right ID du droit
     * @throws FieldNotFoundException remonte
     * @throws ParseException an exception that can occur during parsing dates
     */
    public GroupsRight(Groups groups, Right right) throws Exception
    {
	int groupsIdValue = groups.getPrimaryKeyValue();
	int rightIdValue = right.getPrimaryKeyValue();

	getFields().setData("groupsID", groupsIdValue);
	getFields().setData("rightID", rightIdValue);
    }

    public Fields initFields()
    {
	Vector<Field> fieldsInit = new Vector<Field>();
	fieldsInit.add(new FieldInt("Numéro de groupe", "groupsID"));
	fieldsInit.add(new FieldInt("Numéro de droit", "rightID"));
	return new Fields(fieldsInit);
    }

    /**
     * permet d'obtenir directement l'entity groups lie a cet user
     * 
     * @return le group lier
     * @throws OrmException remonte
     */
    public Groups getGroupsEntity() throws Exception
    {
	Groups groupsDefinition = new Groups();

	Vector<String> search = new Vector<String>();
	search.add(groupsDefinition.getPrimaryKeyName()
		+ getFields().getField(groupsDefinition.getPrimaryKeyName()));

	return (Groups) Orm.select(new Groups(), search).get(0);
    }

    /**
     * permet d'obtenir directement l'entity Right lier a cet user
     * 
     * @return le Right lier
     * @throws Exception remonte
     */
    public Right getRightEntity() throws Exception
    {
	String rightIDValue = getFields().getField("rightID").getDataString();

	Right rightSearchEntity = new Right();
	rightSearchEntity.getFields().setData(
		rightDefinition.getPrimaryKeyName(), rightIDValue);

	return (Right) Orm.select(rightSearchEntity).get(0);
    }
}