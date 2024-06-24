import java.util.ArrayList;
import java.util.List;

class CompanyEmpWage {
    public final String company;
    public final int maxHoursPerMonth;
    public final int monthlyWorkingDays;
    public final int empHourlyWage;
    
    public int totalEmpWage;

    public CompanyEmpWage(String company, int maxHoursPerMonth, int monthlyWorkingDays, int empHourlyWage){
        this.company = company;
        this.maxHoursPerMonth = maxHoursPerMonth;
        this.monthlyWorkingDays = monthlyWorkingDays;
        this.empHourlyWage = empHourlyWage;

    }

    public void setTotalEmpWage(int totalEmpWage){
        this .totalEmpWage = totalEmpWage;

    }

    @Override
    public String toString(){
        return "The company name is " + company + " And the total employee wage is " + totalEmpWage + "rs";
    }
}

public class EmployeeWageBuilder{
    public static final int IS_FULL_TIME = 1;
    public static final int IS_PART_TIME = 2;

    List<CompanyEmpWage> empWageArray;

    public EmployeeWageBuilder(){
        empWageArray = new ArrayList<>();
    }

    public void addCompanyEmpWage(String company, int maxHoursPerMonth, int monthlyWorkingDays, int empHourlyWage){
        CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, maxHoursPerMonth, monthlyWorkingDays, empHourlyWage);
        empWageArray.add(companyEmpWage);
    }

    public void computeEmpWage(){
        for (CompanyEmpWage companyEmpWage : empWageArray) {
            int totalEmpWage = this.calculateWage(companyEmpWage);
            companyEmpWage.setTotalEmpWage(totalEmpWage);
            System.out.println(companyEmpWage);
        }
    }
    

    private int calculateWage(CompanyEmpWage companyEmpWage){
        int hoursPerday = 0, totalEmpHrs = 0, totalWorkingDays = 0;
        while(totalEmpHrs <= companyEmpWage.maxHoursPerMonth && totalWorkingDays < companyEmpWage.monthlyWorkingDays){
            totalWorkingDays++;
            int empCheck = (int)Math.floor(Math.random() * 10) % 3;

        switch (empCheck) {
            case IS_FULL_TIME:
                hoursPerday = 8;
                break;

            case IS_PART_TIME:
                hoursPerday = 4;
                break;

            default:
            hoursPerday = 0;
                break;
        }
            totalEmpHrs += hoursPerday;

        }
        return totalEmpHrs * companyEmpWage.empHourlyWage;

    }

    public static void main(String[] args) {

        EmployeeWageBuilder empWageBuilder = new EmployeeWageBuilder();

        empWageBuilder.addCompanyEmpWage("Zomato", 20, 2, 10);
        empWageBuilder.addCompanyEmpWage("Swiggy", 80, 20, 10);
        empWageBuilder.computeEmpWage();
    }
        
}
