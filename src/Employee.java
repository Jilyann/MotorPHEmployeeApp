import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Employee {

    // ATTRIBUTES
    private static String employeeID;
    private static String employeeName;
    private static String birthday;
    private static double hourlyRate;

    /**
     * Loads employee data from CSV.
     */
    public static void loadEmployeeData(String searchID) {

        String filePath = "details.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            br.readLine();

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String id = data[0];
                String lastName = data[1];
                String firstName = data[2];

                if (id.equals(searchID)) {

                    employeeID = id;
                    employeeName = firstName + " " + lastName;
                    birthday = data[3];
                    hourlyRate = Double.parseDouble(data[18]);

                    return;
                }
            }

            System.out.println("Employee not found.");

        } catch (IOException e) {

            System.out.println("Error reading employee file.");
        }
    }

    /**
     * Displays employee information.
     */
    public static void displayEmployeeInfo() {

        System.out.println("\n===== EMPLOYEE DETAILS =====");
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Birthday: " + birthday);
        System.out.println("Hourly Rate: " + hourlyRate);
    }

    /**
     * Getter for employee name.
     */
    public static String getEmployeeName() {
        return employeeName;
    }

    /**
     * Getter for hourly rate.
     */
    public static double getHourlyRate() {
        return hourlyRate;
    }
}