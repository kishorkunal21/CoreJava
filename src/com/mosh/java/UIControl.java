package com.mosh.java;

public abstract class UIControl {
	
	private boolean isEnabled = true;
	
	public UIControl() {
		System.out.println("UIControl default constructor");
	}
	
//	public UIControl(boolean isEnabled) {
//		this.isEnabled=isEnabled;
//		System.out.println("UIControl constructor");
//	}
	
	public void enable() {
		this.isEnabled= true;
	}
	
	public void disable() {
		this.isEnabled= false;
	}
	public abstract void abstractRender();

	public void render() {
		
	}
	
	public boolean isEnabled() {
		return isEnabled;
	}

	

}
