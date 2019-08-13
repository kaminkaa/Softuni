#include <iostream>
#include <math.h>
#include <sstream>
#include "SqrtGenerator.h"
#include "FibonacciGenerator.h"


int main()
{
    std::cout << "Fibunacci generator:" << std::endl;
    FibonacciGenerator fibgen(3,6);
    fibgen.generateSequence();

    std::cout << fibgen.getName(0) << std::endl;
    std::cout << fibgen.getName(1) << std::endl;

    std::cout << std::endl;

    std::cout << "Square root generator:" << std::endl;
    SqrtGenerator sqrtgen(4,10);
    sqrtgen.generateSequence();

    std::cout << sqrtgen.getName(0) << " " << sqrtgen.getValue(0) << std::endl;
    std::cout << sqrtgen.getName(1) << " " << sqrtgen.getValue(1) << std::endl;
    std::cout << sqrtgen.getName(2) << " " << sqrtgen.getValue(2) << std::endl;
    std::cout << sqrtgen.getName(3) << " " << sqrtgen.getValue(3) << std::endl;
    std::cout << sqrtgen.getName(4) << " " << sqrtgen.getValue(4) << std::endl;
    std::cout << sqrtgen.getName(5) << " " << sqrtgen.getValue(5) << std::endl;

    return 0;
}
