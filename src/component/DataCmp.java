package component;

import constant.SysConstant;
import struct.Option;
import struct.Question;
import struct.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by iassi on 2017-12-12.
 */
public class DataCmp {

    private List<Option>   optionsList;
    //---------------------------------------------

    public List loadData()
    {
        List<Stage> dataList=new ArrayList();

        try
        {
           List<Stage>    stagesList    = loadStages();
           List<Question> questionsList = loadQuestions();
           optionsList   = loadOptions();

            for(Stage stage:stagesList)
            {
                List qList=new ArrayList();
                for(Question question:questionsList)
                {
                    if(stage.getStageId().equals(question.getStageId()))
                    {
                        List opList = new ArrayList();
                        for (Option option : optionsList)
                        {
                            if (option.getSatgeId().equals(question.getStageId()) && option.getqId().equals(question.getqId()))
                            {
                                opList.add(option);
                            }


                        }
                        question.setOptionsList(opList);
                        qList.add(question);
                    }
                }
                stage.setQuestionsList(qList);
                dataList.add(stage);
            }


        } catch ( Exception e) {
            e.printStackTrace();
        }


        return dataList;
    }

    //------------------------------------------------------------

    private List loadStages() throws  Exception {
        List stagesList=new ArrayList();
        InputStream inputStream=this.getClass().getResourceAsStream(SysConstant.TXT_STAGES_PATH);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line="";
        String[] items=null;
        int stageSequence=1;
        while ((line = bufferedReader.readLine()) != null) {

            if(!line.startsWith("#"))
            {
                items=line.split("\\|");
                stagesList.add(new Stage(stageSequence++,items[0],items[1],items[2],items[3],items[4]));
            }
        }
        return stagesList;
    }

    //------------------------------------------------------------

    private List loadQuestions() throws Exception {
        List questionsList=new ArrayList();
        InputStream inputStream=this.getClass().getResourceAsStream(SysConstant.TXT_QUESTIONS_PATH);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line="";
        String[] items=null;
        while ((line = bufferedReader.readLine()) != null) {

            if(!line.startsWith("#"))
            {
                items=line.split("\\|");
                questionsList.add(new Question(items[0],items[1],items[2],items[3]));
            }
        }
        return questionsList;
    }

    //------------------------------------------------------------

    private List loadOptions() throws Exception {
        List optionsList=new ArrayList();
        InputStream inputStream=this.getClass().getResourceAsStream(SysConstant.TXT_OPTIONS_PATH);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line="";
        String[] items=null;
        while ((line = bufferedReader.readLine()) != null) {

            if(!line.startsWith("#"))
            {
                items=line.split("\\|");
                optionsList.add(new Option(items[0],items[1],items[2],items[3],items[4],items[5]));
            }
        }
        return optionsList;
    }
    // ----------------------------

    public List<Option> getOptionsList() {
        return optionsList;
    }


    //************************ TEST ************************
//
//    public DataCmp() {
//        loadData();
//    }
//
//    public static void main(String[] arg)
//    {
//        new DataCmp();
//    }

}
