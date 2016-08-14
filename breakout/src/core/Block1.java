package core;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
/***
 * ブロック１
 * @author yuu
 *
 */
public class Block1 extends Block{
	
	private Rectangle block = new Rectangle();
	
	public void initialize() {

		this.block.setY(0);
		this.block.setX(50);
		this.block.setWidth(80);
		this.block.setHeight(20);
		this.block.setFill(Color.AQUAMARINE);
		this.block.setArcWidth(20);
		this.block.setArcHeight(20);

	}
	public Rectangle block(){
		return this.block;
	}


}
