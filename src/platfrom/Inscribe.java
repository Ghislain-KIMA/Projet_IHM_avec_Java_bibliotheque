package platfrom ;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox ;

public class Inscribe extends VBox
{
    private VBox choice ;

    public Inscribe()
    {
        super() ;

        choice = new VBox(20, new Label("Utilisateur"), new Label("Gestionnaire")) ;
        choice.setAlignment(Pos.CENTER) ;
        ((Label) choice.getChildren().get(0)).setPadding(new Insets(5)) ;
        ((Label) choice.getChildren().get(1)).setPadding(new Insets(5)) ;
        
        VBox.setVgrow(this, Priority.ALWAYS) ;
        VBox.setVgrow(choice, Priority.ALWAYS) ;
        this.getChildren().addAll(choice) ;
        this.setAlignment(Pos.CENTER) ;
        this.getStylesheets().add("file:rssrc/styles/login.css") ;
        this.getStylesheets().add("file:rssrc/styles/inscribe.css") ;

        /* Event */
        ((Label) choice.getChildren().get(0)).setOnMouseClicked((event) ->
        {
            this.getChildren().remove(0) ;
            this.getChildren().add((StackPane) defineConfig("Entrez votre numéro de carte d'accès")) ;
        }) ;
        ((Label) choice.getChildren().get(1)).setOnMouseClicked((event) ->
        {
            this.getChildren().remove(0) ;
            this.getChildren().add((StackPane) defineConfig("Entrez votre code de permis de gestion")) ;
        }) ;
        /* Event */

        /* CSS Style */
        choice.getChildren().get(0).getStyleClass().add("choicelabel") ;
        choice.getChildren().get(1).getStyleClass().add("choicelabel") ;
        choice.getChildren().get(0).getStyleClass().add("userloginshadow") ;
        choice.getChildren().get(1).getStyleClass().add("userloginshadow") ;
        /* CSS Style */
    }

    private Parent defineConfig(String accessCarteCodeLabel)
    {
        int userLoginWidth = 320 ;
        int userLoginHeight = 460 ;

        StackPane stackpane = new StackPane() ;
        VBox userConfigShadow = new VBox() ;
        VBox userConfig = new VBox(15) ;
        VBox lastName = (VBox) Login.labelNameAndTextField("Nom") ;
        VBox firstName = (VBox) Login.labelNameAndTextField("Prénom") ;
        VBox accessCarteCode = (VBox) Login.labelNameAndTextField(accessCarteCodeLabel) ;
        VBox password = (VBox) Login.labelNameAndPasswordField("Mot de passe") ;
        VBox confirmPassword = (VBox) Login.labelNameAndPasswordField("Confirmer mot de passe") ;
        Region spacer = new Region() ;
        HBox.setHgrow(spacer, Priority.ALWAYS) ;
        HBox actions = new HBox(new Button("Effacer"), spacer, new Button("Enregistrer")) ;
        userConfigShadow.setMinSize(userLoginWidth, userLoginHeight) ;
        userConfigShadow.setMaxSize(userLoginWidth, userLoginHeight) ;
        userConfig.setMaxSize(userLoginWidth, userLoginHeight);
        userConfig.setAlignment(Pos.CENTER) ;
        userConfig.setPadding(new Insets(5, 10, 5, 10));
        
        userConfig.getChildren().addAll(lastName, firstName, accessCarteCode, password, confirmPassword, new Label(""), actions) ;
        stackpane.getChildren().addAll(userConfigShadow, userConfig) ;
        /* CSS Style */
        lastName.getChildren().get(0).getStyleClass().add("loginlabel") ;
        firstName.getChildren().get(0).getStyleClass().add("loginlabel") ;
        accessCarteCode.getChildren().get(0).getStyleClass().add("loginlabel") ;
        password.getChildren().get(0).getStyleClass().add("loginlabel") ;
        confirmPassword.getChildren().get(0).getStyleClass().add("loginlabel") ;
        lastName.getChildren().get(1).getStyleClass().add("loginfield") ;
        firstName.getChildren().get(1).getStyleClass().add("loginfield") ;
        accessCarteCode.getChildren().get(1).getStyleClass().add("loginfield") ;
        password.getChildren().get(1).getStyleClass().add("loginfield") ;
        confirmPassword.getChildren().get(1).getStyleClass().add("loginfield") ;
        userConfig.getStyleClass().add("userlogin") ;
        userConfigShadow.getStyleClass().add("userloginshadow") ;
        /* CSS Style */

        return stackpane ;
    }

    public boolean choiceInOccurrence()
    {
        return this.getChildren().contains(choice) ;
    }
    
    public void defaultDefenition()
    {
        this.getChildren().remove(0) ;
        this.getChildren().addAll(choice) ;
    }
}
