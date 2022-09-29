import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import static java.awt.Color.black;

public class PizzaGUIFrame extends JFrame{
    JPanel mainPnl, cAndsPnl, titlePnl, crustPnl, sizePnl, toppingsPnl, btnPnl, receiptPnl , pizzaDetailPnl;
    JLabel titleLbl;
    JButton quitBtn, clearBtn, orderBtn;
    static String thinCrust = "Thin";
    static String regCrust = "Regular";
    static String ddCrust = "Deep-dish";
    String[] size = { "Small ($8)", "Medium ($12)", "Large ($16)", "Super ($20)"};

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



    private void createCrustPanel(){
        crustPnl = new JPanel();
        JRadioButton thinBtn = new JRadioButton(thinCrust);
        thinBtn.setMnemonic(KeyEvent.VK_T);
        thinBtn.setActionCommand(thinCrust);


        JRadioButton regBtn = new JRadioButton(regCrust);
        regBtn.setMnemonic(KeyEvent.VK_R);
        regBtn.setActionCommand(regCrust);

        JRadioButton ddBtn = new JRadioButton(ddCrust);
        ddBtn.setMnemonic(KeyEvent.VK_D);
        ddBtn.setActionCommand(ddCrust);

        //Group the radio buttons.
        ButtonGroup crust = new ButtonGroup();
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
    private void createSizePanel(){
        sizePnl = new JPanel();
        JComboBox sizeList = new JComboBox(size);
        sizeList.setSelectedIndex(0);

        sizePnl.add(sizeList);
        sizePnl.setBorder(new TitledBorder("SIZE"));
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

        toppingsPnl.setBorder(new TitledBorder("TOPPINGS"));
        pizzaDetailPnl.add(toppingsPnl, new GridLayout(3,1));
    }

    private void createReceiptPanel(){
        receiptPnl = new JPanel();

        receiptTA =  new JTextArea(12, 30);
        scroller = new JScrollPane(receiptTA);
        receiptTA.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        receiptPnl.add(scroller);

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
                else {setDefaultCloseOperation(pane.DEFAULT_OPTION);
                }}});





        //clear


        //order

    }

}
