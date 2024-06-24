public class EmployeeWageBuilder {
    public static void main(String[] args) {
        int IS_FULL_TIME = 1;
        int IS_PART_TIME = 2;
        int empHourlyWage = 20;
        int hoursPerday = 0;

        double empCheck = Math.floor(Math.random() * 10) % 3;
        System.out.println(empCheck);

        if(empCheck == IS_FULL_TIME){
            hoursPerday = 8;
        }
        else if(empCheck == IS_PART_TIME){
            hoursPerday = 4;
        }
        else{
            hoursPerday = 0;
        }
        int empDailyWage = empHourlyWage * hoursPerday;

        System.out.println("The employees daily wage is: " + empDailyWage + "rs");
    }
}


