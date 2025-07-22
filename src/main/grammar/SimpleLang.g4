grammar SimpleLang;
@header{
    import java.util.List;
     import java.util.ArrayList;
    import main.ast.nodes.*;
    import main.ast.nodes.declaration.*;
    import main.ast.nodes.Statement.*;
    import main.ast.nodes.Statement.IterationStatement.*;
    import main.ast.nodes.Statement.JumpStatement.*;
    import main.ast.nodes.expr.*;
    import main.ast.nodes.expr.primitives.*;
    import main.ast.nodes.expr.operator.*;
}

compilationUnit returns [Program programRet]:
    {$programRet = new Program();}
    {$programRet.setLine($ctx.start.getLine());}
    (tu=translationUnit{$programRet.addExternalDeclarations($tu.list);})? EOF
    ;

translationUnit returns [List<ExternalDeclaration> list]:
    {$list = new ArrayList<>();}
    (ed=externalDeclaration{if ($ed.externalDecRet != null) $list.add($ed.externalDecRet);})+
    ;

externalDeclaration returns [ExternalDeclaration externalDecRet]:
    fd = functionDefinition {$externalDecRet = $fd.funcDefRet;}
    | dec = declaration {$externalDecRet = $dec.decRet;}
    | Semi { $externalDecRet = null;}
    ;

functionDefinition returns [FunctionDefinition funcDefRet]:
    specs=declarationSpecifiers? dec=declarator declist=declarationList? cstmt=compoundStatement
    {
        $funcDefRet = new FunctionDefinition($specs.ctx != null ? $specs.list: null, $dec.declaratorRet, $declist.ctx != null? $declist.list: null, $cstmt.cstmtRet);
        $funcDefRet.setLine($ctx.start.getLine());
    };

declarationList returns [List<Declaration> list]:
    {$list = new ArrayList<>();}
    (dec=declaration{$list.add($dec.decRet);})+ ;

