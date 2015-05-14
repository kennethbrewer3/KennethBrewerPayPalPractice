package com.mobileappscompany.training.personapp.com.mobileappscompany.training.personapp.domain;

/**
 * Created by Android1 on 3/1/2015.
 */
public class Person {
    private String firstName;
    private String lastName;
    private Gender gender;
    private int age;
    private double height;
    private double weight;
    private String country;
    private String state;
    private String street;
    private String streetNum;

    public Person(String firstName,
                  String lastName,
                  Gender gender,
                  int age,
                  double height,
                  double weight,
                  String country,
                  String state,
                  String street,
                  String streetNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.country = country;
        this.state = state;
        this.street = street;
        this.streetNum = streetNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNum() {
        return streetNum;
    }

    public void setStreetNum(String streetNum) {
        this.streetNum = streetNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (Double.compare(person.height, height) != 0) return false;
        if (Double.compare(person.weight, weight) != 0) return false;
        if (!country.equals(person.country)) return false;
        if (!firstName.equals(person.firstName)) return false;
        if (gender != person.gender) return false;
        if (!lastName.equals(person.lastName)) return false;
        if (!state.equals(person.state)) return false;
        if (!street.equals(person.street)) return false;
        if (!streetNum.equals(person.streetNum)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + age;
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + country.hashCode();
        result = 31 * result + state.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + streetNum.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", street='" + street + '\'' +
                ", streetNum='" + streetNum + '\'' +
                '}';
    }
}
