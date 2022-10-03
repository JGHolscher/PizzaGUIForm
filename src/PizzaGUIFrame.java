import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;

import static java.awt.Color.black;

public class PizzaGUIFrame extends JFrame{
    JPanel mainPnl, cAndsPnl, titlePnl, crustPnl, sizePnl, toppingsPnl, btnPnl, receiptPnl , pizzaDetailPnl;
    JLabel titleLbl;
    JButton quitBtn, clearBtn, orderBtn;

    static String thinCrust = "Thin";
    static String regCrust = "Regular";
    static String ddCrust = "Deep-Dish";
    String[] size = { "Small ", "Medium ", "Large ", "Super "};

    JScrollPane scroller;
    JTextArea receiptTA;




    public PizzaGUIFrame() //DONE
    {
        setTitle("Pizza Order Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();

        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        setSize((screenWidth /4) * 3 , screenHeight);
        setLocationRelativeTo(null); //centers

        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        add(mainPnl);
        pizzaDetailPnl = new JPanel();
        pizzaDetailPnl.setLayout(new GridLayout(3,1));
        mainPnl.add(pizzaDetailPnl, BorderLayout.NORTH);

        cAndsPnl = new JPanel();
        cAndsPnl.setLayout(new GridLayout(1,2));


        createTitlePanel();

        createCrustPanel();
        createSizePanel();
        pizzaDetailPnl.add(cAndsPnl, new GridLayout(2,1));

        createToppingsPanel();

        createReceiptPanel();

        createButtonPanel();

        setVisible(true);
    }
    private void createTitlePanel()//DONE
    {
        titlePnl = new JPanel();

        titleLbl = new JLabel("Pizza Order Form", JLabel.CENTER);
        titleLbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 48));
        //aligns text and image to be stacked not side by side
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);

        titlePnl.add(titleLbl);
        pizzaDetailPnl.add(titlePnl, new GridLayout(1,1));
    }


    ButtonGroup crust = new ButtonGroup();
    JRadioButton thinBtn = new JRadioButton(thinCrust);
    JRadioButton regBtn = new JRadioButton(regCrust);
    JRadioButton ddBtn = new JRadioButton(ddCrust);
    private void createCrustPanel(){
        crustPnl = new JPanel();

        thinBtn.setMnemonic(KeyEvent.VK_T);
        thinBtn.setActionCommand(thinCrust);



        regBtn.setMnemonic(KeyEvent.VK_R);
        regBtn.setActionCommand(regCrust);


        ddBtn.setMnemonic(KeyEvent.VK_D);
        ddBtn.setActionCommand(ddCrust);

        //Group the radio buttons.

        crust.add(thinBtn);
        crust.add(regBtn);
        crust.add(ddBtn);

        //Register a listener for the radio buttons.
        crustPnl.add(thinBtn);
        crustPnl.add(regBtn);
        crustPnl.add(ddBtn);

        crustPnl.setBorder(new TitledBorder("CRUST"));

        cAndsPnl.add(crustPnl, new GridLayout(1,1));
    }

    JComboBox sizeList = new JComboBox(size);
    private void createSizePanel(){
        sizePnl = new JPanel();


        sizePnl.add(sizeList);
        sizePnl.setBorder(new TitledBorder("SIZE: Small ($8), Medium ($12), Large ($16), Super ($20)"));
        cAndsPnl.add(sizePnl, new GridLayout(1,2));
    }

    JCheckBox eyeBox;
    JCheckBox fliesBox;
    JCheckBox teethBox;
    JCheckBox ratsBox;
    JCheckBox spineBox;
    JCheckBox goopBox;

    private void createToppingsPanel() {
        toppingsPnl = new JPanel();

        eyeBox = new JCheckBox("Eyes");
        eyeBox.setMnemonic(KeyEvent.VK_E);


        fliesBox = new JCheckBox("Flies");
        fliesBox.setMnemonic(KeyEvent.VK_F);


        teethBox = new JCheckBox("Teeth");
        teethBox.setMnemonic(KeyEvent.VK_T);


        ratsBox = new JCheckBox("Rats");
        ratsBox.setMnemonic(KeyEvent.VK_R);


        spineBox = new JCheckBox("Spine");
        spineBox.setMnemonic(KeyEvent.VK_S);


        goopBox = new JCheckBox("Goop");
        goopBox.setMnemonic(KeyEvent.VK_G);

        toppingsPnl.add(eyeBox);
        toppingsPnl.add(fliesBox);
        toppingsPnl.add(teethBox);
        toppingsPnl.add(ratsBox);
        toppingsPnl.add(spineBox);
        toppingsPnl.add(goopBox);

        toppingsPnl.setBorder(new TitledBorder("TOPPINGS (+$1.00 each)"));
        pizzaDetailPnl.add(toppingsPnl, new GridLayout(3,1));
    }

    private void createReceiptPanel(){
        receiptPnl = new JPanel();

        receiptTA =  new JTextArea(20, 35);
        scroller = new JScrollPane(receiptTA);
        receiptTA.setFont(new Font("Times New Roman", Font.PLAIN, 16));

        receiptPnl.add(scroller);
        receiptTA.setEditable(false);

        receiptPnl.setBorder(new TitledBorder("RECEIPT"));
        mainPnl.add(receiptPnl, BorderLayout.CENTER);
    }

    private void createButtonPanel() {
        btnPnl = new JPanel();
        btnPnl.setLayout(new GridLayout(1,3));

        orderBtn = new JButton("Order");
        orderBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 48));
        quitBtn = new JButton("Quit");
        quitBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 48));
        clearBtn = new JButton("Clear");
        clearBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 48));

        btnPnl.add(orderBtn);
        btnPnl.add(clearBtn);
        btnPnl.add(quitBtn);

        mainPnl.add(btnPnl, BorderLayout.SOUTH);

        //quit -DONE
        quitBtn.addActionListener(new ActionListener() {
            JOptionPane pane =new JOptionPane();
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(pane,"Do you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION){System.exit(0);}
                else {setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                }}});





        //clear - DONE
        clearBtn.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                    crust.clearSelection();
                    eyeBox.setSelected(false);
                    fliesBox.setSelected(false);
                    teethBox.setSelected(false);
                    ratsBox.setSelected(false);
                    spineBox.setSelected(false);
                    goopBox.setSelected(false);
                    sizeList.setSelectedIndex(0);
                    receiptTA.setText(" ");


            }
        });




        //order
        orderBtn.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                double toppingPrice = 0;
                double subTotal = 0;
                //check
                String selectedToppings = "";
                if(eyeBox.isSelected()){
                    subTotal+= 1.0;
                    toppingPrice+= 1.0;
                    selectedToppings += "Eyes ";
                }
                if(fliesBox.isSelected()){
                    subTotal+= 1.0;
                    toppingPrice+= 1.0;
                    selectedToppings += "Flies ";
                }
                if(teethBox.isSelected()){
                    subTotal+= 1.0;
                    toppingPrice+= 1.0;
                    selectedToppings += "Teeth ";
                }
                if(ratsBox.isSelected()){
                    subTotal+= 1.0;
                    toppingPrice+= 1.0;
                    selectedToppings += "Rats ";
                }
                if(spineBox.isSelected()){
                    subTotal+= 1.0;
                    toppingPrice+= 1.0;
                    selectedToppings += "Spine ";
                }
                if(goopBox.isSelected()){
                    subTotal+= 1.0;
                    toppingPrice+= 1.0;
                    selectedToppings += "Goop ";
                }

                //radio
                String selectedCrust = "";

                if(thinBtn.isSelected()){
                    selectedCrust += "Thin Crust ";
                }
                if(regBtn.isSelected()){
                    selectedCrust += "Regular Crust ";
                }
                if(ddBtn.isSelected()){
                    selectedCrust += "Deep-Dish Crust ";
                }

                //combo
                double sizePrice = 0;
                // S"Small ($8)", "Medium ($12)", "Large ($16)", "Super ($20)"};
                String selectedSize = ""
                   + sizeList.getItemAt(sizeList.getSelectedIndex());
                switch (selectedSize) {
                    case "Small ":
                        sizePrice= 8.0;
                        subTotal += 8.0;
                        break;
                    case "Medium ":
                        sizePrice= 12.0;
                        subTotal += 12.0;
                        break;
                    case "Large ":
                        sizePrice= 16.0;
                        subTotal += 16.0;
                        break;
                    case "Super ":
                        sizePrice= 20.0;
                        subTotal += 20.0;
                        break;
                }

                double tax= 0;
                double totalPrice= 0;
                tax = subTotal * 0.07;
                totalPrice = tax + subTotal;

                String pizza = selectedSize + selectedCrust;

                //XXXXXXXXXXXXXXX.............................................................................................

                receiptTA.append("\n=========================================");
                //"%-5s:%10s\n"
                receiptTA.append(String.format("\n%-70s:%-10s", pizza, sizePrice));

                receiptTA.append(String.format("\n%-80s:%-3s", selectedToppings, toppingPrice));

                receiptTA.append(String.format("\n\n%-78s:%3s", "Sub-total ", subTotal));

                receiptTA.append(String.format("\n%-80s:%3s", "Tax ", Math.round(tax* 100.0) / 100.0));

                receiptTA.append("\n--------------------------------------------------------------------------");

                receiptTA.append(String.format("\n%-80s:%3s", "Total ", Math.round(totalPrice* 100.0) / 100.0));



                receiptTA.append("\n=========================================");

                //receiptTA.append(String.format("\n%-30s %-30s %-30s %-30s %-30s", selectedSize+ selectedCrust, sizePrice, toppingPrice, subTotal));

            }
        });


    }

}
