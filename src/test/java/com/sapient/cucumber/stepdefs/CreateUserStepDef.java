package com.sapient.cucumber.stepdefs;

import static org.junit.Assert.assertNotNull;
import java.util.List;
import com.sapient.cucumber.entity.User;
// import cucumber.api.java8.En;
import io.cucumber.java.en.Given;

// @AutoConfigureMockMvc
// @ContextConfiguration
// @SpringBootTest(classes = CucumberApplication.class)
public class CreateUserStepDef extends BaseStepDef {

  private String apiUri;
  private User givenUser;

  public CreateUserStepDef() {

    // Given("^Create User using below data:$", (final List<User> userList) -> {
    // assertNotNull(userList);
    // givenUser = userList.get(0);
    // apiUri = staticURL + port + "/cucumberdemo/v1/user/add";
    // });


  }

  @Given("^Create User using below data:$")
  public void createUser(final List<User> userList) throws Exception {
    assertNotNull(userList);
    givenUser = userList.get(0);
    apiUri = staticURL + port + "/cucumberdemo/v1/user/add";
  }

  //
  // @When("^Saved successfully$")
  // public void saveUser() throws Exception {
  // final Map<String, Object> map = testRestTemplate.postForObject(apiUri, givenUser, Map.class);
  //
  // System.out.println(map.size());
  // }



}
