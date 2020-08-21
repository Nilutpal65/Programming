abstract class Plan{
    protected double rate;
    abstract void getRate();

    public void calculateBill(int units){
        System.out.println(units*rate);
    }
}//end of Plan class.
class  DomesticPlan extends Plan{
    //@override
    public void getRate(){
        rate=3.50;
    }
}//end of DomesticPlan class.
class CommercialPlan extends Plan{
    public void getRate(){
        rate=7.50;
    }
}
class InstitutionalPlan extends Plan{
    public void getRate(){
        rate=5.50;
    }
}

class GetPlanFactory{
    public Plan getPlan(String PlanType) {
        if (PlanType == null) return null;
        if (PlanType.equalsIgnoreCase("DOMESTICPLAN")) {
            return new DomesticPlan();
        }
        if (PlanType.equalsIgnoreCase("COMMERCIALPLAN")) {
            return new CommercialPlan();
        }
        if (PlanType.equalsIgnoreCase("INSTITUTIONALPLAN")) {
            return new InstitutionalPlan();
        }
        return null;
    }
}

public class GenerateBill {
    public static void main(String[] args) {
        GetPlanFactory gp = new GetPlanFactory();
        Plan p = gp.getPlan("DOMESTICPLAN");
        p.getRate();
        System.out.println(p.rate);
    }
}
