package it.beije.xiv.Prove;

public class Insetto extends Animal{

	//esempio ereditarieta pt2
		private int antenne;
		private int ali;
		
		
		
		public Insetto(String nome, int zampe, String verso, int etaMassima, int antenne, int ali) {
			super(nome, zampe, verso, etaMassima);
			this.antenne = antenne;
			this.ali = ali;
			
			System.out.println( nome + " Creato");
		}
		
		
		
		
		
		@Override
		public String toString() {
			return "Insetto [antenne=" + antenne + ", ali=" + ali + "]";
		}


		public void  print() {
			
			System.out.print("nome :"+ nome);
			System.out.print(" zampe :"+ zampe);
			System.out.print(" ali :"+ ali);
			System.out.print(" antenne :"+ antenne);
			System.out.print(" verso : "+ verso);
			System.out.print(" età massima :"+ etaMassima);
			
		}


		public int getAntenne() {
			return antenne;
		}
		public void setAntenne(int antenne) {
			this.antenne = antenne;
		}
		public int getAli() {
			return ali;
		}
		public void setAli(int ali) {
			this.ali = ali;
		} 
		
		

	}
