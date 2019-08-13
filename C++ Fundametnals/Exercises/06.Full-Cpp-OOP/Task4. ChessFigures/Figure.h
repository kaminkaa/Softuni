#ifndef FIGURE_H
#define FIGURE_H

#include <iostream>

//typedef Figure * FigurePtr;

class Figure {
public:
    char symbol; // @ Pawn // % Knight // & Bishop // # Rook // $ Queen // ! King
    bool color; // true->white false->black
    std::string position; //ex. G3

    virtual std::string* getAvailableMoves(Figure ** otherFigures) = 0;
    virtual bool moveFigure(const std::string newPosition, Figure ** otherFigures) = 0;
};

#endif
