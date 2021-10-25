import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

class sizeyunsuanTest {

    @Test //加法
    void main0() {
        int a=2,b=4,c=2,d=5;
        int fuhao=0;
        String expArr[]=new String[2];
        BiaodashiTest biaodashi = new BiaodashiTest();
        expArr[0]= biaodashi.biaodashi(a,b)+'+'+ biaodashi.biaodashi(c,d)+'=';
        System.out.println(expArr[0]);
    }
    @Test //减法
    void main1() {
        int a=2,b=3,c=7,d=9;
        int fuhao=1;
        String expArr[]=new String[2];
        BiaodashiTest biaodashi = new BiaodashiTest();
        expArr[0]= biaodashi.biaodashi(a,b)+'-'+ biaodashi.biaodashi(c,d)+'=';
        System.out.println(expArr[0]);
    }
    @Test //乘法
    void main2() {
        int a=2,b=4,c=7,d=9;
        int fuhao=2;
        String expArr[]=new String[2];
        BiaodashiTest biaodashi = new BiaodashiTest();
        expArr[0]= biaodashi.biaodashi(a,b)+'×'+ biaodashi.biaodashi(c,d)+'=';
        System.out.println(expArr[0]);
    }
    @Test //除法
    void main3() {
        int a=2,b=4,c=7,d=9;
        int fuhao=3;
        String expArr[]=new String[2];
        BiaodashiTest biaodashi = new BiaodashiTest();
        expArr[0]= biaodashi.biaodashi(a,b)+'÷'+ biaodashi.biaodashi(c,d)+'=';
        System.out.println(expArr[0]);
    }
    @Test //加减
    void main4() {
        int a=2,b=4,c=8,d=2,g=3,h=2;
        int fuhao=4;
        String expArr[]=new String[2];
        BiaodashiTest biaodashi = new BiaodashiTest();
        expArr[0]= biaodashi.biaodashi(a,b)+'+'+ biaodashi.biaodashi(c,d)+'-'+ biaodashi.biaodashi(g,h)+'=';
        System.out.println(expArr[0]);

    }
    @Test //加加
    void main5() {
        int a=2,b=4,c=8,d=2,g=3,h=2;
        int fuhao=5;
        String expArr[]=new String[2];
        BiaodashiTest biaodashi = new BiaodashiTest();
        expArr[0]= biaodashi.biaodashi(a,b)+'+'+ biaodashi.biaodashi(c,d)+'+'+ biaodashi.biaodashi(g,h)+'=';
        System.out.println(expArr[0]);

    }
    @Test  //加乘
    void main6() {
        int a=2,b=4,c=8,d=2,g=1,h=3;
        int fuhao=6;
        String expArr[]=new String[2];
        BiaodashiTest biaodashi = new BiaodashiTest();
        expArr[0]= biaodashi.biaodashi(a,b)+'+'+ biaodashi.biaodashi(c,d)+'×'+ biaodashi.biaodashi(g,h)+'=';
        System.out.println(expArr[0]);

    }
    @Test //加除
    void main7() {
        int a=2,b=3,c=8,d=2,g=1,h=3;
        int fuhao=7;
        String expArr[]=new String[2];
        BiaodashiTest biaodashi = new BiaodashiTest();
        expArr[0]= biaodashi.biaodashi(a,b)+'+'+ biaodashi.biaodashi(c,d)+'÷'+ biaodashi.biaodashi(g,h)+'=';
        System.out.println(expArr[0]);

    }
    @Test //减除
    void main8() {
        int a=2,b=3,c=8,d=2,g=1,h=3;
        int fuhao=8;
        String expArr[]=new String[2];
        BiaodashiTest biaodashi = new BiaodashiTest();
        expArr[0]= '('+biaodashi.biaodashi(a,b)+'-'+ biaodashi.biaodashi(c,d)+')'+'÷'+ biaodashi.biaodashi(g,h)+'=';
        System.out.println(expArr[0]);

    }
    @Test //减乘
    void main9() {
        int a=2,b=3,c=8,d=2,g=1,h=3;
        int fuhao=9;
        String expArr[]=new String[2];
        BiaodashiTest biaodashi = new BiaodashiTest();
        expArr[0]= biaodashi.biaodashi(a,b)+'-'+ biaodashi.biaodashi(c,d)+'×'+ biaodashi.biaodashi(g,h)+'=';
        System.out.println(expArr[0]);

    }
    @Test //乘除
    void main10() {
        int a=2,b=1,c=8,d=1,g=2,h=1;
        int fuhao=10;
        String expArr[]=new String[2];
        BiaodashiTest biaodashi = new BiaodashiTest();
        expArr[0]= biaodashi.biaodashi(a,b)+'×'+ biaodashi.biaodashi(c,d)+'÷'+ biaodashi.biaodashi(g,h)+'=';
        System.out.println(expArr[0]);

    }
}