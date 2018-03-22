package main.data.readers;

public abstract class GenericReader<T> {
	protected final T data;
	
	protected GenericReader(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}
}
