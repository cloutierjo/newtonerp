package newtonERP.viewers.viewerData;

import java.util.Vector;

import newtonERP.common.ActionLink;

/**
 * Représente un département dans une compagnie
 * @author Guillaume
 */
public class GridViewerData extends BaseViewerData
{
    private GridCaseData[] header = new GridCaseData[0];
    private GridCaseData[] leftHeader = new GridCaseData[0];
    private GridCaseData[][] cases = new GridCaseData[0][0];
    private Vector<ActionLink> specificActionButtonList = new Vector<ActionLink>();
    private boolean color = false;
    private boolean spanSimilar = false;

    /**
     * @throws Exception si création fails
     */
    public GridViewerData() throws Exception
    {
	super();
    }

    /**
     * @return the header
     * @throws Exception remonte
     */
    public GridCaseData[] getHeader() throws Exception
    {
	return header;
    }

    /**
     * @param header the header to set
     */
    public void setHeader(GridCaseData[] header)
    {
	this.header = header;
    }

    /**
     * @return the leftHeader
     */
    public GridCaseData[] getLeftHeader()
    {
	return leftHeader;
    }

    /**
     * @param leftHeader the leftHeader to set
     */
    public void setLeftHeader(GridCaseData[] leftHeader)
    {
	this.leftHeader = leftHeader;
    }

    /**
     * @return the cases
     * @throws Exception remonte
     */
    public GridCaseData[][] getCases() throws Exception
    {
	return cases;
    }

    /**
     * @param cases the cases to set
     */
    public void setCases(GridCaseData[][] cases)
    {
	this.cases = cases;
    }

    /**
     * permet d'obtenir les action specifique
     * @return liste de specificAction
     */
    public Vector<ActionLink> getSpecificActionButtonList()
    {
	return specificActionButtonList;
    }

    /**
     * @param specificActionButtonList the specificActionButtonList to set
     */
    public void setSpecificActionButtonList(
	    Vector<ActionLink> specificActionButtonList)
    {
	this.specificActionButtonList = specificActionButtonList;
    }

    /**
     * @param actionLink action du bouton
     */
    public void addSpecificActionButtonList(ActionLink actionLink)
    {
	specificActionButtonList.add(actionLink);
    }

    /**
     * @return the color
     */
    public boolean isColor()
    {
	return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(boolean color)
    {
	this.color = color;
    }

    /**
     * @return the spanSimilar
     */
    public boolean isSpanSimilar()
    {
	return spanSimilar;
    }

    /**
     * @param spanSimilar the spanSimilar to set
     */
    public void setSpanSimilar(boolean spanSimilar)
    {
	this.spanSimilar = spanSimilar;
    }

}