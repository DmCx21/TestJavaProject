import java.io.IOException;
import java.util.Objects;

class Data {

    private int num1;
    private int num2;
    private NumType numType;
    private OperationType operationType;

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public NumType getNumType() {
        return numType;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public Data(NumType inumType, OperationType ioperationType, int inum1, int inum2) throws IOException {
        if (inum1>10 || inum2>10){
            throw new IOException();
        }
        this.num1=inum1;
        this.num2=inum2;
        this.numType=inumType;
        this.operationType=ioperationType;
    }

    private static boolean isInArray(char[] array, char input){
        for (char ch: array){
            if (ch==input){
                return true;
            }
        }
        return false;
    }

    public static Data stringToData(String str) throws IOException {

        str=str.trim();
        int num1=-1;
        String snum[];
        int num2=-1;
        NumType numType=null;
        OperationType operationType=null;


        char[] rome = new char[]{'I','V','X'};
        char[] arabic = new char[]{'1','2','3','4','5','6','7','8','9'};
        char firstChar=str.toCharArray()[0];

        if (isInArray(rome,firstChar)){
            numType=NumType.ROME;
        }
        else if (isInArray(arabic,firstChar)){
            numType=NumType.ARABIC;
        }
        else {
            throw new IOException();
        }

        for (OperationType op:OperationType.values()){
            if(str.indexOf(op.getValue()) >-1){
                operationType=op;
            }
        }
        if (Objects.isNull(operationType)){
            throw new IOException();
        }
        String regex = new StringBuilder().append("\\").append(operationType.getValue()).toString();
        snum=str.split(regex);
        if (snum.length>2){
            throw new IOException();
        }
        snum[0]=snum[0].trim();
        snum[1]=snum[1].trim();

        switch (numType){
            case ROME:
                num1=RomeCoder.decode(snum[0]);
                num2=RomeCoder.decode(snum[1]);
                break;
            case ARABIC:
                try {
                    num1 = Integer.parseInt(snum[0]);
                    num2 = Integer.parseInt(snum[1]);
                } catch (NumberFormatException e) {
                    throw new IOException();
                }

                break;
        }
        return new Data(numType,operationType,num1,num2);
    }


    @Override
    public String toString() {
        return "Data{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                ", numType=" + numType +
                ", operationType=" + operationType +
                '}';
    }
}
