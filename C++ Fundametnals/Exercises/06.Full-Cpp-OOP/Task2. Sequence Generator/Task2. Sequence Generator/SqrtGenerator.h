#ifndef SQRT_GEN_H
#define SQRT_GEN_H

#include <iostream>
#include <math.h>
#include <sstream>
#include "SequenceGenerator.h"

class SqrtGenerator : public SequenceGenerator{
private:
    int startIndex;
    int endIndex;
    double * nums;
    std::string * numNames;
public:
    SqrtGenerator(int startIndex, int endIndex);
    SqrtGenerator(const SqrtGenerator &other);
    SqrtGenerator& operator=(const SqrtGenerator &other);
    ~SqrtGenerator();

    void CopyNums(double *source, int sourceLength, double *dest);
    void CopyNumNames(std::string *source, int sourceLength, std::string *dest);

    double* generateSequence();

    std::string getName(int index);
    double getValue(int index);
};

#endif
