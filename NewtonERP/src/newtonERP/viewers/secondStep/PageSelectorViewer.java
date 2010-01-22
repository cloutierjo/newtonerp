package newtonERP.viewers.secondStep;

import java.net.URLEncoder;

import newtonERP.viewers.Viewer;
import newtonERP.viewers.viewerData.PageSelector;

/**
 * Sert à voir les liste de pages
 * @author Guillaume Lacasse
 */
public class PageSelectorViewer
{

    /**
     * @param pageSelector selecteur de page
     * @return code html
     * @throws Exception si ça fail
     */
    public static String getHtmlCode(PageSelector pageSelector)
	    throws Exception
    {
	String html = "";

	int pageCount = pageSelector.getPageCount();
	int limit = pageSelector.getCurrentLimit();
	int offset = pageSelector.getCurrentOffset();
	String searchEntry = pageSelector.getCurrentSearchEntry();

	searchEntry = URLEncoder.encode(searchEntry, Viewer.getEncoding());

	if (offset > 0)
	    html += "<a href='" + pageSelector.getCurrentUrl() + "?limit="
		    + limit + "&offset=" + (offset - limit) + "&searchEntry="
		    + searchEntry + "'>&lt;</a>";
	else
	    html += "&lt;";

	for (int linkCounter = 0; linkCounter < pageCount; linkCounter++)
	{
	    int currentLinkOffset = limit * linkCounter;

	    if (currentLinkOffset != offset)
		html += " <a href='" + pageSelector.getCurrentUrl() + "?limit="
			+ limit + "&offset=" + linkCounter * limit
			+ "&searchEntry=" + searchEntry + "'>";
	    else
		html += " ";

	    html += (linkCounter + 1);

	    if (currentLinkOffset != offset)
		html += "</a>";
	}

	if (offset + limit < pageSelector.getTotalRowCount())
	    html += " <a href='" + pageSelector.getCurrentUrl() + "?limit="
		    + limit + "&offset=" + (offset + limit) + "&searchEntry="
		    + searchEntry + "'>&gt;</a>";
	else
	    html += " &gt;";

	return html;
    }
}
