#include "Pawn.h"
#include "Knight.h"
#include "Bishop.h"
#include "Rook.h"
#include "Queen.h"
#include "King.h"

int main()
{
    typedef Figure * FigurePtr;
    FigurePtr figuresArr[32]{
        new Pawn(true,"A2"), //0
        new Pawn(true,"B2"), //1
        new Pawn(true,"C2"), //2
        new Pawn(true,"D2"), //3
        new Pawn(true,"E2"), //4
        new Pawn(true,"F2"), //5
        new Pawn(true,"G2"), //6
        new Pawn(true,"H2"), //7
        new Knight(true,"B1"), //8
        new Knight(true,"G1"), //9
        new Bishop(true,"C1"), // 10
        new Bishop(true,"F1"), // 11
        new Rook(true,"A1"), //12
        new Rook(true,"H1"), //13
        new Queen(true,"D1"), //14
        new King(true,"E1"), //15
        new Pawn(false,"A7"), //16
        new Pawn(false,"B7"), //17
        new Pawn(false,"C7"), //18
        new Pawn(false,"D7"), //19
        new Pawn(false,"E7"), //20
        new Pawn(false,"F7"), //21
        new Pawn(false,"G7"), //22
        new Pawn(false,"H7"), //23
        new Knight(false,"B8"), //24
        new Knight(false,"G8"), //25
        new Bishop(false,"C8"), //26
        new Bishop(false,"F8"), //27
        new Rook(false,"A8"), //28
        new Rook(false,"H8"), //29
        new Queen(false,"D8"), //30
        new King(false,"E8") //31
    };

    bool testKnight = figuresArr[25]->moveFigure("H6",figuresArr);
    bool testKnight2 = figuresArr[9]->moveFigure("E2",figuresArr);
    bool testPawn = figuresArr[17]->moveFigure("B6",figuresArr);
    bool testBishop = figuresArr[26]->moveFigure("A6",figuresArr);
    bool testPawn2 = figuresArr[0]->moveFigure("A4",figuresArr);
    bool testRook = figuresArr[12]->moveFigure("A3",figuresArr);
    bool testPawn3 = figuresArr[2]->moveFigure("C4",figuresArr);
    bool testQueen = figuresArr[14]->moveFigure("A4",figuresArr);
    bool testQueen2 = figuresArr[14]->moveFigure("B3",figuresArr);
    bool testKing = figuresArr[15]->moveFigure("D1",figuresArr);
    bool testKing2 = figuresArr[15]->moveFigure("C2",figuresArr);

    std::cout << testKnight << std::endl;
    std::cout << testKnight2 << std::endl;
    std::cout << testPawn << std::endl;
    std::cout << testBishop << std::endl;
    std::cout << testPawn2 << std::endl;
    std::cout << testRook << std::endl;
    std::cout << testPawn3 << std::endl;
    std::cout << testQueen << std::endl;
    std::cout << testQueen2 << std::endl;
    std::cout << testKing << std::endl;
    std::cout << testKing2 << std::endl;

    return 0;
}

