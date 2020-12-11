package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String nickname;
  private String group;

  public ContactData(String firstName, String middleName, String lastName, String nickname, String group) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickname = nickname;
    this.group = group;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickname() {
    return nickname;
  }

  public String getGroup() {
    return group;
  }
}
