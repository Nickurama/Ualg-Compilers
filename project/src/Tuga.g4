grammar Tuga;

// main
tuga : var_decl* func+ EOF;

// variable declarations
var_decl : vars ':' type=(
		T_INT|T_DOUBLE|T_STRING|T_BOOL
	) END_INST												# VarDecl
	;

// functions
func : 'funcao' ID '(' arg_list? ')' (':' type=(
		T_INT|T_DOUBLE|T_STRING|T_BOOL
	))? scope												# FuncDecl
	;

arg_list : arg												# ArgSingle
	| arg ',' arg_list										# ArgMultiple
	;

expr_list : expr											# ExprSingle
	| expr ',' expr_list									# ExprMultiple
	;

arg : ID ':' type=(
		T_INT|T_DOUBLE|T_STRING|T_BOOL
	)														# Argument
	;

func_call : ID '(' expr_list? ')'							# FuncCall
	;

// instructions
inst : print
	| assign
	| scope
	| if
	| ifelse
	| while
	| func_call_inst
	| return
	| empty
	;
// inst : 'escreve' expr END_INST										# PrintInst
// 	| ID '<-' expr END_INST											# AssignInst
// 	| scope															# ScopeRaw
// 	| 'se' '(' expr ')' scope_or_inline								# IfInst
// 	| 'se' '(' expr ')' scope_or_inline 'senao' scope_or_inline		# IfElseInst
// 	| 'enquanto' '(' expr ')' scope_or_inline						# WhileInst
// 	| END_INST														# EmptyInst
// 	;

print : 'escreve' expr END_INST								# PrintInst
	;

assign : ID '<-' expr END_INST								# AssignInst
	;

scope : 'inicio' var_decl* inst* 'fim'						# ScopeInst
	;

scope_or_inline : scope
	| inst
	;

ifelse : 'se' '(' expr ')' scope_or_inline
		'senao' scope_or_inline								# IfElseInst
	;

if : 'se' '(' expr ')' scope_or_inline						# IfInst
	;

while : 'enquanto' '(' expr ')' scope_or_inline				# WhileInst
	;

func_call_inst : func_call END_INST							# FuncCallInst
	;

return : 'retorna' expr? END_INST							# ReturnInst
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
  | func_call												# FuncExpr
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
