package by.etc.tsarikov.task2.interpreter;

import by.etc.tsarikov.task2.interpreter.impl.*;

public class Context {

    public Expression evalute (String s) {
        int pos = s.length()-1;
        while (pos>0) {
            if (Character.isDigit(s.charAt(pos))) {
                pos--;
            }
            else {
                if (s.charAt(pos)==')') {
                    int temp = pos ;
                    while (temp >=0 && s.charAt(temp)!='(') {
                        temp--;
                    }
                    return evalute(s.substring(temp+1,pos-1));

                }

                else if (s.charAt(pos)=='>' || s.charAt(pos)=='<') {

                    Expression left = evalute(s.substring(0,pos-1));
                    int tempPos = pos-2;
                    String str ="";
                    while (tempPos >=0 && Character.isDigit(s.charAt(tempPos)) ) {
                        str +=s.charAt(tempPos);
                        tempPos--;
                    }
                    Expression right = new NumberExpression(Integer.valueOf(str));

                    char oper = s.charAt(pos);
                    switch (oper) {
                        case '>':
                            return new UpperRightExpression(left, right);
                        case '<':
                            return new UpperLeftExpression(left, right);
                    }


                }else {
                    Expression left = evalute(s.substring(0,pos));


                    int tempPos = pos-1;
                    String str ="";
                    while (tempPos >=0 && Character.isDigit(s.charAt(tempPos)) ) {
                        str +=s.charAt(tempPos);

                        tempPos--;
                    }


                    int myPos = 0;

                    while (myPos<str.length()) {
                        if (!Character.isDigit(str.charAt(myPos))) {
                            str = "2";
                            break;
                        }
                        myPos++;
                    }


                    if (str.length()==0) {
                        str = "2";
                    }
                    Expression right = new NumberExpression(Integer.valueOf(str));

                    char oper = s.charAt(pos);

                    switch (oper) {
                        case '|':
                            return new OrExpression(left,right);
                        case '&' :
                            return new AndExpression(left,right);
                        case '^' :
                            return new UpExpression(left,right);
                    }
                }

            }
        }


        int res = Integer.valueOf(s);
        return new NumberExpression(res);
    }
}