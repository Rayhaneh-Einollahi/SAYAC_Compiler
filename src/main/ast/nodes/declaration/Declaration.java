package main.ast.nodes.declaration;

import main.visitor.IVisitor;

import java.util.List;

public class Declaration extends ExternalDeclaration {
    private final List<Type> types;
    private List<InitDeclarator> initDeclarators;
    public Declaration(
            List<Type> types,
            List<InitDeclarator> initDeclarators){
        this.types = types;
        this.initDeclarators = initDeclarators;
    }
    public Declaration(
            List<Type> types){
        this.types = types;
    }

    public void addInitDeclarators(List<InitDeclarator> initDeclarators){
        this.initDeclarators = initDeclarators;
    }


    public String getName(){
        if (initDeclarators==null || initDeclarators.isEmpty()){
            return this.types.getLast().getName();
        }
        return initDeclarators.getLast().getDeclarator().getName();
    }


    public String getSpecialName(){
        if (initDeclarators==null || initDeclarators.isEmpty()){
            return this.types.getLast().getSpecialName();
        }
        return initDeclarators.getLast().getDeclarator().getSpecialName();
    }
    public List<Type> getTypes() {
        return types;
    }

    public List<InitDeclarator> getInitDeclarators() {
        return initDeclarators;
    }

    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Declaration other = (Declaration) obj;
        return this.types.equals(other.types)
                && this.initDeclarators.equals(other.initDeclarators);
    }
}
