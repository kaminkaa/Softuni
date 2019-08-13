#ifndef ROOK_H
#define ROOK_H

#include <iostream>
#include "Figure.h"

class Rook : public Figure {
public:
    Rook (bool color, std::string position);
    std::string* getAvailableMoves(Figure ** otherFigures);
    bool moveFigure(const std::string newPosition, Figure ** otherFigures);
    bool emptyPosition(Figure ** otherFigures, std::string &positionToCheck);
    bool captureMove(Figure ** otherFigures, std::string &positionToCheck, bool color);
    bool validPosition (std::string pos);
};

#endif // ROOK_H
