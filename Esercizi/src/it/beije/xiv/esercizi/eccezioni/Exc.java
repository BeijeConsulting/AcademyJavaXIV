package eccezioni;

public class Exc {
	

	public static void main(String[] args) throws Exception {
		String s = "";
		String v = null;
		try{
			s += "t";
			//v.length();
			prova();
		} catch (NullPointerException e) {
			s += "c";
			//throw new NullPointerException();
		} catch (Exception e) {
			s += "E";
			//throw e;
		} finally {
			s += "f";
			//System.out.println(s);
		}
		s += "a";
		
		System.out.println(s);
	}
	
	public static void prova() throws Exception{
		throw new Exception("- prova Exception -");
	}

}
