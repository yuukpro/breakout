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
	private int speed;
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

		this.changeSpeed(speed);
		ita.setY(550);
		ita.setWidth(this.width);
		ita.setHeight(this.height);
		ita.setFill(Color.YELLOW);
		ita.setArcWidth(20);
		ita.setArcHeight(20);

	}

	public int getSpeed() {
		return speed;
	}

	public void changeSpeed(final int speed) {
		this.speed = speed;
	}

	public void setWidth(final int width) {
		this.width = width;
	}

	public Rectangle getIta() {
		return this.ita;
	}
	public boolean attackPoint(final double ballX,final double ballY){
		if(ballY==this.ita.getY()){
			return false;
		}
		return true;
		
	}

	/***
	 * 板移動
	 * 
	 * @param x
	 */
	public void move(final int x) {
		this.ita.setX(x);
	}

}
