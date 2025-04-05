grammar LExpr;

s : e ;

e : SUB e							# NegateOp
  | LPAREN e RPAREN					# ParenExpr
  | <assoc=right> e POW e			# PowerOp
  | e op=(MLT|DIV) e 				# PrimaryOp
  | e op=(ADD|SUB) e				# SecondaryOp
  | NUM        						# Num
  ;


POW : '^' ;
MLT : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
LPAREN : '(' ;
RPAREN : ')' ;

NUM: DIGIT+ | DIGIT+ '.' DIGIT+;
WS : [ \t\n]+ -> skip ;


fragment
DIGIT : [0-9] ;

