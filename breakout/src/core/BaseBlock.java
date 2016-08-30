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
	
	public void initialize() {

		this.block.setY(0);
		this.block.setX(50);
		this.block.setWidth(80);
		this.block.setHeight(20);
		this.block.setFill(Color.AQUAMARINE);
		this.block.setArcWidth(20);
		this.block.setArcHeight(20);
		this.life=1;

	}
	
	

	public Rectangle block(){
		
		return this.block;
	}
	
	public void attackPoint(){
		
		
	}
}
