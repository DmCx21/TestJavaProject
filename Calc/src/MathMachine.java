import java.io.IOException;

class MathMachine {
    private static int plus(int num1, int num2){
        return num1+num2;
    }

    private static int minus(int num1, int num2){
        return num1-num2;
    }

    private static int multiply(int num1, int num2){
        return num1*num2;
    }

    private static int divide(int num1, int num2){
        return num1/num2;
    }

    public static String count(Data data) throws IOException {
        int result;
        switch (data.getOperationType()){
            case PLUS -> result=plus(data.getNum1(), data.getNum2());
            case MINUS -> result=minus(data.getNum1(), data.getNum2());
            case MULTIPLY -> result=multiply(data.getNum1(), data.getNum2());
            case DIVIDE -> result=divide(data.getNum1(), data.getNum2());
            default -> throw new IllegalStateException("Unexpected value: " + data.getOperationType());
        }
        switch (data.getNumType()){
            case ARABIC -> {
                return (result+"");
            }
            case ROME -> {
                return RomeCoder.encode(result);
            }
            default -> throw new IllegalStateException("Unexpected value: " + data.getNumType());
        }
    }

}
