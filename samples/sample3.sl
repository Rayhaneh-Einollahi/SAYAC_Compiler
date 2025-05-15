FuncDec foo() {
    int x;
    x = 3;
    Print();                    // undefined function "Print"
    if (x)
        x = x + 2;
    else
        x = 1;
}

FuncDec foo(){                  // Redefinition of foo
    int x;
    int x;                      //Redeclaration of "x"
}

main() {
    int foo;                    //no error because this is a variable and not a function
    int y;
    y = 8;
    foo();
    y = z + 10 + hello();       // Undefined function "hello" //Undefined variable "z"
}
