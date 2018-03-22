package main.db;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

public class PostgresExecutor {
	public static List<Map<String, String>> executeSelect(String query) {	
		return ConnectionManager.doWithConnection((con) -> {
			try (Statement stmt = con.createStatement()) {
				// Send the query and bind to the result set
				ResultSet rs = stmt.executeQuery(query);
				
				return ResultSetUtils.toHashMap(rs);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		});
	}
}
