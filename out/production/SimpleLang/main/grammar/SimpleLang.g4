grammar SimpleLang;

@header{
    import main.ast.nodes.*;
    import main.ast.nodes.declaration.*;
    import main.ast.nodes.Stmt.*;
    import main.ast.nodes.expr.*;
    import main.ast.nodes.expr.primitives.*;
    import main.ast.nodes.expr.operator.*;
}

// Parser rules
program returns [Program programRet]:
    {$programRet = new Program();}
    (f = func_dec{ $programRet.addFuncDec($f.funcDecRet); } )*
     m = main { $programRet.setMain($m.mainRet); }
     ;

func_dec returns [FuncDec funcDecRet]:
    'FuncDec' i = ID { $funcDecRet = new FuncDec($i.text); } LPAR RPAR LBRACE
     (s = stmt { $funcDecRet.addStmt($s.stmtRet); })* RBRACE
     { $funcDecRet.setLine($i.line); };


main  returns [Main mainRet]:
    {$mainRet = new Main();}
    m = MAIN LPAR RPAR LBRACE { $mainRet.setLine($m.line); }
    (s = stmt { $mainRet.addStmt($s.stmtRet); })*
     RBRACE;


stmt returns [Stmt stmtRet]:
    a = assign { $stmtRet = $a.assignRet; }
    | i = if_stmt { $stmtRet = $i.ifStmtRet; }
    | v = var_dec { $stmtRet = $v.varDecRet; }
    | f = func_call { $stmtRet = new FuncCallStmt($f.func_call_ret); $stmtRet.setLine($f.func_call_ret.getLine());} SEMI
    | r = return_stmt { $stmtRet = $r.returnRet; }
    ;

return_stmt returns [Return returnRet]:
    r = RETURN e = expr SEMI
    {
        $returnRet = new Return($e.exprRet);
        $returnRet.setLine($r.line);
    };


var_dec returns [VarDec varDecRet]:
    t=TYPE id=ID SEMI
     {
        $varDecRet = new VarDec($id.text);
        $varDecRet.setLine($id.line);
        $varDecRet.setTypeName($t.text);
     };


assign returns [Assign assignRet]:
    id = ID ASSIGN e = expr SEMI
    {
        $assignRet = new Assign($id.text, $e.exprRet);
        $assignRet.setLine($id.line);
    };


if_stmt returns [IfStmt ifStmtRet]:
    i = IF LPAR e = expr { $ifStmtRet = new IfStmt($e.exprRet); } RPAR
    s1 = stmt { $ifStmtRet.setIfBody($s1.stmtRet); }
    (ELSE s2 = stmt { $ifStmtRet.setElseBody($s2.stmtRet); } )?
    { $ifStmtRet.setLine($i.line); };


expr returns [Expr exprRet]:
    e1=expr op1=('++' | '--')
        {
            UnaryOperator  op = ($op1.text.equals("--")) ? UnaryOperator.POST_DEC :  UnaryOperator.POST_INC;
            $exprRet = new UnaryExpr($e1.exprRet, op);
            $exprRet.setLine($op1.line);
        }
    |  e2=expr op2 = ('*' | '/') e3=expr
        {
            BinaryOperator op = ($op2.text.equals("*")) ? BinaryOperator.MULT :  BinaryOperator.DIVIDE;
            $exprRet = new BinaryExpr($e2.exprRet, op, $e3.exprRet);
            $exprRet.setLine($op1.line);
        }
    |  e4=expr op3 = ('+' | '-') e5=expr
        {
            BinaryOperator op = ($op3.text.equals("+")) ? BinaryOperator.PLUS :  BinaryOperator.MINUS;
            $exprRet = new BinaryExpr($e4.exprRet, op, $e5.exprRet);
            $exprRet.setLine($op1.line);
        }
    |  f=func_call {$exprRet = $f.func_call_ret;}
    | p=primary_expr {$exprRet = $p.primary_expr_ret;};

func_call returns [FuncCallExpr func_call_ret]:
    id=ID LPAR RPAR
    {
        $func_call_ret = new FuncCallExpr($id.text);
        $func_call_ret.setLine($id.line);
    };

primary_expr returns [Expr primary_expr_ret]:
    id=ID {$primary_expr_ret = new Identifier($id.text); $primary_expr_ret.setLine($id.line);}
    | i=INT_VAL     { $primary_expr_ret = new IntVal($i.int); $primary_expr_ret.setLine($i.line);}
    | b=BOOL_VAL      { $primary_expr_ret = new BoolVal($b.text); $primary_expr_ret.setLine($b.line);}
    | s=STR_VAL       { $primary_expr_ret = new StringVal($s.text); $primary_expr_ret.setLine($s.line);}
    | d=DOUBLE_VAL   { $primary_expr_ret = new DoubleVal($d.text); $primary_expr_ret.setLine($d.line);}
    ;



// Lexer rules

// 1- General structure
MAIN : 'main';
TYPE : 'int' | 'string' | 'double' | 'bool';
IF : 'if';
ELSE : 'else';
RETURN : 'return';

//2- premitive values
INT_VAL : [0] | [1-9][0-9]*;
STR_VAL : '"' ( ~["\\] | '\\' . )* '"' ;
BOOL_VAL: 'true' | 'false';
DOUBLE_VAL: ([0] | [1-9][0-9]*)'.'[0-9]+;

// 3- Symbols
LBRACE : '{';
RBRACE : '}';
SEMI : ';';
ASSIGN : '=';
PLUS : '+';
LPAR : '(';
RPAR : ')';

// 4- Identifiers
ID : [a-zA-Z_][a-zA-Z0-9_]*;


// 5- Whitespace and comments
WHITE_SPACE : [ \t\r\n]+ -> skip;
LINE_COMMENT : '//' ~[\r\n]* -> skip;
BLOCK_COMMENT : '/*' .*? '*/' -> skip;