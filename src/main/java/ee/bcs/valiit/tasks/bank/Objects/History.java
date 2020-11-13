package ee.bcs.valiit.tasks.bank.Objects;

import java.math.BigDecimal;
import java.math.BigInteger;

public class History {
    private String fromAccountNr;
    private String toAccountNr;
    private String operation;
    private BigDecimal money;

    public String getFromAccountNr() {
        return fromAccountNr;
    }

    public void setFromAccountNr(String fromAccountNr) {
        this.fromAccountNr = fromAccountNr;
    }

    public String getToAccountNr() {
        return toAccountNr;
    }

    public void setToAccountNr(String toAccountNR) {
        this.toAccountNr = toAccountNR;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
