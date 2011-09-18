package newtonERP.orm.fields;

// TODO: clean up that file

import java.util.Vector;

import newtonERP.orm.fields.field.Field;

/**
 * Version non-persistante de fields. Marche exactement comme fields sauf qu'on peut modifier les field apres
 * instanciation et on ne peut les utiliser avec l'Orm
 * 
 * @author Guillaume Lacasse, CloutierJo
 */
public class VolatileFields extends Fields {
	/**
	 * default constructor
	 */
	public VolatileFields() {
		super();
	}

	/**
	 * @param fields une liste de champ a inclure dans le Fields
	 */
	public VolatileFields(Vector<Field> fields) {
		super(fields);
	}

	/**
	 * @param field field à ajouter ou remplacer s'il existe
	 */
	public void add(Field field) {
		// fieldsDataMap.put(field.getSystemName(), field);
	}
}
