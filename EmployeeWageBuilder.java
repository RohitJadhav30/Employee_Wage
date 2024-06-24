public class EmployeeWageBuilder {
    final int IS_FULL_TIME = 1;
    final int IS_PART_TIME = 2;
    final int EMP_HOURLY_WAGE = 20;
    final int MONTHLY_WORKING_DAYS = 20;
    final int MAX_HOURS_PER_MONTH = 100;

    int hoursPerday = 0, totalEmpHrs = 0, totalWorkingDays = 0;

    public void calculateWage(){
        while(totalEmpHrs <= MAX_HOURS_PER_MONTH || totalWorkingDays <= MONTHLY_WORKING_DAYS){
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
        int totalEmpWage = totalEmpHrs * EMP_HOURLY_WAGE;

        System.out.println("The employees monthly wage is: " + totalEmpWage + "rs");

    }
    public static void main(String[] args) {
        EmployeeWageBuilder uc = new EmployeeWageBuilder();
        uc.calculateWage();
    }
}
