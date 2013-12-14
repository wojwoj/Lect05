import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection implements Closeable {

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static class User {

		public final String surname;

		public final String name;
		public final long id;

		public User(String surname, String name, long id) {
			super();
			this.surname = surname;
			this.name = name;
			this.id = id;
		}
	}

	private Connection conn;

	public DataBaseConnection() {
		try {
			this.conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost/JEE1", "jee1", "jee1");
			System.out.println("Ustanowilem polaczenie" + conn.toString());
		} catch (SQLException e) {
			conn = null;
			throw new RuntimeException();
		}
	}

	public long add(String name, String surname) {
		return 0;
	}

	public User findByName(String name) {
		return null;
	}

	public User findById(long id) {
		return null;
	}

	public static void main(String[] args) {
		DataBaseConnection dbconn = new DataBaseConnection();
		try {
			dbconn.add("Grzegorze", "Kowalski");
			dbconn.add("Jan", "Nowak");
			dbconn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void close() throws IOException {
		if (conn != null) {
			try {
				conn.close();
				System.out.println("zwalniam polaczenie");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
