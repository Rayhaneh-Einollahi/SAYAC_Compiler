i = 0;
sum = 0;

while (i < 10) :
    print("first ")
    print(i)
    if (i % 3 == 0) :
        print("first --")
        print(i)
        i = i +1
        continue
    print("second ")
    print(i)
    if (sum > 50):
        break
    
    sum += i;
    i += 1;

