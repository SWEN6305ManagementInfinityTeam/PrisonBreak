package forms;

import constant.SysConstant;
import struct.Option;
import struct.Question;
import struct.Stage;
import struct.UserInfoHolder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.util.*;
import java.util.List;

/**
 * Created by iassi on 2017-12-12.
 */
public class ResultForm implements ActionListener {

    private static JFrame frame;
    private JPanel mainPanel;
    private JPanel resultPanel;
    private JPanel belbinTestPanel;

    private Label     questionLabel;
    private JCheckBox coChkBox;
    private JCheckBox shChkBox;
    private JCheckBox imChkBox;
    private JCheckBox plChkBox;
    private JCheckBox twChkBox;

    private JButton finishGameBtn;
    private Image  twSelectedImg ;
    private Image  coSelectedImg ;
    private Image  shSelectedImg ;
    private Image  imSelectedImg ;
    private Image  plSelectedImg ;



    public ResultForm(boolean timeOut)
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame = new JFrame("Infinity - Group | Prison Break");
//        frame.setContentPane(this.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(SysConstant.WINDOW_WIDTH, SysConstant.WINDOW_HEIGHT);
        frame.getContentPane().setBackground(Color.white);
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setIconImage(new javax.swing.ImageIcon(new SysConstant().getClass().getResource(SysConstant.IMG_APP_ICON_PATH)).getImage());

