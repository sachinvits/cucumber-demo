package com.sapient.cucumber.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Integer id;

  private String userName;
  private String firstName;
  private String lastName;
  private String email;

  // @Override
  // public boolean equals(final Object obj) {
  // if (this == obj) {
  // return true;
  // }
  // if (obj == null) {
  // return false;
  // }
  // if (getClass() != obj.getClass()) {
  // return false;
  // }
  // final User other = (User) obj;
  // if (email == null) {
  // if (other.email != null) {
  // return false;
  // }
  // } else if (!email.equals(other.email)) {
  // return false;
  // }
  // if (firstName == null) {
  // if (other.firstName != null) {
  // return false;
  // }
  // } else if (!firstName.equals(other.firstName)) {
  // return false;
  // }
  // if (id == null) {
  // if (other.id != null) {
  // return false;
  // }
  // } else if (!id.equals(other.id)) {
  // return false;
  // }
  // if (lastName == null) {
  // if (other.lastName != null) {
  // return false;
  // }
  // } else if (!lastName.equals(other.lastName)) {
  // return false;
  // }
  // if (userName == null) {
  // if (other.userName != null) {
  // return false;
  // }
  // } else if (!userName.equals(other.userName)) {
  // return false;
  // }
  // return true;
  // }
  //
  // public String getEmail() {
  // return email;
  // }
  //
  // public String getFirstName() {
  // return firstName;
  // }
  //
  // @Id
  // @GeneratedValue(strategy = GenerationType.AUTO)
  // public Integer getId() {
  // return id;
  // }
  //
  // public String getLastName() {
  // return lastName;
  // }
  //
  // public String getUserName() {
  // return userName;
  // }
  //
  // @Override
  // public int hashCode() {
  // final int prime = 31;
  // int result = 1;
  // result = prime * result + (email == null ? 0 : email.hashCode());
  // result = prime * result + (firstName == null ? 0 : firstName.hashCode());
  // result = prime * result + (id == null ? 0 : id.hashCode());
  // result = prime * result + (lastName == null ? 0 : lastName.hashCode());
  // result = prime * result + (userName == null ? 0 : userName.hashCode());
  // return result;
  // }
  //
  // public void setEmail(final String email) {
  // this.email = email;
  // }
  //
  // public void setFirstName(final String firstName) {
  // this.firstName = firstName;
  // }
  //
  // public void setId(final Integer id) {
  // this.id = id;
  // }
  //
  // public void setLastName(final String lastName) {
  // this.lastName = lastName;
  // }
  //
  // public void setUserName(final String userName) {
  // this.userName = userName;
  // }
  //
  // @Override
  // public String toString() {
  // return "User [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
  // + lastName + ", email=" + email + "]";
  // }



}
