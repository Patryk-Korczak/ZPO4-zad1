package com.company;

public class Worker {
    String firstName;
    String lastName;
    String country;
    Integer salary;

    Worker(String data) {
        String[] info = data.split("\\s+");
        this.firstName = info[0];
        this.lastName = info[1];
        this.country = info[2];
        this.salary = Integer.valueOf(info[3]);
    }

    public void printData() {
        System.out.println(firstName + lastName + country + salary);
    }
}
