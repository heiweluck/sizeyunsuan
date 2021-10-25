public  class Biaodashi {
    //判断假分数，并化假分数为带分数
    public static String biaodashi(int a, int b) {
        if (a >= b) {
            int c;
            c = a / b;
            int d;
            d = a % b;
            {
                if (d == 0) {
                    return c + "";
                }
                return c + "'" + d + "/" + b;
            }
        }
        return a + "/" + b;
    }
}