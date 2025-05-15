package main.ast.nodes.expr.operator;

import java.util.Map;
import java.util.HashMap;

public enum BinaryOperator {
     PLUS("+"),
     MINUS("-"),
     MULT("*"),
     DIVIDE("/"),
     MOD("%"),

     LEFTSHIFT("<<"),
     RIGHTSHIFT(">>"),
     AND("&"),
     XOR("^"),
     OR("|"),

     LESS("<"),
     GREATER(">"),
     LESSEQUAL("<="),
     GREATEREQUAL(">="),

     EQUAL("=="),
     NOTEQUAL("!="),

     ANDAND("&&"),
     OROR("||"),

     ASSIGN("="),
     STARASSIGN("*="),
     DIVASSIGN("/="),
     MODASSIGN("%="),

     PLUSASSIGN("+="),
     MINUSASSIGN("-="),
     LEFTSHIFTASSIGN("<<="),

     RIGHTSHIFTASSIGN(">>="),
     ANDASSIGN("&="),
     XORASSIGN("^="),
     ORASSIGN("|=");

     private final String symbol;
     private static final Map<String, BinaryOperator> lookup = new HashMap<>();

     static {
          for (BinaryOperator op : values()) {
               lookup.put(op.symbol, op);
          }
     }

     BinaryOperator(String symbol) {
          this.symbol = symbol;
     }

     public static BinaryOperator fromString(String symbol) {
          BinaryOperator op = lookup.get(symbol);
          if (op == null) {
               throw new IllegalArgumentException("Unknown binary operator: " + symbol);
          }
          return op;
     }

     public String getSymbol() {
          return symbol;
     }
}