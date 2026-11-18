import javax.swing.JOptionPane;

public class PrintProduct {
    public void printReport(IProducts productObj, String[] productNames, int[][] monthlySales) {
        StringBuilder report = new StringBuilder("PRODUCT SALES REPORT - 2026\n");
        report.append("--------------------------------------------------\n");

        for (int i = 0; i < productNames.length; i++) {
            for (int j = 0; j < monthlySales[i].length; j++) {
                report.append("Enter number of sales for month ")
                        .append((j + 1))
                        .append(" for ")
                        .append(productNames[i])
                        .append(" mattress: ")
                        .append(monthlySales[i][j])
                        .append("\n");
            }
        }

        report.append("--------------------------------------------------\n");
        report.append("TOTAL PRODUCT SALES: ").append(productObj.GetTotalProductSold()).append("\n");
        report.append("AVERAGE PRODUCT SALES: ").append(Math.round(productObj.GetAverageProductSold())).append("\n");
        report.append("MOST POPULAR PRODUCT: ").append(productObj.GetMostPopularProduct());

        JOptionPane.showMessageDialog(null, report.toString());
    }
}
