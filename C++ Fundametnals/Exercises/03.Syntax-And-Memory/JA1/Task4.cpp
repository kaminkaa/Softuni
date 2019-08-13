#include<iostream>
#include<sstream>
#include<vector>

using namespace std;

int operation0 (int arr[], int startIndex, int endIndex)
{
    int sum = 0;
    for(int i=startIndex; i<endIndex; i++){
        sum += arr[i];
    }
    return sum;
}

int operation1 (int arr[], int startIndex, int endIndex)
{
    int sum = 0;
    int length = endIndex - startIndex;

    for(int i=startIndex; i<endIndex; i++){
        sum += arr[i];
    }

    int avg = sum/length;
    return avg;
}

int operation2 (int arr[], int startIndex, int endIndex)
{
    int minvalue=arr[startIndex];
    for(int i=startIndex; i<endIndex; i++){
        if(arr[i]<minvalue){
            minvalue = arr[i];
        }
    }

    return minvalue;
}

int operation3 (int arr[], int startIndex, int endIndex)
{
    int maxvalue=arr[startIndex];
    for(int i=startIndex; i<endIndex; i++){
        if(arr[i]>maxvalue){
            maxvalue = arr[i];
        }
    }

    return maxvalue;
}

int* getArray()
{
    string inputLine;
    getline(cin,inputLine);

    stringstream ss(inputLine);
    int number = 0;
    int length = 0;
    while(ss){
        if(ss >> number){
            length++;
        }
    }

    int *arr = new int[length];
    int i = 0;
    stringstream sss(inputLine);
    while(sss){
        if(sss >> number){
            arr[i] = number;
            i++;
        }
    }

    return arr;
}
int main()
{
    int* arr = getArray();

    int p;
    cin >> p;

    string operationName[p];
    int operationNumber[p];

    for(int i=0; i<p; i++){
        cin >> operationName[i] >> operationNumber[i];
    }

    string input;
    string opName;
    int startIndex, endIndex;
    int opNumber;
    vector <string> opStringsArray;
    int sum, avg, minval, maxval;
    stringstream opString;
    int opCount = 0;
    int inputsCount = 0;

    do
    {
        getline(cin, input);
        istringstream inputLine(input);

        inputsCount = 0;

         while(inputLine){
            if((inputsCount==0)&&(inputLine >> opName)){inputsCount++;}
            else if((inputsCount==1)&&(inputLine >> startIndex)){inputsCount++;}
            else if((inputsCount==2)&&(inputLine >> endIndex)){inputsCount++; break;}
         }

         if(inputsCount==3)
         {
            for(int i=0; i<p; i++){
                if(operationName[i]==opName){
                    opNumber=operationNumber[i];
                }
            }

            switch(opNumber)
            {
            case 0:
                sum = operation0(arr,startIndex,endIndex);
                opString << opName << "(" << startIndex << "," << endIndex << ")=" << sum << ",";
                opStringsArray.push_back(opString.str());
                opCount ++;
                break;

            case 1:
                avg = operation1(arr,startIndex,endIndex);
                opString << opName << "(" << startIndex << "," << endIndex << ")=" << avg << ",";
                opStringsArray.push_back(opString.str());
                opCount ++;
                break;

            case 2:
                minval = operation2(arr,startIndex,endIndex);
                opString << opName << "(" << startIndex << "," << endIndex << ")=" << minval << ",";
                opStringsArray.push_back(opString.str());
                opCount ++;
                break;

            case 3:
                maxval = operation3(arr,startIndex,endIndex);
                opString << opName << "(" << startIndex << "," << endIndex << ")=" << maxval << ",";
                opStringsArray.push_back(opString.str());
                opCount ++;
                break;

            default:
                opCount = opCount;
            }
         }
    }while (opName != "end");

    stringstream outputLine;
    outputLine << "[" << opCount << "]{"<< opStringsArray[opCount-1].substr(0,opStringsArray[opCount-1].length()-1) << "}";

    cout << outputLine.str() << endl;

    delete arr;
    return 0;
}
