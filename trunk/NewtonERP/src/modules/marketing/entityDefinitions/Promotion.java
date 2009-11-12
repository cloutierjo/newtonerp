package modules.marketing.entityDefinitions;

import java.util.Vector;

import newtonERP.module.AbstractOrmEntity;
import newtonERP.module.field.Field;
import newtonERP.module.field.FieldDate;
import newtonERP.module.field.FieldDouble;
import newtonERP.module.field.FieldInt;
import newtonERP.module.field.FieldString;
import newtonERP.module.field.Fields;
import newtonERP.viewers.viewables.PromptViewable;

/**
 * Entité d'une promotion
 * @author Gabriel
 * 
 */
public class Promotion extends AbstractOrmEntity implements PromptViewable
{
    /**
     * @throws Exception si création fail
     */
    public Promotion() throws Exception
    {
	super();
	addCurrencyFormat("budget");
	setVisibleName("Promotion");
    }

    @Override
    public Fields initFields() throws Exception
    {

	Vector<Field> fieldsInit = new Vector<Field>();
	fieldsInit.add(new FieldInt("Numéro", getPrimaryKeyName()));
	fieldsInit.add(new FieldString("Nom De La Promotion", "promotionname"));
	fieldsInit.add(new FieldDate("Date du début de la promotion",
		"startDate"));
	fieldsInit.add(new FieldDate("Date de la fin de la promotion",
		"endingDate"));
	fieldsInit.add(new FieldDouble("Budjet accordé", "budget"));
	fieldsInit.add(new FieldString("Notes de la modalité", "modality"));
	return new Fields(fieldsInit);
    }
}