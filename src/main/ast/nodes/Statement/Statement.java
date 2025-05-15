package main.ast.nodes.Statement;

import main.ast.nodes.Node;

public abstract class Statement extends Node {
    public Integer getStatementCount(){
        return 1;
    }
}
