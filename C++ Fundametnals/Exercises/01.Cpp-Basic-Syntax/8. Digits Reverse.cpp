#include <iostream>
#include <sstream>

using namespace std;

int main()
{
    int n;

    cout << "Enter a positive number:" << endl;
    cin >> n;

    stringstream strs;
    strs << n;

    string s;
    s = strs.str();
    int length = s.length();

    string news;

    for (int i=length; i>0; i--){
        for (int j=0; j<length; j++){
            news[j]=s[i];
        }
    }

    cout << news;
    return 0;
}
