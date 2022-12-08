package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import model.Country;

import java.io.*;
import java.util.ArrayList;

public class MacsFrameworkController {
    @FXML
    Label nameLabel, marketCriteriaWeight, compCriteriaWeight, marketWeightText, compWeightText;
    @FXML
    TextArea criteriaAreaMarket1, criteriaAreaMarket2, criteriaAreaMarket3, criteriaAreaComp1, criteriaAreaComp2, criteriaAreaComp3;
    @FXML
    TextField weightFieldMarket1, weightFieldMarket2, weightFieldMarket3, weightFieldComp1, weightFieldComp2, weightFieldComp3;
    @FXML
    Button country1Button, country2Button, country3Button, saveAllButton;

    private ArrayList<Country> model;
    private ViewController viewController;

    // Initialises the model and viewController
    public void init(ViewController viewController, ArrayList<Country> model) {
        this.model = model;
        this.viewController = viewController;
    }

    // Gets the login username and gets it on the "page"
    public void displayName(String username) {
        nameLabel.setText(username);
    }

    // Saves the entered criteria
    public void saveAllCriteria() {
        try {
            if (Integer.parseInt(weightFieldMarket1.getText()) + Integer.parseInt(weightFieldMarket2.getText()) + Integer.parseInt(weightFieldMarket3.getText()) == 100) {
                marketCriteriaWeight.setTextFill(Color.GREEN);
                marketWeightText.setTextFill(Color.GREEN);

                if (Integer.parseInt(weightFieldComp1.getText()) + Integer.parseInt(weightFieldComp2.getText()) + Integer.parseInt(weightFieldComp3.getText()) == 100 ) {
                    compCriteriaWeight.setTextFill(Color.GREEN);
                    compWeightText.setTextFill(Color.GREEN);

                    for (Country country : model) {
                        // Adding the criteria to each country object in our array
                        // Market attractiveness
                        country.addCriteria(criteriaAreaMarket1.getText(), Integer.parseInt(weightFieldMarket1.getText()));
                        country.addCriteria(criteriaAreaMarket2.getText(), Integer.parseInt(weightFieldMarket2.getText()));
                        country.addCriteria(criteriaAreaMarket3.getText(), Integer.parseInt(weightFieldMarket3.getText()));

                        // Competitive strength
                        country.addCriteria(criteriaAreaComp1.getText(), Integer.parseInt(weightFieldComp1.getText()));
                        country.addCriteria(criteriaAreaComp2.getText(), Integer.parseInt(weightFieldComp2.getText()));
                        country.addCriteria(criteriaAreaComp3.getText(), Integer.parseInt(weightFieldComp3.getText()));
                    }

                    // Calling the setCriteria-method in the different country controllers
                    viewController.getCountry1Controller().setCriteria();
                    viewController.getCountry2Controller().setCriteria();
                    viewController.getCountry3Controller().setCriteria();
                }
                else {
                    System.out.println("Comp weight has to equal 100%");
                    compCriteriaWeight.setTextFill(Color.RED);
                    compWeightText.setTextFill(Color.RED);
                }
            }
            else {
                System.out.println("Market weight has to equal 100%");
                marketCriteriaWeight.setTextFill(Color.RED);
                marketWeightText.setTextFill(Color.RED);
            }

            marketCriteriaWeight.setText(Integer.parseInt(weightFieldMarket1.getText()) + Integer.parseInt(weightFieldMarket2.getText()) + Integer.parseInt(weightFieldMarket3.getText()) + "%");
            compCriteriaWeight.setText(Integer.parseInt(weightFieldComp1.getText()) + Integer.parseInt(weightFieldComp2.getText()) + Integer.parseInt(weightFieldComp3.getText()) + "%");
        }
        catch (RuntimeException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Empty fields!");
            alert.setContentText("Please fill out all the fields before saving.");
            alert.showAndWait();
        }
    }

