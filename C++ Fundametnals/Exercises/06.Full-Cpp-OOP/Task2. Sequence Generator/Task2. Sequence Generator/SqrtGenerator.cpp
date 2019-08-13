#include "SqrtGenerator.h"

SqrtGenerator::SqrtGenerator(int startIndex, int endIndex) :
    startIndex(startIndex),
    endIndex(endIndex),
    nums(new double[endIndex-startIndex]),
    numNames(new std::string[endIndex-startIndex]) {
    }

SqrtGenerator::SqrtGenerator(const SqrtGenerator &other):
    startIndex(other.startIndex),
    endIndex(other.endIndex),
    nums(new double[other.endIndex-other.startIndex]),
    numNames(new std::string[other.endIndex-other.startIndex]) {
    CopyNums(other.nums, other.endIndex-other.startIndex, this->nums);
    CopyNumNames(other.numNames, other.endIndex-other.startIndex, this->numNames);
}

SqrtGenerator& SqrtGenerator::operator=(const SqrtGenerator &other) {
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

SqrtGenerator::~SqrtGenerator() {
    delete[] nums;
    delete[] numNames;
}

void SqrtGenerator::CopyNums(double *source, int sourceLength, double *dest) {
    for (int i = 0; i < sourceLength; i++) {
		dest[i] = source[i];
	}
}

void SqrtGenerator::CopyNumNames(std::string *source, int sourceLength, std::string *dest) {
    for (int i = 0; i < sourceLength; i++) {
		dest[i] = source[i];
	}
}

double* SqrtGenerator::generateSequence(){
    int index = 0;
    for(int i=startIndex; i<endIndex; i++){
        std::stringstream ss;
        nums[index] = sqrt(i);
        ss << "Sqrt(" << i << ")";
        numNames[index] = ss.str();
        index++;
    }
    return nums;
}

std::string SqrtGenerator::getName(int index) {
    return this->numNames[index];
}

double SqrtGenerator::getValue(int index) {
    return this->nums[index];
}
