package com.sapient.cucumber.stepdefs;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import com.fasterxml.jackson.core.type.TypeReference;
import com.sapient.cucumber.entity.User;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class UserManagementStepDef extends BaseStepDef {

  private String apiUri;
  private User givenUser;
  private MvcResult saveUserResult;

  @Given("^On User management page Administrator adds a new user with following fields:$")
  public void createUser(final DataTable dataTable) throws Throwable {

    final List<List<String>> data = dataTable.asLists(String.class);

    givenUser = new User();
    givenUser.setId(Integer.valueOf(data.get(1).get(1)));
    givenUser.setUserName(data.get(2).get(1));
    givenUser.setFirstName(data.get(3).get(1));
    givenUser.setLastName(data.get(3).get(1));
    givenUser.setEmail(data.get(4).get(1));

    apiUri = "/v1/user/add";
  }

  @When("^Administrator saves this new user$")
  public void saveUser() throws Throwable {

    saveUserResult = mockMvc.perform(post(apiUri)//
        .content(mapper.writeValueAsString(givenUser))//
        .contentType(MediaType.APPLICATION_JSON)//
        .accept(MediaType.APPLICATION_JSON))//
        .andDo(print())//
        .andExpect(status().isOk())//
        .andReturn();//

    // LOG.info(mvcResult.getResponse().getContentAsString());

  }

  @Then("^application shows below message on the page:$")
  public void verifySaveSuccessMsg(final String expectedResult) throws Exception {

    final TypeReference<HashMap<String, String>> typeRef =
        new TypeReference<HashMap<String, String>>() {};

    final Map<String, String> statusMap =
        mapper.readValue(saveUserResult.getResponse().getContentAsString(), typeRef);

    LOG.info(expectedResult);

    assertEquals(expectedResult, statusMap.get("status"));

  }



}
