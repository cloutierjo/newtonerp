package newtonERP.viewers.viewerData;

import newtonERP.module.AbstractEntity;

/**
 * Modèle d'un selecteur de page
 * @author Guillaume
 */
public class PageSelector extends AbstractEntity
{
    private String currentUrl;
    private int currentLimit;
    private int pageCount;
    private int currentOffset;
    private int totalRowCount;

    /**
     * @throws Exception si ça fail
     */
    public PageSelector() throws Exception
    {
	super();
	// TODO Auto-generated constructor stub
	currentLimit = 15;
	pageCount = 100;
    }

    /**
     * @param rowPerPage row per page
     * @param pageCount page count
     * @throws Exception si ça fail
     */
    public PageSelector(int limit, int offset, int totalRowCount,
	    String currentUrl) throws Exception
    {
	this.totalRowCount = totalRowCount;
	currentLimit = limit;
	currentOffset = offset;
	pageCount = (int) Math
		.ceil((double) (totalRowCount) / (double) (limit));
	this.currentUrl = currentUrl;
    }

    /**
     * @return nombre de pages
     */
    public int getPageCount()
    {
	return pageCount;
    }

    /**
     * @return nombre maximum de rangée par page
     */
    public int getCurrentLimit()
    {
	return currentLimit;
    }

    /**
     * @return url
     */
    public String getCurrentUrl()
    {
	return currentUrl;
    }

    /**
     * @return offset
     */
    public int getCurrentOffset()
    {
	return currentOffset;
    }

    /**
     * @return nombre total de rangée
     */
    public int getTotalRowCount()
    {
	return totalRowCount;
    }
}
