package controller;

import java.net.URL;
import java.util.ResourceBundle;
import core.Ball;
import core.Ita;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * ブロック崩しプレイフィールド フィールド内のテトリミノを管理
 * 
 */
public class BreakoutPlayFieldController implements Initializable {
	// フィールド
	@FXML
	private VBox vBox;
	@FXML
	private BorderPane ballPane;
	@FXML
	private Pane itaPane;
	
	@FXML
	private AnchorPane mainPane;
	private Ball ball = new Ball();
	private Ita ita = new Ita();

	@Override
	public void initialize(final URL location, final ResourceBundle resources) {
		this.initBall();
		this.initIta();
		
	}
	/***
	 * 板初期描画
	 */
	private void initBall(){
		this.ball.initialize("up", 5, 5);
		this.ballPane.setCenter(this.ball.getBall());
		this.ballPane.setLayoutX(this.ball.getWidth());
		this.ballPane.setLayoutY(this.ball.getHeight());
	}
	/***
	 * 板初期描画
	 */
	private void initIta(){
		this.ita.initialize();
		this.itaPane.getChildren().add(this.ita.getIta());
	}
	


}
