package constant;

/**
 * Created by iassi on 2017-12-12.
 */
public class SysConstant
{
    public final static boolean TEST_VERSION   = false;

    public final static String TIMER_LAST_MINUTES   = "05 : 00";
    public final static int    TIMER_TIME_OF_GAME = 1200; // 10 Min
    public final static int    TIMER_SLEEP_SECOND = 1000;

    public final static int WINDOW_HEIGHT = 650;//600;
    public final static int WINDOW_WIDTH  = 1050;//900;

    public final static String TXT_STAGES_PATH    = "/resources/dataTxt/stages.txt";
    public final static String TXT_QUESTIONS_PATH = "/resources/dataTxt/questions.txt";
    public final static String TXT_OPTIONS_PATH   = "/resources/dataTxt/options.txt";

    public final static String IMG_APP_ICON_PATH     = "/resources/images/appIcon.png";
    public final static String IMG_MAIN_WIN_PATH     = "/resources/images/mainWin.jpg";
    public final static String IMG_FAIL_PATH         = "/resources/images/timeOut.jpg";
    public final static String IMG_FAIL_ICON_PATH    = "/resources/images/failIcon.png";
    public final static String IMG_SUCCESS_PATH      = "/resources/images/success.jpg";
    public final static String IMG_SUCCESS_ICON_PATH = "/resources/images/successIcon.png";

    public final static String IMG_BELBIN_TEAM_WORKER_PATH    = "/resources/images/belbinTestRoles/teamWorker.jpg";
    public final static String IMG_BELBIN_PLANT_PATH          = "/resources/images/belbinTestRoles/plant.jpg";
    public final static String IMG_BELBIN_SHAPER_PATH         = "/resources/images/belbinTestRoles/shaper.jpg";
    public final static String IMG_BELBIN_IMPLEMENTER_PATH    = "/resources/images/belbinTestRoles/implementer.jpg";
    public final static String IMG_BELBIN_COORDINATOR_PATH    = "/resources/images/belbinTestRoles/coordinator.jpg";

    public final static String IMG_BELBIN_TEAM_WORKER_SELECTED_PATH = "/resources/images/belbinTestRoles/teamWorkerSelected.jpg";
    public final static String IMG_BELBIN_PLANT_SELECTED_PATH          = "/resources/images/belbinTestRoles/plantSelected.jpg";
    public final static String IMG_BELBIN_SHAPER_SELECTED_PATH         = "/resources/images/belbinTestRoles/shaperSelected.jpg";
    public final static String IMG_BELBIN_IMPLEMENTER_SELECTED_PATH    = "/resources/images/belbinTestRoles/implementerSelected.jpg";
    public final static String IMG_BELBIN_COORDINATOR_SELECTED_PATH    = "/resources/images/belbinTestRoles/coordinatorSelected.jpg";



    public final static String IMG_SPLASH_SCREEN_PATH    = "/resources/images/splashScreen.png";
    public final static String[] IMG_STAGES_PATH         = new String[] {"/resources/images/stage1_plan.jpg","/resources/images/stage2_tunnal.jpg","/resources/images/stage3.png"};
//    public final static String[] IMG_USERS_PATH          = new String[] {"/resources/images/imgUser1.png","/resources/images/imgUser2.png","/resources/images/imgUser3.png","/resources/images/imgUser4.png","/resources/images/imgUser5.png"};


    public static String splitIntoLines(String txt)
    {
        if(txt.contains("<br/>"))
            return txt;
        String line="";
        String result="";
        String [] txtArray=txt.split(" ");
        for(int i=0;i<txtArray.length;)
        {
            if(line.length()<180) // length of line is 150
            {
                line+=" "+txtArray[i];
                i++;
            }
            else
            {
                result+=line+" <br/>";
                line="";
            }

        }
        result+=line;

        return result;
    }
}
