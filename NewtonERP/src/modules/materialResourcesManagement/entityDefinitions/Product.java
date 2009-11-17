package modules.materialResourcesManagement.entityDefinitions;

import java.util.Vector;

import newtonERP.module.AbstractOrmEntity;
import newtonERP.orm.field.Field;
import newtonERP.orm.field.FieldCurrency;
import newtonERP.orm.field.FieldInt;
import newtonERP.orm.field.FieldString;
import newtonERP.orm.field.Fields;

/**
 * A product
 * 
 * @author r3hallejo
 */
public class Product extends AbstractOrmEntity
{

    /**
     * Default constructor
     * 
     * @throws Exception a general exception
     */
    public Product() throws Exception
    {
	super();
	setVisibleName("Produit");
    }

    @Override
    public Fields initFields() throws Exception
    {
	Vector<Field> fieldsInit = new Vector<Field>();
	fieldsInit.add(new FieldInt("Numero de produit", getPrimaryKeyName()));
	fieldsInit.add(new FieldString("Code de produit", "code"));
	fieldsInit.add(new FieldString("Nom de produit", "name"));
	fieldsInit.add(new FieldInt("Quantité en stock", "quantityInStock"));
	fieldsInit.add(new FieldInt("Point de commande", "reorderPoint"));
	fieldsInit.add(new FieldInt("Quantité réservé", "reservedStock"));
	fieldsInit.add(new FieldInt("Maximum en stock", "maxInStock"));
	fieldsInit.add(new FieldCurrency("Prix d'achat", "purchasingPrice"));
	fieldsInit.add(new FieldCurrency("Prix de vente", "sellingPrice"));
	return new Fields(fieldsInit);
    }

}
