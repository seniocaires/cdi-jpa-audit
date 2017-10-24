package com.github.seniocaires.audit;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.CDI;
import javax.persistence.PreUpdate;

public class AuditListener {

  @PreUpdate
  private void antesUpdate(Object object) {

    final Instance<UserData> userDataInstance = CDI.current().select(UserData.class);

    Logger.getLogger(AuditListener.class.getName()).log(Level.INFO, "PreUpdate na AuditListener");

    UserData userData = null;
    for (Iterator<UserData> userDataIterator = userDataInstance.iterator() ; userDataIterator.hasNext() ;) {
      userData = (UserData) userDataIterator.next();
      break;
    }

    Site site = (Site) object;
    site.setUsuarioAlteracao(userData.getToken());
  }
}
