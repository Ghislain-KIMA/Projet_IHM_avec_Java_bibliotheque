package platfrom ;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox ;

public class Inscribe extends VBox
{
    public Inscribe()
    {
        super() ;

        this.getChildren().add(new Label("INSCRIPTION")) ;
        this.setAlignment(Pos.CENTER) ;
        
        /* ESSAI */
        this.setStyle("-fx-border-color: black") ;
        /* ESSAI */

        this.getStylesheets().add("file:rssrc/style/inscribe.css") ;
    }
}
