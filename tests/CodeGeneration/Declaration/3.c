int i = 0; //this test doesnt work for global
int sum = 0;
int main(){
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
    return sum; //61
}
