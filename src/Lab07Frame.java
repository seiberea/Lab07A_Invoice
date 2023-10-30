import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Lab07Frame extends JFrame
{
    private JPanel mainPanel, titlePanel, middlePanel, itemPanel, quantityPanel, pricePanel, orderPanel, buttonPanel;
    private JLabel titleLabel, itemLabel, quantityLabel, priceLabel;
    private JTextArea orderText;
    private JTextField itemTF1, itemTF2, itemTF3, quantityTF1, quantityTF2, quantityTF3, priceTF1, priceTF2, priceTF3;
    private JScrollPane orderScroll;
    private JButton orderButton, clearButton, quitButton;

    private ActionListener quit = new quitListener();
    private ActionListener order = new orderListener();
    private ActionListener clear = new clearListener();

    private String orderList;
    private double item1Total, item2Total,item3Total, completeTotal;

    Lab07Frame()
    {
        setTitle("Item Order");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        titlePanel = new JPanel();
        middlePanel = new JPanel();
        itemPanel = new JPanel();
        quantityPanel = new JPanel();
        pricePanel = new JPanel();
        orderPanel = new JPanel();
        buttonPanel = new JPanel();

        titleLabel = new JLabel("Item Order Form");
        itemLabel = new JLabel("Item");
        quantityLabel = new JLabel("Quantity");
        priceLabel = new JLabel("Price");

        itemTF1 = new JTextField();
        itemTF1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        itemTF2 = new JTextField();
        itemTF2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        itemTF3 = new JTextField();
        itemTF3.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        quantityTF1 = new JTextField();
        quantityTF1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        quantityTF2 = new JTextField();
        quantityTF2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        quantityTF3 = new JTextField();
        quantityTF3.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        priceTF1 = new JTextField();
        priceTF1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        priceTF2 = new JTextField();
        priceTF2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        priceTF3 = new JTextField();
        priceTF3.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

        orderText = new JTextArea(30,60);
        orderText.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        orderScroll = new JScrollPane(orderText);

        orderButton = new JButton("Order");
        orderButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        orderButton.addActionListener(order);
        clearButton = new JButton("Clear");
        clearButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        clearButton.addActionListener(clear);
        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        quitButton.addActionListener(quit);

        add(mainPanel);
        mainPanel.setLayout(new GridLayout(4,1));

        mainPanel.add(titlePanel);
        titlePanel.setLayout(new GridLayout(1,1));
        titlePanel.add(titleLabel);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));

        mainPanel.add(middlePanel);
        middlePanel.setLayout(new GridLayout(1,3,50,50));

        middlePanel.add(itemPanel);
        itemPanel.setLayout(new GridLayout(4,1));
        itemPanel.add(itemLabel);
        itemLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        itemPanel.add(itemTF1);
        itemPanel.add(itemTF2);
        itemPanel.add(itemTF3);

        middlePanel.add(quantityPanel);
        quantityPanel.setLayout(new GridLayout(4,1));
        quantityPanel.add(quantityLabel);
        quantityLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        quantityPanel.add(quantityTF1);
        quantityPanel.add(quantityTF2);
        quantityPanel.add(quantityTF3);

        middlePanel.add(pricePanel);
        pricePanel.setLayout(new GridLayout(4,1));
        pricePanel.add(priceLabel);
        priceLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        pricePanel.add(priceTF1);
        pricePanel.add(priceTF2);
        pricePanel.add(priceTF3);

        mainPanel.add(orderPanel);
        orderPanel.add(orderScroll);

        mainPanel.add(buttonPanel);
        buttonPanel.add(orderButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(quitButton);

    }
    private class orderListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            //itemTF1, itemTF2, itemTF3, quantityTF1, quantityTF2, quantityTF3, priceTF1, priceTF2, priceTF3;
            String item1 = itemTF1.getText();
            String item2 = itemTF2.getText();
            String item3 = itemTF3.getText();

            double quant1 = Double.parseDouble(quantityTF1.getText());
            double quant2 = Double.parseDouble(quantityTF2.getText());
            double quant3 = Double.parseDouble(quantityTF3.getText());
            double price1 = Double.parseDouble(priceTF1.getText());
            double price2 = Double.parseDouble(priceTF2.getText());
            double price3 = Double.parseDouble(priceTF3.getText());

            item1Total = quant1 * price1;
            item2Total = quant2 * price2;
            item3Total = quant3 * price3;

            completeTotal = item1Total + item2Total + item3Total;

            orderList = String.format("============Invoice============\n"
                            + "Item                Qty     Price     Total\n"
                            + "%s                %.0f     %.2f     %.2f\n"
                            + "%s                %.0f     %.2f     %.2f\n"
                            + "%s                %.0f     %.2f     %.2f\n"
                            + "=============================\n"
                            + "Total:             %.2f\n"
                            + "=============================\n\n",
                    item1, quant1, price1, item1Total, item2, quant2, price2, item2Total, item3, quant3, price3, item3Total, completeTotal);

            orderText.append(orderList);
        }

    }

    private class clearListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            itemTF1.setText(null);
            quantityTF1.setText(null);
            priceTF1.setText(null);

            itemTF2.setText(null);
            quantityTF2.setText(null);
            priceTF2.setText(null);

            itemTF3.setText(null);
            quantityTF3.setText(null);
            priceTF3.setText(null);

            orderText.setText(null);
        }
    }

    private class quitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent AE)
        {
            System.exit(0);
        }
    }
}


