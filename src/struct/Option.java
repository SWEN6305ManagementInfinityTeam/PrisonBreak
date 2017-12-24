package struct;

import constant.SysConstant;

import javax.swing.*;

/**
 * Created by iassi on 2017-12-12.
 */
public class Option {

    private String satgeId;
    private String qId;
    private String opId;
    private String opDescription;
    private String opMarkValue;
    private String opCharValue;
    private JRadioButton rBtn;

    public Option(String satgeId, String qId, String opId, String opDescription, String opMarkValue, String opCharValue) {
        this.satgeId = satgeId;
        this.qId = qId;
        this.opId = opId;
        this.opDescription = opDescription;
        this.opMarkValue = opMarkValue;
        this.opCharValue = opCharValue;
        this.rBtn = new JRadioButton();

        if(SysConstant.TEST_VERSION)
        this.opDescription+=" ("+opCharValue+", "+opMarkValue+" points)";

        this.rBtn.setText(getOpDescription());
    }

    public String getOpDescription() {
        return "<html>"+SysConstant.splitIntoLines(opDescription)+"</html>";
    }

    public void setOpDescription(String opDescription) {
        this.opDescription = opDescription;
    }

    public String getSatgeId() {
        return satgeId;
    }

    public void setSatgeId(String satgeId) {
        this.satgeId = satgeId;
    }

    public String getqId() {
        return qId;
    }

    public void setqId(String qId) {
        this.qId = qId;
    }

    public String getOpId() {
        return opId;
    }

    public void setOpId(String opId) {
        this.opId = opId;
    }

    public String getOpMarkValue() {
        return opMarkValue;
    }

    public void setOpMarkValue(String opMarkValue) {
        this.opMarkValue = opMarkValue;
    }

    public String getOpCharValue() {
        return opCharValue;
    }

    public void setOpCharValue(String opCharValue) {
        this.opCharValue = opCharValue;
    }

    public JRadioButton getrBtn() {
        return rBtn;
    }

    public void setrBtn(JRadioButton rBtn) {
        this.rBtn = rBtn;
    }
}
