import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    // ATTRIBUTES
    private static Scanner userInput = new Scanner(System.in);
    private static boolean isLoggedIn = false;

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" Welcome to MotorPH Payroll ");
        System.out.println("=================================");

        if (authenticate()) {

            employeeMenu();

            // SAMPLE EMPLOYEE DATA
            Employee.loadEmployeeData("10001");
            Employee.displayEmployeeInfo();

            // SAMPLE ATTENDANCE
            Attendance.setAttendanceRecord(
                    LocalDate.now(),
                    LocalTime.of(8, 0),
                    LocalTime.of(17, 0)
            );

            double hoursWorked = Attendance.computeHoursWorked();

            // PAYROLL COMPUTATION
            double grossSalary = Payroll.computeGrossPay(
                    hoursWorked,
                    Employee.getHourlyRate()
            );

            double sss = Payroll.calculateSSS();
            double philHealth = Payroll.calculatePhilHealth();
            double pagibig = Payroll.calculatePagibig();
            double tax = Payroll.calculateTax();

            double netPay = Payroll.computeNetPay();

            // DISPLAY GUI
            GUI.initUI();

            GUI.displayPayrollTable(
                    Employee.getEmployeeName(),
                    grossSalary,
                    sss,
                    philHealth,
                    pagibig,
                    tax,
                    netPay
            );
        }
    }

    /**
     * Authenticates the user login.
     */
    public static boolean authenticate() {

        System.out.print("Enter username: ");
        String username = userInput.nextLine();

        System.out.print("Enter password: ");
        String password = userInput.nextLine();

        if (!password.equals("12345")
                || (!username.equals("employee")
                && !username.equals("payroll_staff"))) {

            System.out.println("Incorrect username and/or password.");
            return false;
        }

        isLoggedIn = true;

        System.out.println("Login Successful!");

        return true;
    }

    /**
     * Displays employee menu.
     */
    public static void employeeMenu() {

        System.out.println("\n===== EMPLOYEE MENU =====");
        System.out.println("1. View Employee Details");
        System.out.println("2. View Payroll Summary");
    }
}