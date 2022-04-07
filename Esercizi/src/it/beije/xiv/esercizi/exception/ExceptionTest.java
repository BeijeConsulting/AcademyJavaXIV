package it.beije.xiv.esercizi.exception;

class MyExceptionParentChecked extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
class MyExceptionChildrenChecked extends MyExceptionParentChecked{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
class MyExceptionParentUnchecked extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
class MyExceptionChildrenUnchecked extends MyExceptionParentUnchecked{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}

public class ExceptionTest {
	
	public void throwsCheckedException() throws Exception {
		throw new Exception("Throws checked exception"); 
	}
	public void throwsUncheckedException() throws RuntimeException {
		throw new RuntimeException("Throws unchecked exception"); 
	}
	public void tryToThrowAnException() {
		//DA ERRORE DI COMPILAZIONE
		//throw new Exception();
	}
	
	public void tryToThrowAMyExceptionParentChecked() throws MyExceptionParentChecked{
		throw new  MyExceptionParentChecked();
	}
	public void tryToThrowAMyExceptionChildrenChecked() throws MyExceptionChildrenChecked{
		throw new MyExceptionChildrenChecked();
	}
	public void tryToThrowAMyExceptionParentUnchecked() throws MyExceptionParentUnchecked{
		throw new MyExceptionParentUnchecked();
	}
	public void tryToThrowAMyExceptionChildrenUnchecked() throws MyExceptionChildrenUnchecked{
		throw new MyExceptionChildrenUnchecked();
	}
	
	public static void main(String [] args) {
		ExceptionTest t = new ExceptionTest();
		ExceptionTestExtend t2= new ExceptionTestExtend();
		
		System.out.println("ExceptionTest:");
		try {
			t.throwsCheckedException();
		}catch(RuntimeException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			t.throwsUncheckedException();
		}catch(RuntimeException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * DA ERRORE DI COMPILAZIONE POICHè RuntimeException non viene mai chiamata
		try {
			t.throwsUncheckedException();
		}catch(Exception e) {
			e.printStackTrace();
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
		*/
		try {
			t.tryToThrowAMyExceptionParentChecked();
		}catch(MyExceptionChildrenChecked e) {
			System.out.println("ParentChecked() MyExceptionChildrenChecked");
			e.printStackTrace();
		}catch(MyExceptionParentChecked e) {
			System.out.println("ParentChecked() MyExceptionParentChecked");
			e.printStackTrace();
		}
		//presente un warning perchè potrebbe non essere mai chiamata(o almeno credo)
		try {
			t.tryToThrowAMyExceptionChildrenChecked();
		}catch(MyExceptionChildrenChecked e) {
			System.out.println("ChildrenChecked() MyExceptionChildrenChecked");
			e.printStackTrace();
		}catch(MyExceptionParentChecked e) {
			System.out.println("ChildrenChecked() MyExceptionParentChecked");
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			t.tryToThrowAMyExceptionParentUnchecked();
		}catch(MyExceptionChildrenUnchecked e) {
			System.out.println("ParentUnchecked() MyExceptionChildrenUnchecked");
			e.printStackTrace();
		}catch(MyExceptionParentUnchecked e) {
			System.out.println("ParentUnchecked() MyExceptionParentUnchecked");
			e.printStackTrace();
		}
		try {
			t.tryToThrowAMyExceptionChildrenUnchecked();
		}catch(MyExceptionChildrenUnchecked e) {
			System.out.println("ChildrenUnchecked() MyExceptionChildrenUnchecked");
			e.printStackTrace();
		}catch(MyExceptionParentUnchecked e) {
			System.out.println("ChildrenUnchecked() MyExceptionParentUnchecked");
			e.printStackTrace();
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
		System.out.println("");
		System.out.println("ExceptionTestExtend:");
		try {
			t2.tryToThrowAMyExceptionParentChecked();
		}catch(MyExceptionChildrenChecked e) {
			System.out.println("ParentChecked() MyExceptionChildrenChecked");
			e.printStackTrace();
		}catch(MyExceptionParentChecked e) {
			System.out.println("ParentChecked() MyExceptionParentChecked");
			e.printStackTrace();
		}
		try {
			t2.tryToThrowAMyExceptionChildrenChecked();
		}catch(MyExceptionChildrenChecked e) {
			System.out.println("ChildrenChecked() MyExceptionChildrenChecked");
			e.printStackTrace();
		}catch(MyExceptionParentChecked e) {
			System.out.println("ChildrenChecked() MyExceptionParentChecked");
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			t2.tryToThrowAMyExceptionParentUnchecked();
		}catch(MyExceptionChildrenUnchecked e) {
			System.out.println("ParentUnchecked() MyExceptionChildrenUnchecked");
			e.printStackTrace();
		}catch(MyExceptionParentUnchecked e) {
			System.out.println("ParentUnchecked() MyExceptionParentUnchecked");
			e.printStackTrace();
		}
		try {
			t2.tryToThrowAMyExceptionChildrenUnchecked();
		}catch(MyExceptionChildrenUnchecked e) {
			System.out.println("ChildrenUnchecked() MyExceptionChildrenUnchecked");
			e.printStackTrace();
		}catch(MyExceptionParentUnchecked e) {
			System.out.println("ChildrenUnchecked() MyExceptionParentUnchecked");
			e.printStackTrace();
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
	}
}

class ExceptionTestExtend extends ExceptionTest{
	public void tryToThrowAMyExceptionParentChecked() throws MyExceptionChildrenChecked{
		//così da errore di compilazione, questo non succede nei throws unchecked
		//throw new MyExceptionParentChecked();
		throw new MyExceptionChildrenChecked();
	}
	/*
	 * ERRORE DI COMPILAZIONE PERCHè CERCA DI TORNARE UN ECCEZIONE PIù GRANDE
	 * (ECCEZIONE DEL METODO DEL PADRE è FIGLIA DELL'ECCEZIONE CHE CERCO DI USARE IN QUESTO METODO) RISPETTO A QUELLA DELLA CLASSE PADRE
	public void tryToThrowAMyExceptionChildrenChecked() throws MyExceptionParentChecked{
		throw new MyExceptionParentChecked();
	}
	*/
	//non danno errori anche se ritorna un errore più grande (questo perchè sono dell eccezioni unchecked)
	public void tryToThrowAMyExceptionParentUnchecked() throws MyExceptionChildrenUnchecked{
		//throw new MyExceptionParentUnchecked();
		throw new MyExceptionChildrenUnchecked();
	}
	public void tryToThrowAMyExceptionChildrenUnchecked() throws MyExceptionParentUnchecked{
		//throw new MyExceptionChildrenUnchecked();
		throw new MyExceptionParentUnchecked();
	}
}

