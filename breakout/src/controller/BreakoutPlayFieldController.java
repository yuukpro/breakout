package controller;

import java.net.URL;
import java.util.ResourceBundle;

import core.Ball;
import core.Block1;
import core.Ita;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * ブロック崩しプレイフィールド フィールド内のブロック、板を管理
 * 
 */
public class BreakoutPlayFieldController implements Initializable {
	// フィールド
	@FXML
	private VBox vBox;
	@FXML
	private Pane ballPane;
	@FXML
	private Pane itaPane;
	@FXML
	private Pane blockPane;

	private Ball ball = new Ball();
	private Ita ita = new Ita();
	private Block1 block1 = new Block1();
	// タイムライン
	private Timeline timeLine;

	@Override
	public void initialize(final URL location, final ResourceBundle resources) {
		this.initBall();
		this.initIta();
		this.initBlock();
		
		
	}
	/***
	 * 板初期描画
	 */
	private void initBall(){
		this.ball.initialize("up", 5, 5);
		this.ballPane.getChildren().add(this.ball.getBall());
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
	/***
	 * ブロック初期描画
	 */
	private void initBlock(){
		this.block1.initialize();
		this.blockPane.getChildren().add(this.block1.block());
		timeLine();
	}
	/**
	 * 定期処理登録
	 */
	private void timeLine() {
		timeLine = new Timeline(new KeyFrame(Duration.millis(300), ae -> run()));
		timeLine.setCycleCount(Timeline.INDEFINITE);
		timeLine.play();
	}
	private void run(){

	}


}
