package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    TextField usernameField;
    @FXML
    PasswordField passwordField;
    @FXML
    Label loginErrorLabel;

    private ViewController viewController;

    // Initialises the viewController
    public void init(ViewController viewController) {
        this.viewController = viewController;
    }

    // handles the login when button is clicked
    public void handleLogin() {
        if (usernameField.getText().equals("Admin") && passwordField.getText().equals("123")) {

            // Getting the dashboard & framework-Controller and using the method to set the name on dashboard.
            viewController.getDashboardController().displayName(usernameField.getText());
            viewController.getMacsFrameworkController().displayName(usernameField.getText());
            viewController.getCountry1Controller().displayName(usernameField.getText());
            viewController.getCountry2Controller().displayName(usernameField.getText());
            viewController.getCountry3Controller().displayName(usernameField.getText());

            // Clearing the fields
            usernameField.clear();
            passwordField.clear();
            loginErrorLabel.setText("");

            // Switching the scene
            viewController.switchScene(ViewController.DASHBOARD_SCENE);

        }
        else {
            loginErrorLabel.setText("Error, please enter valid username and password!");
        }
    }
}
