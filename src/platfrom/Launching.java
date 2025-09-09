package platfrom ;

import javafx.scene.layout.HBox ;
import javafx.scene.Scene ;

public class Launching extends HBox
{
    private Scene mainScene ;

    private Login login ;
    private StandardBoard standardBoard ;

    public Launching()
    {
        super() ;
        this.mainScene = new Scene(this) ;
        this.login = new Login(this.mainScene) ;
        this.standardBoard = new StandardBoard(this.mainScene) ;
        
        this.getChildren().add(this.login) ;
        
        login.getIdentifier().getButtonConnection().setOnAction((event) ->
        {
            this.getChildren().clear() ;
            this.getChildren().add(this.standardBoard) ;
        }) ;

        /* À SUPPRIMER */
        login.setStyle("-fx-border-color: black;") ;
        /* À SUPPRIMER */
    }

    public Scene getMainScene()
    { return this.mainScene ; }
}