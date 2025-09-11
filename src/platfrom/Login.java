package platfrom;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class Login extends HBox
{
    private Presentation presentation ;
    private Identifier identifier ;
    private Inscription inscription ;
    private Button lastButton ;
    private Region spacer1 ;
    private Region spacer2 ;

    public Login(Scene mainScene)
    {
        this.presentation = new Presentation("rssrc/images/image_1.png") ;
        this.identifier = new Identifier() ;
        this.inscription = new Inscription() ;
        this.getChildren().addAll(presentation, (VBox) buildRightVbox()) ;
        this.setAlignment(Pos.CENTER) ;
    
        this.identifier.getLabelInscribe().setOnMouseClicked((event) -> { switchIdentifierToInscription(true, (this.getChildren().contains(this.presentation) ? 1 : 0 ) ) ; } );
        inscription.getStandardButtonSaving().setOnAction((event) -> { savingAction((this.getChildren().contains(this.presentation) ? 1 : 0 )) ; });
        inscription.getManagerButtonSaving().setOnAction((event) -> { savingAction((this.getChildren().contains(this.presentation) ? 1 : 0 )) ; });

        mainScene.widthProperty().addListener((obs, oldVal, newVal) ->
        {
            double w = newVal.doubleValue() ;

            if (w<500)
            {
                this.getChildren().remove(presentation) ;
                ((VBox) this.getChildren().get(0)).setPrefWidth(w) ;
            }
            else
            {
                if (!this.getChildren().contains(presentation))
                    { this.getChildren().addFirst(presentation) ; }
                presentation.setPrefWidth(w*0.4) ;
                ((VBox) this.getChildren().get(1)).setPrefWidth(w*0.6) ;
            }
        });

        this.getStylesheets().add("file:rssrc/styles/login.css") ;
    }

    private void savingAction(int position)
    {
        this.lastButton.setVisible(false) ;
        inscription.defaultDefenition() ;
        ((VBox) this.getChildren().get(position)).getChildren().removeAll(this.spacer1, this.inscription, this.spacer2) ;
        ((VBox) this.getChildren().get(position)).getChildren().addAll(this.spacer1, this.identifier, this.spacer2) ;
    }

    private void switchIdentifierToInscription(boolean visibility, int position)
    {
        this.lastButton.setVisible(visibility) ;
        
        if (((VBox) this.getChildren().get(position)).getChildren().contains(this.identifier))
            {   ((VBox) this.getChildren().get(position)).getChildren().removeAll(this.spacer2, this.identifier, this.spacer1) ;    }
        if (((VBox) this.getChildren().get(position)).getChildren().contains(this.inscription))
            {   ((VBox) this.getChildren().get(position)).getChildren().removeAll(this.spacer1, this.inscription, this.spacer2) ;   }
        if (visibility)
            {   ((VBox) this.getChildren().get(position)).getChildren().addAll(this.spacer1, this.inscription, this.spacer2) ;  }
        else
            {   ((VBox) this.getChildren().get(position)).getChildren().addAll(this.spacer1, this.identifier, this.spacer2) ;   }
    }

    private Parent buildRightVbox()
    {
        VBox vbox = new VBox() ;

        this.lastButton = new Button("<") ;
        this.lastButton.setVisible(false) ;

        
        spacer1 = new Region() ;
        spacer2 = new Region() ;
        VBox.setVgrow(spacer1, Priority.ALWAYS) ;
        VBox.setVgrow(spacer2, Priority.ALWAYS) ;
        
        vbox.getChildren().addAll(new HBox(this.lastButton), spacer1, this.identifier, spacer2) ;

        this.lastButton.setOnAction((event) ->
        {
            if (!inscription.inscriptionChoiceIsOccurrence())
                { inscription.defaultDefenition() ; }
            else
                { switchIdentifierToInscription(false, (this.getChildren().contains(this.presentation) ? 1 : 0 )) ; }
        }) ;
        /* CSS Style */
        this.lastButton.setId("returnbutton") ;
        /* CSS Style */

        return vbox ;
    }

    public Identifier getIdentifier()
    {   return this.identifier ;    }
}
