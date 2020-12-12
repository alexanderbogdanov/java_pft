package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData(
              "Alex", "N", "Bogdanov", "ironweed", null));
      app.getNavigationHelper().goToHomePage();

    }
    app.getContactHelper().modifyContact(new ContactData(
            "Jerry", "Lee", "Lewis", "The Killer", null));
    app.getNavigationHelper().goToHomePage();
  }
}
