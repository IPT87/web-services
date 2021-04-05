package model;

public class SetOfReports {
	private Report[] records;
	
	public SetOfReports() {
		super();
	}
	
	public SetOfReports(Report[] records) {
		super();
		this.records = records;
	}
	
	public void setRecords(Report[] records) {
		this.records = records;
	}
	
	public Report[] getRecords() {
		return this.records;
	}
}
