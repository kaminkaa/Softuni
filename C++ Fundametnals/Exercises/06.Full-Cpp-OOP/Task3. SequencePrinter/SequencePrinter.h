#ifndef PRINTER_H
#define PRINTER_H

#include <iostream>
#include "SequenceGenerator.h"

class SequencePrinter{
public:
    virtual std::string print();
    virtual void setSequence(const SequenceGenerator& sequence);
};




#endif // PRINTER_H
