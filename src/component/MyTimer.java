package component;

import constant.SysConstant;
import forms.PlayForm;
import forms.ResultForm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyTimer extends JPanel implements ActionListener {

    private int count = SysConstant.TIMER_TIME_OF_GAME;
    private boolean isTimerActive = false;
    private Timer tmr;
    private JLabel timeLabel = new JLabel();
    private CountTimer cntd;

    private JProgressBar progressBar;


    public MyTimer() {
        GUI();
        setTimerText("         ");
        isTimerActive = true;
        tmr.start();
    }

    private void GUI() {

        setLayout(new BorderLayout());
        timeLabel.setBorder(BorderFactory.createRaisedBevelBorder());
//        add(timeLabel, BorderLayout.NORTH);

        progressBar = new JProgressBar(0, SysConstant.TIMER_TIME_OF_GAME);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setForeground(new Color(45, 173, 105));
        progressBar.setBackground(new Color(255, 255, 255));
        add(progressBar, BorderLayout.SOUTH);

        cntd = new CountTimer();



    }

    private void setTimerText(String sTime) {
        timeLabel.setText(sTime);
        if(sTime.equals(SysConstant.TIMER_LAST_MINUTES))
            progressBar.setForeground(Color.RED);
        else if(sTime.equals("00 : 00")) // end of time
        {
            PlayForm.getFrame().setVisible(false);
            new ResultForm(true);
        }

        progressBar.setString(sTime);
    }
    public String getTimerText(){
        return timeLabel.getText();
    }

    private void setTimerColor(Color sColor) {
        timeLabel.setForeground(sColor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        JButton btn = (JButton) e.getSource();
    }


    private class CountTimer implements ActionListener {

        public CountTimer() {
            tmr = new Timer(SysConstant.TIMER_SLEEP_SECOND, this);
            count=SysConstant.TIMER_TIME_OF_GAME;
            setTimerText(TimeFormat(count));
            progressBar.setValue(count);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (isTimerActive) {
                count--;
                setTimerText(TimeFormat(count));
                progressBar.setValue(count);
                if(count == 0)isTimerActive = false;
            }
        }

        public void start() {
            count = SysConstant.TIMER_TIME_OF_GAME;
            isTimerActive = true;
            tmr.start();
        }

        public void resume() {
            isTimerActive = true;
            tmr.restart();
        }

        public void stop() {
            tmr.stop();
        }

        public void pause() {
            isTimerActive = false;
        }

        public void reset() {
            count = SysConstant.TIMER_TIME_OF_GAME;
            isTimerActive = true;
            tmr.restart();

        }

    }

    private String TimeFormat(int count) {
        int hours = count / 3600;
        int minutes = (count-hours*3600)/60;
        int seconds = count-minutes*60;
        return String.format("%02d", minutes) + " : " + String.format("%02d", seconds) ;
    }

}


