#ifndef QUEEN_H
#define QUEEN_H

#include <iostream>
#include "Figure.h"

class Queen : public Figure {
public:
    Queen (bool color, std::string position);
    std::string* getAvailableMoves(Figure ** otherFigures);
    bool moveFigure(const std::string newPosition, Figure ** otherFigures);
    bool emptyPosition(Figure ** otherFigures, std::string &positionToCheck);
    bool captureMove(Figure ** otherFigures, std::string &positionToCheck, bool color);
    bool validPosition (std::string pos);
};

#endif // QUEEN_H
