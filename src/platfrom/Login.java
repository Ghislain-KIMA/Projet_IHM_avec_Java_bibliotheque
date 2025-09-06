package platfrom;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Login extends HBox
{
    private Presentation presentation ;
    private Identifier identifier ;
    private Inscription inscription ;
    private Button lastButton ;

    public Login()
    {
        this.presentation = new Presentation("rssrc/images/image_1.png") ;
        this.identifier = new Identifier() ;
        this.inscription = new Inscription() ;
        this.getChildren().addAll(presentation, (VBox) buildRightVbox()) ;
    
        this.identifier.getLabelInscribe().setOnMouseClicked((event) -> { switchIdentifierToInscription(true) ; });
        inscription.getStandardButtonSaving().setOnAction((event) -> { savingAction() ; });
        inscription.getManagerButtonSaving().setOnAction((event) -> { savingAction() ; });

        /* À SUPPRIMER */
        this.presentation.setStyle("-fx-border-color: black;") ;
        this.identifier.setStyle("-fx-border-color: black;") ;
        this.inscription.setStyle("-fx-border-color: black;") ;
        /* À SUPPRIMER */
    }

    private void savingAction()
    {
        this.lastButton.setVisible(false) ;
        inscription.defaultDefenition() ;
        ((VBox) this.getChildren().get(1)).getChildren().remove(1) ;
        ((VBox) this.getChildren().get(1)).getChildren().add(identifier) ;
    }

    private void switchIdentifierToInscription(boolean visibility)
    {
        this.lastButton.setVisible(visibility) ;
        ((VBox) this.getChildren().get(1)).getChildren().remove(1) ;
        if (visibility)
            { ((VBox) this.getChildren().get(1)).getChildren().add(inscription) ; }
        else
            { ((VBox) this.getChildren().get(1)).getChildren().add(identifier) ; }
    }

    private Parent buildRightVbox()
    {
        VBox vbox = new VBox() ;

        this.lastButton = new Button("<") ;
        this.lastButton.setVisible(false) ;
        vbox.getChildren().addAll(new HBox(this.lastButton), this.identifier) ;

        this.lastButton.setOnAction((event) ->
        {
            if (!inscription.inscriptionChoiceIsOccurrence())
                { inscription.defaultDefenition() ; }
            else
                { switchIdentifierToInscription(false) ; }
        }) ;

        /* À SUPPRIMER */
        vbox.getChildren().get(0).setStyle("-fx-border-color: black;") ;
        /* À SUPPRIMER */

        return vbox ;
    }

    public Identifier getIdentifier()
    {
        return this.identifier ;
    }
}
