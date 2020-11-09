package ee.bcs.valiit.tasks.controller;

import java.math.BigDecimal;

public class Account {
    private String accountNr;
    private BigDecimal money = new BigDecimal(0);

    public BigDecimal deposit(BigDecimal x){
        money = money.add(x);
        return money;
    }

    public BigDecimal withdraw(BigDecimal x){
        money = x.subtract(money);
        return money;
    }


    public String getAccountNr() {
        return accountNr;
    }

    public void setAccountNr(String accountNr) {
        this.accountNr = accountNr;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
