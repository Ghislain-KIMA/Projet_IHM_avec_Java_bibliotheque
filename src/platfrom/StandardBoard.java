package platfrom;

import javafx.geometry.Insets ;
import javafx.geometry.Pos ;
import javafx.scene.Parent ;
import javafx.scene.Scene ;
import javafx.scene.control.Label ;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox ;
import javafx.scene.layout.Priority ;
import javafx.scene.layout.Region ;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox ;
import javafx.scene.paint.Color;

public class StandardBoard extends HBox
{
    public StandardBoard(Scene mainScene)
    {
        super() ;

        VBox navigation = (VBox) buildNavigation() ;
        HBox board = (HBox) buildBoard() ;
        VBox.setVgrow(board.getChildren().get(0), Priority.ALWAYS);
        
        this.getChildren().addAll(navigation, board) ;
        HBox.setHgrow(board, Priority.ALWAYS) ;
        board.setAlignment(Pos.CENTER_LEFT) ;
        
        // board.setFillWidth(true) ;
        
        

        mainScene.widthProperty().addListener((obs, oldVal, newVal) ->
        {
            double w = newVal.doubleValue() ;
            board.setPrefWidth(w);
        });

        /* À SUPPRIMER */
        navigation.setStyle(("-fx-border-color: red;")) ;
        board.setStyle(("-fx-border-color: yellow; -fx-border-width: 2px;")) ;
        ((VBox)board.getChildren().get(0)).setStyle(("-fx-border-color: black;")) ;
        /* À SUPPRIMER */

        /* CSS Style */
        navigation.setId("navigation") ;
        this.getStylesheets().add("file:rssrc/styles/standardboard.css") ;
        /* CSS Style */
    }

    private Parent buildBoard()
    {
        HBox hbox = new HBox() ;

        VBox secondNav = (VBox) buildSecondNav() ;
        VBox pdfView = (VBox) buildPdfView() ;

        secondNav.setId("secondnav") ;
        
        hbox.getChildren().addAll(secondNav, pdfView) ;
        return hbox ;
    }

    private Parent buildSecondNav()
    {
        int iconeSize = 48 ;

        VBox vbox = new VBox(10) ;
        VBox borrowBook = new VBox(new ImageView(new Image("file:rssrc/images/emprunter_livre.png")), new Label("Emprunter")) ;
        VBox searchBook = new VBox(new ImageView(new Image("file:rssrc/images/rechercher_livre.png")), new Label("Rechercher")) ;
        VBox addBook = new VBox(new ImageView(new Image("file:rssrc/images/ajouter_livre.png")), new Label("Ajouter")) ;
        VBox removeBook = new VBox(new ImageView(new Image("file:rssrc/images/supprimer_livre.png")), new Label("Supprimer")) ;
        VBox manageBorrowing = new VBox(new ImageView(new Image("file:rssrc/images/gerer_emprunt.png")), new Label("Gérer")) ;
        
        ((ImageView) borrowBook.getChildren().get(0)).setFitWidth(iconeSize) ;
        ((ImageView) borrowBook.getChildren().get(0)).setFitHeight(iconeSize) ;
        ((ImageView) searchBook.getChildren().get(0)).setFitWidth(iconeSize) ;
        ((ImageView) searchBook.getChildren().get(0)).setFitHeight(iconeSize) ;
        ((ImageView) addBook.getChildren().get(0)).setFitWidth(iconeSize) ;
        ((ImageView) addBook.getChildren().get(0)).setFitHeight(iconeSize) ;
        ((ImageView) removeBook.getChildren().get(0)).setFitWidth(iconeSize) ;
        ((ImageView) removeBook.getChildren().get(0)).setFitHeight(iconeSize) ;
        ((ImageView) manageBorrowing.getChildren().get(0)).setFitWidth(iconeSize) ;
        ((ImageView) manageBorrowing.getChildren().get(0)).setFitHeight(iconeSize) ;

        /* À SUPPRIMER */
        borrowBook.setStyle("-fx-border-color: black") ;
        searchBook.setStyle("-fx-border-color: black") ;
        addBook.setStyle("-fx-border-color: black") ;
        removeBook.setStyle("-fx-border-color: black") ;
        manageBorrowing.setStyle("-fx-border-color: black") ;
        /* À SUPPRIMER */

        Region spacer1 = new Region() ;
        Region spacer2 = new Region() ;
        VBox.setVgrow(spacer1, Priority.ALWAYS) ;
        VBox.setVgrow(spacer2, Priority.ALWAYS);

        vbox.getChildren().addAll(searchBook, borrowBook, spacer1, addBook, removeBook, manageBorrowing, spacer2) ;
        vbox.setPadding(new Insets(10, 2, 10, 5)) ;
        return vbox ;
    }

    private Parent buildPdfView()
    {
        Region r = new Region() ;
        Region r1 = new Region() ;
        HBox.setHgrow(r, Priority.ALWAYS);
        HBox.setHgrow(r1, Priority.ALWAYS);

        VBox vbox = new VBox(new HBox(r, new Label("VIEWER"), r1)) ;


        vbox.setAlignment(Pos.CENTER) ;

        /* À SUPPRIMER */
        vbox.setStyle("-fx-border-color: black") ;
        /* À SUPPRIMER */

        return vbox ;
    }

