package ee.bcs.valiit.tasks.controller;

import java.math.BigDecimal;

public class AccountBalance {
    private BigDecimal money = new BigDecimal(0);
    private String fromAccount;
    private String toAccount;

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }
}
