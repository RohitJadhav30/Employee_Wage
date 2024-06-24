import java.util.ArrayList;
import java.util.List;

interface IComputeEmpWage {
    void addCompanyEmpWage(String company, int maxHoursPerMonth, int monthlyWorkingDays, int empHourlyWage);
    void computeEmpWage();
}

class CompanyEmpWage {
    public final String company;
    public final int maxHoursPerMonth;
    public final int monthlyWorkingDays;
    public final int empHourlyWage;
    public int totalEmpWage;

    public CompanyEmpWage(String company, int maxHoursPerMonth, int monthlyWorkingDays, int empHourlyWage) {
        this.company = company;
        this.maxHoursPerMonth = maxHoursPerMonth;
        this.monthlyWorkingDays = monthlyWorkingDays;
        this.empHourlyWage = empHourlyWage;
    }

    public void setTotalEmpWage(int totalEmpWage) {
        this.totalEmpWage = totalEmpWage;
    }

    @Override
    public String toString() {
        return "The company name is " + company + " and the total employee wage is " + totalEmpWage + " rs";
    }
}

public class EmployeeWageBuilder implements IComputeEmpWage {
    public static final int IS_FULL_TIME = 1;
    public static final int IS_PART_TIME = 2;

    private List<CompanyEmpWage> empWageList;

    public EmployeeWageBuilder() {
        empWageList = new ArrayList<>();
    }

    @Override
    public void addCompanyEmpWage(String company, int maxHoursPerMonth, int monthlyWorkingDays, int empHourlyWage) {
        CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, maxHoursPerMonth, monthlyWorkingDays, empHourlyWage);
        empWageList.add(companyEmpWage);
    }

    @Override
    public void computeEmpWage() {
        for (CompanyEmpWage companyEmpWage : empWageList) {
            int totalEmpWage = this.calculateWage(companyEmpWage);
            companyEmpWage.setTotalEmpWage(totalEmpWage);
            System.out.println(companyEmpWage);
        }
    }

    private int calculateWage(CompanyEmpWage companyEmpWage) {
        int hoursPerDay = 0, totalEmpHrs = 0, totalWorkingDays = 0;

        while (totalEmpHrs <= companyEmpWage.maxHoursPerMonth && totalWorkingDays < companyEmpWage.monthlyWorkingDays) {
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;

            switch (empCheck) {
                case IS_FULL_TIME:
                    hoursPerDay = 8;
                    break;
                case IS_PART_TIME:
                    hoursPerDay = 4;
                    break;
                default:
                    hoursPerDay = 0;
                    break;
            }

            totalEmpHrs += hoursPerDay;
        }

        return totalEmpHrs * companyEmpWage.empHourlyWage;
    }

    public static void main(String[] args) {
        IComputeEmpWage empWageBuilder = new EmployeeWageBuilder();

        empWageBuilder.addCompanyEmpWage("Zomato", 100, 20, 20);
        empWageBuilder.addCompanyEmpWage("Swiggy", 150, 22, 15);
        empWageBuilder.computeEmpWage();
    }
}
