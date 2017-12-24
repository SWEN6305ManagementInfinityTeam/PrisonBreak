package test;

/**
 * Created by iassi on 12/22/2017.
 */
public class MainTest {

    public static void main(String[] args) {
        String[] ddd="In this stage, you will participate with the team to develop a plan for the break. Your plan main idea is to dig a tunnel inside the prison which will end outside the prison area. After that, a car will be on time waiting for you and your partners, so that your plan should be accurate for time and effort that should be divided on different team members. The team should work together to achieve the success, depending on this idea you should answer the following five questions that are related specifically to the planning stage, you are free to imagine yourself at any role in the team and then answer the questions honestly.".split(" ");
        String line="";
        for(int i=0;i<ddd.length;)
        {
            if(line.length()<150)
            {
                line+=" "+ddd[i];
                i++;
            }
            else
            {
                System.out.println(line+" <br/>");
                line="";
            }

        }

    }
}
