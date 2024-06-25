import java.util.ArrayList;
import java.util.List;

interface IComputeEmpWage {
    void addCompanyEmpWage(String company, int maxHoursPerMonth, int monthlyWorkingDays, int empHourlyWage);
    void computeEmpWage();
    int getTotalWage(String company);
}

class CompanyEmpWage {
    public final String company;
    public final int maxHoursPerMonth;
    public final int monthlyWorkingDays;
    public final int empHourlyWage;
    private int totalEmpWage;
    private List<Integer> dailyWages;

    public CompanyEmpWage(String company, int maxHoursPerMonth, int monthlyWorkingDays, int empHourlyWage) {
        this.company = company;
        this.maxHoursPerMonth = maxHoursPerMonth;
        this.monthlyWorkingDays = monthlyWorkingDays;
        this.empHourlyWage = empHourlyWage;
        this.totalEmpWage = 0;
        this.dailyWages = new ArrayList<>();
    }

    public void setTotalEmpWage(int totalEmpWage) {
        this.totalEmpWage = totalEmpWage;
    }

    public void addDailyWage(int dailyWage) {
        this.dailyWages.add(dailyWage);
    }

    public int getTotalEmpWage() {
        return totalEmpWage;
    }

    @Override
    public String toString() {
        return "Company: " + company + ", Total Employee Wage: " + totalEmpWage + " rs, Daily Wages: " + dailyWages;
    }
}

public class EmpWageBuilder implements IComputeEmpWage {
    public static final int IS_FULL_TIME = 1;
    public static final int IS_PART_TIME = 2;

    private List<CompanyEmpWage> empWageList;

    public EmpWageBuilder() {
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

    @Override
    public int getTotalWage(String company) {
        for (CompanyEmpWage companyEmpWage : empWageList) {
            if (companyEmpWage.company.equals(company)) {
                return companyEmpWage.getTotalEmpWage();
            }
        }
        return 0;
    }

    private int calculateWage(CompanyEmpWage companyEmpWage) {
        int hoursPerDay = 0, totalEmpHrs = 0, totalWorkingDays = 0;
        int dailyWage = 0;

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
            dailyWage = hoursPerDay * companyEmpWage.empHourlyWage;
            companyEmpWage.addDailyWage(dailyWage);
        }

        return totalEmpHrs * companyEmpWage.empHourlyWage;
    }

    public static void main(String[] args) {
        IComputeEmpWage empWageBuilder = new EmpWageBuilder();

        empWageBuilder.addCompanyEmpWage("Zomato", 100, 20, 20);
        empWageBuilder.addCompanyEmpWage("Swiggy", 150, 22, 15);
        empWageBuilder.computeEmpWage();

        String companyToQuery = "Zomato";
        int totalWage = empWageBuilder.getTotalWage(companyToQuery);
        System.out.println("Total wage for " + companyToQuery + ": " + totalWage + " rs");
    }
}
