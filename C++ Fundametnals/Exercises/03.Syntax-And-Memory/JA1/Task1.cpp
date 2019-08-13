#include<iostream>
#include<sstream>
#include <iomanip>

using namespace std;

int main()
{
    string color1,color2;
    cin >> color1 >> color2;

    string redcolor1 = color1.substr(1+0,2);
    string greencolor1 = color1.substr(1+2,2);
    string bluecolor1 = color1.substr(1+4,2);

    string redcolor2 = color2.substr(1+0,2);
    string greencolor2 = color2.substr(1+2,2);
    string bluecolor2 = color2.substr(1+4,2);

    unsigned int redcolor1int;
    unsigned int greencolor1int;
    unsigned int bluecolor1int;
    unsigned int redcolor2int;
    unsigned int greencolor2int;
    unsigned int bluecolor2int;

    stringstream ss;
    ss << hex << redcolor1;
    ss >> redcolor1int;
    ss.clear();
    ss << hex << greencolor1;
    ss >> greencolor1int;
    ss.clear();
    ss << hex << bluecolor1;
    ss >> bluecolor1int;
    ss.clear();
    ss << hex << redcolor2;
    ss >> redcolor2int;
    ss.clear();
    ss << hex << greencolor2;
    ss >> greencolor2int;
    ss.clear();
    ss << hex << bluecolor2;
    ss >> bluecolor2int;

    int redAvg = (redcolor1int + redcolor2int)/2;
    int greenAvg = (greencolor1int + greencolor2int)/2;
    int blueAvg = (bluecolor1int + bluecolor2int)/2;

    string avgColor;
    stringstream ss2;
    ss2 << hex << setfill('0') << setw(2) << redAvg;
    ss2 << hex << setfill('0') << setw(2) << greenAvg;
    ss2 << hex << setfill('0') << setw(2) << blueAvg;
    avgColor = ss2.str();

    cout << "#" << avgColor;

    return 0;
}
