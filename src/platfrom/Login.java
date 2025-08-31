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
    private VBox leftVbox ;
    private Button returnButton ;
    private StackPane login ;
    private Inscribe inscribe ;

    public Login()
    {
        super() ;

        leftVbox = new VBox() ;
        rightVbox = new VBox() ;
        returnButton = new Button("<") ;
        inscribe = new Inscribe() ;

        returnButton.setVisible(false) ;
        login = (StackPane) defineLogin() ;
        rightVbox.getChildren().addAll(new HBox(returnButton), login) ;
        ((HBox)rightVbox.getChildren().get(0)).setPadding(new Insets(20, 0, 0, 20));
        HBox.setHgrow(leftVbox, Priority.ALWAYS) ;
        HBox.setHgrow(rightVbox, Priority.ALWAYS) ;
        VBox.setVgrow(login, Priority.ALWAYS) ;
        this.getChildren().addAll(leftVbox, rightVbox) ;
        this.scene = new Scene(this) ;

        /* CSS Style */
        this.scene.getStylesheets().add("file:rssrc/styles/login.css") ;
        /* CSS Style */
        
        returnButton.setOnMouseClicked((event) ->
        {
            if (rightVbox.getChildren().contains(inscribe) && inscribe.choiceInOccurrence())
            {
                rightVbox.getChildren().removeLast() ;
                rightVbox.getChildren().add(login) ;
                returnButton.setVisible(false) ;
            }
            else
            {
                inscribe.defaultDefenition() ;
            }
        });
        
        /* Listener */
        scene.widthProperty().addListener((obs, oldVal, newVal) ->
        {
            double w = newVal.doubleValue() ;
            
            if (w < 600)
            {
                this.getChildren().remove(leftVbox) ;
            }
            else
            {
                this.getChildren().clear() ;
                this.getChildren().addAll(leftVbox, rightVbox) ;
            }
            if (this.getChildren().contains(leftVbox))
            {
                leftVbox.setPrefWidth(w*0.4) ;
                leftVbox.setMinWidth(w*0.4) ;
                leftVbox.setMaxWidth(w*0.4) ;
            }
        }) ;
        /* Listener */
    }
    
    private Parent defineLogin()
    {
        int userLoginWidth = 320 ;
        int userLoginHeight = 400 ;

        StackPane stackPane = new StackPane() ;
        VBox userLoginShadow = new VBox() ;
        VBox userLogin = (VBox) defineUserLogin(userLoginWidth, userLoginHeight) ;
        userLoginShadow.setMinSize(userLoginWidth, userLoginHeight) ;
        userLoginShadow.setMaxSize(userLoginWidth, userLoginHeight) ;
        stackPane.getChildren().addAll(userLoginShadow, userLogin);
        /* CSS Style */
        userLogin.getStyleClass().add("userlogin") ;
        userLoginShadow.getStyleClass().add("userloginshadow") ;
        /* CSS Style */

        return stackPane ;
    }

    private Parent defineUserLogin(int userLoginWidth, int userLoginHeight)
    {
        VBox userLogin = new VBox(15) ;

        userLogin.setMinSize(userLoginWidth, userLoginHeight) ;
        userLogin.setMaxSize(userLoginWidth, userLoginHeight) ;
        userLogin.setPrefSize(userLoginWidth, userLoginHeight) ;

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
            returnButton.setVisible(true) ;
            rightVbox.getChildren().removeLast() ;
            rightVbox.getChildren().add(inscribe) ;
            HBox.setHgrow(rightVbox, Priority.ALWAYS) ;
        }) ;
        remindFOrgetPassword.getChildren().get(2).setOnMouseClicked((event) ->
        {
            System.out.println("MOT DE PASSE OUBLIER") ;
        }) ;
        /* Event */

        return userLogin ;
    }

    public static Parent labelNameAndTextField(String name)
    { return new VBox(5, new Label(name), new TextField()) ; }

    public static Parent labelNameAndPasswordField(String name)
    { return new VBox(5, new Label(name), new PasswordField()) ; }

    public Scene getMainLoginHboxScene()
    { return this.scene ; }
}