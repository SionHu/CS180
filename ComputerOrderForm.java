import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Form used to order a custom computer.
 *
 * <p>Homework 11 -- GUIs</p>
 */
public class ComputerOrderForm {
    /**
     * Text fields used for input.
     */
    private JTextField brandJTextField;
    private JTextField cpuCoresJTextField;
    private JTextField gpuCoresJTextField;
    private JTextField ramAmountJTextField;
    private JTextField powerSupplyJTextField;
    private JTextField hdCapacityJTextField;

    /**
     * Buttons used to handle user interaction.
     */
    private JButton calcPriceJButton;
    private JButton clearJButton;

    /**
     * Starting prices for each computer brand
     */
    private static final double APPLE_PRICE = 999.0;
    private static final double DELL_PRICE = 899.0;
    private static final double MICROSOFT_PRICE = 849.0;
    private static final double ASUS_PRICE = 799.0;
    private static final double HP_PRICE = 749.0;

    /**
     * Price multipliers for each component.
     */
    private static final double PER_CPU_CORE_PRICE = 100.0;
    private static final double PER_GPU_CORE_PRICE = 150.0;
    private static final double PER_RAM_GB_PRICE = 25.0;
    private static final double PER_HD_GB_PRICE = 1.0;
    private static final double PER_SUPPLY_WATT_PRICE = 0.25;

    /**
     * Constructs a newly allocated {@code ComputerOrderForm} object.
     */
    public ComputerOrderForm() {
        this.setUpGUI();

        //TODO enter your code for calcPriceJButton's action listener here
        calcPriceJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String brandname = brandJTextField.getText();
                List<String> nameList = new ArrayList<>();
                nameList.add("Apple");
                nameList.add("Dell");
                nameList.add("Microsoft");
                nameList.add("Asus");
                nameList.add("HP");

                if (!(brandname.matches("Apple") || brandname.matches("Dell") || brandname.matches("Microsoft")
                        || brandname.matches("Asus") || brandname.matches("HP"))){
                    JOptionPane.showMessageDialog(null, "Error: Invalid brand! Please enter another!","Computer Order Form", JOptionPane.ERROR_MESSAGE);
                    brandJTextField.setText(null);
                    brandJTextField.requestFocus();
                }else if (Integer.parseInt(cpuCoresJTextField.getText()) <= 0){
                    JOptionPane.showMessageDialog(null, "Error: Invalid amount of CPU cores! Please enter a positive number!", "Computer Order Form", JOptionPane.ERROR_MESSAGE);
                    cpuCoresJTextField.setText(null);
                    cpuCoresJTextField.requestFocus();
                }else if (Integer.parseInt(gpuCoresJTextField.getText()) <= 0){
                    JOptionPane.showMessageDialog(null, "Error: Invalid amount of GPU cores! Please enter a positive number!","Computer Order Form", JOptionPane.ERROR_MESSAGE);
                    gpuCoresJTextField.setText(null);
                    gpuCoresJTextField.requestFocus();
                }else if (Integer.parseInt(ramAmountJTextField.getText()) <= 0){
                    JOptionPane.showMessageDialog(null, "Error: Invalid amount of RAM! Please enter a positive number!","Computer Order Form", JOptionPane.ERROR_MESSAGE);
                    ramAmountJTextField.setText(null);
                    ramAmountJTextField.requestFocus();
                }else if (Integer.parseInt(powerSupplyJTextField.getText()) <= 0){
                    JOptionPane.showMessageDialog(null, "Error: Invalid power supply wattage! Please enter a positive number!","Computer Order Form", JOptionPane.ERROR_MESSAGE);
                    powerSupplyJTextField.setText(null);
                    powerSupplyJTextField.requestFocus();
                }else if (Integer.parseInt(hdCapacityJTextField.getText()) <= 0){
                    JOptionPane.showMessageDialog(null, "Error: Invalid HD capacity! Please enter a positive number!","Computer Order Form", JOptionPane.ERROR_MESSAGE);
                    hdCapacityJTextField.setText(null);
                    hdCapacityJTextField.requestFocus();
                }else {
                    double brandPrice = 0;
                    if (brandname.matches("Apple")){
                        brandPrice = APPLE_PRICE;
                    }else if (brandname.matches("Dell")){
                        brandPrice = DELL_PRICE;
                    }else if (brandname.matches("Microsoft")){
                        brandPrice = MICROSOFT_PRICE;
                    }else if (brandname.matches("Asus")){
                        brandPrice = ASUS_PRICE;
                    }else if (brandname.matches("HP")){
                        brandPrice = HP_PRICE;
                    }
                    double totalCost = brandPrice + PER_CPU_CORE_PRICE*Integer.parseInt(cpuCoresJTextField.getText()) + PER_GPU_CORE_PRICE*Integer.parseInt(gpuCoresJTextField.getText())
                            + PER_RAM_GB_PRICE*Integer.parseInt(ramAmountJTextField.getText()) + PER_HD_GB_PRICE*Integer.parseInt(hdCapacityJTextField.getText())
                            + PER_SUPPLY_WATT_PRICE*Integer.parseInt(powerSupplyJTextField.getText());
                    JOptionPane.showMessageDialog(null, "Price: $" + totalCost);
                }
            }
        });
        //TODO enter your code for clearJButton's action listener here
        clearJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brandJTextField.setText(null);
                cpuCoresJTextField.setText(null);
                gpuCoresJTextField.setText(null);
                ramAmountJTextField.setText(null);
                powerSupplyJTextField.setText(null);
                hdCapacityJTextField.setText(null);
            }
        });
    } //ComputerOrderForm

    /**
     * Sets up the GUI for the user.
     */
    private void setUpGUI() {
        //initialize the components
        this.brandJTextField = new JTextField();
        this.cpuCoresJTextField = new JTextField();
        this.gpuCoresJTextField = new JTextField();
        this.ramAmountJTextField = new JTextField();
        this.powerSupplyJTextField = new JTextField();
        this.hdCapacityJTextField = new JTextField();
        this.calcPriceJButton = new JButton("Calculate Price");
        this.clearJButton = new JButton("Clear Form");

        JFrame mainJFrame = new JFrame("Computer Order Form");
        JPanel mainJPanel = new JPanel();

        //format mainJPanel
        mainJPanel.setLayout(new GridLayout(14, 1));
        mainJPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        //add the components to mainJPanel
        mainJPanel.add(new JLabel("Brand:"));
        mainJPanel.add(this.brandJTextField);
        mainJPanel.add(new JLabel("CPU cores:"));
        mainJPanel.add(this.cpuCoresJTextField);
        mainJPanel.add(new JLabel("GPU cores:"));
        mainJPanel.add(this.gpuCoresJTextField);
        mainJPanel.add(new JLabel("RAM amount:"));
        mainJPanel.add(this.ramAmountJTextField);
        mainJPanel.add(new JLabel("Power supply wattage:"));
        mainJPanel.add(this.powerSupplyJTextField);
        mainJPanel.add(new JLabel("HD capacity:"));
        mainJPanel.add(this.hdCapacityJTextField);
        mainJPanel.add(this.calcPriceJButton);
        mainJPanel.add(this.clearJButton);

        //format mainJFrame
        mainJFrame.setMinimumSize(new Dimension(500, 450));
        mainJFrame.setContentPane(mainJPanel);
        mainJFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainJFrame.setLocationRelativeTo(null);
        mainJFrame.pack();

        //make mainJFrame visible
        mainJFrame.setVisible(true);
    } //setUpGUI

    public static void main(String[] args) {
        new ComputerOrderForm();
    } //main
}