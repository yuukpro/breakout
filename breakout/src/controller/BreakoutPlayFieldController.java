package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import core.Ball;
import core.BaseBlock;
import core.GiantItem;
import core.Ita;
import core.NormalBlock;
import core.SpeedItem;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
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
	// ブロック格納
	private List<BaseBlock> blockList;
	// アイテム格納
	private List<SpeedItem> itemList = new ArrayList<>();
	// アイテム格納
	private List<GiantItem> giantList = new ArrayList<>();

	private double y = 1;
	private double x = 0.1;

	private Ball ball = new Ball();
	private Ita ita = new Ita();

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

		this.blockList = new ArrayList<>();
		for (int i = 0; i <= 10; i++) {
			this.blockList.add(new NormalBlock());
			this.blockList.get(i).initialize(this.getRandomInt(6), this.getRandomInt(400), this.getRandomInt(300));
			this.fieldPane.getChildren().add(this.blockList.get(i).getBlock());

		}

		timeLine();
	}

	/**
	 * 定期処理登録
	 */
	private void timeLine() {
		timeLine = new Timeline(new KeyFrame(Duration.millis(5), ae -> run()));
		timeLine.setCycleCount(Timeline.INDEFINITE);
		timeLine.play();
	}

	/***
	 * 定期処理
	 */
	private void run() {

		// 値更新
		this.ball.changeXY(y, x);
		// 壁の当たり判定
		sideAttackCheck();

		// y座標の確認

		// ブロック当たり判定
		blockAttackCheck();
		// 板当たり判定
		itaAttackCheck();
		// アイテム判定
		itemAttackCheck();

		// TODO END
		if (this.ball.getBallY().intValue() == 600) {
			this.timeLine.stop();
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

	// ブロック当たり判定
	private void blockAttackCheck() {
		int life = 0;
		// y座標の確認
		for (int i = 0; i < this.blockList.size(); i++) {
			if (this.blockList.get(i).attackPoint(this.ball.getBallX(), this.ball.getBallY())
					&& this.ball.getVector()) {
				this.ball.changeVector(false);
				this.fieldPane.getChildren().add(
						viewItem(this.blockList.get(i).getBlock().getX(), this.blockList.get(i).getBlock().getY()));
				this.y = 1;
			}
			if (this.blockList.get(i).life()) {
				life++;
			}

		}

		if (life == 0) {
			this.timeLine.stop();
		}

	}

	/***
	 * アイテム当たり判定
	 */
	private void itemAttackCheck() {
		if (!(this.itemList == null)) {
			for (int i = 0; i < this.itemList.size(); i++) {
				this.itemList.get(i).fall();
				if (this.itemList.get(i).attackPoint(this.ita)) {
					this.itemList.get(i).attack();
					SpeedItem.speedUp(this.ita);
				}
			}
		}
		if (!(this.giantList == null)) {
			for (int i = 0; i < this.giantList.size(); i++) {
				this.giantList.get(i).fall();
				if (this.giantList.get(i).attackPoint(this.ita)) {
					this.giantList.get(i).attack();
					GiantItem.giant(this.ita);
				}
			}
		}
	}

	/***
	 * 板の当たり判定
	 */
	private void itaAttackCheck() {
		if (this.ita.attackPoint(this.ball.getBallX(), this.ball.getBallY()) && !this.ball.getVector()) {
			this.ball.changeVector(true);

			this.y = -1;
		} else if (this.ball.getBallY() == 0) {
			this.y = 1;
			this.ball.changeVector(false);
		}

	}

	/***
	 * 壁判定
	 */
	private void sideAttackCheck() {
		// X座標の確認
		if (this.ball.getBallX().intValue() == 0) {
			this.x = 0.1;
		} else if (this.ball.getBallX().intValue() == 430) {
			this.x = -0.1;
		}
	}

	/***
	 * 板移動処理
	 * 
	 * @param key
	 */
	private void itaMove(final int key) {
		switch (key) {
		case 1:
			this.ita.moveItaX(this.ita.getItaX() - this.ita.getSpeed());
			break;
		case 2:
			this.ita.moveItaX(this.ita.getItaX() + this.ita.getSpeed());
			break;

		}
	}

	/***
	 * アイテム登録
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public Circle viewItem(final double x, final double y) {
		if (this.getRandomInt(100) % 2 == 1) {
			SpeedItem item = new SpeedItem();
			item.initialize(x, y);
			this.itemList.add(item);
			return item.getItem();
		} else {
			GiantItem item = new GiantItem();
			item.initialize(x, y);
			this.giantList.add(item);
			return item.getItem();

		}
	}

	/***
	 * ランダム値生成用
	 * 
	 * @param rundom
	 * @return
	 */
	public int getRandomInt(final int rundom) {
		Random rnd = new Random();
		return rnd.nextInt(rundom) + 1;
	}

}
