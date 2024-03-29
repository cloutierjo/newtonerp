package newtonERP.viewers.secondStep; 
 // TODO: clean up that file

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import newtonERP.viewers.Viewer;
import newtonERP.viewers.viewerData.PageSelector;

/**
 * Sert à voir les liste de pages
 * 
 * @author Guillaume Lacasse
 */
public class PageSelectorViewer {

	/**
	 * @param pageSelector selecteur de page
	 * @return code html
	 */
	public static String getHtmlCode(PageSelector pageSelector)

	{
		String html = "";

		html += "<div class=\"PageSelector\">";

		int pageCount = pageSelector.getPageCount();
		int limit = pageSelector.getCurrentLimit();
		int offset = pageSelector.getCurrentOffset();
		String searchEntry = pageSelector.getCurrentSearchEntry();
		String orderBy = pageSelector.getOrderBy();
		try{
			searchEntry = URLEncoder.encode(searchEntry, Viewer.getEncoding());
			orderBy = URLEncoder.encode(orderBy, Viewer.getEncoding());
		}catch(UnsupportedEncodingException e){
			throw new RuntimeException(e);
		}

		if(offset > 0){
			html += "<a href='" + pageSelector.getCurrentUrl() + "?limit=" + limit + "&amp;offset=" + (offset - limit)
			        + "&amp;searchEntry=" + searchEntry + "&amp;orderBy=" + orderBy
			        + "'><img src='/file/images/blueLeftArrow.gif' alt='gauche' style='border:0px' /></a>";
		}else{
			html += "<img src='/file/images/blackLeftArrow.gif' alt='gauche' />";
		}

		for(int linkCounter = 0; linkCounter < pageCount; linkCounter++){
			int currentLinkOffset = limit * linkCounter;

			if(currentLinkOffset != offset){
				html += " <a href='" + pageSelector.getCurrentUrl() + "?limit=" + limit + "&amp;offset=" + linkCounter
				        * limit + "&amp;searchEntry=" + searchEntry + "&amp;orderBy=" + orderBy + "'>";
			}else{
				html += " ";
			}

			html += (linkCounter + 1);

			if(currentLinkOffset != offset){
				html += "</a>";
			}
		}

		if(offset + limit < pageSelector.getTotalRowCount()){
			html += " <a href='" + pageSelector.getCurrentUrl() + "?limit=" + limit + "&amp;offset=" + (offset + limit)
			        + "&amp;searchEntry=" + searchEntry + "&amp;orderBy=" + orderBy
			        + "'><img src='/file/images/blueRightArrow.gif' alt='droit' style='border:0px' /></a>";
		}else{
			html += " <img src='/file/images/blackRightArrow.gif' alt='droit' />";
		}

		html += "</div>";

		return html;
	}
}
