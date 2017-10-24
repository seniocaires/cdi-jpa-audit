package com.github.seniocaires.audit;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "SITES")
@NamedQueries({ @NamedQuery(name = "Site.buscarTodos", query = "SELECT site FROM Site site") })
@XmlRootElement
@EntityListeners(AuditListener.class)
public class Site implements Serializable {

  private static final long serialVersionUID = -7381738606035519666L;

  @PreUpdate
  public void onPrePersist() {
    Logger.getLogger(Site.class.getName()).log(Level.INFO, "PreUpdate dentro da entidade");
  }

  private Integer id;

  private String nome;

  private String nomeAlterado;

  private String usuarioAlteracao;

  public Site() {
  }

  public Site(String nome) {
    this.nome = nome;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNomeAlterado() {
    return this.nomeAlterado;
  }

  public void setNomeAlterado(String nomeAlterado) {
    this.nomeAlterado = nomeAlterado;
  }

  public String getUsuarioAlteracao() {
    return this.usuarioAlteracao;
  }

  public void setUsuarioAlteracao(String usuarioAlteracao) {
    this.usuarioAlteracao = usuarioAlteracao;
  }

  @Override
  public String toString() {
    return getNome();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Site other = (Site) obj;
    if (nome == null) {
      if (other.nome != null)
        return false;
    } else if (!nome.equals(other.nome))
      return false;
    return true;
  }
}
