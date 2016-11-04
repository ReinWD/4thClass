

import com.sun.org.apache.xpath.internal.operations.Variable;

import java.util.*;

/**
 * Created by 张巍 on 2016/11/1.
 */
public class test {
    static Stack num = new Stack();
    Stack method=new Stack();
    static String in = "1+23-(6*9/(8+99099))";
    static int  matter, length=in.length();

    public void input() {
        Scanner input = new Scanner(System.in);
        Scanner inS=new Scanner(in);
        in = input.next();
        for(int i=0;inS.hasNext();i++){

        }
        length = in.length();
        in.lastIndexOf("(");
    }

    private void searchBracket() {

    }
    private static void searchPlus() {
        int start, end;
        start = in.indexOf("+");
        end = in.lastIndexOf("+");
        for (int i = start; i < end; ) {

        }
    }

    public void list() {
    }

    public static void main(String[] args){
        int         left = Integer.valueOf(num.pop().toString());
         /*for (String out :sb){
             System.out.println(out);
         }
        System.out.println(sb.length);
        /*for(char a:sb){
            System.out.println(a);
        }*/

    }
}



