package it.beije.xiv.esercizi;

import java.util.ArrayList;

public class EserciziCicli {
	public static void main(String[] args) {
		EserciziCicli.esercizio1();
		System.out.println();
		EserciziCicli.esercizio2();
		System.out.println();
		EserciziCicli.esercizio3(2);
		System.out.println();
		EserciziCicli.esercizio4();
		System.out.println();
		EserciziCicli.esercizio5();
		System.out.println();
		EserciziCicli.esercizio6();
		System.out.println();
		EserciziCicli.esercizio7();
	}
	
	public static void esercizio1() {
		System.out.println("Esercizio 1");
		for(int i= 0; i < 10; i++) {
			System.out.println(i);
		}
	}
	public static void esercizio2() {
		System.out.println("Esercizio 2");
		for(int i= 20; i >= 0; i--) {
			if(i%2 == 0) {
				System.out.println(i);
			}
		}
	}
	public static void esercizio3(int n) {
		System.out.println("Esercizio 3");
		for(int i = 0; i < 11; i++) {
				System.out.println(""+ n + " x "+ i + "= " + (i*n));
		}
	}
	public static void esercizio4() {
		System.out.println("Esercizio 4");
		for(int i = 6; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void esercizio5() {
		System.out.println("Esercizio 5");
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print("#");
			}
			System.out.println();
		}
	}
	public static void esercizio6() {
		System.out.println("Esercizio 6");
		StringBuilder s1 = new StringBuilder("123456");
		for(int i=0; i < s1.length(); i++) {
			System.out.print(s1.substring(0, i+1) + "   ");
			System.out.println(s1.reverse().substring(i));
			s1.reverse();
		}
	}
	public static void esercizio7() {
		System.out.println("Esercizio 7 & 8");
		ArrayList<Double> l = new ArrayList<Double>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 100; i++) {
			if(i == 0 || i == 1) {
				l.add(1.0);
				sb.append(l.get(i));
			}else {
				l.add((l.get(i-2)+l.get(i-1)));
				sb.append(l.get(i));
			}
			System.out.println(sb.toString());
			sb.append(", ");
		}
	}
}
