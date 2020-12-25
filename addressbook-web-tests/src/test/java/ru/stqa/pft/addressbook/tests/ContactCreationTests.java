package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstName("Alex")
            .withAddress("SPb, Lenina 1")
            .withLastName("Bogdanov")
            .withHomePhone("2350863")
            .withMobilePhone("89113289778")
            .withWorkPhone("3267998")
            .withEmail("mail@mail.ru")
            .withEmail2("mail@yandex.ru")
            .withEmail3("mail@google.com");
//            .withGroup();

    app.contact().create(contact);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact
                    .withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt()))));

  }

  @Test
  public void testBadContactCreation() throws Exception {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstName("Alex'")
            .withAddress("SPb, Lenina 1")
            .withLastName("Bogdanov")
            .withHomePhone("2350863")
            .withMobilePhone("89113289778")
            .withWorkPhone("3267998")
            .withEmail("mail@mail.ru")
            .withEmail2("mail@yandex.ru")
            .withEmail3("mail@google.com");
    //            .withGroup();
    app.contact().create(contact);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));

  }
}