expression returns [Expr expRet]
  : id=Identifier   {$expRet = new Identifier($id.text, $id.getLine());}
  | c=Constant        {$expRet = new ConstantExpr(new StringVal($c.text));  $expRet.setLine($c.getLine());}
  | {List<StringVal> list = new ArrayList<>();}(str=StringLiteral{list.add(new StringVal($str.text));})+  {$expRet = new StringExpr(list); $expRet.setLine($ctx.start.getLine());}
  | LeftParen e=expression RightParen {$expRet = $e.expRet; $expRet.setLine($ctx.start.getLine());}
  | LeftParen t=typeName RightParen LeftBrace i=initializerList Comma? RightBrace {$expRet = new IniListExpr($t.typeRet, $i.list); $expRet.setLine($ctx.start.getLine());}
  | e1=expression LeftBracket e2=expression RightBracket { $expRet = new ArrayExpr($e1.expRet, $e2.expRet); $expRet.setLine($ctx.start.getLine());}
  | e=expression LeftParen l=argumentExpressionList? RightParen {$expRet = new FunctionExpr($e.expRet, $l.ctx!=null? $l.list: null); $expRet.setLine($ctx.start.getLine());}
  | e=expression PlusPlus    {$expRet = new UnaryExpr($e.expRet, UnaryOperator.POST_INC); $expRet.setLine($ctx.start.getLine());}
  | e=expression MinusMinus    {$expRet = new UnaryExpr($e.expRet, UnaryOperator.POST_DEC); $expRet.setLine($ctx.start.getLine());}
  | { List<Token> ops = new ArrayList<>(); }
       (op=(PlusPlus  | MinusMinus | Sizeof) {ops.add($op);})* (                                          // Prefix operators (zero or more)
         id=Identifier     {$expRet = new Identifier($id.text, $id.getLine()); }
       | c=Constant       {$expRet = new ConstantExpr(new StringVal($c.text));}
       | {List<StringVal> list = new ArrayList<>();}(str=StringLiteral{list.add(new StringVal($str.text));})+  {$expRet = new StringExpr(list);}
       | LeftParen e=expression RightParen {$expRet = $e.expRet;}
       | LeftParen t=typeName RightParen LeftBrace i=initializerList Comma? RightBrace {$expRet = new IniListExpr($t.typeRet, $i.list);}
       | u=unaryOperator ce=castExpression { $expRet = new UnaryExpr($ce.expRet, UnaryOperator.fromString($u.stringRet.getName())); }
       | Sizeof LeftParen t=typeName RightParen { $expRet = new SizeofTypeExpr($t.typeRet);}
    )
    {
      for (int i = ops.size() - 1; i >= 0; i--) {
        Token op = ops.get(i);
        switch (op.getType()) {
          case PlusPlus:
            $expRet = new UnaryExpr($expRet, UnaryOperator.PRE_INC);
            break;
          case MinusMinus:
            $expRet = new UnaryExpr($expRet, UnaryOperator.PRE_DEC);
            break;
          case Sizeof:
            $expRet = new UnaryExpr($expRet, UnaryOperator.SIZEOF);
            break;
        }
      }
      $expRet.setLine($ctx.start.getLine());
    }
  | LeftParen tn=typeName RightParen ce=castExpression { $expRet = new CastExpr($tn.typeRet, $ce.expRet); $expRet.setLine($ctx.start.getLine());}
  | e1=expression op=(Star | Div | Mod) e2=expression
        {BinaryOperator op = BinaryOperator.fromString($op.text);
         $expRet = new BinaryExpr($e1.expRet, op, $e2.expRet);
         $expRet.setLine($ctx.start.getLine());
        }
  | e1=expression op=(Plus | Minus) e2=expression                                          // Additive
        {BinaryOperator op = BinaryOperator.fromString($op.text);
         $expRet = new BinaryExpr($e1.expRet, op, $e2.expRet);
         $expRet.setLine($ctx.start.getLine());
        }
  | e1=expression op=(LeftShift | RightShift) e2=expression                                // Shift
        {BinaryOperator op = BinaryOperator.fromString($op.text);
        $expRet = new BinaryExpr($e1.expRet, op, $e2.expRet);
        $expRet.setLine($ctx.start.getLine());
        }
  | e1=expression op=(Less | Greater | LessEqual | GreaterEqual) e2=expression             // Relational
        {BinaryOperator op = BinaryOperator.fromString($op.text);
        $expRet = new BinaryExpr($e1.expRet, op, $e2.expRet);
        $expRet.setLine($ctx.start.getLine());
        }
  | e1=expression op=(Equal | NotEqual) e2=expression                                      // Equality
        {BinaryOperator op = BinaryOperator.fromString($op.text);
         $expRet = new BinaryExpr($e1.expRet, op, $e2.expRet);
         $expRet.setLine($ctx.start.getLine());
        }
  | e1=expression op=And e2=expression                                                     // Bitwise AND
        {BinaryOperator op = BinaryOperator.fromString($op.text);
         $expRet = new BinaryExpr($e1.expRet, op, $e2.expRet);
         $expRet.setLine($ctx.start.getLine());
        }
  | e1=expression op=Xor e2=expression                                                     // Bitwise XOR
        {BinaryOperator op = BinaryOperator.fromString($op.text);
         $expRet = new BinaryExpr($e1.expRet, op, $e2.expRet);
         $expRet.setLine($ctx.start.getLine());
        }
  | e1=expression op=Or e2=expression                                                      // Bitwise OR
        {BinaryOperator op = BinaryOperator.fromString($op.text);
         $expRet = new BinaryExpr($e1.expRet, op, $e2.expRet);
         $expRet.setLine($ctx.start.getLine());
        }
  | e1=expression op=AndAnd e2=expression                                                  // Logical AND
        {BinaryOperator op = BinaryOperator.fromString($op.text);
         $expRet = new BinaryExpr($e1.expRet, op, $e2.expRet);
         $expRet.setLine($ctx.start.getLine());
        }
  | e1=expression op=OrOr e2=expression                                                    // Logical OR
        {BinaryOperator op = BinaryOperator.fromString($op.text);
         $expRet = new BinaryExpr($e1.expRet, op, $e2.expRet);
         $expRet.setLine($ctx.start.getLine());
        }
  | e1=expression Question e2=expression Colon e3=expression                               // Conditional operator
        { $expRet = new TernaryExpr($e1.expRet, $e2.expRet, $e3.expRet);
          $expRet.setLine($ctx.start.getLine());
        }
  | e1=expression op2=assignmentOperator e2=expression                                        // Assignment
        {BinaryOperator op = BinaryOperator.fromString($op2.text);
         $expRet = new BinaryExpr($e1.expRet, op, $e2.expRet);
         $expRet.setLine($ctx.start.getLine());
        }
  | e1=expression (Comma es+=expression)+                                                 // Comma operator
        {
            List<Expr> result = new ArrayList<>();
                result.add($e1.expRet);
                for (ExpressionContext ctx : $es) {
                    result.add(ctx.expRet);
                }
            $expRet = new CommaExpr(result);
            $expRet.setLine($ctx.start.getLine());
        }
    ;

