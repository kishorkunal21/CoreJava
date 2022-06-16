package com.mosh.java;

public class CheckBox extends UIControl{

	private String text="";
	
	public CheckBox()
	{
		//super(true);
		System.out.println("CheckBox default Constructor");
	}
//	public CheckBox(String text)
//	{
//		super(true);
//		this.text=text;
//		System.out.println("CheckBox Constructor");
//	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public void clear() {
		this.text = "";
	}
	
	public void render() {
		System.out.println("Render CheckBox");
	}
	@Override
	public String toString() {
		return text;
	}

	@Override
	public void abstractRender() {
		System.out.println("CheckBox abstractRender");
		
	}
}
