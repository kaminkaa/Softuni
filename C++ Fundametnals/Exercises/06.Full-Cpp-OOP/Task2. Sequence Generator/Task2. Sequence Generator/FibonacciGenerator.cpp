#include "FibonacciGenerator.h"

FibonacciGenerator::FibonacciGenerator(int startIndex, int endIndex) :
    startIndex(startIndex),
    endIndex(endIndex),
    nums(new double[endIndex-startIndex]),
    numNames(new std::string[endIndex-startIndex]) {
    }

FibonacciGenerator::FibonacciGenerator(const FibonacciGenerator &other):
    startIndex(other.startIndex),
    endIndex(other.endIndex),
    nums(new double[other.endIndex-other.startIndex]),
    numNames(new std::string[other.endIndex-other.startIndex]) {
    CopyNums(other.nums, other.endIndex-other.startIndex, this->nums);
    CopyNumNames(other.numNames, other.endIndex-other.startIndex, this->numNames);
}

FibonacciGenerator& FibonacciGenerator::operator=(const FibonacciGenerator &other) {
	if (this != &other) {
		delete[] this->nums;
		delete[] this->numNames;

		int numsLength = other.endIndex-other.startIndex;
        this->nums = new double[numsLength];
        this->numNames = new std::string[numsLength];

        CopyNums(other.nums, numsLength, this->nums);
        CopyNumNames(other.numNames, numsLength, this->numNames);
	}
	return *this;
}

FibonacciGenerator::~FibonacciGenerator() {
    delete[] nums;
    delete[] numNames;
}

void FibonacciGenerator::CopyNums(double *source, int sourceLength, double *dest) {
    for (int i = 0; i < sourceLength; i++) {
		dest[i] = source[i];
	}
}

void FibonacciGenerator::CopyNumNames(std::string *source, int sourceLength, std::string *dest) {
    for (int i = 0; i < sourceLength; i++) {
		dest[i] = source[i];
	}
}

double* FibonacciGenerator::generateSequence(){
    int index = 0;
    bool isFibunacci1 = false;
    bool isFibunacci2 = false;
    std::stringstream ss;
    for(int i=startIndex; i<endIndex; i++){
        isFibunacci1 = CheckFibunacci(5*i*i + 4);
        isFibunacci2 = CheckFibunacci(5*i*i - 4);
        if(isFibunacci1 || isFibunacci2){
            nums[index] = i;
            ss << "Fibunacci " << i ;
            numNames[index] = ss.str();
            index++;
        }
        //ss.clear();
        ss.str("");
    }
    return nums;
}

bool FibonacciGenerator::CheckFibunacci(int x) {
    int s = sqrt(x);
    return (s*s == x);
}

std::string FibonacciGenerator::getName(int index) {
    return this->numNames[index];
}

double FibonacciGenerator::getValue(int index) {
    return this->nums[index];
}

