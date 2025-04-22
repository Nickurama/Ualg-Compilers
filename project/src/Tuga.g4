grammar Tuga;

// main
tuga : var_decl* inst+ EOF;

// variable declarations
var_decl : vars ':' type=(
		T_INT|T_DOUBLE|T_STRING|T_BOOL
	) END_INST												# VarDecl
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

scope_or_inline : scope
	| inst
	;

if : 'se' '(' expr ')' scope_or_inline						# IfInst
	;

else : 'senao' scope_or_inline								# ElseInst
	;

while : 'enquanto' '(' expr ')' scope_or_inline				# WhileInst
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
T_INT:		'inteiro' ;
T_DOUBLE:	'real' ;
T_STRING:	'string' ;
T_BOOL:		'booleano' ;

// raw types
INT : [0-9]+ ;
DOUBLE: [0-9]+ '.' [0-9]+ ;
STRING: '"' ~["]* '"' ;
TRUE : 'verdadeiro' ;
FALSE : 'falso' ;

// variables
ID : [a-zA-Z_] [a-zA-Z0-9_]* ;

// skips
WS : [ \t\r\n]+ -> skip ;
SL_COMMENT : '//' .*? (EOF|'\n') -> skip ; // single-line comment
ML_COMMENT : '/*' .*? '*/' -> skip ; // multi-line comment


// fragment
// ALL_CHARS : [ a-zA-Z\\|.,!@#$%^&*()_+=\[\]{}'";:<>/?\-] ;
// ALL_CHARS : ~["]* ;
