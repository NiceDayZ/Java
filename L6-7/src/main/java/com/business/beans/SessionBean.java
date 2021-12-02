package com.business.beans;


import com.business.model.Account;
import com.business.repository.SessionRole;
import com.business.service.AccountService;
import com.business.util.RoleType;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

@ManagedBean
@SessionScoped
public class SessionBean {

    @Inject
    AccountService accountService;

    @Inject
    SessionRole sessionRole;

    private RoleType roleType;
    private String name;
    private String pw;
    private String result;

    public void login(){
        sessionRole.setRoleType(accountService.login(new Account(name, pw)));
        System.out.println(sessionRole.getRoleType().getName());

        if(sessionRole.getRoleType() != null){
            result = "Success";
        }else{
            result = "Name or password incorrect";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
}
