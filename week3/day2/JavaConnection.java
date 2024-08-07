package week3.day2;

public class JavaConnection implements DatabaseConnection {
	
		//Concrete class 'JavaConnection' implementing the Interface 'DatabaseConnection'
		@Override
		public void connect() {
			System.out.println("Connecting to the database");
		}
	
		@Override
		public void disconnect() {
			System.out.println("Disconnect the database");
		}
	
		@Override
		public void executeUpdate() {
			System.out.println("Execute Update");
		}

		public static void main(String[] args) {
			JavaConnection jConn = new JavaConnection();
			jConn.connect();
			jConn.disconnect();
			jConn.executeUpdate();
		}
}
