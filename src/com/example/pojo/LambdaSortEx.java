package com.example.pojo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaSortEx {

    public static void main(String[] args) {

        List<Developer> devs = getDevelopers();

        //Sort by age
        Collections.sort(devs, new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        devs.forEach(System.out::println);

        //List.sort() sort directly
        devs.sort(new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                if (o1.getSalary() > o2.getSalary()) {
                    return 1;
                } else if (o1.getSalary() < o2.getSalary()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        System.out.println("-------sort by salary---------");
        devs.forEach(System.out::println);

        //lambda here
        devs.sort((Developer o1, Developer o2) -> o1.getName().compareTo(o2.getName()));
        devs.sort(Comparator.comparing(Developer::getName));
        System.out.println("-----------sorting with lamda-----");
        devs.forEach(System.out::println);

        //more lambda
        devs.sort(((o1, o2) -> o1.getAge() - o2.getAge()));

        devs.sort((Comparator.comparingInt(Developer::getAge)));

        Comparator<Developer> salaryComparator = ((o1, o2) -> {
            if (o1.getSalary() > o2.getSalary()) {
                return 1;
            } else if (o1.getSalary() < o2.getSalary()) {
                return -1;
            } else {
                return 0;
            }
        });

        List<Developer> sortedDevs = devs.stream().sorted(Comparator.comparing(Developer::getSalary, (o1, o2) -> {
            if (o1 > o2) {
                return 1;
            } else if (o1 < o2) {
                return -1;
            } else {
                return 0;
            }
        })).collect(Collectors.toList());

        List<Developer> sortedDev2 = devs.stream().sorted(salaryComparator).collect(Collectors.toList());

        devs.sort(salaryComparator);
        System.out.println("----------------Comparator interface------");
        devs.forEach(System.out::println);

        devs.sort(salaryComparator.reversed());
        devs.forEach(System.out::println);
    }

    private static List<Developer> getDevelopers() {
        Developer developer1 = new Developer("mkyong", 70000.00, 33);
        Developer developer2 = new Developer("alvin", 80000.00, 20);
        Developer developer3 = new Developer("json", 100000.00, 10);
        Developer developer4 = new Developer("iris", 170000.00, 55);

        return Arrays.asList(developer1, developer2, developer3, developer4);

    }
}

class Developer {
    String name;
    double salary;
    int age;

    public Developer(String name, double salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
