interface Bank{
    String getBankName();
}
class HDFC implements Bank{
    private final String BNAME;
    public HDFC(){
        BNAME="HDFC BANK";
    }
    public String getBankName() {
        return BNAME;
    }
}
class ICICI implements Bank{
    private final String BNAME;
    ICICI(){
        BNAME="ICICI BANK";
    }
    public String getBankName() {
        return BNAME;
    }
}


abstract class Loan{
    protected double rate;
    abstract void getInterestRate(double rate);
    public void calculateLoanPayment(double loanamount, int years)
    {
        /*
              to calculate the monthly loan payment i.e. EMI

              rate=annual interest rate/12*100;
              n=number of monthly installments;
              1year=12 months.
              so, n=years*12;

            */

        double EMI;
        int n;

        n=years*12;
        rate=rate/1200;
        EMI=((rate*Math.pow((1+rate),n))/((Math.pow((1+rate),n))-1))*loanamount;

        System.out.println("your monthly EMI is "+ EMI +" for the amount"+loanamount+" you have borrowed");
    }
}// end of the Loan abstract class.

class HomeLoan extends Loan{
    public void getInterestRate(double r){
        rate=r;
    }
}

class BussinessLoan extends Loan{
    public void getInterestRate(double r){
        rate=r;
    }

}//End of the BusssinessLoan class.

abstract class AbstractFactory{
    public abstract Bank getBank(String bank);
    public abstract Loan getLoan(String loan);
}

class BankFactory extends AbstractFactory{
    public Bank getBank(String bank) {
        if (bank == null) return null;
        if (bank.equalsIgnoreCase("HDFC")) return new HDFC();
        if (bank.equalsIgnoreCase("ICICI")) return new ICICI();
        return null;
    }
    public Loan getLoan(String loan) {
        return null;
    }
}

class LoanFactory extends AbstractFactory {
    public Bank getBank(String bank) {
        return null;
    }
    public Loan getLoan(String loan) {
        if (loan == null) return null;
        if (loan.equalsIgnoreCase("HOME")) return new HomeLoan();
        if (loan.equalsIgnoreCase("BUSINESS")) return new BussinessLoan();
        return null;
    }
}

class FactoryCreator {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("Bank")){
            return new BankFactory();
        } else if(choice.equalsIgnoreCase("Loan")){
            return new LoanFactory();
        }
        return null;
    }
}//End of the FactoryCreator.

public class AbstractFactoryPatternExample {
}
