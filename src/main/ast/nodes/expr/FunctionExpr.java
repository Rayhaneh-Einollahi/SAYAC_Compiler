package main.ast.nodes.expr;

import main.visitor.IVisitor;

import java.util.Collections;
import java.util.List;

public class FunctionExpr extends Expr {
    private Expr outside;
    private List<Expr> arguments;

    public FunctionExpr(Expr outside, List<Expr> arguments) {
        this.outside = outside;
        if (arguments.getFirst() instanceof CommaExpr) {
            this.arguments = arguments;
        } else {
            this.arguments = ((CommaExpr) arguments.getFirst()).getExpressions();
        }
    }

    public void removeArgs(List<Integer> inds) {
        if (inds.isEmpty())
            return;
        inds.sort(Collections.reverseOrder()); // sort descending
        for (int index : inds) {
            if (index >= 0 && index < arguments.size()) {
                arguments.remove(index);
            }
        }
    }

    public String getName() {
        return this.outside.getName();
    }

    public Expr getOutside() {
        return outside;
    }

    public List<Expr> getArguments() {
        return arguments;
    }

    public Integer getArgumentCount() {
        int cnt = 0;
        if (arguments == null) {
            return 0;
        }
        for (Expr expr : arguments) {
            if (expr instanceof CommaExpr) {
                cnt += ((CommaExpr) expr).getExpressions().size();
            } else {
                cnt++;
            }
        }
        return cnt;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public boolean isDead() {
        return false;
    }

}
