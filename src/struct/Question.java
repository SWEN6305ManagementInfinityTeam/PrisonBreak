package struct;

import constant.SysConstant;

import java.util.List;

/**
 * Created by iassi on 2017-12-12.
 */
public class Question {

    private String stageId;
    private String qId;
    private String qdescription;
    private String qMark;
    private List<Option>   optionsList;

    public Question(String stageId, String qId, String qdescription,String qMark) {
        this.stageId = stageId;
        this.qId = qId;
        this.qdescription = qdescription;
        this.qMark = qMark;


        if(SysConstant.TEST_VERSION)
            this.qdescription+=" (Mark:"+ qMark+")";
    }

    public List<Option> getOptionsList() {
        return optionsList;
    }

    public void setOptionsList(List optionsList) {
        this.optionsList = optionsList;
    }

    public String getStageId() {
        return stageId;
    }

    public void setStageId(String stageId) {
        this.stageId = stageId;
    }

    public String getqId() {
        return qId;
    }

    public void setqId(String qId) {
        this.qId = qId;
    }

    public String getQdescription() {
        return SysConstant.splitIntoLines(qdescription);
    }

    public void setQdescription(String qdescription) {
        this.qdescription = qdescription;
    }

    public String getqMark() {
        return qMark;
    }

    public void setqMark(String qMark) {
        this.qMark = qMark;
    }

}
