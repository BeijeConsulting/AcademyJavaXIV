package it.beije.turing.file;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class StressTest {
	
	
	
	public static void main(String[] args) {
		ArrayList<Connection> connections = new ArrayList<>();
		int jdbCount = 0;
		int lastCount = 0;
		do {
			
			try {
				connections.add(JDBCmanager.getConnection());
				connections.get(connections.size() - 1).beginRequest();
				jdbCount++;
				
				for(Connection c : connections) {
					if(c.isClosed())
						break;
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(jdbCount + "is the max number of connections");
			}			
		}while(jdbCount > lastCount);
		
	}

}
