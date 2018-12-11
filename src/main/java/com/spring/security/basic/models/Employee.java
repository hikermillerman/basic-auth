package com.spring.security.basic.models;

public class Employee {
    private String first;

    private String last;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("first='").append(first).append('\'');
        sb.append(", last='").append(last).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
