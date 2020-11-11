package ee.bcs.valiit.tasks.test;

import java.math.BigDecimal;

public class Lesson4 {
    // TODO loo programm, mis hoiab mälus panga konto numbrit ja konto balanssi
    // TEE programm:
    //
    public static void main(String[] args) {
        /*BigDecimal a = new BigDecimal("10");
        BigDecimal b = BigDecimal.ONE;
        
        if(a.compareTo(b) < 0){
            System.out.println("jep");
        } else {
            System.out.println("ei ole");
        }
         */

        User user = new User("123123213213", 500);
    }

    public static class User {
        private String iban = "";
        private int balance = 0;

        public User(String iban, int balance) {
            this.iban = iban;
            this.balance = balance;
        }

        public String getIban() {
            return iban;
        }

        public void setIban(String iban) {
            this.iban = iban;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }
    }

}
