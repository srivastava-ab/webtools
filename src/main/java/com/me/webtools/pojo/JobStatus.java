package com.me.webtools.pojo;

public enum JobStatus {

	NEW("new"),
	ASSIGNED("assign"),
	PENDING_APPROVAL("pending_approval"),
	COMPLETE("complete");
	
	 private String name;

	    private JobStatus(String name) {
	        this.name = name;
	    }

	    public String getStatusEnum() {
	        return this.name;
	    }
}
