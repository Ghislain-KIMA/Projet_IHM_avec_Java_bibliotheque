package platfrom ;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox ;

// import platfrom.Identifier ;

public class Inscription extends VBox
{
    private StackPane inscriptionChoice ;
    private Button standardSaving ;
    private Button managerSaving ;

    public Inscription()
    {
        super() ;

        inscriptionChoice = (StackPane) buildInscriptionChoice() ;

        this.getChildren().addAll(this.inscriptionChoice) ;
        this.setAlignment(Pos.CENTER) ;

        /* CSS Style */
        this.getStylesheets().add("file:rssrc/styles/inscription.css") ;
        /* CSS Style */

        StackPane standard = (StackPane) buildInscriptionEntreeBoard("Entrez votre numéro de carte d'accès") ;
        this.standardSaving = (Button) ((HBox) ((VBox) standard.getChildren().get(1)).getChildren().get(6)).getChildren().get(2) ;
        StackPane manager = (StackPane) buildInscriptionEntreeBoard("Entrez votre code de permis de gestion") ;
        this.managerSaving = (Button) ((HBox) ((VBox) manager.getChildren().get(1)).getChildren().get(6)).getChildren().get(2) ;

        ((Label) ((VBox) inscriptionChoice.getChildren().get(0)).getChildren().get(0)).setOnMouseClicked((event) ->
        {
            this.getChildren().clear() ;
            this.getChildren().add(standard) ;
        }) ;
        ((Label) ((VBox) inscriptionChoice.getChildren().get(0)).getChildren().get(1)).setOnMouseClicked((event) ->
        {
            this.getChildren().clear() ;
            this.getChildren().add(manager) ;
        }) ;
    }

    private Parent buildInscriptionChoice()
    {
        VBox vbox = new VBox(20, new Label("Utilisateur"), new Label("Gestionnaire")) ;
        vbox.setAlignment(Pos.CENTER) ;

            /* CSS Style */
        vbox.getChildren().get(0).getStyleClass().add("inscriptionchoice") ;
        vbox.getChildren().get(1).getStyleClass().add("inscriptionchoice") ;
        vbox.getChildren().get(0).getStyleClass().add("userentreeboardshadow") ;
        vbox.getChildren().get(1).getStyleClass().add("userentreeboardshadow") ;
            /* CSS Style */

        return new StackPane(vbox) ;
    }

    private Parent buildInscriptionEntreeBoard(String accessLabel)
    {
        int inscriptionWidth = 350 ;
        int inscriptionHeight = 480 ;

        StackPane stackPane = new StackPane() ;

        VBox inscriptionEntreeBoardShadow = new VBox() ;
    
        VBox entreeBoard = new VBox(15) ;

        VBox lastName = (VBox) Identifier.labelNameAndTextField("Nom") ;
        VBox firstName = (VBox) Identifier.labelNameAndTextField("Prénom") ;
        VBox accessCarteCode = (VBox) Identifier.labelNameAndTextField(accessLabel) ;
        VBox password = (VBox) Identifier.labelNameAndPasswordField("Mot de passe") ;
        VBox confirmPassword = (VBox) Identifier.labelNameAndPasswordField("Confirmer mot de passe") ;
        Region spacer = new Region() ;
        HBox.setHgrow(spacer, Priority.ALWAYS) ;
        HBox actions = new HBox(new Button("Effacer"), spacer, new Button("Enregistrer")) ;
        entreeBoard.setPadding(new Insets(30, 10, 30, 10));
        entreeBoard.getChildren().addAll(lastName, firstName, accessCarteCode, password, confirmPassword, new Label(""), actions) ;
        stackPane.getChildren().addAll(inscriptionEntreeBoardShadow, entreeBoard) ;

        entreeBoard.setMinSize(inscriptionWidth, inscriptionHeight) ;
        entreeBoard.setMaxSize(inscriptionWidth, inscriptionHeight) ;
        inscriptionEntreeBoardShadow.setMinSize(inscriptionWidth, inscriptionHeight);
        inscriptionEntreeBoardShadow.setMaxSize(inscriptionWidth, inscriptionHeight);

        ((Button) actions.getChildren().get(0)).setOnAction((event) ->
        {
            ((TextField) lastName.getChildren().get(1)).clear() ;
            ((TextField) firstName.getChildren().get(1)).clear() ;
            ((TextField) accessCarteCode.getChildren().get(1)).clear() ;
            ((PasswordField) password.getChildren().get(1)).clear() ;
            ((PasswordField) confirmPassword.getChildren().get(1)).clear() ;
        }) ;

            /* CSS Style */
        lastName.getChildren().get(0).getStyleClass().add("identifylabel") ;
        firstName.getChildren().get(0).getStyleClass().add("identifylabel") ;
        accessCarteCode.getChildren().get(0).getStyleClass().add("identifylabel") ;
        password.getChildren().get(0).getStyleClass().add("identifylabel") ;
        confirmPassword.getChildren().get(0).getStyleClass().add("identifylabel") ;
        lastName.getChildren().get(1).getStyleClass().add("identifyfield") ;
        firstName.getChildren().get(1).getStyleClass().add("identifyfield") ;
        accessCarteCode.getChildren().get(1).getStyleClass().add("identifyfield") ;
        password.getChildren().get(1).getStyleClass().add("identifyfield") ;
        confirmPassword.getChildren().get(1).getStyleClass().add("identifyfield") ;
        entreeBoard.getStyleClass().add("userentreeboard") ;
        inscriptionEntreeBoardShadow.getStyleClass().add("userentreeboardshadow") ;
        actions.getChildren().get(0).getStyleClass().add("actionbuttonshand") ;
        actions.getChildren().get(2).getStyleClass().add("actionbuttonshand") ;
        actions.getChildren().get(0).getStyleClass().add("connectionbutton") ;
        actions.getChildren().get(2).getStyleClass().add("connectionbutton") ;
            /* CSS Style */
        return stackPane ;
    }

    public Button getStandardButtonSaving()
    {   return this.standardSaving ;    }

    public Button getManagerButtonSaving()
    {   return this.managerSaving ; }

    public boolean inscriptionChoiceIsOccurrence()
    {   return this.getChildren().contains(this.inscriptionChoice) ;    }
    
    public void defaultDefenition()
    {
        this.getChildren().clear(); ;
        this.getChildren().add(this.inscriptionChoice) ;
    }
}
