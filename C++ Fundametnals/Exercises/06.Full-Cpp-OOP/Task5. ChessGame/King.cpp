#include "King.h"
#include <sstream>

King::King(bool color, std::string position){
    this -> color = color;
    this -> position = position;
    if(this -> color == 1){
        this -> symbol = 'k';
    } else {
        this -> symbol = 'K';
    }
}

std::string* King::getAvailableMoves(Figure ** otherFigures){
    std::string * availablepositions = new std::string[8]; // maximum 8 positions to move
    std::stringstream positionToCheck;
    std::string posToCheck;
    int index = 0;

    // direction: left
    positionToCheck << (char)(this->position[0] - 1) << this->position[1];
    posToCheck = positionToCheck.str();
    positionToCheck.str("");
    if(validPosition(posToCheck)==1){
        if(emptyPosition(otherFigures,posToCheck) || captureMove(otherFigures,posToCheck,this->color)){
            availablepositions[index] = posToCheck;
            index++;
        }
    }

    // direction: right
    positionToCheck << (char)(this->position[0] + 1) << this->position[1];
    posToCheck = positionToCheck.str();
    positionToCheck.str("");
    if(validPosition(posToCheck)==1){
        if(emptyPosition(otherFigures,posToCheck) || captureMove(otherFigures,posToCheck,this->color)){
            availablepositions[index] = posToCheck;
            index++;
        }
    }

    // direction: up
    positionToCheck << this->position[0] << (this->position[1]-'0') + 1;
    posToCheck = positionToCheck.str();
    positionToCheck.str("");
    if(validPosition(posToCheck)==1){
        if(emptyPosition(otherFigures,posToCheck) || captureMove(otherFigures,posToCheck,this->color)){
            availablepositions[index] = posToCheck;
            index++;
        }
    }

    // direction: left up
    positionToCheck << (char)(this->position[0] - 1) << (this->position[1]-'0') + 1;
    posToCheck = positionToCheck.str();
    positionToCheck.str("");
    if(validPosition(posToCheck)==1){
        if(emptyPosition(otherFigures,posToCheck) || captureMove(otherFigures,posToCheck,this->color)){
            availablepositions[index] = posToCheck;
            index++;
        }
    }

    // direction: right up
    positionToCheck << (char)(this->position[0] + 1) << (this->position[1]-'0') + 1;
    posToCheck = positionToCheck.str();
    positionToCheck.str("");
    if(validPosition(posToCheck)==1){
        if(emptyPosition(otherFigures,posToCheck) || captureMove(otherFigures,posToCheck,this->color)){
            availablepositions[index] = posToCheck;
            index++;
        }
    }

    // direction: down
    positionToCheck << this->position[0] << (this->position[1]-'0') - 1;
    posToCheck = positionToCheck.str();
    positionToCheck.str("");
    if(validPosition(posToCheck)==1){
        if(emptyPosition(otherFigures,posToCheck) || captureMove(otherFigures,posToCheck,this->color)){
            availablepositions[index] = posToCheck;
            index++;
        }
    }

    // direction: left down
    positionToCheck << (char)(this->position[0] - 1) << (this->position[1]-'0') - 1;
    posToCheck = positionToCheck.str();
    positionToCheck.str("");
    if(validPosition(posToCheck)==1){
        if(emptyPosition(otherFigures,posToCheck) || captureMove(otherFigures,posToCheck,this->color)){
            availablepositions[index] = posToCheck;
            index++;
        }
    }

    // direction: right down
    positionToCheck << (char)(this->position[0] + 1) << (this->position[1]-'0') - 1;
    posToCheck = positionToCheck.str();
    positionToCheck.str("");
    if(validPosition(posToCheck)==1){
        if(emptyPosition(otherFigures,posToCheck) || captureMove(otherFigures,posToCheck,this->color)){
            availablepositions[index] = posToCheck;
            index++;
        }
    }

    return availablepositions;
}

bool King::moveFigure(const std::string newPosition, Figure ** otherFigures){
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

bool King::emptyPosition(Figure ** otherFigures, std::string &positionToCheck){
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

bool King::captureMove(Figure ** otherFigures, std::string &positionToCheck, bool color){
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

bool King::validPosition (std::string pos){
    bool checkLetter = false;
    bool checkNumber = false;
    bool posValid = false;

    if(pos[0]=='A' || pos[0]=='B' || pos[0]=='C' || pos[0]=='D' || pos[0]=='E' || pos[0]=='F' || pos[0]=='G' || pos[0]=='H'){
        checkLetter = true;
    }

    if(pos[1]=='1' || pos[1]=='2' || pos[1]=='3' || pos[1]=='4' || pos[1]=='5' || pos[1]=='6' || pos[1]=='7' || pos[1]=='8'){
        checkNumber = true;
    }

    if(checkLetter==1 && checkNumber==1){
        posValid = true;
    }

    return posValid;
}

