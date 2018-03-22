package main;

import java.util.List;
import java.util.Map;

public class QueryResult {
	private List<Map<String, String>> data;
	private String query;

	public QueryResult(List<Map<String, String>> data, String query) {
		super();
		this.setData(data);
		this.setQuery(query);
	}

	public List<Map<String, String>> getData() {
		return data;
	}

	public void setData(List<Map<String, String>> data) {
		this.data = data;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
}
