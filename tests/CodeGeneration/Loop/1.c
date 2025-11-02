int main() {
    int i = 1;
    if(i == 10) {
        int k = 0;
    }
    int j = 0;
    while (i < 100) {
        i++;
        if(i == 19) {
            continue;
        }
        j++;
        if(j > 70) {
            break;
        }
    }
    return i + j; //144
}