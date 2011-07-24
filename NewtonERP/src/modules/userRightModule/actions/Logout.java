package modules.userRightModule.actions; 
 // TODO: clean up that file

import java.util.Hashtable;

import newtonERP.common.Authentication;
import newtonERP.module.AbstractAction;
import newtonERP.module.AbstractEntity;
import newtonERP.module.generalEntity.StaticTextEntity;

/**
 * action permettant de ce delogguer
 * 
 * @author GLacasse
 */
public class Logout extends AbstractAction {
	/**
	 * Constructeur
	 */
	public Logout() {
		setDetailedDescription("fermer votre session de manière sécuritaire");
	}

	@Override
	public AbstractEntity doAction(AbstractEntity entity, Hashtable<String, String> parameters) {
		Authentication.setCurrentUserName(null);

		return new StaticTextEntity("Au revoir!");
	}

}
