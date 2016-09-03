package core;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/***
 * ブロック
 * 
 * @author kitajima
 *
 */
public class BaseBlock {

	private Rectangle block = new Rectangle();
	private int life;

	// 初期化
	public void initialize(final int life, final int x, final int y) {

		this.block.setY(y);
		this.block.setX(x);
		this.block.setWidth(80);
		this.block.setHeight(20);
		this.life = life;
		this.changeColor();
		this.block.setArcWidth(20);
		this.block.setArcHeight(20);

	}

	// 当たり判定
	public boolean attackPoint(final double ballX, final double ballY) {
		// 板とボールが同じ座標かつ板の範囲内にボールがあること
		if (!(this.life == 0) && ballY == this.block.getY() + this.block.getHeight() && this.block.getX() <= ballX
				&& this.block.getX() + this.block.getWidth() >= ballX) {
			this.life--;
			changeColor();
			return true;
		} else {
			return false;
		}
	}

	// ブロック色
	public void changeColor() {

		switch (this.life) {

		case 0:
			this.block.setFill(Color.TRANSPARENT);

			break;
		case 1:
			this.block.setFill(Color.BLUE);
			break;
		case 2:
			this.block.setFill(Color.BLUEVIOLET);
			break;
		case 3:
			this.block.setFill(Color.TAN);
			break;
		case 4:
			this.block.setFill(Color.CYAN);
			break;
		case 5:
			this.block.setFill(Color.CRIMSON);
			break;
		case 6:
			this.block.setFill(Color.DARKBLUE);
			break;

		default:
			this.block.setFill(Color.VIOLET);
			break;
		}
	}

	public boolean life() {
		if (this.life == 0) {
			return false;
		} else {
			return true;
		}
	}

	public Rectangle getBlock() {

		return this.block;
	}

}
