package model;

public class Document {
	
	private Integer pcId;
	private String fileName;
	
	public Document() {
		super();
	}

	public Document(Integer pcId, String fileName) {
		this.pcId = pcId;
		this.fileName = fileName;
	}

	public Integer getPcId() {
		return pcId;
	}

	public void setPcId(Integer pcId) {
		this.pcId = pcId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	 @Override
	public String toString() {
		return String.format("[#PC: %d – File: %s]", pcId, fileName);
	}

}
