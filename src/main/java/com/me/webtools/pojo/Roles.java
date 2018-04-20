package com.me.webtools.pojo;

public enum Roles {

	
	
	Admin("admin"),
	Employee("employee");
	
	
    private String name;

    private Roles(String name) {
        this.name = name;
    }

    public String getStatusEnum() {
        return this.name;
    }
	
}
