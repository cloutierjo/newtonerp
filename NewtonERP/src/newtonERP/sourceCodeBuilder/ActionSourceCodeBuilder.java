package newtonERP.sourceCodeBuilder; 
 // TODO: clean up that file

import modules.taskModule.entityDefinitions.ActionEntity;
import modules.taskModule.entityDefinitions.ModuleEntity;
import newtonERP.orm.Orm;

/**
 * Build source code for action entity
 * 
 * @author Guillaume Lacasse
 */
public class ActionSourceCodeBuilder {
	/**
	 * @param actionEntity action entity
	 * @return source code
	 */
	public static String build(ActionEntity actionEntity) {
		actionEntity = (ActionEntity) Orm.getInstance().selectUnique(actionEntity);

		String sourceCode = "";

		String packageName = getPackageName(actionEntity);
		String naturalKeyName = getNaturalKeyValue(actionEntity);
		String systemName = getSystemName(actionEntity);

		sourceCode += "package modules." + packageName + ".actions;\n";
		sourceCode += "\n";
		sourceCode += "import java.util.Hashtable;\n";
		sourceCode += "import java.util.Vector;\n";
		sourceCode += "import newtonERP.module.AbstractAction;\n";
		sourceCode += "import newtonERP.module.AbstractEntity;\n";
		sourceCode += "import newtonERP.module.AbstractOrmEntity;\n";
		sourceCode += "import newtonERP.orm.Orm;\n";
		sourceCode += "import newtonERP.orm.exceptions.OrmException;\n";
		sourceCode += "import newtonERP.orm.field.Field;\n";
		sourceCode += "import newtonERP.viewers.viewerData.BaseViewerData;\n";
		sourceCode += "import newtonERP.module.generalEntity.StaticTextEntity;\n";

		sourceCode += "\n";
		sourceCode += "/**\n";
		sourceCode += " * " + naturalKeyName + "\n";
		sourceCode += " * @author NewtonERP code generator - Guillaume Lacasse\n";
		sourceCode += " */\n";
		sourceCode += "public class " + systemName + " extends AbstractAction\n";
		sourceCode += "{\n";
		sourceCode += "    @Override\n";
		sourceCode += "    public AbstractEntity doAction(AbstractEntity sourceEntity, Hashtable<String, String> parameters)\n";
		sourceCode += "    {\n";
		sourceCode += "        return new StaticTextEntity(\"Please implement action\");\n";
		sourceCode += "    }\n";
		sourceCode += "}\n";

		return sourceCode;
	}

	private static String getSystemName(ActionEntity actionEntity) {
		return actionEntity.getDataString("systemName");
	}

	private static String getNaturalKeyValue(ActionEntity actionEntity)

	{
		return actionEntity.getNaturalKeyDescription();
	}

	private static String getPackageName(ActionEntity actionEntity)

	{
		return ModuleSourceCodeBuilder.getPackageName(getModuleEntity(actionEntity));
	}

	private static ModuleEntity getModuleEntity(ActionEntity actionEntity)

	{
		ModuleEntity moduleEntity = (ModuleEntity) actionEntity.getSingleAccessor(new ModuleEntity()
		        .getForeignKeyName());

		return moduleEntity;
	}
}
