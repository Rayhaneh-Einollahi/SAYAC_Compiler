void process(int x):



    printf("%d\n", x)
end
void f2():
    printf()
end
void f1():
    f2()
end
int main():
    process(10)
    f1()
end