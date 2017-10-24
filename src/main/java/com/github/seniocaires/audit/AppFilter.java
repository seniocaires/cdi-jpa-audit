package com.github.seniocaires.audit;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class AppFilter implements Filter {

  @Inject
  private UserData userData;

  public void init(FilterConfig arg0) throws ServletException {
  }

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    userData.setToken(((HttpServletRequest) request).getHeader("Authorization"));
    // TODO: Adicionar demais informações sobre o usuário

    chain.doFilter(request, response);
  }

  public void destroy() {
  }

}
