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
public class sizeyunsuan {
    private static Random random = new Random();
    public static int range;
    //主函数
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("请输入产生几以内的数字：");
        range=sc.nextInt();
        System.out.println("请输入产生多少个运算表达式：");
        int num=sc.nextInt();
        int rightcount[]=new int[num+2];
        int wrongcount[]=new int[num+2];
        int right1=0;
        int wrong1=0;
        String[] results=new String[num];
        Biaodashi biaodashi =new Biaodashi();////判断假分数，并化假分数为带分数
        ReductionofFraction reductionofFraction=new ReductionofFraction();//计算结果约分
        int i;
        for( i=0;i<num;i++){

            String expArr[]=new String[2];//定义生成的题目
            int a= (int) (random.nextInt(range))+1;//分子1
            int b= (int) (random.nextInt(range))+1;//分母2
            int c= (int) (random.nextInt(range))+1;//分子2
            int d= (int) (random.nextInt(range))+1;//分母2

            int g= (int) (random.nextInt(range))+1;//分子3
            int h= (int) (random.nextInt(range))+1;//分母3

            int fuhao;//运算符
            fuhao= (int) (random.nextInt(10));
            if(b!=1&&d!=1&&h!=1) {//分母均不为0时生成带有分数的计算题，同时计算结果
                //加法
                if(fuhao==0) {
                    int fenzi=a*d+b*c;
                    int fenmu=b*d;
                    expArr[0]= biaodashi.biaodashi(a,b)+'+'+ biaodashi.biaodashi(c,d)+'=';
                    System.out.println(expArr[0]);
                    results[i]=reductionofFraction.reductionofFraction(fenzi, fenmu);

                }
                //减法
                if(fuhao==1&&a*d-b*c>=0) {
                    int fenzi=a*d-b*c;
                    int fenmu=b*d;
                    expArr[0]= biaodashi.biaodashi(a,b)+'-'+ biaodashi.biaodashi(c,d)+'=';
                    System.out.println(expArr[0]);
                    results[i]=reductionofFraction.reductionofFraction(fenzi, fenmu);
                }
                if(fuhao==1&&a*d-b*c<0) {
                    if(i==0){i=-1;}
                    else{i=i-1;}
                }
                //乘法
                if(fuhao==2) {
                    int fenzi=a*c;
                    int fenmu=b*d;
                    expArr[0]= biaodashi.biaodashi(a,b)+'×'+ biaodashi.biaodashi(c,d)+'=';
                    System.out.println(expArr[0]);
                    results[i]=reductionofFraction.reductionofFraction(fenzi, fenmu);
                }
                //除法
                if(fuhao==3) {
                    int fenzi=a*d;
                    int fenmu=b*c;
                    expArr[0]= biaodashi.biaodashi(a,b)+'÷'+ biaodashi.biaodashi(c,d)+'=';
                    System.out.println(expArr[0]);
                    results[i]=reductionofFraction.reductionofFraction(fenzi, fenmu);
                }
                //加减
                if(fuhao==4&&a*d*h+c*b*h-g*b*d>0){
                    int fenzi=a*d*h+c*b*h-g*b*d;
                    int fenmu=b*d*h;
                    expArr[0]= biaodashi.biaodashi(a,b)+'+'+ biaodashi.biaodashi(c,d)+'-'+ biaodashi.biaodashi(g,h)+'=';
                    System.out.println(expArr[0]);
                    results[i]=reductionofFraction.reductionofFraction(fenzi, fenmu);
                }
                if(fuhao==4&&a*d*h+c*b*h-g*b*d<0){
                    if(i==0){i=-1;}
                    else{i=i-1;}

                }
                //加加
                if (fuhao==5&&a*d*h+c*b*h+g*b*d>0){
                    int fenzi=a*d*h+c*b*h+g*b*d;
                    int fenmu=b*d*h;
                    expArr[0]= biaodashi.biaodashi(a,b)+'+'+ biaodashi.biaodashi(c,d)+'+'+ biaodashi.biaodashi(g,h)+'=';
                    System.out.println(expArr[0]);
                    results[i]=reductionofFraction.reductionofFraction(fenzi, fenmu);
                }

                //加乘
                if (fuhao==6&&a*d*h+c*g*b>0){
                    int fenzi=a*d*h+c*g*b;
                    int fenmu=b*d*h;
                    expArr[0]= biaodashi.biaodashi(a,b)+'+'+ biaodashi.biaodashi(c,d)+'×'+ biaodashi.biaodashi(g,h)+'=';
                    System.out.println(expArr[0]);
                    results[i]=reductionofFraction.reductionofFraction(fenzi, fenmu);
                }

                //加除
                if (fuhao==7){
                    int fenzi=a*d*g+b*c*h;
                    int fenmu=b*d*g;
                    expArr[0]= biaodashi.biaodashi(a,b)+'+'+ biaodashi.biaodashi(c,d)+'÷'+ biaodashi.biaodashi(g,h)+'=';
                    System.out.println(expArr[0]);
                    results[i]=reductionofFraction.reductionofFraction(fenzi, fenmu);
                }
                //减除
                if(fuhao==8&&a*d-b*c>0){
                    int fenzi=a*d*h-b*c*h;
                    int fenmu=b*d*g;
                    expArr[0]= '('+biaodashi.biaodashi(a,b)+'-'+ biaodashi.biaodashi(c,d)+')'+'÷'+ biaodashi.biaodashi(g,h)+'=';
                    System.out.println(expArr[0]);
                    results[i]=reductionofFraction.reductionofFraction(fenzi, fenmu);
                }
                if(fuhao==8&&a*d-b*c<0){
                    if(i==0){i=-1;}
                    else{i=i-1;}
                }
                //减乘
                if(fuhao==9&&a*d*h-b*c*g>0){
                    int fenzi=a*d*h-b*c*g;
                    int fenmu=b*d*h;
                    expArr[0]= biaodashi.biaodashi(a,b)+'-'+ biaodashi.biaodashi(c,d)+'×'+ biaodashi.biaodashi(g,h)+'=';
                    System.out.println(expArr[0]);
                    results[i]=reductionofFraction.reductionofFraction(fenzi, fenmu);
                }
                if(fuhao==9&&a*d*h-b*c*g<0) {
                    if (i==0) { i=-1; }
                    else { i=i-1; }
                }
                //乘除
                if(fuhao==10){
                    int fenzi=a*c*h;
                    int fenmu=b*d*g;
                    expArr[0]= biaodashi.biaodashi(a,b)+'×'+ biaodashi.biaodashi(c,d)+'÷'+ biaodashi.biaodashi(g,h)+'=';
                    System.out.println(expArr[0]);
                    results[i]=reductionofFraction.reductionofFraction(fenzi, fenmu);
                }
            }
            else if(b==1&&d==1) {//分母至少一个为0时生成只含有整式的运算式，同时计算结果
                if (fuhao == 0) {
                    int fenzi = a * d + b * c;
                    int fenmu = b * d;
                    expArr[0] = a + "+" + c + "=";
                    System.out.println(expArr[0]);
                    results[i] = reductionofFraction.reductionofFraction(fenzi, fenmu);

                }
                if (fuhao == 1 && a-c >= 0) {
                    int fenzi = a-c;
                    int fenmu = b * d;
                    expArr[0] = a + "-" + c + "=";
                    System.out.println(expArr[0]);
                    results[i] = reductionofFraction.reductionofFraction(fenzi, fenmu);

                }
                if (fuhao == 1 && a-c < 0) {
                    if (i==0) { i=-1; }
                    else { i=i-1; }

                }
                if (fuhao == 2) {
                    int fenzi = a * c;
                    int fenmu = b * d;
                    expArr[0] = c + "×" + a + "=";
                    System.out.println(expArr[0]);
                    results[i] = reductionofFraction.reductionofFraction(fenzi, fenmu);

                }
                if (fuhao == 3) {
                    int fenzi = a * d;
                    int fenmu = b * c;
                    expArr[0] = a + "÷" + c + "=";
                    System.out.println(expArr[0]);
                    results[i] = reductionofFraction.reductionofFraction(fenzi, fenmu);

                }
                if (fuhao == 3 && c == 0) {
                    if (i == 0) {
                        i = -1;
                    } else {
                        i = i - 1;
                    }
                }
            }
                else{
                    if (i==0) { i=-1; }
                    else { i=i-1; }



            }
            //题目写入
            FileWriter fw = null;
            try {

                File f=new File("Exersies.txt");
                fw = new FileWriter(f, true);
            } catch (IOException e) {
                e.printStackTrace();
            }if(expArr[0]!=null) {
                PrintWriter pw = new PrintWriter(fw);
                pw.println(i+1+"."+expArr[0]);
                pw.flush();
                try {
                    fw.flush();
                    pw.close();
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }}
            //答案写入
            FileWriter fn = null;
            try {

                File f=new File("Answer.txt");
                fn = new FileWriter(f, true);
            } catch (IOException e) {
                e.printStackTrace();
            }if(expArr[0]!=null) {
                PrintWriter pn = new PrintWriter(fn);
                pn.println(i+1+"."+results[i]);
                pn.flush();
                try {
                    fn.flush();
                    pn.close();
                    fn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }}
        }
        System.out.println("输入ok后提交：");
        Scanner sc1=new Scanner(System.in);
        String submit=sc1.nextLine();
        if(submit.equals("ok")){
            String array[]=new String[num];
            try
            {   int k=0;

                FileReader fr = new FileReader("D:/IDEA/projects/java_02/answers.txt");
                BufferedReader br = new BufferedReader(fr);
                String s ;
                while((s = br.readLine())!=null) {//读取答案
                    array[k]=s;	k++;
                }br.close();
                fr.close();
            }catch(IOException e){
                System.out.println("指定文件不存在");
            }
            for(int j=0;j<num;j++) {
                if (array[j].equals(results[j])) {//验证答案，统计正确和错误的个数

                    rightcount[j] = j + 1;
                    right1++;
                } else {

                    wrongcount[j] = j + 1;
                    wrong1++;
                }
            }
            FileWriter fg = null;
            try {
                //反馈正确与错误题目的信息
                File f=new File("Grade.txt");
                fg = new FileWriter(f, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            PrintWriter pg = new PrintWriter(fg);
            pg.println(" ");
            pg.print("Correct:"+right1+"(");
            for (int j = 0; j <= num; j++) {
                if (rightcount[j] != 0) {
                    pg.print(rightcount[j] + ",");
                }
            }
            pg.println(")");
            pg.print("Wrong:"+wrong1+"(");
            for (int j = 0; j <= num; j++) {
                if (wrongcount[j] != 0) {
                    pg.print(wrongcount[j] + ",");
                }
            }
            pg.print(")");
            pg.flush();
            try {
                fg.flush();
                pg.close();
                fg.close();
            } catch (IOException e) {
                e.printStackTrace();
            }}
    }
}