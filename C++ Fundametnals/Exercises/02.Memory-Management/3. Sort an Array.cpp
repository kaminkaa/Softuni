#include<iostream>
using namespace std;

int N = 10;

void selectionSort(int arr[], int start, int endv);

int main()
{
    int arr[N];

    cout << "Enter " << N << " random numbers:" << endl;
    for(int i=0; i<N; i++){
        cin >> arr[i];
    }

    selectionSort(arr,3,7);

    cout << "Sorted array:" << endl;
    for(int i=0; i<N; i++){
        cout << arr[i] << endl;
    }
    return 0;
}

void selectionSort(int arr[], int start, int endv)
{
  int minvalue, j, minvalpos;

    for ( int i=start; i<endv; i++){
            minvalue = arr[i];
        for ( j=i; j<endv;j++){
            if(arr[j]<minvalue){
                minvalue = arr[j];
                minvalpos = j;
            }
        }
        if (minvalue != arr[i]){
        swap(arr[i],arr[minvalpos]);
        }
    }
    return;
}
