package npinjamruang;

import javax.swing.*;
import java.awt.*;

public class ImageHelper {

    public static ImageIcon getIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(ImageHelper.class.getResource(path));
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
}
