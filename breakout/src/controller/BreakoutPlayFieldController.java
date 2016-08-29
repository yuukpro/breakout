package controller;

import java.net.URL;
import java.util.ResourceBundle;

import core.Ball;
import core.Block1;
import core.Ita;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
	private Pane fieldPane;

	private int y = 1;

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
		this.fieldPane.setFocusTraversable(true);
		this.fieldPane.requestFocus();
		this.operationKeySetting();

	}

	/***
	 * 板初期描画
	 */
	private void initBall() {
		this.ball.initialize(5, 5);
		this.fieldPane.getChildren().add(this.ball.getBall());
		this.fieldPane.setLayoutX(this.ball.getWidth());
		this.fieldPane.setLayoutY(this.ball.getHeight());
	}

	/***
	 * 板初期描画
	 */
	private void initIta() {
		this.ita.initialize();
		this.fieldPane.getChildren().add(this.ita.getIta());
	}

	/***
	 * ブロック初期描画
	 */
	private void initBlock() {
		this.block1.initialize();
		this.fieldPane.getChildren().add(this.block1.block());
		timeLine();
	}

	/**
	 * 定期処理登録
	 */
	private void timeLine() {
		timeLine = new Timeline(new KeyFrame(Duration.millis(10), ae -> run()));
		timeLine.setCycleCount(Timeline.INDEFINITE);
		timeLine.play();
	}

	private void run() {
		// TODO テスト段階 一時コミットよう
		this.ball.changeXY(y);

		if (this.ita.attackPoint(this.ball.getBallX(), this.ball.getBallY()) && !this.ball.getVector()) {
			this.ball.changeVector(true);
			this.y = -1;
		}

	}

	/**
	 * キー操作設定
	 */
	private void operationKeySetting() {
		this.fieldPane.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent keyEvent) {

				if (keyEvent.getCode() == KeyCode.LEFT) {
					itaMove(1);

				}
				if (keyEvent.getCode() == KeyCode.RIGHT) {
					itaMove(2);

				}

			}

		});
	}

	/***
	 * 板移動処理
	 * 
	 * @param key
	 */
	private void itaMove(final int key) {
		switch (key) {
		case 1:
			this.ita.moveItaX(this.ita.getItaX() - 10);
			break;
		case 2:
			this.ita.moveItaX(this.ita.getItaX() + 10);
			break;

		}
	}

}
