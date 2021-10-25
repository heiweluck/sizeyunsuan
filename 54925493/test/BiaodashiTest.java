import org.junit.jupiter.api.Test;

class BiaodashiTest {

    @Test
    public String biaodashi(int a, int b) {
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
