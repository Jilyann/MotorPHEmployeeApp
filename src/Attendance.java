import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class Attendance {

    // ATTRIBUTES
    private static LocalTime loginTime;
    private static LocalTime logoutTime;
    private static LocalDate attendanceDate;
    private static double totalHoursWorked;

    /**
     * Sets attendance record.
     */
    public static void setAttendanceRecord(
            LocalDate date,
            LocalTime login,
            LocalTime logout
    ) {

        attendanceDate = date;
        loginTime = login;
        logoutTime = logout;
    }

    /**
     * Computes daily work hours.
     */
    public static double computeHoursWorked() {

        if (loginTime != null && logoutTime != null) {

            Duration duration = Duration.between(loginTime, logoutTime);

            totalHoursWorked = duration.toMinutes() / 60.0;

            System.out.println(
                    "Computed Hours Worked: "
                    + totalHoursWorked
            );

        } else {

            totalHoursWorked = 0.0;

            System.out.println("Invalid attendance record.");
        }

        return totalHoursWorked;
    }

    /**
     * Computes weekly hours.
     */
    public static double computeWeeklyHours() {

        System.out.println("Computing weekly hours...");

        return totalHoursWorked;
    }
}