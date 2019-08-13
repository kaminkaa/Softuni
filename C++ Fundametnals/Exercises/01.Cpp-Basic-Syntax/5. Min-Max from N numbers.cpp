#include <iostream>

using namespace std;

int main()
{
    int n;

    cout << "Give a value for N:" << endl;
    cin >> n;

    int numbers[n];

    cout << "Enter the numbers:" << endl;
    for (int i=0; i<n; i++){
        cin >> numbers[i];
    }

    int maxn = numbers[0];
    int minn = numbers[0];

    for (int i=0; i<n; i++){
        if (numbers[i]>=maxn){
            maxn = numbers[i];
        }
        if (numbers[i]<=minn){
            minn = numbers[i];
        }
    }

    cout << "Max value is " << maxn << endl;
    cout << "Min value is " << minn << endl;

    return 0;
}
