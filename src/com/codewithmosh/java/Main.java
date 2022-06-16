package com.codewithmosh.java;

public class Main {

	public static void main(String[] args) {
		String []s ={"kk","kk2"};

	}

	void a(){
		String msg = "Job created !!1111";
		System.out.println(msg.substring(0,14));
		int sal = 1_0001;
		System.out.println(sal);
		compareObjects();
		up_down_cast();
	}
	
	private void interfacing() {

		ITaxCalculator calculator = new TaxCalculator2018(100000);
		TaxReport2 r1 = new TaxReport2(calculator);
		r1.show();
		r1.setCalculator(new TaxCalculator2019(100000) );
		r1.show();
		r1.show(new TaxCalculator2018(100000));
	
	}
	private void polymorphism() {		
		UIControl [] ui = {new TextBox(),new CheckBox()};
		for(UIControl u:ui) {
			u.render();
			u.abstractRender();
		}
	}
	private static void compareObjects() {
		Point p1 = new Point(10, 15);
		Point p2 = new Point(10, 15);
		System.out.println("P1="+p1.hashCode() +" P2="+p2.hashCode());
		p1=p2;
		System.out.println("P1="+p1.hashCode() +" P2="+p2.hashCode());
		System.out.println(p1==p2);
		System.out.println(p1.equals(p2));
	}
	private static void up_down_cast() {
		//TextBox ui = new TextBox();
		//CheckBox ui = new CheckBox();
		UIControl ui = new TextBox();
		//System.out.println(txt);
		show(ui);
	}
	
	private static void show(UIControl control) {
		if(control instanceof TextBox)
		{
			TextBox  c  =(TextBox)control;
			c.setText("KK");
		}
		System.out.println(control.toString());
	}

}
