package eu.matfx;



import javafx.scene.image.Image;

public class ImageLoader 
{
	

	/**
	 * Bilder aus dem normalen Ordner holen; nicht für unterschiedliche Dichten vorgesehen.
	 * @param fileName
	 * @return
	 */
	public static Image getImage()
	{
	
		return new Image(GluonCardPane.class.getResourceAsStream("/icon.png"));
	}

}
