package it.beije.turing.test;

public class Test extends SuperTest{
	public static void main(String[] args) {
		Test test1 = new Test();
		Test test2 = (Test)new SuperTest();
		SuperTest test3 = new Test();
		SuperTest test4 = new SuperTest();
		test1 = (Test)test3;
	}
}
