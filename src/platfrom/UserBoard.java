package platfrom;

import javafx.geometry.Insets ;
import javafx.geometry.Pos ;
import javafx.scene.Parent ;
import javafx.scene.control.Label ;
import javafx.scene.layout.HBox ;
import javafx.scene.layout.Priority ;
import javafx.scene.layout.Region ;
import javafx.scene.layout.VBox ;

public class UserBoard extends HBox
{
    public UserBoard()
    {
        super() ;

        VBox navigagion = (VBox) definedNavigation() ;
        VBox body = new VBox(new Label("Ghislain")) ;
        body.setAlignment(Pos.CENTER);
        VBox.setVgrow(body.getChildren().get(0), Priority.ALWAYS);
        
        this.getChildren().addAll(navigagion, body) ;
        HBox.setHgrow(body, Priority.ALWAYS) ;
        navigagion.setPadding(new Insets(0, 0, 0, 10)) ;
        // HBox.setHgrow(navigagion, Priority.ALWAYS);

        /* À SUPPRIMER */
        navigagion.setStyle(("-fx-border-color: red;")) ;
        body.setStyle(("-fx-border-color: yellow; -fx-border-width: 2px;")) ;
        /* À SUPPRIMER */
    }

    private Parent definedNavigation()
    {
        VBox navigagion = new VBox() ;
        HBox profile = new HBox(new Label("Profile")) ; 
        HBox settings = new HBox(new Label("Settings")) ;
        Region spacer = new Region() ;
        VBox.setVgrow(spacer, Priority.ALWAYS) ;
        HBox resseaux = new HBox(new Label("Réseaux liste")) ;
        HBox quitter = new HBox(new Label("Exit")) ;

        navigagion.getChildren().addAll(profile, settings, spacer, resseaux, quitter) ;

        /* À SUPPRIMER */
            // profile.setAlignment(Pos.CENTER) ;
            // settings.setAlignment(Pos.CENTER) ;
            // resseaux.setAlignment(Pos.CENTER) ;
            // quitter.setAlignment(Pos.CENTER) ;
        /* À SUPPRIMER */

        resseaux.setPadding(new Insets(0, 0, 20, 0)) ;
        navigagion.setMinWidth(200) ;

        return navigagion ;
    }
}
