package com.sapient.cucumber.stepdefs;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import com.sapient.cucumber.entity.User;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class CreateUserStepDef extends BaseStepDef {

  private String apiUri;
  private User givenUser;

  @Given("^create user using following fields:$")
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

  @When("^Saved successfully$")
  public void saveUser() throws Throwable {

    final MvcResult mvcResult = mockMvc.perform(post(apiUri)//
        .content(mapper.writeValueAsString(givenUser))//
        .contentType(MediaType.APPLICATION_JSON)//
        .accept(MediaType.APPLICATION_JSON))//
        .andDo(print())//
        .andExpect(status().isOk())//
        .andReturn();//

    LOG.info(mvcResult.getResponse().getContentAsString());


  }



}
