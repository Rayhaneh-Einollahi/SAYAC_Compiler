int main(){
    int a = 1;
    int b = 1;
    if(a > 1){
        b = 2;
    }
    else if(a == 0) {
        b = 10;
    }
    else{
        b = 3;
        if(b > 2){
            b +=1;
        }
    }

    return b;//4
}