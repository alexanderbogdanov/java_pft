package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstName("Alex")
              .withAddress("SPb, Lenina 1")
              .withLastName("Bogdanov")
              .withHomePhone("2350863")
              .withMobilePhone("89113289778")
              .withWorkPhone("3267998")
              .withEmail("mail@mail.ru")
              .withEmail2("mail@yandex.ru")
              .withEmail3("mail@google.com"));
      app.goTo().homePage();
    }
  }

  @Test
  public void testContactModification() {

    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId())
            .withFirstName("Jerry")
            .withAddress("SPb, Pushkina 5")
            .withLastName("Lewis")
            .withHomePhone("1234567")
            .withMobilePhone("89213577998")
            .withWorkPhone("332211")
            .withEmail("mail@yahoo.com")
            .withEmail2("mail@test.ru")
            .withEmail3("mail@kremlin.ru");

    app.contact().modify(contact);
    app.goTo().homePage();

    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();

    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

  }

}
