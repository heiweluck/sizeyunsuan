public class ReductionofFraction {
    //计算结果约分
    public  String reductionofFraction(int a, int b) {// 分数约分，用于计算结果
        Biaodashi biaodashi =new Biaodashi();
        int y = 1;
        for (int i = a; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                y = i;
                break;
            }
        }
        int z = a / y;// 分子
        int m = b / y;// 分母
        if (z == 0) {
            return "0";
        }
        if(m==1) return z+"";
        else  return Biaodashi.biaodashi(z,m);

    }
}
