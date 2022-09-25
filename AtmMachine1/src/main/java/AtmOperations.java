import java.util.HashMap;
import java.util.Map;

public class AtmOperations implements AtmOperationsInterface{
    ATM atm = new ATM();
    Map<Double,String> histories = new HashMap<>();
    @Override
    public void viewBalance() {
        System.out.println("Available Balance is : "+atm.getBalance());

    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
        if (withdrawAmount % 500==0) {   //because in a atm machine available cash is in multiple of 500
            if (withdrawAmount <= atm.getBalance()) {
                histories.put(withdrawAmount, " Amount Withdrawn");
                System.out.println("Collect the Cash " + withdrawAmount);
                atm.setBalance(atm.getBalance() - withdrawAmount);
                viewBalance();
            } else {
                System.out.println("You don't have enough money!");
            }
        }else {
            System.out.println("Please enter the amount in multiple of 500");
        }
    }
    @Override
    public void depositAmount(double depositAmount) {
        histories.put(depositAmount," Amount Deposited");
        System.out.println(depositAmount+" Deposited Successfully!!");
        atm.setBalance(atm.getBalance()+depositAmount);
        viewBalance();
    }

    @Override
    public void viewHistory() {
            for (Map.Entry<Double,String> m:histories.entrySet()){
                System.out.println(m.getKey()+""+m.getValue());
            }
    }
}
