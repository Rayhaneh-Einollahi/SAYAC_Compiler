package main.ast.nodes.expr;

import main.ast.nodes.declaration.InitializerList;
import main.ast.nodes.declaration.Typename;
import main.visitor.IVisitor;

public class IniListExpr extends Expr{


    private Typename typename;
    private InitializerList initializerList;

    public IniListExpr(Typename typename, InitializerList initializerList){
        this.typename = typename;
        this.initializerList = initializerList;
    }

    public Typename getTypename() {
        return typename;
    }

    public InitializerList getInitializerList() {
        return initializerList;
    }
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
