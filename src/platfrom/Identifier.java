package platfrom ;

import java.util.HashMap;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox ;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox ;

public class Identifier extends VBox
{
    private Label labelInscribe ;
    private Button connectionButton ;
    private TextField userId ;
    private PasswordField userPassword ;

    private Label loginError ;

    public Identifier()
    {
        this.getChildren().add((StackPane) builIdentifierEntreeBoard()) ;
        this.setAlignment(Pos.CENTER) ;
    }

    private Parent builIdentifierEntreeBoard()
    {
        int connectionWidth = 320 ;
        int connectionHeight = 400 ;

        VBox identifying = (VBox) labelNameAndTextField("Entrez votre identfiant") ;
        VBox password = (VBox) labelNameAndPasswordField("Mot de passe") ;
        this.userId = (TextField) identifying.getChildren().get(1) ;
        this.userPassword = (PasswordField) password.getChildren().get(1) ;
        loginError = new Label("Vos informations sont invalides") ;
        loginError.setId("loginerror") ;
        loginError.setVisible(false) ;
        Region hSpacer1 = new Region() ;
        Region hSpacer2 = new Region() ;
        HBox.setHgrow(hSpacer1, Priority.ALWAYS);
        HBox.setHgrow(hSpacer2, Priority.ALWAYS);
        HBox remindFOrgetPassword = new HBox(5, new CheckBox(), new Label("Se souvenir de moi"), hSpacer1, new Label("Mot de passe oublié ?")) ;
        remindFOrgetPassword.getChildren().get(0).setId("sesouvenirdemoi");
        connectionButton = new Button("Se connecter".toUpperCase()) ;
        labelInscribe = new Label("S'inscrire") ;
        HBox firstLaunch = new HBox(new Label("Vous n'avez pas de compte ?"), hSpacer2, labelInscribe) ;
        
        VBox entreeBoard = new VBox(15, identifying, password, loginError, remindFOrgetPassword, connectionButton, firstLaunch) ;
        entreeBoard.setAlignment(Pos.CENTER);
        entreeBoard.setPadding(new Insets(30, 10, 30, 10));
        
        StackPane stackPane = new StackPane(new VBox(), entreeBoard) ;
        stackPane.setMaxSize(connectionWidth, connectionHeight);
            /* CSS Style */
        this.connectionButton.getStyleClass().add("connectionbutton");
        identifying.getChildren().get(0).getStyleClass().add("identifylabel") ;
        password.getChildren().get(0).getStyleClass().add("identifylabel") ;
        identifying.getChildren().get(1).getStyleClass().add("identifyfield") ;
        password.getChildren().get(1).getStyleClass().add("identifyfield") ;
        remindFOrgetPassword.getChildren().get(3).setId("forgetpassword") ;
        firstLaunch.getChildren().get(2).setId("inscribe") ;
        ((VBox) stackPane.getChildren().get(0)).getStyleClass().add("userentreeboardshadow") ;
        ((VBox) stackPane.getChildren().get(1)).getStyleClass().add("userentreeboard") ;
            /* CSS Style */
        return stackPane ;
    }

    public Button getConnectionButton()
    {   return this.connectionButton ;  }

    public HashMap<String, String> getIdentificationInfos()
    {
        HashMap<String, String> infos = new HashMap<>() ;
        infos.put("userId", this.userId.getText()) ;
        infos.put("userPassword", this.userPassword.getText()) ;
        return infos ;
    }

    public Label getLoginErrorLabel()
    {
        return this.loginError ;
    }

    public Label getLabelInscribe()
    {   return labelInscribe ;  }

    public static Parent labelNameAndTextField(String name)
    {   return new VBox(5, new Label(name), new TextField()) ;  }

    public static Parent labelNameAndPasswordField(String name)
    {   return new VBox(5, new Label(name), new PasswordField()) ;  }
}
