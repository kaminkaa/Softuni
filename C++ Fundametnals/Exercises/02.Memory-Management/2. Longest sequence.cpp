#include<iostream>
using namespace std;

int N = 10;

int main()
{
    int arr[N];

    cout << "Enter " << N << " numbers:" << endl;
    for(int i=0; i<N; i++){
        cin >> arr[i];
    }

    int maxtotal, maxcurrent = 1;
    int element;

    for(int i=1; i<=N; i++){
        if(arr[i-1] == arr[i]){
            maxcurrent ++;
            if (maxcurrent > maxtotal){
                element = arr[i];
                maxtotal = maxcurrent;
            }
        }
        else {
            maxcurrent = 1;
        }
    }

    if (maxtotal != 1){
        cout << "The longest sequence is:" << endl;
        for (int i=0; i<maxtotal; i++){
            cout << element << " ";
        }
    } else {
        cout << "There is no longest sequence. Please enter other numbers!" << endl;
    }

    return 0;
}


