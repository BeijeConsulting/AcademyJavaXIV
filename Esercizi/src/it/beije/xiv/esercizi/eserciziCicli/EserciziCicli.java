package it.beije.xiv.esercizi.eserciziCicli;

public class EserciziCicli {
public static void main(String...args)
{
	System.out.print("I primi dieci numeri interi sono :");
	stampaPrimi10Numeri();
	System.out.println();
	System.out.print("I primi dieci numeri interi pari tra 0 e 20 sono :");
	stampaPrimi10NumeriPari();
	System.out.println();
	int n = 6;
	System.out.print("La tebellina del "+n+" è:");
	stampaTabellina(n);
	System.out.println();
	piramideDiCaratteri(n);
	stampaTriangolo();
	System.out.print("I primi cento numeri di Fibonacci sono :");
	fibonacci(100);
	System.out.println();
	System.out.print("le prime "+n+" numeri di Fibonacci sono :");
	fibonacci(5);
	System.out.println();
}
private static void stampaPrimi10Numeri() {
	for(int i=0;i<10;i++)
	{
		System.out.print(" "+i);
	}
}
private static void stampaPrimi10NumeriPari() {
	for(int i=20;i>0;i-=2)
	{
		System.out.print(" "+i);
	}
}
private static void stampaTabellina(int n) {
	for(int i=1;i<11;i++)
	{
		System.out.print(" "+i*n);
	}
}
private static void piramideDiCaratteri(int n) {
	for(int i=1;i<n;i++)
	{
		for(int k=0;k<i;k++)
		{
		System.out.print("#");
		}
		System.out.println();
	}
	for(int i=1;i<n;i++)
	{
		for(int k=n;k>i;k--)
		{
		System.out.print("*");
		}
		System.out.println();
	}
}
private static void stampaTriangolo()
{
	StringBuilder q;
	StringBuilder uno=new StringBuilder();
	StringBuilder due = new StringBuilder("7654321");
	for(int i=1;i<7;i++)
	{
	//	q = new StringBuilder();
		uno.append(i);
		due.deleteCharAt(0);
		System.out.println(uno.toString()+" "+due.toString());
	}
}
private static void fibonacci(int n)
{
	int precedente1=0,precedente2=0;
	for(int i=0;i<n;i++)
	{
		
		int temp;
		System.out.print(" "+(temp=precedente1+precedente2));
		if (i==0)
		{
			precedente1=1;
		}
		precedente2=precedente1;
		precedente1=temp;
		if (i==0)
		{
			precedente2=1;
		}
	}
}
private static void fibonacciRighe(int n)
{
	for(int i=0;i<n;i++)
	{
		fibonacci(i+1);
	}
}
}

