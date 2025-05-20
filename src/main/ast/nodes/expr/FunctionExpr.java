package main.ast.nodes.expr;

import main.visitor.IVisitor;

import java.util.Collections;
import java.util.List;

public class FunctionExpr extends Expr{
    private Expr outside;
    private List<Expr> arguments;

    public FunctionExpr(Expr outside, List<Expr> arguments){
        this.outside = outside;
        this.arguments = arguments;
    }

    public void removeArgs(List<Integer> inds){
        if (inds.isEmpty())
            return;
//        inds.sort(Collections.reverseOrder());
        if (!arguments.isEmpty() && !(arguments.getFirst() instanceof CommaExpr)){
            arguments.removeFirst();
            return;
        }
        List<Expr> list = ((CommaExpr)arguments.getFirst()).getExpressions();
        inds.sort(Collections.reverseOrder()); // sort descending
        for (int index : inds) {
            if (index >= 0 && index < list.size()) {
                list.remove(index);
            }
        }
    }
    public String getName(){
        return this.outside.getName();
    }
    public Expr getOutside() {
        return outside;
    }

    public List<Expr> getArguments() {
        return arguments;
    }

    public Integer getArgumentCount() {
        int cnt= 0;
        if (arguments == null){
            return 0;
        }
        for (Expr expr : arguments){
            if (expr instanceof CommaExpr){
                cnt += ((CommaExpr) expr).getExpressions().size();
            }
            else{
                cnt++;
            }
        }
        return cnt;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
    public boolean isDead(){
        return false;
    }

}
