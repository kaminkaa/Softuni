#include<iostream>
#include<fstream>

using namespace std;

int * parseNumbers(const string& str, int& resultLength);

int main()
{
    cout << "Type in the name of the input file:" << endl;
    string inputfile;
    getline(cin,inputfile);

    cout << "Type in the name of the output file:" << endl;
    string outputfile;
    getline(cin,outputfile);

    string inputfilename = inputfile + ".txt";
    string outputfilename = outputfile + ".txt";

    ifstream fileInput(inputfilename);
    int sum = 0;
    int number = 0;

    while (fileInput >> number) {
        sum += number;
    }

    ofstream fileOutput(outputfilename);
    fileOutput << sum << endl;

    return 0;
}


