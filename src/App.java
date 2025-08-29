import platfrom.Login ;

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
        Login root = new Login() ;

        mainStage.setScene(root.getMainLoginHboxScene()) ;
        mainStage.setTitle("Bibliotheque VIP") ;
        mainStage.setMaximized(true) ;
        mainStage.show() ;
    }
}