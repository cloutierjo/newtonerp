package modules.materialResourcesManagement.entityDefinitions;

import java.util.Vector;

import newtonERP.module.AbstractOrmEntity;
import newtonERP.module.field.Field;
import newtonERP.module.field.FieldInt;
import newtonERP.module.field.FieldString;
import newtonERP.module.field.Fields;
import newtonERP.viewers.viewables.PromptViewable;

/**
 * A product
 * 
 * @author r3hallejo
 */
public class Product extends AbstractOrmEntity implements PromptViewable
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
	return new Fields(fieldsInit);
    }

}