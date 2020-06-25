package com.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Student student1 = new Student("Arleight", 8, 3);
        Student student2 = new Student("Skyraider", 10, 2);
        Student student3 = new Student("Cruse Vessel", 30, 3);
        Student student4 = new Student("Hummer", 20, 1);
        Student student5 = new Student("Submarine1", 25, 4);
        Student student6 = new Student("F16", 4, 2);

        List<Student> students = Arrays.asList(student1, student2, student3, student4, student5, student6);

//        Collections.shuffle(students);
//        students.forEach(System.out::println);
//
//        System.out.println("-------Sorting based on names-----------");
//        Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
//        Collections.sort(students, nameComparator);
//        students.forEach(System.out::println);
//
        System.out.println("-------Sorting based on country-----------");
        Comparator<Student> countryComparator = Comparator.comparing(Student::getCountryCode);
        Collections.sort(students, new CompareByCountry());
        students.forEach(System.out::println);

        //System.out.println("-------Sorting based on countryName-----------");
        Comparator<Student> countryNameComparator = Comparator.comparing(Student::getCountryCode, (s1, s2) ->
        {

            if (s1 == 1) {
                s1 = 2;
            } else if (s2 == 1) {
                s2 = 2;
            } else if (s1 == 2) {
                s1 = 1;
            } else if (s2 == 2) {
                s2 = 1;
            } else if (s1 == 3) {
                s1 = 5;
            } else if (s2 == 3) {
                s2 = 5;
            } else if (s1 == 4) {
                s1 = 4;
            } else if (s2 == 4) {
                s2 = 4;
            } else if (s1 == 0) {
                s1 = 3;
            } else if (s2 == 0) {
                s2 = 3;
            }

            return s1.compareTo(s2);
        });
        Collections.sort(students, countryNameComparator);
        //students.forEach(System.out::println);

        List<String> words = Arrays.asList("pen", "blue", "atom", "to",
                "ecclesiastical", "abbey", "car", "ten", "desk", "slim",
                "journey", "forest", "landscape", "achievement", "Antarctica");

        words.sort(Comparator.comparingInt(String::length));

        //words.forEach(System.out::println);

        words.sort((e1, e2) ->  e2.length() - e1.length() );

        //words.forEach(System.out::println);

        List<Integer> domain = Arrays.asList(3,4,1,2,4,3);
        domain.sort((s1, s2) -> s1.compareTo(s2));

        //domain.forEach(System.out::println);
    }
}

class Student {
    String name;
    int age;
    int countryCode;

    public Student(String name, int age, int countryCode) {
        this.name = name;
        this.age = age;
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", countryCode=" + countryCode +
                '}';
    }
}

class CompareByCountry implements Comparator<Student> {

    @Override
    public int compare(Student c1, Student c2) {


        return c1.getCountryCode() - c2.getCountryCode();
    }
}
