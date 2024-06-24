public class EmployeeWageBuilder {
    public static void main(String[] args) {
        final int IS_FULL_TIME = 1;
        final int IS_PART_TIME = 2;
        final int EMP_HOURLY_WAGE = 20;
        final int MONTHLY_WORKING_DAYS = 20;

        int hoursPerday = 0, totalEmpWage = 0;

        for(int day = 1; day <= MONTHLY_WORKING_DAYS; day++){
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
            int empDailyWage = EMP_HOURLY_WAGE * hoursPerday;

            totalEmpWage += empDailyWage;
        }

        System.out.println("The employees monthly wage is: " + totalEmpWage + "rs");
    }
}
