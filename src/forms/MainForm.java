package forms;

import component.DataCmp;
import constant.SysConstant;
import struct.Option;
import struct.UserInfoHolder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by iassi on 2017-12-12.
 */
public class MainForm implements ActionListener {
    private static JFrame frame;
    private JPanel  mainPanel;
    private JPanel  bodyPanel;
    private JButton startBtn;


    //-------------------------------------------------------------------------------------------------
    public static void main(String[] args) throws IOException {


        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
         JWindow window = new JWindow();
        window.setSize(SysConstant.WINDOW_WIDTH, SysConstant.WINDOW_HEIGHT);
        window.setLocation(dim.width / 2 - window.getSize().width / 2, dim.height / 2 - window.getSize().height / 2);

        Image splashScreenImg = new javax.swing.ImageIcon(new SysConstant().getClass().getResource(SysConstant.IMG_SPLASH_SCREEN_PATH)).getImage();
        JLabel splashScreenLabel = new JLabel(new ImageIcon(splashScreenImg.getScaledInstance(SysConstant.WINDOW_WIDTH, SysConstant.WINDOW_HEIGHT, Image.SCALE_SMOOTH)));
          window.getContentPane().add(splashScreenLabel);

        window.setVisible(true);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        window.setVisible(false);

        frame = new JFrame("Infinity - Group | Prison Break");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(SysConstant.WINDOW_WIDTH, SysConstant.WINDOW_HEIGHT);
        Image bgImg = new ImageIcon(new SysConstant().getClass().getResource(SysConstant.IMG_MAIN_WIN_PATH)).getImage();
        JLabel bgImgLbl = new JLabel(new ImageIcon(bgImg.getScaledInstance(SysConstant.WINDOW_WIDTH, SysConstant.WINDOW_HEIGHT, Image.SCALE_SMOOTH)));
        frame.setContentPane(bgImgLbl);
        frame.setLayout(new BorderLayout());
        frame.add(new MainForm().mainPanel, BorderLayout.WEST);
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.setIconImage(new javax.swing.ImageIcon(new SysConstant().getClass().getResource(SysConstant.IMG_APP_ICON_PATH)).getImage());
        frame.setResizable(false);
        frame.setVisible(true);
    }

    //-------------------------------------------------------------------------------------------------


    private void createUIComponents()  {

        try
        {
            createMainPanel();

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(frame, "Error in method - createMainPanel");
        }


    }
    //-------------------------------------------------------------------------------------------------

    @Override
    public void actionPerformed(ActionEvent e) {

             frame.setVisible(false);
             new PlayForm();

    }
    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    private void createMainPanel() throws IOException {
        mainPanel = new JPanel();
        mainPanel.setOpaque(false);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        bodyPanel = new JPanel(new GridBagLayout());//2, 5
        bodyPanel.setOpaque(false);
        startBtn=new JButton("Start");


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.ipady = 5;      //make this component tall
        gbc.ipadx = 10;      //make this component wide
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 5;   //2 columns wide
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = 1;   //2 columns wide

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.insets = new Insets(20,35,30,0);  // padding
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 4;   //4 columns wide
        JLabel descLabel = new JLabel("<html>" +
                "<p>Prison Break Story <br/> " +
                " You have robbed a bank and sent to Fox River State prison in Chicago, US.<br/>" +
                " it’s one of the maximum-security prisons in the United state. You were <br/>" +
                "sentenced a 30 years imprisonment so you’ve decided to escape from the prison <br/>" +
                " with another 4 prisoners. To escape, You’ve divided the escaping process to <br/>" +
                " Three Stages, they are: planning, digging a Tunnel, Get Away through a Car. <br/>" +
                "<br/>" +
                "Each stage consist of 5 questions with five choices, your task is to chose the <br/>" +
                " most correct answer but you have to answer within 20 minutes so you can escape <br/>" +
                " or you will be caught! <br/><br/>" +
                "You have to be careful!<br/>" +
                "</p></html>");
        descLabel.setForeground(Color.white);
        bodyPanel.add(descLabel, gbc);
        gbc.gridx=0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE;
        startBtn=new JButton("       Play       ");
        startBtn.addActionListener(this);
        bodyPanel.add(startBtn, gbc);
        mainPanel.add(bodyPanel, GroupLayout.Alignment.CENTER);
    }




}
