package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().createContact(new ContactData(
            "Alex", "N", "Bogdanov", "ironweed", null));
    app.getNavigationHelper().goToHomePage();
  }
 }
