#ifndef FIB_GEN_H
#define FIB_GEN_H

#include <iostream>
#include <math.h>
#include <sstream>
#include "SequenceGenerator.h"

class FibonacciGenerator : public SequenceGenerator{
private:
    int startIndex;
    int endIndex;
    double * nums;
    std::string * numNames;
public:
    FibonacciGenerator(int startIndex, int endIndex);
    FibonacciGenerator(const FibonacciGenerator &other);
    FibonacciGenerator& operator=(const FibonacciGenerator &other);
    ~FibonacciGenerator();

    void CopyNums(double *source, int sourceLength, double *dest);
    void CopyNumNames(std::string *source, int sourceLength, std::string *dest);

    double* generateSequence();

    bool CheckFibunacci(int x);

    std::string getName(int index);
    double getValue(int index);
};

#endif

