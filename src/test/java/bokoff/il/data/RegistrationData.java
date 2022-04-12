package bokoff.il.data;

import bokoff.il.utils.RandomUtils;
import com.github.javafaker.Faker;

public class RegistrationData {
  Faker faker = new Faker();
  RandomUtils randomUtils = new RandomUtils();

  public String firstName = faker.name().firstName();
  public String lastName = faker.name().lastName();
  public String email = faker.internet().emailAddress();
  public String mobilePhone = randomUtils.getRandomPhone(10);
  public String subjects="English";
  public String gender="Male";
  public String filePath= "img/test.jpg";
  public String currentAddress=faker.address().fullAddress();
  public String year=randomUtils.getRandomInt(1900, 2100);
  public String day = randomUtils.getRandomInt(1,28);
  public String hobby="Sports";
  public String state="NCR";
  public String city="Delhi";
}
