package struct;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iassi on 12/15/2017.
 */
public class UserInfoHolder {

    private static List<Stage> dataList;
    private static int currentStageIndex   =0;
//    private static int currentUserIndex    =0;
    private static int currentQuestionIndex=0;
//    private static List<String> usersList= new ArrayList<String>();


    public static int getCurrentStageIndex() {
        return currentStageIndex;
    }

    public static void setCurrentStageIndex(int currentStageIndex) {
        UserInfoHolder.currentStageIndex = currentStageIndex;
    }

//    public static int getCurrentUserIndex() {
//        return currentUserIndex;
//    }

//    public static void setCurrentUserIndex(int currentUserIndex) {
//        UserInfoHolder.currentUserIndex = currentUserIndex;
//    }

    public static int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }
//    public static void nextUserIndex() {
//        if(usersList.size()<= (currentUserIndex+1))
//            currentUserIndex=0;
//        else
//            currentUserIndex++;
//    }
    public static void nextStageIndex() {
        currentStageIndex++;
    }
    public static void nextQuestionIndex() {
         currentQuestionIndex++;
    }
    public static void resetQuestionIndex() {
         currentQuestionIndex=0;
    }

    public static void setCurrentQuestionIndex(int currentQuestionIndex) {
        UserInfoHolder.currentQuestionIndex = currentQuestionIndex;
    }

//    public static void addIntoUsersList(String userName) {
//        usersList.add(userName);
//    }

//    public static List<String> getUsersList() {
//        return usersList;
//    }


    public static List<Stage> getDataList() {
        return dataList;
    }

    public static void setDataList(List<Stage> dataList) {
        UserInfoHolder.dataList = dataList;
    }
}
