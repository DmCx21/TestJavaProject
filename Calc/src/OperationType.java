enum OperationType {
    PLUS('+'),MINUS('-'),MULTIPLY('*'),DIVIDE('/');

    private char value;
    OperationType(char c) {
        this.value=c;
    }

    public char getValue() {
        return value;
    }
}
