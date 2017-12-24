package forms;

import component.DataCmp;
import component.MyTimer;
import constant.SysConstant;
import struct.Option;
import struct.Question;
import struct.Stage;
import struct.UserInfoHolder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by iassi on 2017-12-12.
 */
public class PlayForm implements ActionListener {

    private static JFrame frame;
    private JPanel        mainPanel;
    private JPanel        questionPanel;
    private java.util.List<Stage> dataList;
    private JButton       nextBtn;
    private  ButtonGroup  groupBtn;
    private ArrayList     jRdioBtnList;
    private boolean       viewStageSummary;
    private boolean       checkUserAnswer;
    private int           currentStage;

    public PlayForm()
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame = new JFrame("Infinity - Group | Prison Break");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(SysConstant.WINDOW_WIDTH, SysConstant.WINDOW_HEIGHT);
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        Image bgImg = new ImageIcon(new SysConstant().getClass().getResource(SysConstant.IMG_STAGES_PATH[0])).getImage();
        JLabel bgImgLbl = new JLabel(new ImageIcon(bgImg.getScaledInstance(SysConstant.WINDOW_WIDTH, SysConstant.WINDOW_HEIGHT, Image.SCALE_SMOOTH)));
        frame.setContentPane(bgImgLbl);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.add(this.mainPanel, BorderLayout.SOUTH);
        frame.setIconImage(new javax.swing.ImageIcon(new SysConstant().getClass().getResource(SysConstant.IMG_APP_ICON_PATH)).getImage());

    }




    private void createUIComponents()  {
        DataCmp dataCmp=new DataCmp();
        dataList = dataCmp.loadData();
        viewStageSummary=true;
        checkUserAnswer=false;
        currentStage=UserInfoHolder.getCurrentStageIndex();
        UserInfoHolder.setDataList(dataList);
        mainPanel = new JPanel();
        nextBtn=new JButton("Next");
        nextBtn.addActionListener(this);
        mainPanel.setOpaque(false);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        questionPanel=new JPanel(new GridLayout(6,1));
        questionPanel.setBackground(new Color(255,255,229));
        questionPanel.setBackground(Color.WHITE);
        questionPanel.setPreferredSize(new Dimension(800, 250));;

        JPanel btnPanel=new JPanel(new GridBagLayout());
        btnPanel.setBackground(Color.WHITE);

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
        gbc.insets = new Insets(5,0,5,0);  // padding
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 4;   //4 columns wide

        btnPanel.add(nextBtn,gbc);
        mainPanel.add(questionPanel);
        mainPanel.add(btnPanel);
        mainPanel.add(new MyTimer());

        drawQuestion();
    }


    //-----------------------------------------------------------------------


    private void drawQuestion()
    {
        if(dataList == null || dataList.size() ==0 ||
                (dataList.size() <= (UserInfoHolder.getCurrentStageIndex())))// &&
        {
            frame.setVisible(false);
            new ResultForm(false);
        }
        else if(viewStageSummary)
        {
            drawStageSummary();
        }
        else
        {
            checkUserAnswer=true;

            try {
                questionPanel.removeAll();
                questionPanel.setLayout(new GridLayout(6,1));
                Question question = dataList.get(UserInfoHolder.getCurrentStageIndex()).getQuestionsList().get(UserInfoHolder.getCurrentQuestionIndex());
                questionPanel.add(new JLabel("<html><font color=\"red\"> Stage ["+(UserInfoHolder.getCurrentStageIndex()+1)+"]   "+"Q"+(UserInfoHolder.getCurrentQuestionIndex()+1) +": "+question.getQdescription()+"</font></html>"));
                groupBtn = new ButtonGroup();
                jRdioBtnList = new ArrayList();

                if (question.getOptionsList() != null && question.getOptionsList().size() > 0) {
                    for (Option op : question.getOptionsList()) {
                        jRdioBtnList.add(op.getrBtn());
                        op.getrBtn().setOpaque(false);
                        groupBtn.add(op.getrBtn());
                        questionPanel.add(op.getrBtn());
                    }
                }


                ///-------------------
                if (dataList.get(UserInfoHolder.getCurrentStageIndex()).getQuestionsList().size() <= (UserInfoHolder.getCurrentQuestionIndex() + 1)) {
                    UserInfoHolder.resetQuestionIndex();
                    UserInfoHolder.nextStageIndex();
                } else {
                    UserInfoHolder.nextQuestionIndex();
                }

                if (UserInfoHolder.getCurrentQuestionIndex() == 1 && UserInfoHolder.getCurrentStageIndex() > 0) {
                Image bgImg = new ImageIcon(new SysConstant().getClass().getResource(SysConstant.IMG_STAGES_PATH[UserInfoHolder.getCurrentStageIndex()])).getImage();
                JLabel bgImgLbl = new JLabel(new ImageIcon(bgImg.getScaledInstance(SysConstant.WINDOW_WIDTH, SysConstant.WINDOW_HEIGHT, Image.SCALE_SMOOTH)));
                frame.getContentPane().removeAll();
                frame.setContentPane(bgImgLbl);
                frame.add(mainPanel, BorderLayout.SOUTH);
                frame. repaint();
                }
//                mainPanel.repaint();
//                mainPanel.revalidate();
                questionPanel.revalidate();
                questionPanel.repaint();

                if(currentStage!=UserInfoHolder.getCurrentStageIndex())
                {
                    currentStage = UserInfoHolder.getCurrentStageIndex();
                    viewStageSummary=true;
                }

            } catch (Exception e) {
                System.out.println("Error in PlayForm.drawQuestion:" + e);
            }

        }
    }

//--------------------------------------------------------------------------------------------------
private void drawStageSummary()
{

    if(dataList == null || dataList.size() ==0 ||
            (dataList.size() <= (UserInfoHolder.getCurrentStageIndex())))// &&
    {
        frame.setVisible(false);
        new ResultForm(false);
    }
    else
    {
        viewStageSummary = false;
        checkUserAnswer = false;
        questionPanel.removeAll();
        questionPanel.setLayout(new BorderLayout());
        questionPanel .add(new JLabel(dataList.get(UserInfoHolder.getCurrentStageIndex()).getSummary(), JLabel.CENTER),BorderLayout.CENTER);
        questionPanel.revalidate();
        questionPanel.repaint();
    }

}
//--------------------------------------------------------------------------------------------------
    private boolean validate()
    {
        for(Object opRbtn:jRdioBtnList)
        {
            if(((JRadioButton)opRbtn).isSelected())
            return true;
        }

        return false;
    }
//--------------------------------------------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {

        if(viewStageSummary)
        {
            drawStageSummary();
        }
        else
        {
          if (checkUserAnswer && validate())
              drawQuestion();
          else if(checkUserAnswer)
              JOptionPane.showMessageDialog(frame, "Please answer the Question.");
            else
              drawQuestion();
       }

    }
    //---------------------------------------------------------------------------------------------

    public static JFrame getFrame() {
        return frame;
    }
}
