package platfrom;

import javafx.geometry.Insets ;
import javafx.geometry.Pos ;
import javafx.scene.layout.VBox ;
import javafx.scene.layout.HBox ;
import javafx.scene.Scene ;
import javafx.scene.layout.Priority ;
import javafx.scene.layout.Region ;
import javafx.scene.layout.StackPane ;
import javafx.scene.control.TextField ;
import javafx.scene.control.CheckBox ;
import javafx.scene.control.Label ;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button ;
import javafx.scene.Parent ;

public class Login extends HBox
{
    private Scene scene ;
    private VBox rightVbox ;

    public Login()
    {
        super() ;

        VBox leftVbox = new VBox() ;
        rightVbox = new VBox() ;
        HBox.setHgrow(leftVbox, Priority.ALWAYS);
        HBox.setHgrow(rightVbox, Priority.ALWAYS);
        rightVbox.getChildren().add(login()) ;
        rightVbox.setAlignment(Pos.CENTER);
        this.getChildren().addAll(leftVbox, rightVbox) ;
        this.scene = new Scene(this) ;
        /* CSS Style */
        this.scene.getStylesheets().add("file:rssrc/styles/login.css") ;
        /* CSS Style */
    }
    
    private Parent login()
    {
        int userLoginWidth = 320 ;
        int userLoginHeight = 400 ;

        StackPane stackPane = new StackPane() ;
        VBox userLoginShadow = new VBox();
        VBox userLogin = (VBox) defineUserLogin(userLoginWidth, userLoginHeight) ;
        userLoginShadow.setMaxWidth(userLoginWidth) ;
        userLoginShadow.setMinHeight(userLoginHeight) ;
        stackPane.getChildren().addAll(userLoginShadow, userLogin);
        /* CSS Style */
        userLogin.setId("userlogin") ;
        userLoginShadow.getStyleClass().add("userloginshadow") ;
        /* CSS Style */
        
        return stackPane ;
    }

    private Parent defineUserLogin(int userLoginWidth, int userLoginHeight)
    {
        VBox userLogin = new VBox(15) ;

        userLogin.setMinSize(userLoginWidth, userLoginHeight);
        userLogin.setMaxSize(userLoginWidth, userLoginHeight);
        userLogin.setPrefSize(userLoginWidth, userLoginHeight);

        VBox identifying = (VBox) labelNameAndTextField("Entrez votre identfiant") ;
        VBox password = (VBox) labelNameAndPasswordField("Mot de passe") ;
        Label loginError = new Label() ;

        Region hSpacer1 = new Region() ;
        Region hSpacer2 = new Region() ;
        HBox.setHgrow(hSpacer1, Priority.ALWAYS);
        HBox.setHgrow(hSpacer2, Priority.ALWAYS);
        HBox remindFOrgetPassword = new HBox(new CheckBox("Se souvenir de moi"), hSpacer1, new Label("Mot de passe oublié ?")) ;
        Button connexionButton = new Button("Se connecter".toUpperCase()) ;
        HBox firstLaunch = new HBox(new Label("Vous n'avez pas de compte ?"), hSpacer2, new Label("S'inscrire")) ;

        userLogin.setAlignment(Pos.CENTER);
        userLogin.setPadding(new Insets(5, 10, 5, 10));
        userLogin.getChildren().addAll(identifying, password, loginError, remindFOrgetPassword, connexionButton, firstLaunch) ;
        
        /* CSS Style */
        identifying.getChildren().get(0).getStyleClass().add("loginlabel") ;
        password.getChildren().get(0).getStyleClass().add("loginlabel") ;
         identifying.getChildren().get(1).getStyleClass().add("loginfield") ;
        password.getChildren().get(1).getStyleClass().add("loginfield") ;
        remindFOrgetPassword.getChildren().get(2).setId("forgetpassword") ;
        firstLaunch.getChildren().get(2).setId("inscribe") ;
        /* CSS Style */

        /* Event */
        firstLaunch.getChildren().get(2).setOnMouseClicked((event) ->
        {
            rightVbox.getChildren().remove(0) ;
            rightVbox.getChildren().add(new Inscribe()) ;
        }) ;
        remindFOrgetPassword.getChildren().get(2).setOnMouseClicked((event) ->
        {
            System.out.println("MOT DE PASSE OUBLIER") ;
        }) ;
        /* Event */

        return userLogin ;
    }

    public Parent labelNameAndTextField(String name)
    { return new VBox(5, new Label(name), new TextField()) ; }

    public Parent labelNameAndPasswordField(String name)
    { return new VBox(5, new Label(name), new PasswordField()) ; }

    public Scene getMainLoginHboxScene()
    { return this.scene ; }
}