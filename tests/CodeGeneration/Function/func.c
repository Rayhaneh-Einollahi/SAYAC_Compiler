void f0() {
    int x = 1;
   int y = x + 2;
}

void f1(int x) {
    int y = x + 1;
}

int f2() {
    int x = 1;
    return x;
}

int f3(int x) {
    int y = x + 1;
    return y;
}

int main() {
    int z = 20;
    int w = 30;
    int x = 10;
    f0();
    f1(x);
    int y = f2();
    int z = f3(y);
}