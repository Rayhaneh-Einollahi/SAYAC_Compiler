package main.ast.nodes.declaration;
public enum Type{
    VOID,
    CHAR,
    SHORT,
    INT,
    LONG,
    FLOAT,
    DOUBLE,
    SIGNED,
    UNSIGNED,
    BOOL,
    CONST,
    TYPEDEF,
    IDENTIFIER;

    private String identifierName;

    public void setIdentifierName(String name) {
        if (this != IDENTIFIER) {
            throw new UnsupportedOperationException("Only IDENTIFIER type can have a name");
        }
        this.identifierName = name;
    }


    public String getName() {
        if (this != IDENTIFIER) return null;
        return identifierName;
    }

    public String getSpecialName() {
        if (this != IDENTIFIER) return null;
        return identifierName;
    }
}