argumentExpressionList returns [List<Expr> list]:
    {$list = new ArrayList<>();}
  e=expression{$list.add($e.expRet);} (Comma e2=expression{$list.add($e2.expRet);})* ;

unaryOperator returns [StringVal stringRet]:
  cm=(And | Star | Plus | Minus | Tilde | Not){$stringRet = new StringVal($cm.text);} ;

castExpression  returns [Expr expRet]
  : LeftParen tn=typeName RightParen ce=castExpression { $expRet = new CastExpr($tn.typeRet, $ce.expRet); }
  | e=expression { $expRet = $e.expRet; }
  | d=DigitSequence {$expRet = new IntVal(Integer.parseInt($d.text));}
  ;

assignmentOperator returns [String text]
  : cm=(Assign | StarAssign | DivAssign | ModAssign | PlusAssign | MinusAssign | LeftShiftAssign | RightShiftAssign | AndAssign | XorAssign | OrAssign)
   {$text = $cm.getText();}
   ;

declaration returns [Declaration decRet]
    : specs=declarationSpecifiers decl=initDeclaratorList? Semi
    {
        $decRet = new Declaration($specs.list, $decl.ctx != null ? $decl.list : null);
        $decRet.setLine($ctx.start.getLine());
    }
    ;

declarationSpecifiers returns [List<Expr> list]:
    {$list = new ArrayList<>();}
    (spec = declarationSpecifier{$list.add($spec.specRet);})+ ;

declarationSpecifier returns [Expr specRet]
    : td=Typedef {$specRet = new StringVal($td.text);}
    | ts=typeSpecifier {$specRet = $ts.typeSpecRet;}
    | c =Const {$specRet = new StringVal($c.text);}
    ;

initDeclaratorList returns [List<InitDeclarator> list]:
    {$list = new ArrayList<>();}
    i0 = initDeclarator {$list.add($i0.initDecRet);} (Comma ii = initDeclarator{$list.add($ii.initDecRet);})* ;

initDeclarator returns [InitDeclarator initDecRet]
    : dec=declarator {$initDecRet = new InitDeclarator($dec.declaratorRet);}
    (Assign ini = initializer {$initDecRet.addInitializer($ini.iniRet);})? ;

