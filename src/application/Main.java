package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Main extends Application {
	int cat1Score = 0, cat2Score = 0;
	String cat1 = "Java Team", cat2 = "SQL Team";
	private Label score1Lbl, score2Lbl;
	private Button cat1Btn, cat2Btn, showBtn, resetBtn;

	@Override
	public void start(Stage primaryStage) {
		//unchangeable value for the width of the buttons
		final double BTN_WIDTH = 100;

		//create and position the Java category label
		Label cat1Lbl = new Label(cat1);
		cat1Lbl.setLayoutX(110);
		cat1Lbl.setLayoutY(10);
		cat1Lbl.setTextFill(Color.RED);

		//create and position the category 1 scores label
		score1Lbl = new Label("" + cat1Score);
		score1Lbl.setLayoutX(130);
		score1Lbl.setLayoutY(40);
		score1Lbl.setTextFill(Color.RED);
		score1Lbl.setVisible(false);

		//Create and position the category 1 button
		cat1Btn = new Button("Vote " + cat1);
		cat1Btn.setLayoutX(90);
		cat1Btn.setLayoutY(80);
		cat1Btn.setPrefWidth(BTN_WIDTH);

		cat1Btn.setOnAction((ActionEvent event) -> {
			cat1Score++;
			//score1Lbl.setText(""+cat1Score);
		});//end lambda expression

		//create and position the SQL category label
		Label cat2Lbl = new Label(cat2);
		cat2Lbl.setLayoutX(230);
		cat2Lbl.setLayoutY(10);
		cat2Lbl.setTextFill(Color.BLUE);

		//create and position the category 2 scores label
		score2Lbl = new Label("" + cat2Score);
		score2Lbl.setLayoutX(250);
		score2Lbl.setLayoutY(40);
		score2Lbl.setTextFill(Color.BLUE);
		score2Lbl.setVisible(false);

		//Create and position the category 2 button
		cat2Btn = new Button("Vote " + cat2);
		cat2Btn.setLayoutX(210);
		cat2Btn.setLayoutY(80);
		cat2Btn.setPrefWidth(BTN_WIDTH);

		cat2Btn.setOnAction((ActionEvent event) -> {
			cat2Score++;
			//score2Lbl.setText(""+cat2Score);
		});//end lambda expression

		//Create and position the show votes button
		showBtn = new Button("Show Votes");
		showBtn.setLayoutX(90);
		showBtn.setLayoutY(120);
		showBtn.setPrefWidth(BTN_WIDTH);

		showBtn.setOnAction((ActionEvent event) -> {
			showVotes();
			setBtnUse(true, true, true, false);
		});//end lambda expression

		//Create and position the reset votes button
		resetBtn = new Button("Reset Votes");
		resetBtn.setLayoutX(210);
		resetBtn.setLayoutY(120);
		resetBtn.setPrefWidth(BTN_WIDTH);
		resetBtn.setDisable(true);

		resetBtn.setOnAction((ActionEvent event) -> {
			resetVotes();
			setBtnUse(false, false, false, true);
		});//end lambda expression

		//create a link to the Java image
		Image jImage = new Image(Main.class.getResourceAsStream("/Java_Duke.png"));

		//Setting the image view and place the image
		ImageView jImgView = new ImageView(jImage);
		jImgView.setX(10);
		jImgView.setY(30);

		//create a link to the SQL image
		Image sqlImage = new Image(Main.class.getResourceAsStream("/Datagirl.png"));

		//Setting the image view and place the image
		ImageView sqlImgView = new ImageView(sqlImage);
		sqlImgView.setX(320);
		sqlImgView.setY(30);

		try {
			Group root = new Group();
			root.getChildren().add(cat1Lbl);
			root.getChildren().add(score1Lbl);
			root.getChildren().add(cat1Btn);
			root.getChildren().add(cat2Lbl);
			root.getChildren().add(score2Lbl);
			root.getChildren().add(cat2Btn);
			root.getChildren().add(showBtn);
			root.getChildren().add(resetBtn);
			root.getChildren().add(jImgView);
			root.getChildren().add(sqlImgView);

			Scene scene = new Scene(root, 400, 150);
			primaryStage.setTitle("Voting Panel!");
			primaryStage.setMinWidth(scene.getWidth());
			primaryStage.setMinHeight(scene.getHeight());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void showVotes() {
		score1Lbl.setText("" + cat1Score);
		score2Lbl.setText("" + cat2Score);
		score1Lbl.setVisible(true);
		score2Lbl.setVisible(true);
	}//end method showVotes

	private void resetVotes() {
		cat1Score = 0;
		cat2Score = 0;
		score1Lbl.setVisible(false);
		score2Lbl.setVisible(false);
	}//end method resetVotes

	private void setBtnUse(boolean cat1, boolean cat2, boolean show, boolean reset) {
		cat1Btn.setDisable(cat1);
		cat2Btn.setDisable(cat2);
		showBtn.setDisable(show);
		resetBtn.setDisable(reset);
	}//end method setBtnUse

	public static void main(String[] args) {
		launch(args);
	}
}
