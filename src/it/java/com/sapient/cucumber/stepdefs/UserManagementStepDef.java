package com.sapient.cucumber.stepdefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import com.fasterxml.jackson.core.type.TypeReference;
import com.sapient.cucumber.entity.User;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserManagementStepDef extends BaseStepDef {

  private String apiUri;
  private User givenUser;
  private MvcResult saveUserResult;

  @Given("^On User management page Administrator adds a new user with details:\"([^\"]*)\"$")
  public void createUser(final String userDetailsKey) throws Throwable {

    final String userDetailsJson = getPropValue(userDetailsKey);

    givenUser = mapper.readValue(userDetailsJson, User.class);

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

    assertNotNull(saveUserResult);

  }

  @Then("^application shows below message on the page:$")
  public void verifySaveSuccessMsg(final String expectedResult) throws Exception {

    final TypeReference<HashMap<String, String>> typeRef =
        new TypeReference<HashMap<String, String>>() {};

    final Map<String, String> statusMap =
        mapper.readValue(saveUserResult.getResponse().getContentAsString(), typeRef);

    LOG.info(getPropValue(expectedResult));

    assertEquals(getPropValue(expectedResult), statusMap.get("status"));

  }



}
