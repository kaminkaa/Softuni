#include<iostream>
#include<sstream>

using namespace std;

class LineParser
{
public:
    class IntSmartArray
    {
    private:
        int length;
        int * data;

        void validateIndex(int index)
        {
            if(index<0 || index >= this->length)
            {
                throw "index out of bounds";
            }
        }

    public:

        IntSmartArray(int length) :
            length(length),
            data(new int[length]) {}

        void setElement (int index, int value)
        {
            validateIndex(index);
            this->data[index]=value;
        }

        string toString()
        {
            stringstream stringResult;

            for(int i=0; i < this->length; i++)
            {
                stringResult << this->data[i] << " ";
            }

            return stringResult.str();
        }
    };

private:
    string line;

public:
    LineParser(const string& line):
        line(line) {}

    IntSmartArray getNumbers() const
    {
        if(isdigit(this->line[0]))
        {
            stringstream ss(this->line);
            int length = 0;
            int number = 0;

            while(ss)
            {
                if(ss >> number)
                {
                    length++;
                }
            }

            IntSmartArray intArr(length);
            int i = 0;

            stringstream sss(this->line);
            while(sss)
            {
                if(sss >> number)
                {
                    intArr.setElement(i,number);
                    i++;
                }
            }

            return intArr;
        }
        else
        {
            IntSmartArray intFalseArr(0);
            return intFalseArr;
        }
    }

    /*StringSmartArray getStrings() const{
    }
    CharSmartArray getChars() const{
    }
    void changeLine(const string& line){
    }*/
};

int main()
{

    string input;
    getline(cin,input);

    LineParser parser(input);

    LineParser::IntSmartArray result = parser.getNumbers();
    string o = result.toString();

    cout << o << endl;

    return 0;
}
