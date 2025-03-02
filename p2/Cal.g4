grammar Cal;
prog	: s EOF ;
s		: LPAREN l RPAREN
		| A
		;
l		: l COMMA s
		| s
		;

A		: 'a' ;
COMMA	: ',' ;
LPAREN	: '(' ;
RPAREN	: ')' ;
WS		: [\r\t\n]+ -> skip ;
