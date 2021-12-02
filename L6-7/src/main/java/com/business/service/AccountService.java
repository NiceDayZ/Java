package com.business.service;

import com.business.model.Account;
import com.business.model.Exam;
import com.business.util.RoleType;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;

@Stateless
public class AccountService {
    @PersistenceContext(unitName = "TestJava")
    EntityManager em;

    public void register(Account account){
        em.persist(account);
    }

    public RoleType login(Account account){
        List<Account> accountList = em.createNamedQuery("Account.findOne", Account.class)
                                        .setParameter("name", account.getName())
                                        .setParameter("pw", account.getPw())
                                        .getResultList();

        System.out.println(accountList.size());
        if (accountList.size() != 0) {
            for (RoleType roleType : RoleType.values()) {
                if (Objects.equals(roleType.getName(), accountList.get(0).getRole())) {
                    return roleType;
                }
            }
        }
        return null;

    }
}
