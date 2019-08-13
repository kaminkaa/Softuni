#include <iostream>

using namespace std;

int main()
{
    int n1,n2;

    cout << "Enter a value for number 1:" << endl;
    cin >> n1;
    cout << "Enter a value for number 2:" << endl;
    cin >> n2;

    int gcd;

    for (int i = 1; i <= n1 && i <= n2; i++){
        if(n1%i==0 && n2%i == 0 ){
            gcd=i;
        }
    }

    cout << "Greatest Common Divisor (GCD):" << gcd << endl;

    return 0;
}
