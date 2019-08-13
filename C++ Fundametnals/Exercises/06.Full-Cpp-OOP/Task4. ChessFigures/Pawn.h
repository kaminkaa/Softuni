#ifndef PAWN_H
#define PAWN_H

#include <iostream>
#include "Figure.h"

//typedef Figure * FigurePtr;

class Pawn : public Figure {
public:
    Pawn (bool color, std::string position);
    std::string* getAvailableMoves(Figure ** otherFigures);
    bool moveFigure(const std::string newPosition, Figure ** otherFigures);
    bool checkCaptureMove (Figure ** otherFigures, const std::string &positionToCheck, bool color);
    bool checkPositionAvailabilty (Figure ** otherFigures, const std::string &positionToCheck);
    std::string firstMoveBlack(const std::string &currentPosition);
    std::string firstMoveWhite(const std::string &currentPosition);
    std::string forwardPositionBlack(const std::string &currentPosition);
    std::string forwardPositionWhite(const std::string &currentPosition);
    std::string captureLeftBlack(const std::string &currentPosition);
    std::string captureRightBlack(const std::string &currentPosition);
    std::string captureLeftWhite(const std::string &currentPosition);
    std::string captureRightWhite(const std::string &currentPosition);
};


#endif // PAWN_H
