package core;

import java.io.IOException;
import java.net.URL;
import controller.BreakoutPlayFieldController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * ブロック崩しフィールド ゲームフィールド上に表示する項目を管理 ゲームフィールド画面表示、ブロック崩しをするフィールド設置、スコア設置（未実装）
 * 
 */

public class BreakoutGameField extends Application {

	private BreakoutPlayFieldController breakoutPlayFieldController;

	public static void main(final String[] args) {
		launch(args);
	}

	@Override
	public void start(final Stage primaryStage) throws Exception {

		/**
		 * 画面の初期設定
		 */
		Parent root = initTetris();
		/**
		 * 画面表示処理
		 */
		breakoutShow(primaryStage, root);
		this.breakoutPlayFieldController.ballView();


	}

	/**
	 * ブロック崩し画面表示
	 */
	private void breakoutShow(final Stage primaryStage, Parent root) {
		primaryStage.setTitle("BREAKOUT");
		Scene breakoutField = new Scene(root, 450, 640);
		primaryStage.setScene(breakoutField);
		primaryStage.show();
	}

	/**
	 * 初期作成
	 */
	public Parent initTetris() throws IOException {

		URL localtion = getClass().getClassLoader().getResource(
				"resources/GameField.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader(localtion);

		Parent root = fxmlLoader.load();
		this.breakoutPlayFieldController = fxmlLoader.getController();

		return root;

	}

}
