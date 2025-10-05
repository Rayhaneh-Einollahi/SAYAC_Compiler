int f(int n){
    if (n==1 || n==2 )
        return 1;
    return f(n-1) + f(n-2);
}

int main(){
    return f(5);

}