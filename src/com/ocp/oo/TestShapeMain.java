package com.ocp.oo;

public class TestShapeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlayerPiece pl = new PlayerPiece();
		TilePiece tl = new TilePiece();
		
		doShapes(pl);
		doShapes(tl);

	}
	public static void doShapes(GameShape g)
	{
		g.displayShape();
	}

}
