#include <iostream>
#include <sstream>

using namespace std;

int main()
{
    int n;

    cout << "Enter a number from 1 to 50 000:" << endl;
    cin >> n;

    int f = 1;

    for (int i=1; i<=n; i++){
        f *= i;
    }

    stringstream fs;
    fs << f;

    string s;
    s = fs.str();
    int length = s.length();
    int numOfa = 0;

    for (int i=0; i<length; i++){
        if(s[i]== '0'){
             numOfa++;
        }
    }

    cout << "Number of zeros is: " << numOfa << endl;

    return 0;
}
