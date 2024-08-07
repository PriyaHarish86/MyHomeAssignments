package week3.day2;

public interface DatabaseConnection {
	
	//Interface 'DatabseConnection' with abstract methods
	abstract void connect();
	abstract void disconnect();
	abstract void executeUpdate();
	
}
