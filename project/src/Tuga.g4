grammar Tuga;

// main
tuga : inst+ EOF;

// instructions
inst : 'escreve' expr END_INST						# PrintInst
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
  ;

literal : INT										# Int
  | DOUBLE											# Double
  | STRING											# String
  | TRUE											# True
  | FALSE											# False
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
STRING: '"' ALL_CHARS+ '"' ;
TRUE : 'verdadeiro' ;
FALSE : 'falso' ;

// skips
WS : [ \t\r\n]+ -> skip ;
SL_COMMENT : '//' .*? (EOF|'\n') -> skip ; // single-line comment
ML_COMMENT : '/*' .*? '*/' -> skip ; // multi-line comment

fragment
ALL_CHARS : [ a-zA-Z=] ;
