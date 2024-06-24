public class EmployeeWageBuilder {
    public static void main(String[] args) {
        final int IS_FULL_TIME = 1;
        final int IS_PART_TIME = 2;
        final int empHourlyWage = 20;
        int hoursPerday = 0;

        int empCheck = (int)Math.floor(Math.random() * 10) % 3;
        System.out.println(empCheck);

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
        
        int empDailyWage = empHourlyWage * hoursPerday;

        System.out.println("The employees daily wage is: " + empDailyWage + "rs");
    }
}
