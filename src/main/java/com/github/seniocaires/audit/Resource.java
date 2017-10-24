package com.github.seniocaires.audit;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

@Path("/sites")
@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
@Transactional
public class Resource {

  @Inject
  private Service service;

  @GET
  @Path("/change")
  public Response change() {
    for (Site site : service.buscarTodos()) {
      site.setNomeAlterado(site.getNome() + String.valueOf(1 + (int) (Math.random() * 100)));
      service.salvar(site);
    }
    return Response.ok().build();
  }

  @GET
  @Path("/")
  public Response sites() {
    return Response.ok(new Gson().toJson(service.buscarTodos())).build();
  }
}
