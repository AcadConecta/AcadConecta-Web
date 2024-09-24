package code.acadConecta.model.util;

import java.io.IOException;
import java.io.InputStream;

public class ImageUtil {
    public static byte[] generateBytesFromRelative() {

        byte[] bytesImage = null;
        try (InputStream inputStream = ImageUtil.class.getResourceAsStream("/static/images/icon_perfil_default_6212_web.png")) {
            if (inputStream == null) {
                throw new IOException("Image not found");
            }
            bytesImage = inputStream.readAllBytes();
        } catch (IOException error) {
            System.out.println("Error to convert image in bytes: " + error.getMessage());
        }
        return bytesImage;
    }
}
