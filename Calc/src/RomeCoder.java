import java.io.IOException;

class RomeCoder {

    private enum RomeNumbers{
        I(1),II(2),III(3),IV(4),V(5),
        VI(6),VII(7),VIII(8),IX(9),X(10);

        private int value;

        RomeNumbers(int i) {
            this.value=i;
        }

        public int getValue() {
            return value;
        }
    }
    private enum RomeNumbs {
        C(100),XC(90),L(50),
        XL(40),X(10),IX(9),
        V(5),IV(4),I(1);

        private int value;

        RomeNumbs(int i) {
            this.value=i;
        }

        public int getValue() {
            return value;
        }
    }

    public static String encode(int num) throws IOException {
        if (num<=0 || num>100){
            throw new IOException();
        }
        String str = "";
        int tempNum;
        for(RomeNumbs rnum : RomeNumbs.values()) {
            tempNum = rnum.getValue();
            while (num >= tempNum) {
                str=str.concat(rnum.name());
                num-=tempNum;
            }
        }
        return str;
    }

    public static int decode(String str) throws IOException {
        try {
            return RomeNumbers.valueOf(str).getValue();
        } catch (IllegalArgumentException e){
           throw new IOException();
        }
    }
}
