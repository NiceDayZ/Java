package com.business.util;

import java.util.Objects;

public enum RoleType {
    STUDENT("Student"),
    PROFESSOR("Professor"),
    ADMIN("Admin");

    private String name;

    RoleType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
