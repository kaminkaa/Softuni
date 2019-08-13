#include<iostream>
#include<sstream>
#include<vector>

using namespace std;

int main(){

    vector<int> v;

    string line;
    getline(cin,line);

    if(isdigit(line[0])){
        stringstream ss(line);
        int number = 0;

        while(ss){
            if(ss >> number){
                v.push_back(number);
            }
        }
    }

    for(int i=0; i<v.size(); i++){
        cout << v[i] << endl;
    }
    return 0;
}
