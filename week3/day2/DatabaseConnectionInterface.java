package week3.day2;

public interface DatabaseConnectionInterface {
	
	//Interface 'DatabseConnection' with abstract methods
		public abstract void connect();
		public abstract void disconnect();
		public abstract void executeUpdate();
		
}
