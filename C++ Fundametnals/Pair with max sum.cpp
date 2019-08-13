#include <iostream>
#include <vector>

using namespace std;

vector < int > findMax(int N, vector < int > numbers) {
    vector <int> result;
    int sum = 0;
    int maxsum = 0;
    int n1, n2;

    for(int i=0; i<N; i++){
            for(int j=i+1; j<N-1; j++){
                sum = numbers[i] + numbers[j];
                if(sum>maxsum){
                    maxsum = sum;
                    n1 = numbers[i];
                    n2 = numbers[j];
                }
            }
        }
    if(n1<n2){
        result.push_back(n1);
        result.push_back(n2);
    } else {
        result.push_back(n2);
        result.push_back(n1);
    }

    return result;
}

int main(){
    vector <int> v;
    v.push_back(10);
    v.push_back(9);
    v.push_back(7);
    v.push_back(5);
    v.push_back(8);

    vector<int> r = findMax(5,v);
    cout << r[0] << " " << r[1];
}


