package View;

import javax.imageio.ImageIO;
import java.awt.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Assets {

    private final Map<Object, Image> vehicleImage = new HashMap<>();

    public void bind(Object object, String imagePath) {
        vehicleImage.put(object, getImage(imagePath));
    }

    private Image getImage(String imagePath) {

        Image tempImage = null;

        if(imagePath != null) {
            try {
                tempImage = ImageIO.read(Assets.class.getResourceAsStream(imagePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (tempImage != null) {
            return tempImage;
        } else {
            throw new NullPointerException("ERROR - Could not find image at path" +
                    ": " + imagePath);
        }

    }

    public Image get(Object object){
        return vehicleImage.get(object);
    }


}
