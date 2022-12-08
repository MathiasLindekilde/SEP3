package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Country;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ViewController {
    public Stage stage;
    private Scene loginScene;
    private LoginController loginController;
    private Scene dashboardScene;
    private DashboardController dashboardController;
    private Scene macsFrameworkScene;
    private MacsFrameworkController macsFrameworkController;
    private Scene country1Scene;
    private Country1Controller country1Controller;
    private Scene country2Scene;
    private Country2Controller country2Controller;
    private Scene country3Scene;
    private Country3Controller country3Controller;

    public static final String LOGIN_SCENE = "LOGIN_SCENE";
    public static final String DASHBOARD_SCENE = "DASHBOARD_SCENE";
    public static final String MACS_FRAMEWORK_SCENE = "MACS_FRAMEWORK_SCENE";
    public static final String COUNTRY_1_SCENE = "COUNTRY_1_SCENE";
    public static final String COUNTRY_2_SCENE = "COUNTRY_2_SCENE";
    public static final String COUNTRY_3_SCENE = "COUNTRY_3_SCENE";
    public static final String OPEN_FILE_CHOOSER = "OPEN_FILE_CHOOSER";

    Image icon;
    FileChooser fileChooser;
    File file;

    // Loads the needed scenes, and initialises the stage, icon etc.
    public ViewController(Stage stage, ArrayList<Country> model) {
        this.stage = stage;
        icon = new Image("images/icon.jpg");
        fileChooser = new FileChooser();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("LoginScene.fxml"));
        try {
            loginScene = new Scene(loader.load());
            loginScene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
            loginController = loader.getController();
            loginController.init(this);

        }
        catch (IOException e) {
            System.out.println("Failed to load LoginScene.fxml");
            System.exit(1);
        }

        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("DashboardScene.fxml"));
        try {
            dashboardScene = new Scene(loader.load());
            dashboardScene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
            dashboardController = loader.getController();
            dashboardController.init(this, model);
        }
        catch (IOException e) {
            System.out.println("Failed to load DashboardScene.fxml");
            System.exit(1);
        }

        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MacsFrameworkScene.fxml"));
        try {
            macsFrameworkScene = new Scene(loader.load());
            macsFrameworkScene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
            macsFrameworkController = loader.getController();
            macsFrameworkController.init(this, model);
        }
        catch (IOException e) {
            System.out.println("Failed to load MacsFrameworkScene.fxml");
            System.exit(1);
        }

        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Country1Scene.fxml"));
        try {
            country1Scene = new Scene(loader.load());
            country1Scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
            country1Controller = loader.getController();
            country1Controller.init(this, model);
        }
        catch (IOException e) {
            System.out.println("Failed to load Country1Scene.fxml");
            System.exit(1);
        }

        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Country2Scene.fxml"));
        try {
            country2Scene = new Scene(loader.load());
            country2Scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
            country2Controller = loader.getController();
            country2Controller.init(this, model);
        }
        catch (IOException e) {
            System.out.println("Failed to load Country2Scene.fxml");
            System.exit(1);
        }

        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Country3Scene.fxml"));
        try {
            country3Scene = new Scene(loader.load());
            country3Scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
            country3Controller = loader.getController();
            country3Controller.init(this, model);
        }
        catch (IOException e) {
            System.out.println("Failed to load Country3Scene.fxml");
            System.exit(1);
        }

        // Switches to the start scene at app launch
        switchScene(LOGIN_SCENE);
    }

    // Switches scenes depending on parameter entered
    public void switchScene(String sceneName) {
        stage.getIcons().add(icon);
        stage.setResizable(false);

        if (LOGIN_SCENE.equals(sceneName)) {
            stage.setTitle("MACS - Login");
            stage.setScene(loginScene);
            stage.show();
        }
        else if (DASHBOARD_SCENE.equals(sceneName)) {
            stage.setTitle("MACS - Dashboard");
            stage.setScene(dashboardScene);
            stage.show();
        }
        else if (MACS_FRAMEWORK_SCENE.equals(sceneName)) {
            stage.setTitle("MACS - Set criteria");
            stage.setScene(macsFrameworkScene);
            stage.show();
        }
        else if (COUNTRY_1_SCENE.equals(sceneName)) {
            stage.setTitle("MACS - Country 1");
            stage.setScene(country1Scene);
            stage.show();
        }
        else if (COUNTRY_2_SCENE.equals(sceneName)) {
            stage.setTitle("MACS - Country 2");
            stage.setScene(country2Scene);
            stage.show();
        }
        else if (COUNTRY_3_SCENE.equals(sceneName)) {
            stage.setTitle("MACS - Country 3");
            stage.setScene(country3Scene);
            stage.show();
        }
        else if (OPEN_FILE_CHOOSER.equals(sceneName)) {
            stage.setTitle("Select a file");
            file = fileChooser.showOpenDialog(stage);
        }
    }

    // Getting the different controllers
    public DashboardController getDashboardController() {
        return dashboardController;
    }

    public MacsFrameworkController getMacsFrameworkController() {
        return macsFrameworkController;
    }

    public Country1Controller getCountry1Controller() {
        return country1Controller;
    }

    public Country2Controller getCountry2Controller() {
        return country2Controller;
    }

    public Country3Controller getCountry3Controller() {
        return country3Controller;
    }







}

