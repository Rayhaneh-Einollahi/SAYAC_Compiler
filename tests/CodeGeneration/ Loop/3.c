int i = 0;
int sum = 0;

while (i < 20) {
    if (i % 3 == 0) {
        i++;
        continue;
    }
    if (sum > 50) {
        break;
    }
    sum += i;
    i++;
}
