package modules.customerVendor.entityDefinitions;

import java.util.Vector;

import newtonERP.module.AbstractOrmEntity;
import newtonERP.orm.field.Field;
import newtonERP.orm.field.Fields;
import newtonERP.orm.field.type.FieldBool;
import newtonERP.orm.field.type.FieldDouble;
import newtonERP.orm.field.type.FieldInt;
import newtonERP.orm.field.type.FieldString;

/**
 * A tax entity
 * 
 * @author r3hallejo
 */
public class Tax extends AbstractOrmEntity
{
	/**
	 * Default constructor
	 * 
	 * @throws Exception a general exception
	 */
	public Tax() throws Exception
	{
		super();
		setVisibleName("Taxes");
	}

	@Override
	public Fields initFields() throws Exception
	{
		Vector<Field<?>> fieldsInit = new Vector<Field<?>>();
		fieldsInit.add(new FieldInt("Numero", getPrimaryKeyName()));
		fieldsInit.add(new FieldString("Nom", "name"));
		fieldsInit.add(new FieldString("Code", "code"));
		fieldsInit.add(new FieldDouble("Valeur en %", "value"));
		fieldsInit.add(new FieldBool("Type Fédéral", "isFederalTax"));
		fieldsInit.add(new FieldBool("Type Provincial", "isStateTax"));
		return new Fields(fieldsInit);
	}

}
