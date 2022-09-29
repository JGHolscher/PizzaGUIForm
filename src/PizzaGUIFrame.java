import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.KeyEvent;

import static java.awt.Color.black;

public class PizzaGUIFrame extends JFrame{
    JPanel mainPnl, titlePnl, crustPnl, sizePnl, toppingsPnl, btnPnl, pizzaDetailPnl;
    JLabel titleLbl;
    static String thinCrust = "Thin";
    static String regCrust = "Regular";
    static String ddCrust = "Deep-dish";
    String[] size = { "Small ($8)", "Medium ($12)", "Large ($16)", "Super ($20)"};
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
        pizzaDetailPnl.setLayout(new GridLayout());
        mainPnl.add(pizzaDetailPnl, BorderLayout.NORTH);
        //createTitlePanel();

        createCrustPanel();
        createSizePanel();
        //createToppingsPanel();

        //createButtonPanel();

        setVisible(true);
    }
    /*private void createTitlePanel()//DONE
    {
        titlePnl = new JPanel();

        titleLbl = new JLabel("Pizza Order Form", JLabel.CENTER);
        titleLbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 48));
        //aligns text and image to be stacked not side by side
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);

        titlePnl.add(titleLbl);
        mainPnl.add(titlePnl, BorderLayout.NORTH);
    }

     */

    private void createCrustPanel(){
        crustPnl = new JPanel();
        JRadioButton thinBtn = new JRadioButton(thinCrust);
        thinBtn.setMnemonic(KeyEvent.VK_T);
        thinBtn.setActionCommand(thinCrust);
        thinBtn.setSelected(true);

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

        pizzaDetailPnl.add(crustPnl, new GridLayout(1,1));
    }
    private void createSizePanel(){
        sizePnl = new JPanel();
        JComboBox sizeList = new JComboBox(size);
        sizeList.setSelectedIndex(3);

        sizePnl.add(sizeList);
        sizePnl.setBorder(new TitledBorder("SIZE"));
        mainPnl.add(sizePnl, BorderLayout.SOUTH);
    }

}
