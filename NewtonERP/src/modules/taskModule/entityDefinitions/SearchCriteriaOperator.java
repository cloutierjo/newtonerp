package modules.taskModule.entityDefinitions;

// TODO: clean up that file

import java.util.Hashtable;
import java.util.Vector;

import newtonERP.module.AbstractEntity;
import newtonERP.module.AbstractOrmEntity;
import newtonERP.orm.fields.Fields;
import newtonERP.orm.fields.field.Field;
import newtonERP.orm.fields.field.FieldFactory;
import newtonERP.orm.fields.field.FieldType;
import newtonERP.viewers.viewerData.BaseViewerData;
import newtonERP.viewers.viewerData.ListViewerData;

/**
 * Opérateur de critère de recherche
 * 
 * @author Guillaume Lacasse
 */
public class SearchCriteriaOperator extends AbstractOrmEntity {
	/**
	 */
	public SearchCriteriaOperator() {
		super();
		setVisibleName("Opérateur");
	}

	@Override
	public Fields initFields() {
		Vector<Field> fieldList = new Vector<Field>();
		fieldList.add(FieldFactory.newField(FieldType.STRING, "name"));
		return new Fields(fieldList);
	}

	@Override
	public AbstractEntity deleteUI(Hashtable<String, String> parameters)

	{
		/*
		 * On ne veut pas permettre l'effacement d'opérateur alors on redirige l'effacement vers GetList
		 */
		ListViewerData entityList = super.getList();
		return entityList;
	}

	@Override
	public BaseViewerData editUI(Hashtable<String, String> parameters)

	{
		/*
		 * On ne veut pas permettre la modification d'opérateur alors on redirige vers GetList
		 */
		ListViewerData entityList = super.getList();
		return entityList;
	}

	@Override
	public final ListViewerData getList(Hashtable<String, String> parameters)

	{
		ListViewerData entityList = super.getList(parameters);
		return entityList;
	}

	/**
	 * @return opérateur en string
	 */
	public String getOperator() {
		return getDataString("name");
	}
}
