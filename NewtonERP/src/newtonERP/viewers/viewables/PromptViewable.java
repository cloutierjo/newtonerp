package newtonERP.viewers.viewables;

import java.util.Hashtable;

import newtonERP.module.AbstractAction;
import newtonERP.module.EntityException;
import newtonERP.module.Module;
import newtonERP.orm.exceptions.OrmException;

/**
 * @author r3lacasgu
 * 
 */
public interface PromptViewable
{
    /**
     * @return Module callé par le prompt
     * @throws EntityException
     */
    public Module getSubmitModule() throws EntityException;

    /**
     * @return Utilisateur actuel Cette methode sera effacée au sprint 2 car
     *         l'autentification sera faite dans le servlet
     */
    public String getCurrentUserName();

    /**
     * @return Action à affectuer quand on submit le prompt
     * @throws EntityException
     */
    public AbstractAction getSubmitAction() throws EntityException;

    /**
     * @return message du prompt, exemple: quel est votre nom?
     */
    public String getPromptMessage();

    /**
     * @return nom des input du prompt et leur valeur actuelles
     */
    public Hashtable<String, String> getInputList() throws OrmException;

    /**
     * @return nom du bouton "ok"
     */
    public String getButtonCaption();
}