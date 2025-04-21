grammar Tuga;

// main
tuga : var_decl* inst+ EOF;

// variable declarations
var_decl : vars ':' TYPE END_INST							# VarDecl
	;

// instructions
inst : print
	| assign
	| scope
	| if
	| if else
	| while
	| empty
	;

print : 'escreve' expr END_INST								# PrintInst
	;

assign : ID '<-' expr END_INST								# AssignInst
	;

scope : 'inicio' inst* 'fim'								# ScopeInst
	;

if : 'se' '(' expr ')' scope								# IfInst
	| 'se' '(' expr ')' inst								# InlineIfInst
	;

else : 'senao' scope										# ElseInst
	| 'senao' inst											# InlineElseInst
	;

while : 'enquanto' '(' expr ')' scope						# WhileInst
	| 'enquanto' '(' expr ')' inst							# InlineWhileInst
	;

empty : END_INST											# EmptyInst
	;

// variables
vars : ID													# VarSingle
	| ID ',' vars											# VarMultiple
	;

// expressions
expr : LPAREN expr RPAREN									# ParenExpr
  | op=SUB expr												# ArithmeticNegateOp
  | op=NOT expr												# LogicNegateOp
  | expr op=(MLT|DIV|MOD) expr								# MultDivOp
  | expr op=(SUM|SUB) expr									# SumSubOp
  | expr op=(LESS|GREATER|LESS_EQ|GREATER_EQ) expr			# RelOp
  | expr op=(EQUALS|N_EQUALS) expr							# EqualsOp
  | expr op=AND expr										# AndOp
  | expr op=OR expr											# OrOp
  | literal													# LiteralExpr
  | ID														# IDExpr
  ;

literal : INT												# Int
  | DOUBLE													# Double
  | STRING													# String
  | TRUE													# True
  | FALSE													# False
  ;

// operators
END_INST:	';' ;
LPAREN:		'(' ;
RPAREN:		')' ;
SUM:		'+' ;
SUB:		'-' ;
MLT:		'*' ;
DIV:		'/' ;
MOD:		'%' ;
LESS:		'<' ;
GREATER:	'>' ;
LESS_EQ:	'<=' ;
GREATER_EQ:	'>=' ;
EQUALS:		'igual' ;
N_EQUALS:	'diferente' ;
AND:		'e' ;
OR:			'ou' ;
NOT:		'nao' ;

// types
INT : [0-9]+ ;
DOUBLE: [0-9]+ '.' [0-9]+ ;
STRING: '"' ~["]* '"' ;
TRUE : 'verdadeiro' ;
FALSE : 'falso' ;

// variables
TYPE : 'booleano' | 'inteiro' | 'real' | 'string' ;
ID : [a-zA-Z_] [a-zA-Z0-9_]* ;

// skips
WS : [ \t\r\n]+ -> skip ;
SL_COMMENT : '//' .*? (EOF|'\n') -> skip ; // single-line comment
ML_COMMENT : '/*' .*? '*/' -> skip ; // multi-line comment


// fragment
// ALL_CHARS : [ a-zA-Z\\|.,!@#$%^&*()_+=\[\]{}'";:<>/?\-] ;
// ALL_CHARS : ~["]* ;
