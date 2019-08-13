#include<iostream>
#include<string>

using namespace std;

int main()
{
    string T;
    do
    {
        getline(cin,T);
        if (T.length()<1 || T.length()>500){ cout << "Text is too small or too big. Enter it again." << endl;}

    } while (T.length()<1 || T.length()>500);

    string W;
    int P;
    do
    {
        cin >> W >> P;
        if (W.length()>30){ cout << "The word is too long. Enter all again." << endl;}
        if (P<1 || P>100) { cout << "The percent should be between 1 and 100. Enter all again." << endl;}
    } while (W.length()>30 || (P<1 || P>100));


    int wlength = W.length();
    int currLength = 0;
    int j = 0;
    int matchingLettersCount = 0;
    int similarWords = 0;
    int percent;

    for(int i=0; i<(T.length()+1); i++)
    {
        if(T[i]==' ' || T[i]==',' || T[i]=='.' || T[i]==';' || T[i]=='!' || T[i]=='?' || T[i]=='\0')
        {
            if(currLength==wlength && T[i-currLength]==W[0]){
                percent = (matchingLettersCount*100)/wlength;
                if(percent >= P){
                    similarWords++;
                }
            }
            cout << "  " << endl;
            currLength = 0;
            j = 0;
            matchingLettersCount = 0;
            continue;
        }

        currLength ++;

        cout << "T = " << T[i] << "  " << "W = " << W[j] << endl;

        if(T[i] == W[j])
        {
            matchingLettersCount++;
        }
        j++;
    }

    cout << similarWords << endl;
    return 0;
}
