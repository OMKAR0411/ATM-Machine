import java.util.ArrayList;

public class Transaction {
    private String type;
    private Float amount;


    Transaction(String type, Float amount) {
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }
}
