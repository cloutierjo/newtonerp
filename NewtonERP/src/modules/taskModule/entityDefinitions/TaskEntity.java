package modules.taskModule.entityDefinitions; 
 // TODO: clean up that file

import java.util.Hashtable;
import java.util.Vector;

import newtonERP.module.AbstractEntity;
import newtonERP.module.AbstractOrmEntity;
import newtonERP.orm.associations.AccessorManager;
import newtonERP.orm.fields.Fields;
import newtonERP.orm.fields.field.Field;
import newtonERP.orm.fields.field.type.FieldBool;
import newtonERP.orm.fields.field.type.FieldInt;

/**
 * entité représentant une task
 * 
 * @author Guillaume Lacasse
 */
public class TaskEntity extends AbstractOrmEntity {
	/**
	 */
	public TaskEntity() {
		super();
		setVisibleName("Tâche automatisée");
		AccessorManager.addAccessor(this, new Specification());
		AccessorManager.addAccessor(this, new EffectEntity());
	}

	@Override
	public Fields initFields() {
		FieldInt specification = new FieldInt("Specification", new Specification().getForeignKeyName());
		specification.setNaturalKey(true);

		FieldInt effet = new FieldInt("Effet", new EffectEntity().getForeignKeyName());
		effet.setNaturalKey(true);

		Vector<Field<?>> fieldList = new Vector<Field<?>>();
		fieldList.add(new FieldInt("Numéro", getPrimaryKeyName()));
		fieldList.add(new FieldBool("Est active", "isActive"));
		fieldList.add(new FieldBool("Recherche directe", "straightSearch"));
		fieldList.add(specification);
		fieldList.add(effet);
		return new Fields(fieldList);
	}

	/**
	 * @param entityParameters paramètres de l'entité
	 * @param isStraightSearch si c'est une recherche directe
	 * @return true si la spécification de la tâche est satisfaite
	 */
	public boolean isSatisfied(Hashtable<String, String> entityParameters, boolean isStraightSearch) {
		return getSpecification().isSatisfied(entityParameters, isStraightSearch);
	}

	private Specification getSpecification() {
		return (Specification) getSingleAccessor(new Specification().getForeignKeyName());
	}

	/**
	 * Execute l'effet de la tâche
	 * 
	 * @param entityParameters paramètres de l'entité
	 * @param isStraightSearch si c'est une recherche directe
	 * @return entité viewable, résultat de la tâche
	 */
	public AbstractEntity execute(Hashtable<String, String> entityParameters, boolean isStraightSearch) {
		return getEffect().execute(entityParameters, isStraightSearch);
	}

	private EffectEntity getEffect() {
		return (EffectEntity) getSingleAccessor(new EffectEntity().getForeignKeyName());
	}

	/**
	 * @return si la tâche est présentement active
	 */
	public boolean isActive() {
		return (Boolean) (getData("isActive"));
	}

	/**
	 * @return si c'est une recherche directe
	 */
	public boolean isStraightSearch() {
		return (Boolean) (getData("straightSearch"));
	}
}
