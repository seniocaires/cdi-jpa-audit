package com.github.seniocaires.audit;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class UserData {

  private String token;

  // TODO: Adicionar demais informações sobre o usuário

  public String getToken() {
    return this.token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