    private Parent buildNavigation()
    {
        VBox navigation = new VBox(10) ;
        StackPane profile = new StackPane(new HBox(), (HBox) navigationTopItem("rssrc/images/profile.png", "Profile")) ;
        ((HBox) profile.getChildren().get(0)).getStyleClass().add("navigationshadow") ;
        StackPane settings = new StackPane(new HBox(), (HBox) navigationTopItem("rssrc/images/settings.png", "Settings")) ;
        ((HBox) settings.getChildren().get(0)).getStyleClass().add("navigationshadow") ;

        ((HBox) profile.getChildren().get(1)).hoverProperty().addListener((obs, oldVal, isHovered) ->
        {
            System.out.println("STACKPANE") ;
            if (isHovered)
            {
                DropShadow shadow = new DropShadow() ;
                shadow.setRadius(10) ;
                shadow.setOffsetX(0) ;
                shadow.setOffsetY(5) ;
                shadow.setColor(Color.BLACK) ;
                ((HBox) profile.getChildren().get(0)).setEffect(shadow) ;
                ((HBox) profile.getChildren().get(0)).setStyle("-fx-background-color: red;") ;
            }
            else
            {
                ((HBox) profile.getChildren().get(0)).setEffect(null) ;
            }
        });


        Region spacer = new Region() ;
        VBox.setVgrow(spacer, Priority.ALWAYS) ;
        HBox resseaux = (HBox) defineSocialReseaux() ;
        HBox quitter = new HBox(new Label("Exit".toUpperCase())) ;
        quitter.setAlignment(Pos.CENTER) ;
        quitter.setPadding(new Insets(5));
        
        navigation.getChildren().addAll(profile, settings, spacer, resseaux, quitter) ;
        navigation.setMinWidth(200) ;
        navigation.setMaxWidth(200) ;
        navigation.setPadding(new Insets(10)) ;
        
        /* À SUPPRIMER */
        // profile.setAlignment(Pos.CENTER) ;
        // settings.setAlignment(Pos.CENTER) ;
        // resseaux.setAlignment(Pos.CENTER) ;
        // quitter.setAlignment(Pos.CENTER) ;
        quitter.setStyle("-fx-border-color: black;") ;
        /* À SUPPRIMER */

        /* CSS Style */
        quitter.getStyleClass().add("navallitems") ;
        quitter.getStyleClass().add("navlabel") ;
        /* CSS Style */

        return navigation ;
    }

    private Parent navigationTopItem(String iconePath, String labelString)
    {
        int iconeSize = 48 ;
        HBox hbox = new HBox(10) ;
        
        ImageView icone = new ImageView(new Image("file:" + iconePath)) ;
        icone.setFitWidth(iconeSize) ;
        icone.setFitHeight(iconeSize) ;
        Label label = new Label(labelString) ;
        hbox.getChildren().addAll(new StackPane(icone), label) ;
        hbox.setAlignment(Pos.CENTER_LEFT) ;
        hbox.setPadding(new Insets(5)) ;

        /* À SUPPRIMER */
        hbox.getChildren().get(0).setStyle("-fx-border-color: black;") ;
        hbox.setStyle("-fx-border-color: black;") ;
        // label.setStyle("-fx-border-color: black;") ;
        /* À SUPPRIMER */

        /* CSS Style */
        hbox.getChildren().get(0).getStyleClass().add("navicones".toLowerCase()) ;
        label.getStyleClass().add("navlabel") ;
        hbox.getStyleClass().add("navallitems") ;
        /* CSS Style */

        return hbox ;
    }

    private Parent defineSocialReseaux()
    {
        int iconeSize = 24 ;

        HBox hbox = new HBox(10) ;
        ImageView facebook = new ImageView(new Image("file:rssrc/images/facebook.png")) ;
        ImageView instagram = new ImageView(new Image("file:rssrc/images/instagram.png")) ;
        ImageView youtube = new ImageView(new Image("file:rssrc/images/youtube.png")) ;
        facebook.setFitWidth(iconeSize) ;
        facebook.setFitHeight(iconeSize) ;
        instagram.setFitWidth(iconeSize) ;
        instagram.setFitHeight(iconeSize) ;
        youtube.setFitWidth(iconeSize) ;
        youtube.setFitHeight(iconeSize) ;

        Region begin = new Region() ;
        Region end = new Region() ;
        Region spacerRight = new Region() ;
        Region spacerLeft = new Region() ;
        HBox.setHgrow(begin, Priority.ALWAYS) ;
        HBox.setHgrow(end, Priority.ALWAYS) ;
        HBox.setHgrow(spacerLeft, Priority.ALWAYS) ;
        HBox.setHgrow(spacerRight, Priority.ALWAYS) ;

        hbox.setPadding(new Insets(5)) ;
        hbox.getChildren().addAll(begin, facebook, spacerLeft, instagram, spacerRight, youtube, end) ;

        /* CSS Style */
        facebook.getStyleClass().add("navicones") ;
        instagram.getStyleClass().add("navicones") ;
        youtube.getStyleClass().add("navicones") ;
        hbox.getStyleClass().add("navallitems") ;
        /* CSS Style */

        /* À SUPPRIMER */
        hbox.setStyle("-fx-border-color: black;") ;
        /* À SUPPRIMER */

        return hbox ;
    }
}
