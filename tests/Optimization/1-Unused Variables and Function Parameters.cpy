void process(int x, int unused_param):
    int a = 5
    int b = 10
    int c = 15
    printf("%d\n", x)
end
void f2(int x):
    printf()
end
void f1(int x):
    f2(x)
end
int main():
    process(10, 20)
    f1(100)
end