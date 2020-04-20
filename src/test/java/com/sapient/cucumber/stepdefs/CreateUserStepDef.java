package com.sapient.cucumber.stepdefs;

import java.util.List;
import java.util.Map;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import com.sapient.cucumber.entity.User;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java8.En;
import io.cucumber.datatable.DataTable;

@AutoConfigureMockMvc
// @ContextConfiguration
// @SpringBootTest(classes = CucumberApplication.class)
public class CreateUserStepDef extends BaseStepDef implements En {

  private String apiUri;
  private User givenUser;

  public CreateUserStepDef() {

    // Given("^Create User using below data:$", (final List<User> userList) -> {
    // assertNotNull(userList);
    // givenUser = userList.get(0);
    // apiUri = staticURL + port + "/cucumberdemo/v1/user/add";
    // });


  }


  @Given("^create user using following fields:$")
  public void createUser(final DataTable dataTable) throws Exception {

    final List<List<String>> data = dataTable.asLists(String.class);

    givenUser = new User();
    givenUser.setId(Integer.valueOf(data.get(1).get(1)));
    givenUser.setUserName(data.get(2).get(1));
    givenUser.setFirstName(data.get(3).get(1));
    givenUser.setLastName(data.get(3).get(1));
    givenUser.setEmail(data.get(4).get(1));

    apiUri = staticURL + port + "/cucumberdemo/v1/user/add";
  }


  @When("^Saved successfully$")
  public void saveUser() throws Exception {

    final Map<String, Object> map = testRestTemplate.postForObject(apiUri, givenUser, Map.class);

    System.out.println(map.size());
  }



}
