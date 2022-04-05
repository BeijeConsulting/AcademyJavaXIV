package Prove;

public class Animal {

	//esempio ereditarieta pt1 
			public String nome; 
			public int  zampe;
			public String verso;
			public int etaMassima;
			
			
			@Override
			public String toString() {
				return "Animal [nome=" + nome + ", zampe=" + zampe + ", verso=" + verso + ", etaMassima=" + etaMassima
						+ "]";
			}

			
			
			
			public Animal(String nome, int zampe, String verso, int etaMassima) {
				
				this.setNome(nome);
				this.setZampe(zampe);
				this.setVerso(verso);
				this.setEtaMassima(etaMassima);
				System.out.println (nome +" Creato  ");
				
			}
			
			public Animal() {
				
				this.setNome("cane");
				this.setZampe(4);
				this.setVerso("Bau Bau");
				this.setEtaMassima(20);
				System.out.print("Cane Creato");
			}

			public String getNome() {
				return nome;
			}

			public void setNome(String nome) {
				this.nome = nome;
			}

			public int getZampe() {
				return zampe;
			}

			public void setZampe(int zampe) {
				this.zampe = zampe;
			}

			public String getVerso() {
				return verso;
			}

			public void setVerso(String verso) {
				this.verso = verso;
			}

			public int getEtaMassima() {
				return etaMassima;
			}

			public void setEtaMassima(int etaMassima) {
				this.etaMassima = etaMassima;
			}

			
			
			
		

	}

