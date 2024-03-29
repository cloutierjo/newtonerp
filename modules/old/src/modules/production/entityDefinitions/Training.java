package modules.production.entityDefinitions;

import java.util.Vector;

import newtonERP.module.AbstractOrmEntity;
import newtonERP.orm.associations.AccessorManager;
import newtonERP.orm.field.Field;
import newtonERP.orm.field.Fields;
import newtonERP.orm.field.type.FieldInt;
import newtonERP.orm.field.type.FieldText;

/**
 * A general training
 * 
 * @author r3hallejo
 */
public class Training extends AbstractOrmEntity
{
	/**
	 * Default constructor
	 * 
	 * @throws Exception a general exception
	 */
	public Training() throws Exception
	{
		super();
		setVisibleName("Formation");
		AccessorManager.addAccessor(this, new TrainingType());
		AccessorManager.addAccessor(this, new ProductionProject());
	}

	@Override
	public Fields initFields() throws Exception
	{
		Vector<Field<?>> fieldsInit = new Vector<Field<?>>();
		fieldsInit.add(new FieldInt("Numero", getPrimaryKeyName()));
		fieldsInit.add(new FieldInt("Projet associé", new ProductionProject()
				.getForeignKeyName()));
		fieldsInit.add(new FieldInt("Type de formation", new TrainingType()
				.getForeignKeyName()));
		fieldsInit.add(new FieldText("Description", "description", true));
		return new Fields(fieldsInit);
	}
}
