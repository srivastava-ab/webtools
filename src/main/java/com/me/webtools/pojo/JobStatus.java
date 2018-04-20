package com.me.webtools.pojo;

public enum JobStatus {

	NEW("new"),
	ASSIGN("assign"),
	PROCESSING("processing"),
	COMPLETE("complete");
	
	 private String name;

	    private JobStatus(String name) {
	        this.name = name;
	    }

	    public String getStatusEnum() {
	        return this.name;
	    }
}
