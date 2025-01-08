class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException(String message) {
        super(message);
    }
}

class Account {
    private String owner;
    private int balance;
    private String accountNumber;

    public Account(String owner, int balance, String accountNumber) {
        this.owner = owner;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public String getBalance() {
        return balance + "";
    }

    public void withdrawal(int amount) throws NotEnoughMoneyException {
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new NotEnoughMoneyException("NI ma pieniędzy");
        }
    }
}

// Kod klasy Main
class Main {
    public static void main(String[] args) {
        Account a = new Account("John Doe", 10, "12345");
        try {
            a.withdrawal(100);
        } catch (NotEnoughMoneyException e) {
            System.out.println("Błąd: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Nieoczekiwany błąd: " + e.getMessage());
        } finally {
            System.out.println("Finally: " + a.getBalance());
        }
    }
}