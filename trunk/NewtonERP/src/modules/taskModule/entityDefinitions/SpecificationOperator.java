package modules.taskModule.entityDefinitions;

import java.util.Hashtable;
import java.util.Vector;

import newtonERP.module.AbstractEntity;
import newtonERP.module.AbstractOrmEntity;
import newtonERP.module.field.Field;
import newtonERP.module.field.FieldInt;
import newtonERP.module.field.FieldString;
import newtonERP.module.field.Fields;
import newtonERP.module.generalEntity.EntityList;
import newtonERP.viewers.viewables.PromptViewable;

/**
 * Opérateur de spécification (et, ou etc...)
 * @author Guillaume Lacasse
 */
public class SpecificationOperator extends AbstractOrmEntity implements
	PromptViewable
{

    /**
     * @throws Exception si création fail
     */
    public SpecificationOperator() throws Exception
    {
	super();
	setVisibleName("Opérateur");
    }

    @Override
    public Fields initFields() throws Exception
    {
	Vector<Field> fieldList = new Vector<Field>();
	fieldList.add(new FieldInt("Numéro", getPrimaryKeyName()));
	fieldList.add(new FieldString("Nom", "name"));
	return new Fields(fieldList);
    }

    @Override
    public AbstractEntity deleteUI(Hashtable<String, String> parameters)
	    throws Exception
    {
	/*
	 * On ne veut pas permettre l'effacement d'opérateur alors on redirige
	 * l'effacement vers GetList
	 */
	EntityList entityList = (EntityList) super.getList();
	return entityList;
    }

    @Override
    public AbstractEntity editUI(Hashtable<String, String> parameters)
	    throws Exception
    {
	/*
	 * On ne veut pas permettre la modification d'opérateur alors on
	 * redirige vers GetList
	 */
	EntityList entityList = (EntityList) super.getList();
	return entityList;
    }

    @Override
    public final AbstractEntity getList(Hashtable<String, String> parameters)
	    throws Exception
    {
	// On ne veut pas permettre l'effacement ni la modification d'opérateur
	// alors on enlève les
	// bouton Delete et Modifier en passant son nom de caption en argument
	EntityList entityList = (EntityList) super.getList(parameters);
	entityList.removeSpecificActionButton("Effacer");
	entityList.removeSpecificActionButton("Modifier");
	return entityList;
    }
}