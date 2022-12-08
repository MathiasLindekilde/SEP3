import javafx.application.Application;
import javafx.stage.Stage;
import model.Country;
import view.ViewController;

import java.util.ArrayList;

public class Main extends Application {
    private ViewController viewController;
    private ArrayList<Country> model;

    @Override
    public void start(Stage stage) {
        Country country1 = new Country("Country1");
        Country country2 = new Country("Country2");
        Country country3 = new Country("Country3");
        model = new ArrayList<>();
        model.add(country1);
        model.add(country2);
        model.add(country3);
        viewController = new ViewController(stage, model);

    }

    public static void main(String[] args) {
        Application.launch(Main.class);
    }
}
