


import javax.swing.*;
        import java.awt.event.*;
        import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProductApp extends JFrame {
    private JTextField txtCustomerName, txtPrice;
    private JComboBox<String> cmbProducts;

    public ProductApp() {
        setTitle("Product App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem itemExit = new JMenuItem("Exit");
        itemExit.addActionListener(e -> System.exit(0));
        menuFile.add(itemExit);

        JMenu menuTools = new JMenu("Tools");
        JMenuItem itemProcess = new JMenuItem("Process");
        itemProcess.addActionListener(e -> processSales());

        JMenuItem itemClear = new JMenuItem("Clear");
        itemClear.addActionListener(e -> clearForm());

        menuTools.add(itemProcess);
        menuTools.add(itemClear);

        menuBar.add(menuFile);
        menuBar.add(menuTools);
        setJMenuBar(menuBar);

        // Components
        JLabel lblCustomer = new JLabel("Customer Name:");
        lblCustomer.setBounds(20, 30, 120, 25);
        add(lblCustomer);

        txtCustomerName = new JTextField();
        txtCustomerName.setBounds(150, 30, 200, 25);
        add(txtCustomerName);

        JLabel lblProduct = new JLabel("Select Product:");
        lblProduct.setBounds(20, 70, 120, 25);
        add(lblProduct);

        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        cmbProducts = new JComboBox<>(products);
        cmbProducts.setBounds(150, 70, 200, 25);
        add(cmbProducts);

        JLabel lblPrice = new JLabel("Enter Price:");
        lblPrice.setBounds(20, 110, 120, 25);
        add(lblPrice);

        txtPrice = new JTextField();
        txtPrice.setBounds(150, 110, 200, 25);
        add(txtPrice);

        JButton btnProcess = new JButton("PROCESS");
        btnProcess.setBounds(150, 150, 200, 30);
        btnProcess.addActionListener(e -> processSales());
        add(btnProcess);
    }

    private void processSales() {
        try {
            String customerName = txtCustomerName.getText();
            String selectedProduct = (String) cmbProducts.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText());

            ProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            // Display Message Box
            String message = "Customer Name: " + customerName + "\n" +
                    "Product: " + selectedProduct + "\n" +
                    "VAT: R " + vat + "\n" +
                    "COMMISSION: R " + commission + "\n" +
                    "TOTAL: R " + total;
            JOptionPane.showMessageDialog(this, message);

            // Save to file data.txt
            try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt", true))) {
                writer.println("DATA LOG");
                writer.println("****************************************");
                writer.println("Customer Name: " + customerName);
                writer.println("Product: " + selectedProduct);
                writer.println("VAT: R " + vat);
                writer.println("COMMISSION: R " + commission);
                writer.println("TOTAL: R " + total);
                writer.println("****************************************");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric price.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving to file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProducts.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        new ProductApp().setVisible(true);
    }
}
