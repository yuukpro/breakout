package controller;

import java.net.URL;
import java.util.ResourceBundle;
import core.Ball;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
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
	private Ball ball = new Ball();

	@Override
	public void initialize(final URL location, final ResourceBundle resources) {
		this.ball.initialize("up", 5, 5);
		
	}

	/***
	 * 描画テスト
	 * 
	 * @param root
	 * 
	 * @param root
	 */
	public void ballView() {
		this.ballPane.setCenter(this.ball.getBall());
		this.ballPane.setLayoutX(this.ball.getWidth());
		this.ballPane.setLayoutY(this.ball.getHeight());

	}

}
