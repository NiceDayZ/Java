package com.business.beans;

import com.business.model.Account;
import com.business.service.AccountService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

@ManagedBean
@SessionScoped
public class RegisterBean {

    @Inject
    AccountService accountService;

    private String name;
    private String pw;
    private String result;

    public void register(){
        accountService.register(new Account(name, pw));
        result = "Success";
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
}