typeSpecifier returns [Expr typeSpecRet]
    : Void {$typeSpecRet = new StringVal($Void.text);}
    | Char {$typeSpecRet = new StringVal($Char.text);}
    | Short {$typeSpecRet = new StringVal($Short.text);}
    | Int {$typeSpecRet = new StringVal($Int.text);}
    | Long {$typeSpecRet = new StringVal($Long.text);}
    | Float {$typeSpecRet = new StringVal($Float.text);}
    | Double {$typeSpecRet = new StringVal($Double.text);}
    | Signed {$typeSpecRet = new StringVal($Signed.text);}
    | Unsigned {$typeSpecRet = new StringVal($Unsigned.text);}
    | Bool {$typeSpecRet = new StringVal($Bool.text);}
    | id=Identifier {$typeSpecRet = new Identifier($id.text, $id.getLine());}
    ;

specifierQualifierList returns [List<Expr> list]
    @init{$list = new ArrayList<>();}
    :(ts = typeSpecifier{$list.add($ts.typeSpecRet);} | Const{$list.add(new StringVal($Const.text));})
    (sq = specifierQualifierList{$list.addAll($sq.list);})?
    ;

declarator returns [Declarator declaratorRet]:
    {$declaratorRet = new Declarator(); $declaratorRet.setLine($ctx.start.getLine());}
    (p=pointer{$declaratorRet.setPointer($p.ptrRet);})?
    d=directDeclarator{$declaratorRet.setDirectDeclarator($d.ddRet);}
    ;

directDeclarator returns [DirectDeclarator ddRet]
    @init {$ddRet = new DirectDeclarator();}
    :id=Identifier{$ddRet.setIdentifier(new Identifier($id.text, $id.getLine()));}
    | LeftParen d=declarator RightParen{$ddRet.setInnerDeclarator($d.declaratorRet);}
    | dd=directDeclarator{$ddRet = $dd.ddRet;} LeftBracket exp=expression? RightBracket {$ddRet.addArrExpr($exp.expRet);}
    | dd=directDeclarator{$ddRet = $dd.ddRet;} LeftParen  (pl=parameterList{$ddRet.addFuncParams($pl.list);}
                                                           | (idl=identifierList{$ddRet.addFuncIdentifiers($idl.list);})?) RightParen
    ;

pointer returns [Pointer ptrRet]:
    {
        $ptrRet = new Pointer();
        int stars = 0;
        List<Integer> constCounts = new ArrayList<>();
    }
    ((Star c+=Const* {stars++; constCounts.add($c.size());}))+
    {
        $ptrRet.setStarCount(stars);
        $ptrRet.setConstCounts(constCounts);
    }
    ;

parameterList returns [List<Parameter> list]:
    {$list = new ArrayList<>();}
    p=parameterDeclaration{$list.add($p.paramRet);} (Comma p2=parameterDeclaration{$list.add($p2.paramRet);})* ;

parameterDeclaration returns [Parameter paramRet]:
    ds=declarationSpecifiers{$paramRet = new Parameter($ds.list);} (d=declarator{$paramRet.setDeclarator($d.declaratorRet);}
            | (d2=abstractDeclarator{$paramRet.setDeclarator($d2.declaratorRet);})?)
    ;

identifierList returns [List<Identifier> list]:
    {$list = new ArrayList<>();}
    id=Identifier{$list.add(new Identifier($id.text, $id.getLine()));} (Comma id2=Identifier{$list.add(new Identifier($id.text, $id.getLine()));})* ;

typeName returns [Typename typeRet]:
    {$typeRet = new Typename();}
    spl=specifierQualifierList{$typeRet.setSpecifierQualifiers($spl.list);}
    (d=abstractDeclarator{$typeRet.setDeclarator($d.declaratorRet);})?
    ;

abstractDeclarator returns [Declarator declaratorRet]
    @init {$declaratorRet = new Declarator();}:
    p=pointer{$declaratorRet.setPointer($p.ptrRet);} | (p=pointer{$declaratorRet.setPointer($p.ptrRet);})? dd=directAbstractDeclarator{$declaratorRet.setDirectDeclarator($dd.ddRet);}
    ;

