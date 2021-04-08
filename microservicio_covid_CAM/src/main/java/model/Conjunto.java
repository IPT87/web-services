package model;

public class Conjunto {
	private Informe[] data;

	public Conjunto() {
		super();
	}

	public Conjunto(Informe[] data) {
		super();
		this.data = data;
	}

	public Informe[] getData() {
		return data;
	}

	public void setData(Informe[] data) {
		this.data = data;
	}
	
}
