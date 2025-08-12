int i = 10;
int x = 100;

int f(int x, int y, int z) {
    int a = x + y + z;
    int b = i + x;
    int i = x * 100;
    int j = i + 10;
    return j;
}

int main() {
    int y = x + 10;
    int g = f(3, 7, 9);
}