#include "Knight.h"
#include <sstream>

Knight::Knight(bool color, std::string position){
    this -> symbol = '%';
    this -> color = color;
    this -> position = position;
}

std::string* Knight::getAvailableMoves(Figure ** otherFigures){
    std::string * availablepositions = new std::string[8]; // maximum 8 positions to move
    std::string position[8];
    int index = 0;

    position[0] = moveToPosition0(this->position);
    position[1] = moveToPosition1(this->position);
    position[2] = moveToPosition2(this->position);
    position[3] = moveToPosition3(this->position);
    position[4] = moveToPosition4(this->position);
    position[5] = moveToPosition5(this->position);
    position[6] = moveToPosition6(this->position);
    position[7] = moveToPosition7(this->position);

    for(int i=0; i<8; i++){
        if(emptyPosition(otherFigures,position[i]) || captureMove(otherFigures,position[i],this->color)){
            availablepositions[index]=position[i];
            index++;
        }
    }

    return availablepositions;
}

bool Knight::moveFigure(const std::string newPosition, Figure ** otherFigures){
    bool moveFigure = false;
    std::string * availablepositions = new std::string[8];
    availablepositions = getAvailableMoves(otherFigures);

    for(int i=0; i<8; i++){
        if(otherFigures[i] != nullptr){
            if(availablepositions[i]==newPosition){
                this->position = newPosition;
                moveFigure = true;
            }
        }
    }

    return moveFigure;
}

bool Knight::emptyPosition(Figure ** otherFigures, std::string &positionToCheck){
    bool emptyposition = true;
    for(int i=0; i<32; i++){
        if(otherFigures[i] != nullptr){
            if(otherFigures[i]->position==positionToCheck){
                emptyposition = false;
            }
        }
    }
    return emptyposition;
}

bool Knight::captureMove(Figure ** otherFigures, std::string &positionToCheck, bool color){
    bool capture = false;
    for(int i=0; i<32; i++){
        if(otherFigures[i] != nullptr){
            if(otherFigures[i]->position==positionToCheck && otherFigures[i]->color!=color){
                capture = true;
            }
        }
    }
    return capture;
}

std::string Knight::moveToPosition0(const std::string &currentPosition){
    std::stringstream moveposition;

    moveposition << (char)(currentPosition[0] + 1) << (currentPosition[1]-'0') + 2;
    return moveposition.str();
}

std::string Knight::moveToPosition1(const std::string &currentPosition){
    std::stringstream moveposition;

    moveposition << (char)(currentPosition[0] + 1) << (currentPosition[1]-'0') - 2;
    return moveposition.str();
}

std::string Knight::moveToPosition2(const std::string &currentPosition){
    std::stringstream moveposition;

    moveposition << (char)(currentPosition[0] - 1) << (currentPosition[1]-'0') + 2;
    return moveposition.str();
}

std::string Knight::moveToPosition3(const std::string &currentPosition){
    std::stringstream moveposition;

    moveposition << (char)(currentPosition[0] - 1) << (currentPosition[1]-'0') - 2;
    return moveposition.str();
}

std::string Knight::moveToPosition4(const std::string &currentPosition){
    std::stringstream moveposition;

    moveposition << (char)(currentPosition[0] + 2) << (currentPosition[1]-'0') + 1;
    return moveposition.str();
}

std::string Knight::moveToPosition5(const std::string &currentPosition){
    std::stringstream moveposition;

    moveposition << (char)(currentPosition[0] + 2) << (currentPosition[1]-'0') - 1;
    return moveposition.str();
}

std::string Knight::moveToPosition6(const std::string &currentPosition){
    std::stringstream moveposition;

    moveposition << (char)(currentPosition[0] - 2) << (currentPosition[1]-'0') + 1;
    return moveposition.str();
}

std::string Knight::moveToPosition7(const std::string &currentPosition){
    std::stringstream moveposition;

    moveposition << (char)(currentPosition[0] - 2) << (currentPosition[1]-'0') - 1;
    return moveposition.str();
}
