package platfrom;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Presentation extends VBox
{
    public Presentation(String imgePath)
    {
        super() ;
        this.getChildren().add((ImageView) buildPresentationImageView()) ;
    }

    private ImageView buildPresentationImageView()
    {
        ImageView imageView = new ImageView(new Image("file:rssrc/images/facebook.png")) ;
        return imageView ;
    }
}
