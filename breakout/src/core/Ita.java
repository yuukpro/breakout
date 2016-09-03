package core;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/***
 * 板
 * 
 * @author kitajima
 *
 */
public class Ita {
	private int height = 10;
	private int width = 100;
	private double speed = 20;
	private Rectangle ita = new Rectangle();

	/***
	 * 板の初期化
	 * 
	 * @param vector
	 *            方向
	 * 
	 * @param speed
	 *            スピード
	 */
	public void initialize() {

		ita.setY(550);
		ita.setWidth(this.width);
		ita.setHeight(this.height);
		ita.setFill(Color.YELLOW);
		ita.setArcWidth(20);
		ita.setArcHeight(20);

	}

	public double getSpeed() {
		return speed;
	}

	public void changeSpeed() {
		this.speed = this.speed + 0.001;
	}

	public void setWidth(final int width) {
		this.width = width;
	}

	public void giant() {
		this.width += 5;
		this.ita.setWidth(this.width);
	}

	public Rectangle getIta() {
		return this.ita;
	}

	/***
	 * 板の当たり判定
	 * 
	 * @param ballX
	 * @param ballY
	 * @return
	 */
	public boolean attackPoint(final double ballX, final double ballY) {
		// 板とボールが同じ座標かつ板の範囲内にボールがあること
		if (ballY == this.ita.getY() && this.ita.getX() <= ballX && this.ita.getX() + this.width >= ballX) {
			return true;
		} else {
			return false;
		}

	}

	/***
	 * 板移動
	 * 
	 * @param x
	 */
	public void moveItaX(final double x) {
		this.ita.setX(x);
	}

	public int getItaX() {
		return (int) this.ita.getX();
	}

	public int getitaY() {
		return (int) this.ita.getY();
	}

	public int getWidth() {
		return this.width;
	}

}
