package newtonERP.module.generalEntity;

/**
 * Représente un fichier d'image visible en HTML
 * @author Guillaume Lacasse
 */
public class ImageFile extends newtonERP.module.AbstractEntity
{
	private String alt;

	private String url;

	/**
	 * @param alt nom de l'image
	 * @param url url de l'image
	 */
	public ImageFile(String alt, String url)
	{
		super();
		this.alt = alt;
		this.url = url;
	}

	/**
	 * @return url de l'image
	 */
	public String getUrl()
	{
		return url;
	}

	/**
	 * @return description de l'image
	 */
	public String getAlt()
	{
		return alt;
	}

}