directAbstractDeclarator returns [DirectDeclarator ddRet]
    @init {$ddRet = new DirectDeclarator();}:
    LeftBracket expression? RightBracket {$ddRet.addArrExpr($exp.expRet);}
    | LeftParen  (d=abstractDeclarator{$ddRet.setInnerDeclarator($d.declaratorRet);} | (pl=parameterList?{$ddRet.addFuncParams($pl.list);})) RightParen
    | dd=directAbstractDeclarator{$ddRet = $dd.ddRet;} LeftBracket exp=expression? RightBracket {$ddRet.addArrExpr($exp.expRet);}
    | dd=directAbstractDeclarator{$ddRet = $dd.ddRet;} LeftParen pl=parameterList? RightParen  {$ddRet.addFuncParams($pl.list);}
    ;

initializer returns [Initializer iniRet]
    @init {$iniRet = new Initializer();}:
    exp=expression{$iniRet.setExpr($exp.expRet);} | LeftBrace i=initializerList{$iniRet.setInitializerlist($i.list);} Comma? RightBrace ;

initializerList returns [InitializerList list]
    @init {$list = new InitializerList();}:
    d=designation? i=initializer{$list.add($d.ctx!=null? $d.dRet : null, $i.iniRet);} (Comma d2=designation? i2=initializer{$list.add($d2.ctx!=null? $d2.dRet : null, $i2.iniRet);})* ;

designation returns [Designation dRet]:
    {$dRet = new Designation();}
    (d=designator{$dRet.addDesignator($d.dRet);})+ Assign ;

designator returns [Designator dRet]
    @init {$dRet = new Designator(); }:
    LeftBracket exp=expression{$dRet.setExpr($exp.expRet);} RightBracket | Dot id=Identifier{ $dRet.setIdentifier(new Identifier($id.text, $id.getLine()));}
    ;

statement returns [Statement stRet]:
    c=compoundStatement{$stRet = $c.cstmtRet; $stRet.setLine($ctx.start.getLine());}
    | e=expressionStatement{$stRet = $e.stRet;$stRet.setLine($ctx.start.getLine());}
    | s=selectionStatement{$stRet = $s.stRet; $stRet.setLine($ctx.start.getLine());}
    | i=iterationStatement{$stRet = $i.stRet; $stRet.setLine($ctx.start.getLine());}
    | j=jumpStatement{$stRet = $j.stRet;      $stRet.setLine($ctx.start.getLine());}
    ;

compoundStatement returns [CompoundStatement cstmtRet]:
    {$cstmtRet = new CompoundStatement(); $cstmtRet.setLine($ctx.start.getLine());}
    LeftBrace (b = blockItem{$cstmtRet.addBlockItem($b.blockRet);})* RightBrace ;

blockItem returns [BlockItem blockRet]:
    st = statement{$blockRet = new BlockItem($st.stRet);}
    | dec = declaration {$blockRet = new BlockItem($dec.decRet);}
    ;

expressionStatement returns [ExpressionStatement stRet]:
    (exp=expression{$stRet = new ExpressionStatement($exp.expRet);})? Semi;

selectionStatement returns [SelectionStatement stRet]
    : If LeftParen exp = expression RightParen ifst=statement {$stRet= new SelectionStatement($exp.expRet, $ifst.stRet);}
    (Else elsest=statement {$stRet.addElse($elsest.stRet);})?;

iterationStatement returns [IterationStatement stRet]
    :While LeftParen e=expression RightParen s=statement {$stRet = new WhileStatement($e.expRet, $s.stRet);}
    | Do s=statement While LeftParen e=expression RightParen Semi{$stRet = new DoWhileStatement($s.stRet, $e.expRet);}
    | For LeftParen f=forCondition RightParen s=statement {$stRet = new ForStatement($f.forconRet, $s.stRet);};

forCondition returns [ForCondition forconRet]
    @init {$forconRet = new ForCondition();}
    :(fd=forDeclaration{$forconRet.setDeclaration($fd.forRet);} | (e=expression{$forconRet.setExpr($e.expRet);})?)
    Semi (f1=forExpression{$forconRet.setConditions($f1.list);})? Semi (f2=forExpression{$forconRet.setSteps($f2.list);})? ;

