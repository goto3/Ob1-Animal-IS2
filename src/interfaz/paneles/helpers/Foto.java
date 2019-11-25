package interfaz.paneles.helpers;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Foto extends JLabel {

    private JFileChooser subirAvatar;
    public ImageIcon imageShowing;

    public Foto(ImageIcon image, int width, int height) {
        imageShowing = image;

        subirAvatar = new JFileChooser();
        subirAvatar.setCurrentDirectory(new File("user.home"));
        subirAvatar.setFileFilter(new FileNameExtensionFilter("*.Images", "png", "jpg"));
        subirAvatar.setAcceptAllFileFilterUsed(false);        

        if (imageShowing != null) {
            setIcon(Resize(imageShowing, width, height));
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int returnValue = subirAvatar.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    ImageIcon ii = new ImageIcon(subirAvatar.getSelectedFile().getAbsolutePath());
                    setIcon(Resize(ii, width, height));
                    imageShowing = ii;
                }
            }
        });
    }

    public void UpdatePhoto(ImageIcon image, int width, int height) {
        imageShowing = image;
        if (imageShowing != null) {
            setIcon(Resize(imageShowing, width, height));
        }
    }

    private ImageIcon Resize(ImageIcon imageIcon, int width, int height) {
        Image img = imageIcon.getImage();
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

}
