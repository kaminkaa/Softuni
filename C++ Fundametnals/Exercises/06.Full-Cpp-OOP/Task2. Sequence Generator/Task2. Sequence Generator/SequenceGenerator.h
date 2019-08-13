#ifndef SEQUENCE_GEN_H
#define SEQUENCE_GEN_H

#include <iostream>

class SequenceGenerator {
public:
    virtual double* generateSequence() = 0;
};

#endif // SEQUENCE_GEN_H
