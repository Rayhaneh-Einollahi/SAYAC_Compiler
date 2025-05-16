void foo():
    printf("heb")
end
void foo(int x):
    printf("heb")
end
int foo(int x, char y):
    printf("heb")
end
void moo(char x, char y):
    printf("%s%s", x, y)
    moo(20)
end
void shoo():
    int x
    foo(foo(x), x)
    moo(10)
end
int main():
    foo(3)
    foo(3, 5) // amdan ro in error nazashtam ke dar nazar begirid ba esm va tedad argoman bayad tashkhis bedid
    moo("Hello", "World")
end