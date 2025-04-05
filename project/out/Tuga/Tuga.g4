grammar Tuga;

// main
tuga : inst+ EOF;

// instructions
inst : 'escreve' expr END_INST;

// expressions
expr : LPAREN expr RPAREN							# ParenExpr
  | unary_op expr 									# UnaryOp
  | expr binary_op expr	 							# BinaryOp
  | literal											# LiteralExpr
  ;

unary_op : op=SUB									# ArithmeticNegateOp
  | op=NOT											# LogicNegateOp
  ;

binary_op : op=(MLT|DIV|MOD)						# ArithmeticMultDivOp
  | op=(SUM|SUB)									# ArithmeticSumSubOp
  | op=(LESS|GREATER|LESS_EQ|GREATER_EQ)			# LogicRelOp
  | op=(EQUALS|N_EQUALS)							# LogicEqualsOp
  | op=AND											# LogicAndOp
  | op=OR											# LogicOrOp
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
