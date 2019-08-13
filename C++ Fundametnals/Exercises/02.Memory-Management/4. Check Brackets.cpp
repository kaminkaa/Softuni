#include<iostream>
#include<sstream>
using namespace std;

bool checkBrackets (string input);

int main()
{
    cout << "Please enter a mathematical expression:" << endl;

    string inputLine;
    getline(cin, inputLine);

    bool result = checkBrackets(inputLine);

    if(result == 1){
        cout << "Brackets are placed correctly!" << endl;
    } else {
        cout << "Brackets are NOT placed correctly!" << endl;
    }

    return 0;
}

bool checkBrackets (string input)
{
    istringstream inputStream(input);
    int countbr = 0;
    char c;

    while(inputStream){
        if(inputStream >> c){
            if(c == '('){ countbr ++; }
            else if (c == ')') { countbr ++; }
        }
    }

    if (countbr%2 == 0){
        return true;
    } else {
        return false;
    }
}
