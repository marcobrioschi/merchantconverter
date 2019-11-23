grammar IntergalacticExpression;

start :
    sumexpression EOF
    ;

sumexpression
    :
    |   multexpression (PLUS | MINUS) sumexpression
    |   multexpression
    ;

multexpression
    :
    |   value (MULT | DIV) multexpression
    |   value
    ;

value
    :
    | LP sumexpression RP
    | INT
    | ROMAN
    ;

LP      :   '(';
RP      :   ')';
PLUS    :   '+';
MINUS   :   '-';
MULT    :   '*';
DIV     :   '/';
INT     :   '0'..'9'+;
ROMAN   :   ( 'M' | 'D' | 'C' | 'L' | 'X' | 'V' | 'I' )+;
WS      : [ \r\t\n]+ -> skip;