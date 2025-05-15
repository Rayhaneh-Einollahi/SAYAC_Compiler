package main.ast.nodes.expr.operator;

public enum UnaryOperator {
    POST_INC("++", true),
    POST_DEC("--", true),
    PRE_INC("++", false),
    PRE_DEC("--", false),
    SIZEOF("sizeof"),
    AND("&"),
    STAR("*"),
    PLUS("+"),
    MINUS("-"),
    TILDE("~"),
    NOT("!");

    private final String symbol;
    private final boolean isPostfix;

    UnaryOperator(String symbol) {
        this(symbol, false);
    }

    UnaryOperator(String symbol, boolean isPostfix) {
        this.symbol = symbol;
        this.isPostfix = isPostfix;
    }

    public static UnaryOperator fromString(String op, boolean isPostfix) {
        for (UnaryOperator unOp : values()) {
            if (unOp.symbol.equals(op)) {
                // Handle ++/-- (need to check postfix/prefix)
                if (op.equals("++") || op.equals("--")) {
                    if (unOp.isPostfix == isPostfix) {
                        return unOp;
                    }
                } else {
                    return unOp;
                }
            }
        }
        throw new IllegalArgumentException("Unknown unary operator: " + op);
    }

    public String getSymbol() {
        return symbol;
    }

    public static UnaryOperator fromString(String op) {
        return fromString(op, false);
    }
}