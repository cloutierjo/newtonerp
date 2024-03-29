package modules.taskModule.actions; 
 // TODO: clean up that file

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Map.Entry;

import modules.taskModule.entityDefinitions.ActionEntity;
import modules.taskModule.entityDefinitions.EntityEntity;
import modules.taskModule.entityDefinitions.ModuleEntity;
import newtonERP.module.AbstractAction;
import newtonERP.module.AbstractEntity;
import newtonERP.sourceCodeBuilder.ActionSourceCodeBuilder;
import newtonERP.sourceCodeBuilder.EntitySourceCodeBuilder;
import newtonERP.sourceCodeBuilder.SourceCodeBuilder;
import newtonERP.viewers.viewerData.BaseViewerData;

/**
 * Cette action sert à écrire les fichiers de code source d'un module
 * 
 * @author Guillaume Lacasse
 */
public class GenerateSourceCode extends AbstractAction {
	/**
	 */
	public GenerateSourceCode() {
		super(new ModuleEntity());
	}

	@Override
	public AbstractEntity doAction(AbstractEntity entity, Hashtable<String, String> parameters) {
		ModuleEntity moduleEntity = (ModuleEntity) entity;

		String moduleClassCode;

		String moduleClassFileName = SourceCodeBuilder.buildModuleClassFileName(moduleEntity);

		BaseViewerData edit = moduleEntity.editUI(parameters);

		if(fileExists(moduleClassFileName)){
			edit.addAlertMessage("La classe du module existe déjà.");
		}else{
			Hashtable<String, String> actionFileAndCodeList = buildActionFileAndCodeList(moduleEntity);
			Hashtable<String, String> entityFileAndCodeList = buildEntityFileAndCodeList(moduleEntity);

			for(String fileName : actionFileAndCodeList.keySet()){
				if(fileExists(fileName)){
					edit.addAlertMessage("Le fichier " + fileName + " de la classe de l'action existe déjà.");
					return edit;
				}
			}

			for(String fileName : entityFileAndCodeList.keySet()){
				if(fileExists(fileName)){
					edit.addAlertMessage("Le fichier " + fileName + " de la classe de l'entité existe déjà.");
					return edit;
				}
			}

			moduleClassCode = SourceCodeBuilder.buildModuleSourceCode(moduleEntity);

			SourceCodeBuilder.createDirectoriesForModule(moduleEntity);

			writeClassFile(moduleClassFileName, moduleClassCode);
			edit.addNormalMessage("La classe du module a été générée.");

			for(String fileName : actionFileAndCodeList.keySet()){
				writeClassFile(fileName, actionFileAndCodeList.get(fileName));
			}

			for(Entry<String, String> entityFileAndCode : entityFileAndCodeList.entrySet()){
				writeClassFile(entityFileAndCode.getKey(), entityFileAndCode.getValue());
			}
		}

		return edit;
	}

	private Hashtable<String, String> buildEntityFileAndCodeList(ModuleEntity moduleEntity) {
		Hashtable<String, String> fileAndCodeList = new Hashtable<String, String>();

		String path = SourceCodeBuilder.getModulePackagePath(moduleEntity) + "/entityDefinitions";

		String fileName;
		String sourceCode;

		for(EntityEntity entityEntity : moduleEntity.getEntityEntityList()){
			fileName = path + "/" + entityEntity.getDataString("systemName") + ".java";
			sourceCode = EntitySourceCodeBuilder.build(entityEntity);
			fileAndCodeList.put(fileName, sourceCode);
		}

		return fileAndCodeList;
	}

	private Hashtable<String, String> buildActionFileAndCodeList(ModuleEntity moduleEntity) {
		Hashtable<String, String> fileAndCodeList = new Hashtable<String, String>();

		String path = SourceCodeBuilder.getModulePackagePath(moduleEntity) + "/actions";

		String fileName;
		String sourceCode;

		for(ActionEntity actionEntity : moduleEntity.getActionEntityList()){
			fileName = path + "/" + actionEntity.getDataString("systemName") + ".java";
			sourceCode = ActionSourceCodeBuilder.build(actionEntity);
			fileAndCodeList.put(fileName, sourceCode);
		}

		return fileAndCodeList;
	}

	private boolean fileExists(String moduleClassFileName) {
		File file = new File(moduleClassFileName);
		return file.exists();
	}

	/**
	 * @param fileName file name
	 * @param classCode class code
	 */
	public static void writeClassFile(String fileName, String classCode)

	{
		try{
			File file = new File(fileName);
			file.createNewFile();

			FileWriter outFile;

			outFile = new FileWriter(fileName);

			PrintWriter out = new PrintWriter(outFile);
			out.print(classCode);
			out.close();
		}catch(IOException e){
			throw new RuntimeException(e);
		}
	}
}
