package week3.day2;

public class ExecutionClassJavaConnection extends MySqlConnection{
	
	//Concrete class 'ExecutionClassJavaConnection' inheriting the Interface 'MySqlConnection' and implenenting all the abstract nethods
	@Override
	public void connect() {
		System.out.println("Connect database");	
	}

	@Override
	public void disconnect() {
		System.out.println("Disconnect database");		
	}

	@Override
	public void executeUpdate() {
		System.out.println("Execute Update");		
	}

	@Override
	public void executeQuery() {
		System.out.println("Execute the query");		
	}
	
	public static void main(String[] args) {
		ExecutionClassJavaConnection jc = new ExecutionClassJavaConnection();
		jc.connect();
		jc.disconnect();
		jc.executeUpdate();
		jc.executeQuery();
	}

}
