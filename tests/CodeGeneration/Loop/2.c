int main() {
    sum = 0;
    for (int i = 4; i < 10; i++) {
        if(i == 6) {
            continue;
        }
        sum += i;
        if(sum > 15) {
            break;
        }
    }
}