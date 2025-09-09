package platfrom ;

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

        mainScene.widthProperty().addListener((obs, oldVal, newVal) ->
        {
            double w = newVal.doubleValue() ;
            board.setPrefWidth(w);
        }) ;

        /* CSS Style */
        this.getStylesheets().add("file:rssrc/styles/standardboard.css") ;
        /* CSS Style */
    }

    private Parent buildBoard()
    {
        HBox hbox = new HBox() ;

        VBox secondNav = (VBox) buildSecondNav() ;
        VBox pdfView = (VBox) buildPdfView() ;
        
        hbox.getChildren().addAll(secondNav, pdfView) ;
        return hbox ;
    }

    private Parent buildSecondNav()
    {
        int iconeSize = 48 ;

        VBox vbox = new VBox(10) ;
        StackPane borrowBook = new StackPane(new VBox(), new VBox(new ImageView(new Image("file:rssrc/images/emprunter_livre.png")), new Label("Emprunter"))) ;
        StackPane searchBook = new StackPane(new VBox(), new VBox(new ImageView(new Image("file:rssrc/images/rechercher_livre.png")), new Label("Rechercher"))) ;
        StackPane addBook = new StackPane(new VBox(), new VBox(new ImageView(new Image("file:rssrc/images/ajouter_livre.png")), new Label("Ajouter"))) ;
        StackPane removeBook = new StackPane(new VBox(), new VBox(new ImageView(new Image("file:rssrc/images/supprimer_livre.png")), new Label("Supprimer"))) ;
        StackPane manageBorrowing = new StackPane(new VBox(), new VBox(new ImageView(new Image("file:rssrc/images/gerer_emprunt.png")), new Label("Gérer"))) ;
        
        ((ImageView) ((VBox) borrowBook.getChildren().get(1)).getChildren().get(0)).setFitWidth(iconeSize) ;
        ((ImageView) ((VBox) borrowBook.getChildren().get(1)).getChildren().get(0)).setFitHeight(iconeSize) ;
        ((ImageView) ((VBox) searchBook.getChildren().get(1)).getChildren().get(0)).setFitWidth(iconeSize) ;
        ((ImageView) ((VBox) searchBook.getChildren().get(1)).getChildren().get(0)).setFitHeight(iconeSize) ;
        ((ImageView) ((VBox) addBook.getChildren().get(1)).getChildren().get(0)).setFitWidth(iconeSize) ;
        ((ImageView) ((VBox) addBook.getChildren().get(1)).getChildren().get(0)).setFitHeight(iconeSize) ;
        ((ImageView) ((VBox) removeBook.getChildren().get(1)).getChildren().get(0)).setFitWidth(iconeSize) ;
        ((ImageView) ((VBox) removeBook.getChildren().get(1)).getChildren().get(0)).setFitHeight(iconeSize) ;
        ((ImageView) ((VBox) manageBorrowing.getChildren().get(1)).getChildren().get(0)).setFitWidth(iconeSize) ;
        ((ImageView) ((VBox) manageBorrowing.getChildren().get(1)).getChildren().get(0)).setFitHeight(iconeSize) ;

        navAllItemsShadowAction((VBox) borrowBook.getChildren().get(0), (VBox) borrowBook.getChildren().get(1)) ;
        navAllItemsShadowAction((VBox) searchBook.getChildren().get(0), (VBox) searchBook.getChildren().get(1)) ;
        navAllItemsShadowAction((VBox) addBook.getChildren().get(0), (VBox) addBook.getChildren().get(1)) ;
        navAllItemsShadowAction((VBox) removeBook.getChildren().get(0), (VBox) removeBook.getChildren().get(1)) ;
        navAllItemsShadowAction((VBox) manageBorrowing.getChildren().get(0), (VBox) manageBorrowing.getChildren().get(1)) ;

        ((VBox) borrowBook.getChildren().get(1)).setPadding(new Insets(5)) ;
        ((VBox) searchBook.getChildren().get(1)).setPadding(new Insets(5)) ;
        ((VBox) addBook.getChildren().get(1)).setPadding(new Insets(5)) ;
        ((VBox) removeBook.getChildren().get(1)).setPadding(new Insets(5)) ;
        ((VBox) manageBorrowing.getChildren().get(1)).setPadding(new Insets(5)) ;

        ((VBox) borrowBook.getChildren().get(1)).setAlignment(Pos.CENTER); ;
        ((VBox) searchBook.getChildren().get(1)).setAlignment(Pos.CENTER); ;
        ((VBox) addBook.getChildren().get(1)).setAlignment(Pos.CENTER); ;
        ((VBox) removeBook.getChildren().get(1)).setAlignment(Pos.CENTER); ;
        ((VBox) manageBorrowing.getChildren().get(1)).setAlignment(Pos.CENTER); ;
        
        Region spacer1 = new Region() ;
        Region spacer2 = new Region() ;
        VBox.setVgrow(spacer1, Priority.ALWAYS) ;
        VBox.setVgrow(spacer2, Priority.ALWAYS);

        vbox.getChildren().addAll(searchBook, borrowBook, spacer1, addBook, removeBook, manageBorrowing, spacer2) ;
        vbox.setPadding(new Insets(10, 5, 10, 5)) ;

        /* CSS Style */
        vbox.setId("secondnav") ;
        borrowBook.getStyleClass().add("navallitems") ;
        searchBook.getStyleClass().add("navallitems") ;
        addBook.getStyleClass().add("navallitems") ;
        removeBook.getStyleClass().add("navallitems") ;
        manageBorrowing.getStyleClass().add("navallitems") ;
        ((VBox) borrowBook.getChildren().get(0)).getStyleClass().add("navigationshadow") ;
        ((VBox) searchBook.getChildren().get(0)).getStyleClass().add("navigationshadow") ;
        ((VBox) addBook.getChildren().get(0)).getStyleClass().add("navigationshadow") ;
        ((VBox) removeBook.getChildren().get(0)).getStyleClass().add("navigationshadow") ;
        ((VBox) manageBorrowing.getChildren().get(0)).getStyleClass().add("navigationshadow") ;
        ((VBox) borrowBook.getChildren().get(1)).getStyleClass().add("secondnavitems");
        ((VBox) searchBook.getChildren().get(1)).getStyleClass().add("secondnavitems");
        ((VBox) addBook.getChildren().get(1)).getStyleClass().add("secondnavitems");
        ((VBox) removeBook.getChildren().get(1)).getStyleClass().add("secondnavitems");
        ((VBox) manageBorrowing.getChildren().get(1)).getStyleClass().add("secondnavitems");
        /* CSS Style */

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
        // vbox.setStyle("-fx-border-color: black") ;
        /* À SUPPRIMER */

        return vbox ;
    }

    private Parent buildNavigation()
    {
        VBox navigation = new VBox(10) ;
        StackPane profile = (StackPane) navigationTopItem("rssrc/images/profile.png", "Profile") ;
        StackPane settings = (StackPane) navigationTopItem("rssrc/images/settings.png", "Settings") ;

        Region spacer = new Region() ;
        VBox.setVgrow(spacer, Priority.ALWAYS) ;
        HBox resseaux = (HBox) defineSocialReseaux() ;
        StackPane quitter = new StackPane(new HBox(), new HBox(new Label("Exit".toUpperCase()))) ;
        ((HBox) quitter.getChildren().get(1)).setAlignment(Pos.CENTER) ;
        ((HBox) quitter.getChildren().get(1)).setPadding(new Insets(5));
        
        navigation.getChildren().addAll(profile, settings, spacer, resseaux, quitter) ;
        navigation.setMinWidth(200) ;
        navigation.setMaxWidth(200) ;
        navigation.setPadding(new Insets(10)) ;

        navAllItemsShadowAction((HBox) quitter.getChildren().get(0), (HBox) quitter.getChildren().get(1)) ;

        /* CSS Style */
        navigation.setId("navigation") ;
        ((HBox) quitter.getChildren().get(0)).getStyleClass().add("navigationshadow") ;
        ((HBox) quitter.getChildren().get(1)).getStyleClass().add("navallitems") ;
        ((HBox) quitter.getChildren().get(1)).getStyleClass().add("navlabel") ;
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
        
        StackPane stackPane = new StackPane(new HBox(), hbox) ;
        ((HBox) stackPane.getChildren().get(0)).getStyleClass().add("navigationshadow") ;

        navAllItemsShadowAction(((HBox) stackPane.getChildren().get(0)), (HBox) stackPane.getChildren().get(1)) ;

        /* CSS Style */
        label.getStyleClass().add("navlabel") ;
        hbox.getStyleClass().add("navallitems") ;
        /* CSS Style */

        return stackPane ;
    }

    private void navAllItemsShadowAction(Parent effect, Parent action)
    {
        action.hoverProperty().addListener((obs, oldVal, isHovered) ->
        {
            if (isHovered)
            {
                DropShadow shadow = new DropShadow() ;
                shadow.setRadius(0) ;
                shadow.setOffsetX(2) ;
                shadow.setOffsetY(2) ;
                shadow.setColor(Color.BLACK) ;
                effect.setEffect(shadow) ;
                effect.setStyle("-fx-background-color: #b69e62;") ;
            }
            else
            { effect.setEffect(null) ; }
        });
    }

    private Parent defineSocialReseaux()
    {
        int iconeSize = 24 ;
        int iconePadding = 5 ;

        HBox hbox = new HBox(10) ;
        StackPane facebook = new StackPane(new HBox(), new HBox(new ImageView(new Image("file:rssrc/images/facebook.png")))) ;
        StackPane instagram = new StackPane(new HBox(), new HBox(new ImageView(new Image("file:rssrc/images/instagram.png")))) ;
        StackPane youtube = new StackPane(new HBox(), new HBox(new ImageView(new Image("file:rssrc/images/youtube.png")))) ;
        
        ((ImageView) ((HBox) facebook.getChildren().get(1)).getChildren().get(0)).setFitWidth(iconeSize) ;
        ((ImageView) ((HBox) facebook.getChildren().get(1)).getChildren().get(0)).setFitHeight(iconeSize) ;
        ((ImageView) ((HBox) instagram.getChildren().get(1)).getChildren().get(0)).setFitWidth(iconeSize) ;
        ((ImageView) ((HBox) instagram.getChildren().get(1)).getChildren().get(0)).setFitHeight(iconeSize) ;
        ((ImageView) ((HBox) youtube.getChildren().get(1)).getChildren().get(0)).setFitWidth(iconeSize) ;
        ((ImageView) ((HBox) youtube.getChildren().get(1)).getChildren().get(0)).setFitHeight(iconeSize) ;
        
        navAllItemsShadowAction(((HBox) facebook.getChildren().get(0)), ((HBox) facebook.getChildren().get(1))) ;
        navAllItemsShadowAction(((HBox) instagram.getChildren().get(0)), ((HBox) instagram.getChildren().get(1))) ;
        navAllItemsShadowAction(((HBox) youtube.getChildren().get(0)), ((HBox) youtube.getChildren().get(1))) ;

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
        
        ((HBox) facebook.getChildren().get(1)).setPadding(new Insets(iconePadding)) ;
        ((HBox) instagram.getChildren().get(1)).setPadding(new Insets(iconePadding)) ;
        ((HBox) youtube.getChildren().get(1)).setPadding(new Insets(iconePadding)) ;

        /* CSS Style */
        ((HBox) facebook.getChildren().get(0)).getStyleClass().add("navigationshadow") ;
        ((HBox) instagram.getChildren().get(0)).getStyleClass().add("navigationshadow") ;
        ((HBox) youtube.getChildren().get(0)).getStyleClass().add("navigationshadow") ;
        ((HBox) facebook.getChildren().get(1)).getStyleClass().add("navallitems") ;
        ((HBox) instagram.getChildren().get(1)).getStyleClass().add("navallitems") ;
        ((HBox) youtube.getChildren().get(1)).getStyleClass().add("navallitems") ;
        /* CSS Style */

        return hbox ;
    }
}
