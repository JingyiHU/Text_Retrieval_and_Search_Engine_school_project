package main.db;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultSetUtils {
	public static List<Map<String, String>> toHashMap(ResultSet resultSet) {
		List<Map<String, String>> list = new ArrayList<>();

		try {
			while (resultSet.next()) {
				Map<String, String> map = new HashMap<>();
				ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
				for(int idx = 1; idx<= resultSetMetaData.getColumnCount(); idx++) {
					map.put(resultSetMetaData.getColumnLabel(idx), resultSet.getString(idx).trim());
				}
				
				list.add(map);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return list;
	}
}
