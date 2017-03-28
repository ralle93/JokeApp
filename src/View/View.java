package View;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import static javafx.application.Application.launch;


/**
 * Created by rasmusthrane on 24/03/17.
 */
public class View extends Application {

    BorderPane borderpane = new BorderPane();

    public HBox viewRatings() {
        TableColumn jokeColumn = new TableColumn("Joke");
        jokeColumn.setPrefWidth(400);
        TableColumn ratingColumn = new TableColumn("Rating");
        ratingColumn.setPrefWidth(100);

        TableView jokesTable = new TableView();
        jokesTable.getColumns().addAll(jokeColumn, ratingColumn);

        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().add(jokesTable);
        return hbox;
    }

    public HBox viewJokes() {
        Label jokeLabel = new Label("This is a joke");
        Button likeButton = new Button("Like");
        Button dislikeButton = new Button("Dislike");
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().add(jokeLabel);
        hbox.getChildren().add(likeButton);
        hbox.getChildren().add(dislikeButton);
        return hbox;
    }

    public void start(Stage primaryStage) {

        Label mainLabel = new Label("Main");
        //Temp Labels
        Label viewAllLabel = new Label("View All");

        Button button1 = new Button("Rate Jokes page");
        button1.setOnAction(event -> {
            borderpane.setCenter(viewJokes());
        });
        Button button2 = new Button("View All Jokes by Rating");
        button2.setOnAction(event -> {
            borderpane.setCenter(viewRatings());
        });

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(10,10,10,10));
        hbox.getChildren().add(button1);
        hbox.getChildren().add(button2);

        borderpane.setTop(hbox);
        borderpane.setCenter(mainLabel);

        Scene mainScene = new Scene(borderpane, 1000, 800);
        primaryStage.setTitle("JokeApp");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
