#include<iostream>
#include<string>

using namespace std;

class StringFormatter {
private:
    string stringToFormat;
    string formatPrefix;

public:
    StringFormatter(string& stringToFormat, const string& formatPrefix):
        stringToFormat(stringToFormat),
        formatPrefix(formatPrefix) {}

    void format(string insertArr[]){
        int counter = 0;
        string toFind = formatPrefix + (char)counter;
        cout << toFind << endl;

        unsigned int searchindex = stringToFormat.find(toFind);
        int lastmatchpos;

        do{
            lastmatchpos = searchindex;
            stringToFormat.replace(lastmatchpos,formatPrefix.size()+1,insertArr[counter]);
            counter++;
            toFind = formatPrefix + (char)counter;
            cout << toFind << endl;
            searchindex = stringToFormat.find(toFind, lastmatchpos+1);
       } while (searchindex != string::npos);
   }
};

    // void format(int insertArr[], int insertArrSize);


int main(){

    string s = "Dear *:0, Our company *:1 wants to make you a Donation Of *:2 Million *:3 in good faith. Please send us a picture of your credit card";
    StringFormatter formatter(s, "*:");

    string inserts[] = {"Ben Dover", "Totally Legit NonSpam Ltd", "13", "Leva"};

    formatter.format(inserts);
    cout << s;

    return 0;
}
