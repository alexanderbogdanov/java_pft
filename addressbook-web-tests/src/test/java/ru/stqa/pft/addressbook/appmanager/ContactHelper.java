package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }


  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("address"), contactData.getAddress());

    if (creation) {
//      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText((contactData.getGroup()));

      if (isGroupPresent()) {
        new Select(wd.findElement(By.name("new_group"))).selectByIndex(1);
      } else {
        new Select(wd.findElement(By.name("new_group"))).selectByIndex(0);
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  private boolean isGroupPresent() {
    WebElement element = wd.findElement(By.name("new_group"));
    List<WebElement> elements = element.findElements(By.tagName("option"));
    int numberOfOptions = elements.size();
    if (numberOfOptions > 1) {
      return true;
    } else {
      return false;
    }
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }


  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
    alertAccept();
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }

//  public void initContactModification(int index) {
//    wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
//  }

  public void initContactModificationById(int id) {
    wd.findElement(By.xpath("//a[contains(@href, 'edit.php?id=" + id + "')]")).click();

  }
  public void submitContactModification() {
    click(By.xpath("//*[@id=\"content\"]/form[1]/input[1]"));
  }

  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm(contact, true);
    submitContactCreation();
  }

  public void modify(ContactData contact) {
    initContactModificationById(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    returnToHomePage();

  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.cssSelector("[title=\"Edit\"]")).size();
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cols = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cols.get(0).findElement(
              By.tagName("input")).getAttribute("value"));
      String lastName = cols.get(1).getText();
      String firstName = cols.get(2).getText();
      String address = cols.get(3).getText();
      contacts.add(new ContactData()
              .withId(id)
              .withFirstName(firstName)
              .withAddress(address)
              .withLastName(lastName));
    }
    return contacts;
  }



}
