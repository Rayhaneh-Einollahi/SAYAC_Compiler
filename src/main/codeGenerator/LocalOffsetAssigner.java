package main.codeGenerator;

import main.ast.nodes.Program;
import main.ast.nodes.Statement.BlockItem;
import main.ast.nodes.Statement.CompoundStatement;
import main.ast.nodes.declaration.Declaration;
import main.ast.nodes.declaration.ExternalDeclaration;
import main.ast.nodes.declaration.FunctionDefinition;
import main.ast.nodes.declaration.InitDeclarator;
import main.visitor.Visitor;


public class LocalOffsetAssigner extends Visitor<Void>{
    public final MemoryManager memoryManager;

    public LocalOffsetAssigner(MemoryManager memoryManager) {
        this.memoryManager = memoryManager;
    }

    public Void visit(Program program) {
        for (ExternalDeclaration ed : program.getExternalDeclarations()){
            if(ed instanceof FunctionDefinition)
                ed.accept(this);
        }
        return null;
    }

    public Void visit(FunctionDefinition functionDefinition) {
        memoryManager.beginFunctionSetOffset(functionDefinition.getName());
        functionDefinition.getBody().accept(this);
        return null;
    }

    public Void visit(Declaration declaration) {
        for (InitDeclarator initDeclarator : declaration.getInitDeclarators()) {
            if (initDeclarator.getDeclarator().isArray()) {
                // just handle int a[SIZE];
                int array_size = initDeclarator.getDeclarator().getDirectDeclarator().getArraySize();
                memoryManager.allocateLocal(initDeclarator.getDeclarator().getSpecialName(), 2 * array_size);
                memoryManager.putArrayStep(initDeclarator.getDeclarator().getSpecialName(), initDeclarator.getDeclarator().getDirectDeclarator().getStepsSizes());
            }
            else {
                memoryManager.allocateLocal(initDeclarator.getDeclarator().getSpecialName(), 2);
            }
        }
        return null;
    }


    public Void visit(CompoundStatement compoundStatement) {
        int beginOffset = memoryManager.getCurrentOffset();
        for (BlockItem bi : compoundStatement.getBlockItems()) {
            if(bi.getDeclaration() != null)
                bi.accept(this);
        }
        int scopesBase = memoryManager.getCurrentOffset();
        for (BlockItem bi : compoundStatement.getBlockItems()) {
            if(bi.getStatement() != null){
                memoryManager.setCurrentOffset(scopesBase);
                bi.accept(this);
            }
        }
        memoryManager.setCurrentOffset(beginOffset);
        return null;
    }
}