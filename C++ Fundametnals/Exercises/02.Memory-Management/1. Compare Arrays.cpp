#include<iostream>
using namespace std;

int N = 5;

bool compArr(int arr1[], int arr2[]);

int main()
{
    int arr1[N], arr2[N];
    bool AreEqual;

    cout << "Enter " << N << " numbers for array 1:" << endl;
    for(int i=0; i<N; i++){
        cin >> arr1[i];
    }

    cout << "Enter " << N << "numbers for array 2:" << endl;
    for(int i=0; i<N; i++){
        cin >> arr2[i];
    }

    AreEqual = compArr(arr1,arr2);
    if (AreEqual == 1){
        cout << "Arrays are equal!" << endl;
    } else {
        cout << "Arrays are NOT equal!" << endl;
    }

    return 0;
}

 bool compArr(int arr1[], int arr2[])
 {
    for (int i=0; i<N; i++){
        if(arr1[i] != arr2[i]){
            return false;
        }
    }
    return true;
 }
