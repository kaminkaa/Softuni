#include <iostream>

using namespace std;

int main()
{
    int n1,n2,n3;
    char sign='+';

    cin >> n1 >> n2 >> n3;

    if (n1<0 && n2>0 && n3>0){sign='-';}
    if (n1<0 && n2<0 && n3>0){sign='+';}
    if (n1<0 && n2>0 && n3<0){sign='+';}
    if (n1<0 && n2<0 && n3<0){sign='-';}
    if (n1>0 && n2>0 && n3>0){sign='+';}
    if (n1>0 && n2<0 && n3>0){sign='-';}
    if (n1>0 && n2>0 && n3<0){sign='-';}
    if (n1>0 && n2<0 && n3<0){sign='+';}

    cout << sign << endl;

    return 0;
}
