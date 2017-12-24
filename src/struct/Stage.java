package struct;

import constant.SysConstant;

import java.util.List;

/**
 * Created by iassi on 2017-12-12.
 */
public class Stage
{
    private String stageId;
    private String stageDescription;
    private String stageImageId;
    private String stageTime;
    private String summary;
    private List<Question>   questionsList;
    private int    stageSequence;

    public Stage(int stageSequence,String stageId, String stageDescription, String stageImageId, String stageTime, String summary) {
        this.stageSequence = stageSequence;
        this.stageId = stageId;
        this.stageDescription = stageDescription;
        this.stageImageId = stageImageId;
        this.stageTime = stageTime;
        this.summary = summary;
    }

    public List<Question> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List questionsList) {
        this.questionsList = questionsList;
    }

    public String getStageId() {
        return stageId;
    }

    public void setStageId(String stageId) {
        this.stageId = stageId;
    }

    public String getStageDescription() {
        return stageDescription;
    }

    public void setStageDescription(String stageDescription) {
        this.stageDescription = stageDescription;
    }

    public String getStageImageId() {
        return stageImageId;
    }

    public void setStageImageId(String stageImageId) {
        this.stageImageId = stageImageId;
    }

    public String getStageTime() {
        return stageTime;
    }

    public void setStageTime(String stageTime) {
        this.stageTime = stageTime;
    }

    public String getSummary() {
        return "<html> <font color=\"red\">Stage ("+stageSequence+")</font><br/>"+SysConstant.splitIntoLines(summary)+" </html>";
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
