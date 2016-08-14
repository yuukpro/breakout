package core;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/***
 * ボール
 * @author kitajima
 *
 */
public class Ball {
	private int height = 250;
	private int width = 50;
	private String vector;
	private int radius;
	private int speed;
	private Circle ball;

	/***
	 * ボールの初期化
	 * @param vector　方向
	 * @param radius　半径
	 * @param speed　スピード
	 */
	public void initialize(final String vector, final int radius, final int speed) {
		this.radius = radius;
		this.changeVector(vector);
		this.changeSpeed(speed);
		this.setBall(new Circle(this.radius * 2, Color.BLACK));

	}

	public String getVector() {
		return vector;
	}

	public void changeVector(String vector) {
		this.vector = vector;
	}

	public int getSpeed() {
		return speed;
	}

	public void changeSpeed(int speed) {
		this.speed = speed;
	}

	public Circle getBall() {
		return ball;
	}

	public void setBall(Circle circle) {
		this.ball = circle;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}
