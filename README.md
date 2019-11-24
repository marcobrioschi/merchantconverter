# The intergalactic translator

### Design choices

* We aren't only speaking about number conversion: I will use this program in my transactions so we are speaking about money. I introduced the concept of intergalactic money that is a value object and can be showed in earth or intergalactic way. So if I gain more than 4000 unit of money or a negative amount, the value is valid but not representable with an intergalactic string.

* I separated the responsibilities for each representation and for the intergalactic (due to his complexity) I separated the builder from the formatter. 

* If use the flag _--timemaster_ the program enable the dialect of TimeMaster plane (that use III instead of IV)

### Notes

* To validate the intergalactic number it's also possible to use a regular expression like _^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$_ but I realized only at the end :-(

### Options

* add a parser for expression
* complete the build.gradle and travis build