grammar IntergalacticExpression;

start :
    sumexpression EOF
    ;

sumexpression
    :
    |   sumexpression (PLUS | MINUS) multexpression
    |   multexpression
    ;

multexpression
    :
    |   multexpression (MULT | DIV) value
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