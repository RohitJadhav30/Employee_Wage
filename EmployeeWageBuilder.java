import java.util.Scanner;

public class EmployeeWageBuilder{
    public static final int IS_FULL_TIME = 1;
    public static final int IS_PART_TIME = 2;

    private final String company;
    private final int maxHoursPerMonth;
    private final int monthlyWorkingDays;
    private final int empHourlyWage;
    
    private int totalEmpWage;

    public EmployeeWageBuilder(String company, int maxHoursPerMonth, int monthlyWorkingDays, int empHourlyWage){
        this.company = company;
        this.maxHoursPerMonth = maxHoursPerMonth;
        this.monthlyWorkingDays = monthlyWorkingDays;
        this.empHourlyWage = empHourlyWage;

    }

    public void calculateWage(){
        int hoursPerday = 0, totalEmpHrs = 0, totalWorkingDays = 0;
        while(totalEmpHrs <= maxHoursPerMonth && totalWorkingDays < monthlyWorkingDays){
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
        totalEmpWage = totalEmpHrs * empHourlyWage;

    }

    @Override
    public String toString(){
        return "The company name is " + company + " And the total employee wage is " + totalEmpWage + "rs";
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter company name: ");
        String company = sc.nextLine();

        System.out.print("Enter max hours per month: ");
        int maxHoursPerMonth = sc.nextInt();

        System.out.print("Enter monthly working days: ");
        int monthlyWorkingDays = sc.nextInt();

        System.out.print("Enter hourly wage: ");
        int empHourlyWage = sc.nextInt();
        sc.close();

        EmployeeWageBuilder uc = new EmployeeWageBuilder(company, maxHoursPerMonth, monthlyWorkingDays, empHourlyWage);
        uc.calculateWage();

        System.out.println(uc.toString());
    }
}