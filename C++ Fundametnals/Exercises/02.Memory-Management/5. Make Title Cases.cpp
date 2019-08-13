#include<iostream>
#include <string>

using namespace std;

void makeTitleCase(string& text);

int main()
{
    cout << "Please enter a line of text:" << endl;

    string inputLine;
    getline(cin, inputLine);

    makeTitleCase(inputLine);

    cout << inputLine << endl;

    return 0;
}

void makeTitleCase(string& text)
{
    for(int i=0; i<text.length(); i++){
        if(i == 0){
            if (text[i]!= '.'){
                text[i] = toupper(text[i]);
            }
        } else if(text[i] == ' ' || text[i]== ','){
            text[i+1] = toupper(text[i+1]);
        }
    }

    return;
}