forDeclaration returns [Declaration forRet]:
    d=declarationSpecifiers{$forRet = new Declaration($d.list);} (i=initDeclaratorList{$forRet.addInitDeclarators($i.list);})?
    ;

forExpression returns [List<Expr> list]:
    {$list = new ArrayList<>();}
    e=expression{$list.add($e.expRet);} (Comma e2=expression{$list.add($e2.expRet);})*;

jumpStatement returns [JumpStatement stRet]:

    ( Continue {$stRet = new ContinueStatement();}
    | Break {$stRet = new BreakStatement();}
    | Return {$stRet = new ReturnStatement();} (e=expression{((ReturnStatement)$stRet).setExpr($e.expRet);})? )
    Semi ;

Break                 : 'break'                 ;
Char                  : 'char'                  ;
Const                 : 'const'                 ;
Continue              : 'continue'              ;
Do                    : 'do'                    ;
Double                : 'double'                ;
Else                  : 'else'                  ;
Float                 : 'float'                 ;
For                   : 'for'                   ;
If                    : 'if'                    ;
Int                   : 'int'                   ;
Long                  : 'long'                  ;
Return                : 'return'                ;
Short                 : 'short'                 ;
Signed                : 'signed'                ;
Sizeof                : 'sizeof'                ;
Switch                : 'switch'                ;
Typedef               : 'typedef'               ;
Unsigned              : 'unsigned'              ;
Void                  : 'void'                  ;
While                 : 'while'                 ;
Bool                  : 'bool'                  ;
LeftParen             : '('                     ;
RightParen            : ')'                     ;
LeftBracket           : '['                     ;
RightBracket          : ']'                     ;
LeftBrace             : '{'                     ;
RightBrace            : '}'                     ;
Less                  : '<'                     ;
LessEqual             : '<='                    ;
Greater               : '>'                     ;
GreaterEqual          : '>='                    ;
LeftShift             : '<<'                    ;
RightShift            : '>>'                    ;
Plus                  : '+'                     ;
PlusPlus              : '++'                    ;
Minus                 : '-'                     ;
MinusMinus            : '--'                    ;
Star                  : '*'                     ;
Div                   : '/'                     ;
Mod                   : '%'                     ;
And                   : '&'                     ;
Or                    : '|'                     ;
AndAnd                : '&&'                    ;
OrOr                  : '||'                    ;
Xor                   : '^'                     ;
Not                   : '!'                     ;
Tilde                 : '~'                     ;
Question              : '?'                     ;
Colon                 : ':'                     ;
Semi                  : ';'                     ;
Comma                 : ','                     ;
Assign                : '='                     ;
StarAssign            : '*='                    ;
DivAssign             : '/='                    ;
ModAssign             : '%='                    ;
PlusAssign            : '+='                    ;
MinusAssign           : '-='                    ;
LeftShiftAssign       : '<<='                   ;
RightShiftAssign      : '>>='                   ;
AndAssign             : '&='                    ;
XorAssign             : '^='                    ;
OrAssign              : '|='                    ;
Equal                 : '=='                    ;
NotEqual              : '!='                    ;
Arrow                 : '->'                    ;
Dot                   : '.'                     ;

Identifier
    : IdentifierNondigit (IdentifierNondigit | Digit)* ;

fragment IdentifierNondigit
    : Nondigit | UniversalCharacterName ;

fragment Nondigit
    : [a-zA-Z_] ;

fragment Digit
    : [0-9] ;

fragment UniversalCharacterName
    : '\\u' HexQuad | '\\U' HexQuad HexQuad ;

fragment HexQuad
    : HexadecimalDigit HexadecimalDigit HexadecimalDigit HexadecimalDigit ;

Constant
    : IntegerConstant | FloatingConstant | CharacterConstant ;

