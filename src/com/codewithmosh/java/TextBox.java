package com.codewithmosh.java;

public class TextBox extends UIControl{

	private String text="";
	
	public TextBox()
	{
		//super(true);
		System.out.println("TextBox default Constructor");
	}
	/*
	 * public TextBox(String text) { super(true); this.text=text;
	 * System.out.println("TextBox Constructor"); }
	 */
	
	public void setText(String text) {
		this.text = text;
	}
	public void render() {
		System.out.println("Render TextBox");
	}
	public void clear() {
		this.text = "";
	}
	@Override
	public String toString() {
		return text;
	}

	@Override
	public void abstractRender() {
		// TODO Auto-generated method stub
		System.out.println("TextBox abstractRender");
	}
}
