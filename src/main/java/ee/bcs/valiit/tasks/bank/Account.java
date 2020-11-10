package ee.bcs.valiit.tasks.bank;

import java.math.BigDecimal;

public class Account {
    private String id;
    private String accountNr;
    private BigDecimal money = new BigDecimal(0);


    public Account(String id, String accountNr, BigDecimal money) {
        this.id = id;
        this.accountNr = accountNr;
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
