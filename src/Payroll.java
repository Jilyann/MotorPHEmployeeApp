public class Payroll {

    // ATTRIBUTES
    private static double grossSalary;
    private static double sssDeduction;
    private static double philHealthDeduction;
    private static double pagibigDeduction;
    private static double taxDeduction;
    private static double netPay;

    /**
     * Computes gross salary.
     */
    public static double computeGrossPay(
            double hoursWorked,
            double hourlyRate
    ) {

        grossSalary = hoursWorked * hourlyRate;

        System.out.println("Gross Salary: " + grossSalary);

        return grossSalary;
    }

    /**
     * Computes SSS deduction.
     */
    public static double calculateSSS() {

        sssDeduction = grossSalary * 0.05;

        System.out.println("SSS Deduction: " + sssDeduction);

        return sssDeduction;
    }

    /**
     * Computes PhilHealth deduction.
     */
    public static double calculatePhilHealth() {

        philHealthDeduction = grossSalary * 0.03;

        System.out.println("PhilHealth Deduction: "
                + philHealthDeduction);

        return philHealthDeduction;
    }

    /**
     * Computes Pag-IBIG deduction.
     */
    public static double calculatePagibig() {

        pagibigDeduction = grossSalary * 0.02;

        System.out.println("Pag-IBIG Deduction: "
                + pagibigDeduction);

        return pagibigDeduction;
    }

    /**
     * Computes tax deduction.
     */
    public static double calculateTax() {

        taxDeduction = grossSalary * 0.08;

        System.out.println("Tax Deduction: " + taxDeduction);

        return taxDeduction;
    }

    /**
     * Computes net pay.
     */
    public static double computeNetPay() {

        netPay = grossSalary
                - sssDeduction
                - philHealthDeduction
                - pagibigDeduction
                - taxDeduction;

        System.out.println("Net Pay: " + netPay);

        return netPay;
    }
}