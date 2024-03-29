package modules.materialResourcesManagement.entityDefinitions;

import java.util.Vector;

import modules.customerVendor.entityDefinitions.Invoice;
import newtonERP.module.AbstractOrmEntity;
import newtonERP.orm.associations.AccessorManager;
import newtonERP.orm.field.Field;
import newtonERP.orm.field.Fields;
import newtonERP.orm.field.type.FieldDate;
import newtonERP.orm.field.type.FieldInt;
import newtonERP.orm.field.type.FieldText;

/**
 * A delivery when a new Invoice (Customer or Vendor) has been generated
 * 
 * @author r3hallejo
 */
public class Shipping extends AbstractOrmEntity
{
	/**
	 * Default constructor
	 * 
	 * @throws Exception a general exception
	 */
	public Shipping() throws Exception
	{
		super();
		setVisibleName("Livraison");
		AccessorManager.addAccessor(this, new ShippingType());
		AccessorManager.addAccessor(this, new Invoice());
		AccessorManager.addAccessor(this, new Shipper());
		AccessorManager.addAccessor(this, new Location());
		AccessorManager.addAccessor(this, new ShippingStatus());
	}

	@Override
	public Fields initFields() throws Exception
	{
		Vector<Field<?>> fieldsInit = new Vector<Field<?>>();
		fieldsInit
				.add(new FieldInt("Numero de livraison", getPrimaryKeyName()));
		fieldsInit.add(new FieldInt("Facture associée", new Invoice()
				.getForeignKeyName()));
		fieldsInit.add(new FieldInt("Type de livraison", new ShippingType()
				.getForeignKeyName()));
		fieldsInit.add(new FieldDate("Date estimée de livraison",
				"estimatedShippingDate"));
		fieldsInit.add(new FieldInt("Expéditeur", new Shipper()
				.getForeignKeyName()));
		fieldsInit.add(new FieldText("Commentaire", "shippingComment", false));
		fieldsInit.add(new FieldInt("Location", new Location()
				.getForeignKeyName()));
		fieldsInit.add(new FieldInt("Status", new ShippingStatus()
				.getForeignKeyName()));
		return new Fields(fieldsInit);
	}
}