    // Saves the entered criteria in our model and saves the criteria to a .bin file found in savedCriteria folder.
    public void saveCriteriaTemplate() {
        try {
            if (Integer.parseInt(weightFieldMarket1.getText()) + Integer.parseInt(weightFieldMarket2.getText()) + Integer.parseInt(weightFieldMarket3.getText()) == 100) {
                marketCriteriaWeight.setTextFill(Color.GREEN);
                marketWeightText.setTextFill(Color.GREEN);

                if (Integer.parseInt(weightFieldComp1.getText()) + Integer.parseInt(weightFieldComp2.getText()) + Integer.parseInt(weightFieldComp3.getText()) == 100 ) {
                    compCriteriaWeight.setTextFill(Color.GREEN);
                    compWeightText.setTextFill(Color.GREEN);

                    for (Country country : model) {
                        // Adding the criteria to each country object in our array
                        // Market attractiveness
                        country.addCriteria(criteriaAreaMarket1.getText(), Integer.parseInt(weightFieldMarket1.getText()));
                        country.addCriteria(criteriaAreaMarket2.getText(), Integer.parseInt(weightFieldMarket2.getText()));
                        country.addCriteria(criteriaAreaMarket3.getText(), Integer.parseInt(weightFieldMarket3.getText()));

                        // Competitive strength
                        country.addCriteria(criteriaAreaComp1.getText(), Integer.parseInt(weightFieldComp1.getText()));
                        country.addCriteria(criteriaAreaComp2.getText(), Integer.parseInt(weightFieldComp2.getText()));
                        country.addCriteria(criteriaAreaComp3.getText(), Integer.parseInt(weightFieldComp3.getText()));
                    }

                    // Calling the setCriteria-method in the different country controllers
                    viewController.getCountry1Controller().setCriteria();
                    viewController.getCountry2Controller().setCriteria();
                    viewController.getCountry3Controller().setCriteria();
                }
                else {
                    System.out.println("Comp weight has to equal 100%");
                    compCriteriaWeight.setTextFill(Color.RED);
                    compWeightText.setTextFill(Color.RED);
                }
            }
            else {
                System.out.println("Market weight has to equal 100%");
                marketCriteriaWeight.setTextFill(Color.RED);
                marketWeightText.setTextFill(Color.RED);
            }

            marketCriteriaWeight.setText(Integer.parseInt(weightFieldMarket1.getText()) + Integer.parseInt(weightFieldMarket2.getText()) + Integer.parseInt(weightFieldMarket3.getText()) + "%");
            compCriteriaWeight.setText(Integer.parseInt(weightFieldComp1.getText()) + Integer.parseInt(weightFieldComp2.getText()) + Integer.parseInt(weightFieldComp3.getText()) + "%");
        }
        catch (RuntimeException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Empty fields!");
            alert.setContentText("Please fill out all the fields before saving.");
            alert.showAndWait();
            return;
        }

        try {
            // Pops up a text dialog box for you to name the file in
            TextInputDialog fileOutName = new TextInputDialog("ex. criteria, template");
            fileOutName.setHeaderText("Output file name");
            fileOutName.showAndWait();
            String outputFileName = fileOutName.getEditor().getText();

            // Sets the directory for the file to be saved in and as.
            FileOutputStream fileOut = new FileOutputStream("savedCriteria/" + outputFileName + ".bin");
            ObjectOutputStream write = new ObjectOutputStream(fileOut);

            write.writeObject(new Country(model.get(0).getCountry(), new ArrayList<>(model.get(0).criteria)));
            write.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        catch (IOException e) {
            System.out.println("File not found.");
        }
    }

    public void handleLoadCriteria() {

        try {
            // Opens the FileChooser window
            viewController.switchScene(ViewController.OPEN_FILE_CHOOSER);

            ObjectInputStream read;
            if (viewController.file != null) {
                // gets the location/path of the file
                FileInputStream fileIn = new FileInputStream(viewController.file.getAbsolutePath());
                read = new ObjectInputStream(fileIn);

                while (true) {
                    try {
                        // Reads the saved object from the file into our TextAreas and WeightFields.
                        Country country = (Country) read.readObject();
                        criteriaAreaMarket1.setText(country.getCriteria(0).getCriteria());
                        criteriaAreaMarket2.setText(country.getCriteria(1).getCriteria());
                        criteriaAreaMarket3.setText(country.getCriteria(2).getCriteria());
                        criteriaAreaComp1.setText(country.getCriteria(3).getCriteria());
                        criteriaAreaComp2.setText(country.getCriteria(4).getCriteria());
                        criteriaAreaComp3.setText(country.getCriteria(5).getCriteria());

                        weightFieldMarket1.setText(String.valueOf(country.getCriteria(0).getWeight()));
                        weightFieldMarket2.setText(String.valueOf(country.getCriteria(1).getWeight()));
                        weightFieldMarket3.setText(String.valueOf(country.getCriteria(2).getWeight()));
                        weightFieldComp1.setText(String.valueOf(country.getCriteria(3).getWeight()));
                        weightFieldComp2.setText(String.valueOf(country.getCriteria(4).getWeight()));
                        weightFieldComp3.setText(String.valueOf(country.getCriteria(5).getWeight()));
                    }
                    catch (EOFException e) {
                        System.out.println("End of file");
                        break;
                    }
                }
                read.close();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        catch (IOException e) {
            System.out.println("File not found.2");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class not found.");
        }
    }

    // Switches scenes
    public void handleHomeButton() {
        viewController.switchScene(ViewController.DASHBOARD_SCENE);
    }

    public void handleCountry1Button() {
        viewController.switchScene(ViewController.COUNTRY_1_SCENE);
    }

    public void handleCountry2Button() {
        viewController.switchScene(ViewController.COUNTRY_2_SCENE);
    }

    public void handleCountry3Button() {
        viewController.switchScene(ViewController.COUNTRY_3_SCENE);
    }

    public void handleLogoff() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Are you sure you want to logout? Information could be lost. ");

        if (alert.showAndWait().get() == ButtonType.OK) {
            viewController.switchScene(ViewController.LOGIN_SCENE);
        }
    }
}
