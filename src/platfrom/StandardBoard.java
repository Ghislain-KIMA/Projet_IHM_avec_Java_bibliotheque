package platfrom;

import javafx.geometry.Insets ;
import javafx.geometry.Pos ;
import javafx.scene.Parent ;
import javafx.scene.control.Label ;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox ;
import javafx.scene.layout.Priority ;
import javafx.scene.layout.Region ;
import javafx.scene.layout.VBox ;

public class StandardBoard extends HBox
{
    public StandardBoard()
    {
        super() ;

        VBox navigation = (VBox) definedNavigation() ;
        HBox body = new HBox(new VBox(), new Label("Ghislain")) ;
        VBox.setVgrow(body.getChildren().get(0), Priority.ALWAYS);

        ((VBox)body.getChildren().get(0)).getChildren().add(new Label("ESSAI")) ;
        
        this.getChildren().addAll(navigation, body) ;
        HBox.setHgrow(body, Priority.ALWAYS) ;
        navigation.setPadding(new Insets(10)) ;
        navigation.setMaxWidth(200) ;

        /* À SUPPRIMER */
        navigation.setStyle(("-fx-border-color: red;")) ;
        body.setStyle(("-fx-border-color: yellow; -fx-border-width: 2px;")) ;
        ((VBox)body.getChildren().get(0)).setStyle(("-fx-border-color: black;")) ;
        /* À SUPPRIMER */
    }

    private Parent definedNavigation()
    {
        VBox navigation = new VBox(20) ;
        HBox profile = (HBox) navigationTopItem("rssrc/images/profile.png", "Profile") ;
        // profile.setPadding(new Insets(0, 0, 20, 0));
        HBox settings = (HBox) navigationTopItem("rssrc/images/settings.png", "Settings") ;

        Region spacer = new Region() ;
        VBox.setVgrow(spacer, Priority.ALWAYS) ;
        HBox resseaux = (HBox) defineSocialReseaux() ;
        HBox quitter = new HBox(new Label("Exit".toUpperCase())) ;
        quitter.setAlignment(Pos.CENTER) ;

        navigation.getChildren().addAll(profile, settings, spacer, resseaux, quitter) ;

        /* À SUPPRIMER */
            // profile.setAlignment(Pos.CENTER) ;
            // settings.setAlignment(Pos.CENTER) ;
            // resseaux.setAlignment(Pos.CENTER) ;
            // quitter.setAlignment(Pos.CENTER) ;
            quitter.setStyle("-fx-border-color: black;") ;
        /* À SUPPRIMER */

        navigation.setMinWidth(200) ;

        return navigation ;
    }

    private Parent navigationTopItem(String iconePath, String labelString)
    {
        HBox hbox = new HBox(10) ;
        
        ImageView icone = new ImageView(new Image("file:" + iconePath)) ;
        icone.setFitWidth(40) ;
        icone.setFitHeight(40) ;
        Label label = new Label(labelString, icone) ;
        label.setGraphicTextGap(10) ;

        hbox.getChildren().addAll(label) ;

        /* À SUPPRIMER */
        icone.setStyle("-fx-border-color: black;") ;
        hbox.setStyle("-fx-border-color: black;") ;
        label.setStyle("-fx-border-color: black;") ;
        /* À SUPPRIMER */

        /* CSS Style */
        label.getStyleClass().add("navigationtopitem") ;
        /* CSS Style */

        return hbox ;
    }

    private Parent defineSocialReseaux()
    {
        int iconeMaxWidth = 20 ;
        int iconeMaxHeight = 20 ;

        HBox hbox = new HBox(10) ;
        ImageView facebook = new ImageView(new Image("file:rssrc/images/facebook.png")) ;
        ImageView instagram = new ImageView(new Image("file:rssrc/images/instagram.png")) ;
        ImageView youtube = new ImageView(new Image("file:rssrc/images/youtube.png")) ;
        facebook.setFitWidth(iconeMaxWidth) ;
        facebook.setFitHeight(iconeMaxHeight) ;
        instagram.setFitWidth(iconeMaxWidth) ;
        instagram.setFitHeight(iconeMaxHeight) ;
        youtube.setFitWidth(iconeMaxWidth) ;
        youtube.setFitHeight(iconeMaxHeight) ;

        Region begin = new Region() ;
        Region end = new Region() ;
        Region spacerRight = new Region() ;
        Region spacerLeft = new Region() ;
        HBox.setHgrow(begin, Priority.ALWAYS) ;
        HBox.setHgrow(end, Priority.ALWAYS) ;
        HBox.setHgrow(spacerLeft, Priority.ALWAYS) ;
        HBox.setHgrow(spacerRight, Priority.ALWAYS) ;

        hbox.getChildren().addAll(begin, facebook, spacerLeft, instagram, spacerRight, youtube, end) ;

        /* À SUPPRIMER */
        hbox.setStyle("-fx-border-color: black;") ;
        /* À SUPPRIMER */

        return hbox ;
    }
}
