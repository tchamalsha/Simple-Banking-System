package v2;

public class TransactionFinder {
    String transaction;

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }
    public void printPreviousTransaction(){
        System.out.println("Your previous transaction is: \n");
        System.out.println(transaction);
    }
}
