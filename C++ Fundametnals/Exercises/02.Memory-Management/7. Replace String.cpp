#include<iostream>
#include<string>

using namespace std;

int main()
{
    cout << "Please enter a line of text:" << endl;
    string text;
    getline(cin, text);

    cout << "Please enter what to search for:" << endl;
    string searchstring;
    getline(cin,searchstring);

    cout << "Please enter the replace word:" << endl;
    string replacestring;
    getline(cin,replacestring);

    int searchindex = text.find(searchstring);
    int lastmatchpos;

   if (searchindex == string::npos){
        cout << searchstring << " was not found!" << endl;
   } else {
       do{
        lastmatchpos= searchindex;
        text.replace(lastmatchpos,searchstring.size(),replacestring);
        searchindex = text.find(searchstring, lastmatchpos+1);
       } while (searchindex != string::npos);
   }

   cout << "The new text is:" << endl;
   cout << text << endl;

    return 0;
}
