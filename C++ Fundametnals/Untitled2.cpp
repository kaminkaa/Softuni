#include <iostream>
#include <vector>
#include <sstream>

using namespace std;

vector < string > missingWords(string s, string t) {
     istringstream sStream(s);
     string word;
     vector <string> swords;

     while (sStream) {
        if (sStream >> word) {
            swords.push_back(word);
        }
    }

    istringstream tStream(t);
    vector <string> twords;

    while (tStream) {
        if (sStream >> word) {
            twords.push_back(word);
        }
    }

    vector<string> missingwords;

    for (int i=0; i<swords.size(); i++){
        for (int j=0; j<twords.size(); j++){
            if(swords[i]==twords[j]){
                continue;
            } else {
                missingwords.push_back(swords[i]);
            }
        }
    }

    return missingwords;
}

int main(){
    vector<string> r = missingWords("I am using hackerrank to improve programming", "am hackerrank to improve");
    for(int i=0; i<r.size(); i++){
        cout<< r[i];
    }

}
