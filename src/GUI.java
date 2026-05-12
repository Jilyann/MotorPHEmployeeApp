import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GUI {

    // ATTRIBUTES
    private static JFrame loginFrame;
    private static JTable payrollTable;

    /**
     * Initializes the GUI.
     */
    public static void initUI() {

        loginFrame = new JFrame("MotorPH Payroll System");

        loginFrame.setSize(400, 300);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLocationRelativeTo(null);

        loginFrame.setVisible(true);
    }

    /**
     * Displays payroll table.
     */
    public static void displayPayrollTable(
            String employeeName,
            double grossSalary,
            double sssDeduction,
            double philHealthDeduction,
            double pagibigDeduction,
            double taxDeduction,
            double netPay
    ) {

        String[] columns = {"Field", "Amount"};

        String[][] data = {
            {"Employee Name", employeeName},
            {"Gross Salary", String.format("%.2f", grossSalary)},
            {"SSS Deduction", String.format("%.2f", sssDeduction)},
            {"PhilHealth Deduction", String.format("%.2f", philHealthDeduction)},
            {"Pag-IBIG Deduction", String.format("%.2f", pagibigDeduction)},
            {"Tax Deduction", String.format("%.2f", taxDeduction)},
            {"Net Pay", String.format("%.2f", netPay)}
        };

        payrollTable = new JTable(data, columns);

        JScrollPane scrollPane = new JScrollPane(payrollTable);

        JFrame payrollFrame = new JFrame("Payroll Summary");

        payrollFrame.setSize(400, 300);
        payrollFrame.add(scrollPane);
        payrollFrame.setLocationRelativeTo(null);
        payrollFrame.setVisible(true);
    }
}