        if(timeOut)
        {
            Image bgImg = new ImageIcon(new SysConstant().getClass().getResource(SysConstant.IMG_FAIL_PATH)).getImage();
            JLabel bgImgLbl = new JLabel(new ImageIcon(bgImg.getScaledInstance(SysConstant.WINDOW_WIDTH, SysConstant.WINDOW_HEIGHT, Image.SCALE_SMOOTH)));
            frame.setContentPane(bgImgLbl);
        }
        else
        {
            frame.setLayout(new BorderLayout());
            frame.add(this.mainPanel, BorderLayout.CENTER);
        }

    }

    //- --------------------------------------------------------------------------------
    private void createUIComponents() {
        mainPanel = new JPanel(new GridBagLayout());

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

        mainPanel.setOpaque(false);

        finishGameBtn=new JButton("Finish");
        finishGameBtn.addActionListener(this);
        Image coImg = new javax.swing.ImageIcon(new SysConstant().getClass().getResource(SysConstant.IMG_BELBIN_COORDINATOR_PATH)).getImage();
        Image shImg = new javax.swing.ImageIcon(new SysConstant().getClass().getResource(SysConstant.IMG_BELBIN_SHAPER_PATH)).getImage();
        Image imImg = new javax.swing.ImageIcon(new SysConstant().getClass().getResource(SysConstant.IMG_BELBIN_IMPLEMENTER_PATH)).getImage();
        Image plImg = new javax.swing.ImageIcon(new SysConstant().getClass().getResource(SysConstant.IMG_BELBIN_PLANT_PATH)).getImage();
        Image twImg = new javax.swing.ImageIcon(new SysConstant().getClass().getResource(SysConstant.IMG_BELBIN_TEAM_WORKER_PATH)).getImage();

        twSelectedImg = new javax.swing.ImageIcon(new SysConstant().getClass().getResource(SysConstant.IMG_BELBIN_TEAM_WORKER_SELECTED_PATH)).getImage();
        coSelectedImg = new javax.swing.ImageIcon(new SysConstant().getClass().getResource(SysConstant.IMG_BELBIN_COORDINATOR_SELECTED_PATH)).getImage();
        shSelectedImg = new javax.swing.ImageIcon(new SysConstant().getClass().getResource(SysConstant.IMG_BELBIN_SHAPER_SELECTED_PATH)).getImage();
        imSelectedImg = new javax.swing.ImageIcon(new SysConstant().getClass().getResource(SysConstant.IMG_BELBIN_IMPLEMENTER_SELECTED_PATH)).getImage();
        plSelectedImg = new javax.swing.ImageIcon(new SysConstant().getClass().getResource(SysConstant.IMG_BELBIN_PLANT_SELECTED_PATH)).getImage();

        questionLabel=new Label("Select your previous roles in belbin:");
        belbinTestPanel=new JPanel(new GridLayout(1,5,0,5));
        belbinTestPanel.setOpaque(false);

        coChkBox = new JCheckBox();
        coChkBox.setOpaque(false);
        coChkBox.setIcon(new ImageIcon(coImg.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
        coChkBox.setSelectedIcon(new ImageIcon(coSelectedImg.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
        belbinTestPanel.add(coChkBox);

        shChkBox = new JCheckBox();
        shChkBox.setOpaque(false);
        shChkBox.setIcon(new ImageIcon(shImg.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
        shChkBox.setSelectedIcon(new ImageIcon(shSelectedImg.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
        belbinTestPanel.add(shChkBox);

        imChkBox = new JCheckBox();
        imChkBox.setOpaque(false);
        imChkBox.setIcon(new ImageIcon(imImg.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
        imChkBox.setSelectedIcon(new ImageIcon(imSelectedImg.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
        belbinTestPanel.add(imChkBox);

        plChkBox = new JCheckBox();
        plChkBox.setOpaque(false);
        plChkBox.setIcon(new ImageIcon(plImg.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
        plChkBox.setSelectedIcon(new ImageIcon(plSelectedImg.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
        belbinTestPanel.add(plChkBox);

        twChkBox = new JCheckBox();
        twChkBox.setOpaque(false);
        twChkBox.setIcon(new ImageIcon(twImg.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
        twChkBox.setSelectedIcon(new ImageIcon(twSelectedImg.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
        belbinTestPanel.add(twChkBox);


        resultPanel = new JPanel(new GridLayout(10,1));
        resultPanel.setOpaque(false);


        gbc.gridy++;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 4;   //4 columns wide


        mainPanel.add(questionLabel, gbc);
        gbc.insets = new Insets(5,2,5,2);  // padding
        gbc.gridy++;
        mainPanel.add(belbinTestPanel, gbc);
        gbc.gridy++;
        mainPanel.add(finishGameBtn, gbc);
        gbc.gridy++;
        mainPanel.add(resultPanel, gbc);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JCheckBox[] chkBoxs=new JCheckBox[]{coChkBox,shChkBox,imChkBox,plChkBox,twChkBox};
        int selectedRoles=0;
        for(JCheckBox chkBox:chkBoxs)
        {
            if(chkBox.isSelected())
                selectedRoles++;
        }

        if(selectedRoles <2)
        {
            JOptionPane.showMessageDialog(frame, "Please select at least two role.");
        }
        else if(selectedRoles >2)
        {
            JOptionPane.showMessageDialog(frame, "Please select two role only.");
        }
        else
        {
            Long totalMark=0L,userMark=0L;
            Double tmRoleTotal=0D,plRoleTotal=0D,imRoleTotal=0D,shRoleTotal=0D,coRoleTotal=0D;
            Double tmRoleUser=0D,plRoleUser=0D,imRoleUser=0D,shRoleUser=0D,coRoleUser=0D;

            java.util.List<Stage> dataList= UserInfoHolder.getDataList();
            for(Stage stage:dataList)
            {
                List<Question> questionsList=stage.getQuestionsList();
                for(Question question:questionsList)
                {
                    totalMark+= Long.parseLong(question.getqMark());

                    List<Option> optionsList=question.getOptionsList();
                    for(Option option:optionsList)
                    {
                        tmRoleTotal+=option.getOpCharValue().trim().equals("TW")?1D:0D;
                        plRoleTotal+=option.getOpCharValue().trim().equals("PL")?1D:0D;
                        imRoleTotal+=option.getOpCharValue().trim().equals("IM")?1D:0D;
                        shRoleTotal+=option.getOpCharValue().trim().equals("SH")?1D:0D;
                        coRoleTotal+=option.getOpCharValue().trim().equals("CO")?1D:0D;

                        if(option.getrBtn().isSelected())
                        {
                            userMark+=Long.parseLong(option.getOpMarkValue());

                            tmRoleUser+=option.getOpCharValue().trim().equals("TW")?1D:0D;
                            plRoleUser+=option.getOpCharValue().trim().equals("PL")?1D:0D;
                            imRoleUser+=option.getOpCharValue().trim().equals("IM")?1D:0D;
                            shRoleUser+=option.getOpCharValue().trim().equals("SH")?1D:0D;
                            coRoleUser+=option.getOpCharValue().trim().equals("CO")?1L:0D;
                        }
                    }

                }
            }

            belbinTestPanel.removeAll();
            resultPanel.removeAll();
            questionLabel.setText("Your previous roles in belbin:");
            questionLabel.setForeground(Color.BLACK);
//            mainPanel.remove(questionLabel);
            mainPanel.remove(finishGameBtn);
//            mainPanel.setPreferredSize(new Dimension(400, 300));

            belbinTestPanel.revalidate();
            belbinTestPanel.repaint();
            resultPanel.revalidate();
            resultPanel.repaint();
            JPanel markPanel= new JPanel(new FlowLayout());
            JLabel markLabel= new JLabel("");
            markLabel.setForeground(Color.BLACK);

            String imgPath ="",iconPath="";
            String resultTxt="<html>Your result is " + userMark + "  out of " + totalMark + " in Prison Break Game <br/>";
            if(userMark<60)
            {
                imgPath = SysConstant.IMG_FAIL_PATH;
                iconPath = SysConstant.IMG_FAIL_ICON_PATH;
                markPanel.setBackground(Color.RED);
                resultTxt+="Opss! you couldn’t break out of the prison,<br/> and you will be executed for trying </html>";
            }
            else
            {
                imgPath = SysConstant.IMG_SUCCESS_PATH;
                iconPath = SysConstant.IMG_SUCCESS_ICON_PATH;
                markPanel.setBackground(new Color(45, 173, 105));
                resultTxt+="Congratulations, you have succeeded and won your freedom.</html>";
            }



            Image iconImg = new ImageIcon(new SysConstant().getClass().getResource(iconPath)).getImage();
            JLabel iconImgLbl = new JLabel(new ImageIcon(iconImg.getScaledInstance(50,50, Image.SCALE_SMOOTH)));
            resultPanel.add(iconImgLbl);
            markLabel.setText(resultTxt);
            markPanel.add(markLabel);
            resultPanel.add(markPanel);
//            resultPanel.add(new JLabel(""));

            JLabel characterLabel=new JLabel("Your character is:");
            characterLabel.setForeground(Color.BLACK);
            resultPanel.add(characterLabel);
            Map<String,Integer> dataMap=new HashMap<String, Integer>();
            dataMap.put("TW",(tmRoleUser!=0?(int)(round((tmRoleUser/tmRoleTotal),2)*100):0));
            dataMap.put("PL",(plRoleUser!=0?(int)(round((plRoleUser/plRoleTotal),2)*100):0));
            dataMap.put("IM",(imRoleUser!=0?(int)(round((imRoleUser/imRoleTotal),2)*100):0));
            dataMap.put("CO",(coRoleUser!=0?(int)(round((coRoleUser/coRoleTotal),2)*100):0));
            dataMap.put("SH",(shRoleUser!=0?(int)(round((shRoleUser/shRoleTotal),2)*100):0));
            JPanel panel = new JPanel();
            panel.setOpaque(false);
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            JPanel panel2 = new JPanel();
            panel2.setOpaque(false);
            panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

            int tmp=1;

            dataMap= sortByValue(dataMap);
            for (Map.Entry<String, Integer> entry : dataMap.entrySet()) {
                JLabel lbl=new JLabel(getRoleDesc(entry.getKey()) + " " + entry.getValue()+"%   ");
                lbl.setForeground(Color.BLACK);

                if(tmp<3)
                    panel.add(lbl);
                else
                    panel2.add(lbl);

                tmp++;

            }
            resultPanel.add(panel);
            resultPanel.add(panel2);

            for(JCheckBox chkBox:chkBoxs)
            {
                if(chkBox.isSelected())
                {
                    belbinTestPanel.add(new JLabel(chkBox.getIcon()));
                }
            }

            resultPanel.setPreferredSize(new Dimension(330, 600));



            Image bgImg = new ImageIcon(new SysConstant().getClass().getResource(imgPath)).getImage();
            JLabel bgImgLbl = new JLabel(new ImageIcon(bgImg.getScaledInstance(SysConstant.WINDOW_WIDTH, SysConstant.WINDOW_HEIGHT, Image.SCALE_SMOOTH)));
            frame.getContentPane().removeAll();
            frame.setContentPane(bgImgLbl);
            frame.setLayout(new FlowLayout());
            frame.add(mainPanel);
            frame. repaint();

            resultPanel.revalidate();
            resultPanel.repaint();
//            mainPanel.revalidate();
//            mainPanel.repaint();


        }


    }

    //--------------------------------------------------------------------
    private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

        // 1. Convert Map to List of Map
        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        //    Try switch the o1 o2 position for a different order
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        /*
        //classic iterator example
        for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it.hasNext(); ) {
            Map.Entry<String, Integer> entry = it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }*/


        return sortedMap;
    }
    //--------------------------------------------------------------------
    private String getRoleDesc(String roleId)
    {
        String desc=roleId;

             if(roleId.equals("PL")) desc ="Plant";
        else if(roleId.equals("IM")) desc ="Implementer";
        else if(roleId.equals("TW")) desc ="Team Work";
        else if(roleId.equals("CO")) desc ="Coordinator";
        else if(roleId.equals("SH")) desc ="Shaper";

        return desc;
    }
    //--------------------------------------------------------------------
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
