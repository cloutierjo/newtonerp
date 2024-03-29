package modules.marketing.entityDefinitions;

import java.util.Vector;

import newtonERP.module.AbstractOrmEntity;
import newtonERP.orm.associations.AccessorManager;
import newtonERP.orm.field.Field;
import newtonERP.orm.field.Fields;
import newtonERP.orm.field.type.FieldCurrency;
import newtonERP.orm.field.type.FieldDate;
import newtonERP.orm.field.type.FieldInt;
import newtonERP.orm.field.type.FieldString;
import newtonERP.orm.field.type.FieldText;

/**
 * Entité d'une promotion
 * @author Gabriel
 * 
 */
public class Promotion extends AbstractOrmEntity
{
	/**
	 * @throws Exception si création fail
	 */
	public Promotion() throws Exception
	{
		super();
		setVisibleName("Promotion");
		AccessorManager.addAccessor(this, new Sector());
	}

	@Override
	public Fields initFields() throws Exception
	{

		Vector<Field<?>> fieldsInit = new Vector<Field<?>>();
		fieldsInit.add(new FieldInt("Numéro", getPrimaryKeyName()));
		fieldsInit.add(new FieldString("Nom De La Promotion", "promotionname"));
		fieldsInit.add(new FieldDate("Date du début de la promotion",
				"startDate"));
		fieldsInit.add(new FieldDate("Date de la fin de la promotion",
				"endingDate"));
		// Gab: est-ce ce field que tu veux rendre read-only? car tu ne le met
		// pas readonly
		fieldsInit.add(new FieldCurrency("Budjet accordé", "budget"));
		fieldsInit.add(new FieldText("Notes de la modalité", "modality"));
		fieldsInit
				.add(new FieldInt("Secteur", new Sector().getForeignKeyName()));
		return new Fields(fieldsInit);
	}
}
