package platfrom ;

import javafx.scene.layout.HBox ;
import javafx.scene.Scene ;

public class Launching extends HBox
{
    private Scene maiScene ;

    private Login login ;
    private StandardBoard standardBoard ;

    public Launching()
    {
        super() ;
        this.maiScene = new Scene(this) ;
        this.login = new Login() ;
        this.standardBoard = new StandardBoard() ;
        
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
        { return this.maiScene ; }
}