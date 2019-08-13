#include<iostream>
#include<string>

using namespace std;

int occurences(const string& text, const string& searchstring) ;

int main()
{
    cout << "Please enter a line of text:" << endl;
    string inputLine;
    getline(cin, inputLine);

    cout << "Please enter what to search for:" << endl;
    string searchstring;
    getline(cin,searchstring);

    int result = occurences(inputLine,searchstring);

    cout << "There are " << result << " occurences." << endl;

    return 0;
}

int occurences(const string& text, const string& searchstring)
{
   int countocc = 0;
   int searchindex = text.find(searchstring);
   int lastmatchpos;

   if (searchindex == string::npos){
        return countocc;
   } else {
       do{
        countocc ++;
        lastmatchpos= searchindex;
        searchindex = text.find(searchstring, lastmatchpos+1);
       } while (searchindex != string::npos);
   }

   return countocc;
}
