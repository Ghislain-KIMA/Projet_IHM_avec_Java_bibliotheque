package platfrom ;

import javafx.scene.layout.HBox ;
import javafx.util.Duration;

import java.util.HashMap;

import javafx.animation.PauseTransition;
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
        
        login.getIdentifier().getConnectionButton().setOnAction((event) ->
        {
            HashMap<String, String> identificatioInfos = login.getIdentifier().getIdentificationInfos() ;
            if (identificatioInfos.get("userId").equals("admin") && !identificatioInfos.get("userPassword").equals("") )
            {
                this.getChildren().clear() ;
                this.getChildren().add(this.standardBoard) ;
            }
            else if (identificatioInfos.get("userId").equals("standard") && !identificatioInfos.get("userPassword").equals(""))
            {
                this.getChildren().clear() ;
                this.getChildren().add(this.standardBoard) ;              
            }
            else
            {
                login.getIdentifier().getLoginErrorLabel().setVisible(true) ;
                PauseTransition pause = new PauseTransition(Duration.seconds(1.5)) ;
                pause.setOnFinished((event1) ->
                {
                    login.getIdentifier().getLoginErrorLabel().setVisible(false);
                }) ;
                pause.play();
            }
        }) ;
    }

    public Scene getMainScene()
    { return this.mainScene ; }
}