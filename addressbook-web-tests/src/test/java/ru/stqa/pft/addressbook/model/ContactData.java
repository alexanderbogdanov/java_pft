package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {

  public void setId(int id) {
    this.id = id;
  }

  private int id;
  private final String firstName;
  private final String address;
  private final String lastName;
  private String group;

  public ContactData(String firstName, String address, String lastName, String group) {
    this.id = Integer.MAX_VALUE;
    this.lastName = lastName;
    this.firstName = firstName;
    this.address = address;
    this.group = group;
  }

  public ContactData(int id, String firstName, String address, String lastName, String group) {
    this.id = id;
    this.lastName = lastName;
    this.firstName = firstName;
    this.address = address;
    this.group = group;
  }


  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getAddress() {
    return address;
  }

  public String getLastName() {
    return lastName;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstName, that.firstName) &&
            Objects.equals(address, that.address) &&
            Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, address, lastName);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", address='" + address + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }
}
