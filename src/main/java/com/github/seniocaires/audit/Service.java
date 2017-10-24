package com.github.seniocaires.audit;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class Service {

  @PersistenceContext(unitName = "audit-unit")
  private EntityManager entityManager;

  public List<Site> buscarTodos() {
    return entityManager.createNamedQuery("Site.buscarTodos", Site.class).getResultList();
  }

  public void salvar(Site site) {
    entityManager.merge(site);
  }
}
