#include<iostream>
#include<string>
#include<sstream>

using namespace std;

int * parseNumbers(const string& str, int& resultLength);

int main()
{
    cout << "How many lines of numbers will you enter?" << endl;
    int lines;
    cin >> lines;

    string inputline;
    string allnumbers;
    int i = 0;
    cin.ignore();

    do{
    cout << "Enter line " << i+1 << ":" << endl;
    getline(cin,inputline);
    i++;
    allnumbers = allnumbers + inputline + " ";
    }while(i<lines);

    int resultLength = 0;
    int *arr = parseNumbers(allnumbers,resultLength);

    int sum = 0;
    for(int i=0; i<resultLength; i++){
         sum += arr[i];
    }

    cout << "The sum of numbers is " << sum << endl;

    delete arr;

    return 0;
}

int * parseNumbers(const string& str, int& resultLength)
{
    istringstream inputStream(str);
    int number = 0;

    while (inputStream) {
        if (inputStream >> number) {
        resultLength++;
        }
    }

    int *arr = new int[resultLength];
    int i = 0;
    number = 0;

    istringstream inputStream2(str);

    while (inputStream2) {
        if (inputStream2 >> number) {
            arr[i] = number;
            i++;
        }
    }

    return arr;
}
