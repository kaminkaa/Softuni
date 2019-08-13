#ifndef KNIGHT_H
#define KNIGHT_H

#include <iostream>
#include "Figure.h"

class Knight : public Figure{
public:
    Knight (bool color, std::string position);
    std::string* getAvailableMoves(Figure ** otherFigures);
    bool moveFigure(const std::string newPosition, Figure ** otherFigures);
    bool emptyPosition(Figure ** otherFigures, std::string &positionToCheck);
    bool captureMove(Figure ** otherFigures, std::string &positionToCheck, bool color);
    std::string moveToPosition0(const std::string &currentPosition);
    std::string moveToPosition1(const std::string &currentPosition);
    std::string moveToPosition2(const std::string &currentPosition);
    std::string moveToPosition3(const std::string &currentPosition);
    std::string moveToPosition4(const std::string &currentPosition);
    std::string moveToPosition5(const std::string &currentPosition);
    std::string moveToPosition6(const std::string &currentPosition);
    std::string moveToPosition7(const std::string &currentPosition);
};

#endif
