import com.sun.java.swing.plaf.windows.WindowsTextFieldUI;
import com.sun.org.apache.xpath.internal.operations.Minus;

import java.awt.*;
import java.util.*;

/**
 * Created by 张巍 on 2016/11/4.
 */
public class Cal {
    private static boolean ifZero = false;
    private static String inPut;
    private static int result=0;
    private static Stack num = new Stack(), cha = new Stack();

    private static void input() {
        Scanner input = new Scanner(System.in);
        inPut = input.next();
    }

    public static void main(String[] args) {
        input();
        destruction(inPut);
        for (; !cha.isEmpty(); ) {
            calculating1st();
        }
        System.out.println(result);
        System.out.println();
    }

    private static void calculating1st(){
        try {
            String a = cha.pop().toString(), b = null;
            int right = 0, left = 0, another = 0;
            switch (a) {
                case "+":
                    do {
                        if (cha.peek() != "*" || cha.peek() != "/") {
                            try {
                                left = Integer.valueOf(num.pop().toString());
                                right = Integer.valueOf(num.pop().toString());
                            } catch (Exception e) {
                            }
                            result=Add(left, right);
                            num.add(result);
                            num.push(result);
                        } else {
                            another = Integer.valueOf(num.pop().toString());
                            b = cha.pop().toString();
                            switch (b) {
                                case "*":
                                    right = multiply(right, another);
                                    break;
                                case "/":
                                    right = divide(right, another);
                                    break;
                                default:
                                    throw new WTFException();
                            }
                        }
                    } while (cha.peek() != "*" || cha.peek() != "/");
                    Add(left,right);
                    num.add(result);
                    num.push(result);
                    break;
                case "-":
                    do {
                        if (cha.peek() != "*" || cha.peek() != "/") {
                            try {
                                left = Integer.valueOf(num.pop().toString());
                                right = Integer.valueOf(num.pop().toString());
                                System.out.println("wow");
                            } catch (Exception e) {
                            }
                            minus(left, right);
                            num.add(result);
                            num.push(result);
                        } else {
                            another = Integer.valueOf(num.pop().toString());
                            b = cha.pop().toString();
                            switch (b) {
                                case "*":
                                    right = multiply(right, another);
                                    break;
                                case "/":
                                    right = divide(right, another);
                                    break;
                                default:
                                    throw new WTFException();
                            }
                        }
                    } while (cha.peek() != "*" || cha.peek() != "/");
                    result=minus(left,right);
                    num.add(result);
                    num.push(result);
                    break;
                case "*":
                    try {
                        left = Integer.valueOf(num.pop().toString());
                        right = Integer.valueOf(num.pop().toString());
                    } catch (Exception e) {
                    }
                    result=multiply(left,right);
                    num.add(result);
                    num.push(result);
                default:


            }
        } catch (Exception e) {
        }

    }
    private static void destruction(String input) {
        findNums(input);
        findChars(input);
        System.out.println(num);
        System.out.println(cha);

    }

    private static void findNums(String input) {
        String[] cache = input.split("\\D");
        for (int i = 0; i < cache.length; i++) {
            try {
                int a = Integer.valueOf(cache[i]);
                num.add(a);
            } catch (Exception e) {
            }
        }
    }

    private static void findChars(String input) {
        String[] cache = input.split("\\d");
        for (int i = 0; i < cache.length; i++) {
            if (cache[i].isEmpty()) {
                continue;
            } else {
                cha.add(cache[i]);
            }
        }

    }

    private static int Add(int left, int right) {
        int result;
        result = left + right;
        return result;
    }

    public static int minus(int left, int right) {
        int result;
        result = left - right;
        return result;
    }

    public static int multiply(int left, int right) {
        int result;
        result = left * right;
        return result;
    }

    public static int divide(int left, int right) {
        if (right == 0) {
            System.out.println("除数为零，请检查。");
            ifZero = true;
            return 0;
        }
        int result;
        result = left / right;
        return result;
    }
}

class WTFException extends RuntimeException {
}