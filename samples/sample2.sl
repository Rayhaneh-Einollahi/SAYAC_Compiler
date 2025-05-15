FuncDec hello(){
    how_are_you();          //Undeclared function "how_are_you"
}

main() {
    int b;
    b = 10;
    if (b + a + test())         //Undeclared function "test"   //Undeclared variable "a"
        b = b + 5;
    else
        x();                     //Undeclared function "x"

    int b;                       //Redeclaration of "b"
}
