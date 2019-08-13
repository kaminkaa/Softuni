#include <iostream>
#include <math.h>

using namespace std;

int main()
{
    int a,b,c;
    float d,x1,x2 = 0.0;

    cin >> a >> b >> c;

    d = pow(b,2) - 4*a*c;

    if (d<0){
        cout << "There are no real roots." << endl;
    }
    if (d==0){
        x1 = (-1)*b/(2*a);
        cout << "There is one real root:" << endl;
        cout << x1 << endl;
    }
    if (d>0){
        x1 = ((-1)*b + sqrt(d))/(2*a);
        x2 = ((-1)*b - sqrt(d))/(2*a);
        cout << "There are two real roots:" << endl;
        cout << x1 << endl;
        cout << x2 << endl;
    }

    return 0;
}
