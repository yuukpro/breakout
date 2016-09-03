package core;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/***
 * アイテム
 * 
 * @author yuu
 *
 */
public class Item {

	private double coordinateX;
	private double coordinateY;
	private Circle item;

	/***
	 * 
	 * @param radius
	 * @param speed
	 */
	public void initialize(final double coordinateX, final double coordinateY) {
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.setItem(new Circle(5, Color.CHARTREUSE));
		this.item.setCenterX(this.coordinateX);
		this.item.setCenterY(this.coordinateY);
	}

	public Circle getItem() {
		return item;
	}

	public void setItem(Circle item) {
		this.item = item;
	}

	public void fall() {
		this.item.setCenterY(this.item.getCenterY() + 0.5);
	}

	public void attack() {

		this.item.setFill(Color.TRANSPARENT);
	}

	public boolean attackPoint(final Ita ita) {
		if (ita.getItaX() <= this.item.getCenterX() && ita.getItaX() + ita.getWidth() >= item.getCenterX()
				&& ita.getitaY() == this.item.getCenterY()) {
			return true;

		}
		return false;
	}

}
