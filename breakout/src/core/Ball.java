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
	private boolean vector=true;
	private int radius;
	private int speed;
	private Circle ball;
	

	/***
	 * ボールの初期化
	 * @param vector　方向
	 * @param radius　半径
	 * @param speed　スピード
	 */
	public void initialize(final int radius, final int speed) {
		this.radius = radius;
		this.changeSpeed(speed);
		this.setBall(new Circle(this.radius * 2, Color.BLACK));

	}

	public boolean getVector() {
		return vector;
	}

	public void changeVector(final boolean vector) {
		this.vector = vector;
	}

	public int getSpeed() {
		return speed;
	}

	public void changeSpeed(final int speed) {
		this.speed = speed;
	}
	
	public void changeXY(final int y){
		this.ball.setCenterY(this.ball.getCenterY()+y);
		System.out.println(this.ball.getCenterY());
	}

	public Circle getBall() {
		return ball;
	}
	public Double getBallX(){
		return this.ball.getCenterX();
	}
	public Double getBallY(){
		return this.ball.getCenterY();		
	}
	public void setBall(final Circle circle) {
		this.ball = circle;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(final int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(final int width) {
		this.width = width;
	}

}
