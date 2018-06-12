package test;

import java.util.Date;

public class GetClassName extends Date{
	private static final long serialVersionID=1L;
	private void test(){
		System.out.println(super.getClass().getName());
	}

	public static void main(String[] args) {
		new GetClassName().test();

	}

}
