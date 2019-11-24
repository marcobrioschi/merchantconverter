# The intergalactic translator

### Instructions

Import the gradle project and run the class _Main_. If you use the flag _--timemaster_ the program enable the dialect of TimeMaster planet that use IIII instead of IV.

### Design choices

* We aren't only speaking about number conversion: I will use this program in my transactions so we are speaking about money. I introduced the concept of intergalactic money that is a value object and can be showed in earth or intergalactic way. So if I gain more than 4000 unit of money or a negative amount, the value is valid but not representable with an intergalactic string.

* I separated the responsibilities for each representation and for the intergalactic (due to his complexity) I separated the builder from the formatter. 

* I used an adapter to introduce the TimeMaster dialect, in this way I didn't need to modify other code.

* You can write expression using operators '+' '-' '/' '*' and parentheses, some expressions to test:
    * M * II - (D * III) + I - (C * V)
    * (1999 - M - D - CD - LXXX + 1) / X * M
    * ((CDXCIX + 1) * (IV + 2) / M / (IX - VI))
    * MM / D (try enabling _--timemaster_ flag)

* I used the spock framework for the unit test

### Notes

* To validate the intergalactic number it's also possible to use a regular expression like _^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$_
