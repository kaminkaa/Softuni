#ifndef FIGURE_H
#define FIGURE_H

#include <iostream>

//typedef Figure * FigurePtr;

class Figure {
public:
    bool color; // true->white false->black
    std::string position; //ex. G3
    char symbol; // p-white/P-black Pawn // n-white/N-black Knight // b/B Bishop // r/R Rook // q/Q Queen // k/K King

    virtual std::string* getAvailableMoves(Figure ** otherFigures) = 0;
    virtual bool moveFigure(const std::string newPosition, Figure ** otherFigures) = 0;
};

#endif