fragment IntegerConstant
    : DecimalConstant IntegerSuffix?
    | OctalConstant IntegerSuffix?
    | HexadecimalConstant IntegerSuffix?
    | BinaryConstant ;

fragment BinaryConstant
    : '0' [bB] [0-1]+ ;

fragment DecimalConstant
    : NonzeroDigit Digit* ;

fragment OctalConstant
    : '0' OctalDigit* ;

fragment HexadecimalConstant
    : HexadecimalPrefix HexadecimalDigit+ ;

fragment HexadecimalPrefix
    : '0' [xX] ;

fragment NonzeroDigit
    : [1-9] ;

fragment OctalDigit
    : [0-7] ;

fragment HexadecimalDigit
    : [0-9a-fA-F] ;

fragment IntegerSuffix
    : UnsignedSuffix LongSuffix? | UnsignedSuffix LongLongSuffix | LongSuffix UnsignedSuffix? | LongLongSuffix UnsignedSuffix? ;

fragment UnsignedSuffix
    : [uU] ;

fragment LongSuffix
    : [lL] ;

fragment LongLongSuffix
    : 'll' | 'LL' ;

fragment FloatingConstant
    : DecimalFloatingConstant | HexadecimalFloatingConstant ;

fragment DecimalFloatingConstant
    : FractionalConstant ExponentPart? FloatingSuffix? | DigitSequence ExponentPart FloatingSuffix? ;

fragment HexadecimalFloatingConstant
    : HexadecimalPrefix (HexadecimalFractionalConstant | HexadecimalDigitSequence) BinaryExponentPart FloatingSuffix? ;

fragment FractionalConstant
    : DigitSequence? Dot DigitSequence | DigitSequence Dot ;

fragment ExponentPart
    : [eE] Sign? DigitSequence ;

fragment Sign
    : [+-] ;

DigitSequence
    : Digit+ ;

fragment HexadecimalFractionalConstant
    : HexadecimalDigitSequence? Dot HexadecimalDigitSequence | HexadecimalDigitSequence Dot ;

fragment BinaryExponentPart
    : [pP] Sign? DigitSequence ;

fragment HexadecimalDigitSequence
    : HexadecimalDigit+ ;

fragment FloatingSuffix
    : [flFL] ;

fragment CharacterConstant
    : '\'' CCharSequence '\'' | 'L\'' CCharSequence '\''| 'u\'' CCharSequence '\'' | 'U\'' CCharSequence '\''
    ;

fragment CCharSequence
    : CChar+ ;

fragment CChar
    : ~['\\\r\n] | EscapeSequence ;

fragment EscapeSequence
    : SimpleEscapeSequence | OctalEscapeSequence | HexadecimalEscapeSequence | UniversalCharacterName ;

fragment SimpleEscapeSequence
    : '\\' ['"?abfnrtv\\] ;

fragment OctalEscapeSequence
    : '\\' OctalDigit OctalDigit? OctalDigit? ;

fragment HexadecimalEscapeSequence
    : '\\x' HexadecimalDigit+ ;

StringLiteral
    : EncodingPrefix? '"' SCharSequence? '"' ;

fragment EncodingPrefix
    : 'u8' | 'u' | 'U' | 'L' ;

fragment SCharSequence
    : SChar+ ;

fragment SChar
    : ~["\\\r\n] | EscapeSequence | '\\\n' | '\\\r\n' ;

MultiLineMacro
    : '#' (~[\n]*? '\\' '\r'? '\n')+ ~ [\n]+ -> channel(HIDDEN) ;

Directive
    : '#' ~[\n]* -> channel(HIDDEN) ;

Whitespace
    : [ \t]+ -> channel(HIDDEN) ;

Newline
    : ('\r' '\n'? | '\n') -> channel(HIDDEN) ;

BlockComment
    : '/*' .*? '*/' -> channel(HIDDEN) ;

LineComment
    : '//' ~[\r\n]* -> channel(HIDDEN) ;