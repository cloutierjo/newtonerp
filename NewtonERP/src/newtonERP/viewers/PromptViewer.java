package newtonERP.viewers;

import java.util.Vector;

import newtonERP.module.AbstractOrmEntity;
import newtonERP.module.BaseAction;
import newtonERP.module.generalEntity.FlagPool;
import newtonERP.module.generalEntity.ListOfValue;
import newtonERP.module.generalEntity.ScrollList;
import newtonERP.serveur.Servlet;
import newtonERP.viewers.viewables.PromptViewable;

/**
 * Represents the prompt viewer
 * @author Guillaume Lacasse, Pascal Lemay
 */
public class PromptViewer
{
    /**
     * Return the html code for the web page
     * @param entity the entity to view
     * @return html
     * @throws Exception general exception
     */
    @SuppressWarnings("null")
    public static String getHtmlCode(PromptViewable entity) throws Exception
    {
	AbstractOrmEntity ormEntity = null;
	System.out.println("getHtmlCode() (prompt viewer)");
	String html = "";

	String formActionUrl = Servlet.makeLink(entity.getCurrentModule(),
		entity.getCurrentAction());

	if (entity.getBackLinkUrl() != null)
	    html += "<p><a href=\"" + entity.getBackLinkUrl() + "\"> < "
		    + entity.getBackLinkName() + "</a></p>";

	html += "<h2>" + entity.getPromptMessage() + "</h2>";

	if (entity instanceof AbstractOrmEntity)
	{
	    ormEntity = (AbstractOrmEntity) (entity);
	    // if (ormEntity.getPrimaryKeyValue() != 0)
	    formActionUrl += "?" + ormEntity.getPrimaryKeyName() + "="
		    + ormEntity.getPrimaryKeyValue();
	}

	html += "<form method=\"post\" action=\"" + formActionUrl + "\">";

	html += "<table>";

	String inputValue;
	String textFieldType;

	for (String inputName : entity.getOrderedFieldNameList())
	{
	    String isReadOnly = "";
	    inputValue = entity.getInputValue(inputName);

	    ListOfValue listOfValue = entity.tryMatchListOfValue(inputName);

	    if (entity instanceof AbstractOrmEntity
		    && inputName.equals(ormEntity.getPrimaryKeyName()))
		isReadOnly = "DISABLED";

	    if (listOfValue == null)
	    {
		if (entity.isFieldHidden(inputName))
		    textFieldType = "password";
		else
		    textFieldType = "text";

		html += "\n<tr><td>" + entity.getLabelName(inputName)
			+ ": </td><td><input type=\"" + textFieldType
			+ "\" name=\"" + inputName + "\" value=\"" + inputValue
			+ "\" class=\"textField\" " + isReadOnly
			+ "></td></tr>";
	    }
	    else
	    {
		html += "<tr><td>"
			+ SelectBoxViewer.getHtmlCode(listOfValue, inputName,
				inputValue) + "</td></tr>";
	    }
	}

	if (entity instanceof AbstractOrmEntity)
	    for (FlagPool flagPool : entity.getPositiveFlagPoolList().values())
	    {
		flagPool.query(ormEntity.getPrimaryKeyName(), ormEntity
			.getPrimaryKeyValue());
		html += "<tr><td colspan=\"2\">"
			+ CheckListViewer.getHtmlCode(flagPool) + "</td></tr>";
	    }

	if (entity.getAlertMessageList() != null)
	    for (String message : entity.getAlertMessageList())
		html += "<p class=\"errorMessage\">" + message + "</p>";

	if (entity.getNormalMessageList() != null)
	    for (String message : entity.getNormalMessageList())
		html += "<p class=\"normalMessage\">" + message + "</p>";

	if (entity instanceof AbstractOrmEntity)
	{
	    html += getSingleAccessorLinkList((AbstractOrmEntity) entity);
	    html += getMultipleAccessorLinkList((AbstractOrmEntity) entity);
	}

	html += "<tr><td colspan=\"2\" align=\"center\"><input type=\"submit\" name=\"submit\" value=\""
		+ entity.getButtonCaption() + "\"></td></tr>";
	html += "</table>";

	html += "</form>";

	return html;
    }

    private static String getMultipleAccessorLinkList(AbstractOrmEntity entity)
	    throws Exception
    {
	String html = "";

	Vector<AbstractOrmEntity> pluralAccessor;

	ScrollList scrollList;

	for (String accessorName : entity.getPluralAccessorList().keySet())
	{
	    pluralAccessor = entity.getPluralAccessorList().get(accessorName);

	    if (pluralAccessor.size() > 0)
	    {
		scrollList = new ScrollList(pluralAccessor.get(0)
			.getVisibleName()
			+ "(s)");

		for (AbstractOrmEntity currentForeignEntity : pluralAccessor)
		{
		    scrollList.setTitleUrl(Servlet.makeLink(
			    currentForeignEntity.getCurrentModule(),
			    new BaseAction("GetList", currentForeignEntity)));

		    scrollList.addLink(currentForeignEntity
			    .getNaturalKeyDescription(), Servlet.makeLink(
			    currentForeignEntity.getCurrentModule(),
			    new BaseAction("Edit", currentForeignEntity))
			    + "?"
			    + currentForeignEntity.getPrimaryKeyName()
			    + "=" + currentForeignEntity.getPrimaryKeyValue());
		}
		html += "<tr><td>"
			+ ScrollListViewer.getHtmlContent(scrollList)
			+ "</td></tr>";
	    }
	}

	return html;
    }

    private static String getSingleAccessorLinkList(AbstractOrmEntity entity)
	    throws Exception
    {
	String html = "";

	ScrollList scrollList = new ScrollList("Est associé à");

	AbstractOrmEntity foreignEntity;
	for (String accessorName : entity.getSingleAccessorList().keySet())
	{
	    foreignEntity = entity.getSingleAccessorList().get(accessorName);

	    String listLinkName = foreignEntity.getVisibleName();

	    String entityLinkName = foreignEntity.getNaturalKeyDescription();

	    String entityUrl = Servlet.makeLink(foreignEntity
		    .getCurrentModule(), new BaseAction("Edit", foreignEntity))
		    + "?"
		    + foreignEntity.getPrimaryKeyName()
		    + "="
		    + foreignEntity.getPrimaryKeyValue();

	    String listUrl = Servlet.makeLink(foreignEntity.getCurrentModule(),
		    new BaseAction("GetList", foreignEntity));

	    scrollList.addLinkGroup(listLinkName, listUrl, entityLinkName,
		    entityUrl);
	}

	if (entity.getSingleAccessorList().size() > 0)
	    html += "<tr><td>" + ScrollListViewer.getHtmlContent(scrollList)
		    + "</td></tr>";

	return html;
    }
}
