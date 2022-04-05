package esercizi;
/*public class YetMoreInitializationOrder { 
	
	static { 
		add(2);  //primo ad essere stampato
		}
	
static void add(int num) { 
	System.out.print(num + " ");
	
}

YetMoreInitializationOrder() {
	add(5);  //quito ad essere stampato
	}

static {
	add(4); //secondo ad essere stampato
	}

{ add(6); } //terzo ad essere stampato

static { 
	new YetMoreInitializationOrder(); 
	}

{ add(8); } //quarto ad essere stampato

public static void main(String[] args) {} 

}*/

public class YetMoreInitializationOrder { 
	
	static { 
		add(2);  //primo ad essere stampato
		}
	
static void add(int num) { 
	System.out.print(num + " ");
	
}

YetMoreInitializationOrder() {
	add(5);  //quarto ad essere stampato
	}

static {
	add(4); //secondo ad essere stampato
	}


{ add(6); } //terzo ad essere stampato



static { 
	new YetMoreInitializationOrder(); 
	}

static { add(8); } //quinto ad essere stampato

public static void main(String[] args) {} 

}