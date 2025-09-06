import platfrom.Launching ;

import javafx.application.Application ;
import javafx.stage.Stage ;

public class App extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args) ;
    }

    public void start(Stage mainStage) throws Exception
    {
        Launching root = new Launching() ;
        mainStage.setScene(root.getMainScene()) ;
        mainStage.setTitle("Bibliotheque VIP") ;
        mainStage.setMinHeight(600) ;
        mainStage.setMinWidth(400) ;
        mainStage.setMaximized(true) ;
        mainStage.show() ;
    }
}