#include "Pawn.h"
#include <sstream>

Pawn::Pawn(bool color, std::string position){
    this -> symbol = '@';
    this -> color = color;
    this -> position = position;
}

std::string* Pawn::getAvailableMoves(Figure ** otherFigures){
    std::string * availablepositions = new std::string[4];      // first move, forward move, left capture move, right capture move
    std::string firstmoveblack, forwposblack, captureleftblack, capturerightblack;
    std::string firstmovewhite, forwposwhite, captureleftwhite, capturerightwhite;
    int index = 0;

    switch(this->color){
    case false:  // case for the black pawn:
        firstmoveblack = firstMoveBlack(this->position);        // first move for black pawn

        if(this->position[1]=='7' && checkPositionAvailabilty(otherFigures,firstmoveblack)){
        availablepositions[index] = firstmoveblack;
        index++;
        }

        forwposblack = forwardPositionBlack(this->position);    // forward move for black pawn

        if(checkPositionAvailabilty(otherFigures,forwposblack)){
            availablepositions[index] = forwposblack;
            index++;
        }

        if(this->position[0]!= 'H'){                            // left capture move for black pawn
            captureleftblack = captureLeftBlack(this->position);
            if(checkCaptureMove(otherFigures,captureleftblack,this->color)){
                availablepositions[index] = captureleftblack;
                index++;
            }
        }

        if(this->position[0]!= 'A'){                            // right capture move for black pawn
            capturerightblack = captureRightBlack(this->position);
            if(checkCaptureMove(otherFigures,capturerightblack,this->color)){
                availablepositions[index] = capturerightblack;
                index++;
            }
        }

        break;

    case true:  // case for the white pawn:
        firstmovewhite = firstMoveWhite(this->position);        // first move for white pawn

        if(this->position[1]=='2' && checkPositionAvailabilty(otherFigures,firstmovewhite)){
        availablepositions[index] = firstmovewhite;
        index++;
        }

        forwposwhite = forwardPositionWhite(this->position);    // forward move for white pawn

        if(checkPositionAvailabilty(otherFigures,forwposwhite)){
            availablepositions[index] = forwposwhite;
            index++;
        }

        if(this->position[0]!= 'A'){                            // left capture move for white pawn
            captureleftwhite = captureLeftWhite(this->position);
            if(checkCaptureMove(otherFigures,captureleftwhite,this->color)){
                availablepositions[index] = captureleftwhite;
                index++;
            }
        }

        if(this->position[0]!= 'H'){                            // right capture move for white pawn
            capturerightwhite = captureRightWhite(this->position);
            if(checkCaptureMove(otherFigures,capturerightwhite,this->color)){
                availablepositions[index] = capturerightwhite;
                index++;
            }
        }
        break;

        default: ;
    }

    return availablepositions;
}

bool Pawn::moveFigure(const std::string newPosition, Figure ** otherFigures){
    bool moveFigure = false;
    std::string * availablepositions = new std::string[4];
    availablepositions = getAvailableMoves(otherFigures);

    for(int i=0; i<4; i++){
        if(otherFigures[i] != nullptr){
            if(availablepositions[i]==newPosition){
                this->position = newPosition;
                moveFigure = true;
            }
        }
    }

    return moveFigure;
}

bool Pawn::checkCaptureMove (Figure ** otherFigures, const std::string &positionToCheck, bool color){
    bool capture = false;

    for(int i=0; i<32; i++){
        if(otherFigures[i] != nullptr){
            if(otherFigures[i]->position == positionToCheck && otherFigures[i]->color!=color){
                capture=true;
            }
        }
    }

    return capture;
}

bool Pawn::checkPositionAvailabilty (Figure ** otherFigures, const std::string &positionToCheck){
    bool availability = true;

    for(int i=0; i<32; i++){
        if(otherFigures[i] != nullptr){
            if(otherFigures[i]->position == positionToCheck){
                availability=false;
            }
        }


    }

    return availability;
}

std::string Pawn::firstMoveBlack(const std::string &currentPosition){
    std::stringstream firstmove;

    firstmove << currentPosition[0] << 5;
    return firstmove.str();
}

std::string Pawn::firstMoveWhite(const std::string &currentPosition){
    std::stringstream firstmove;

    firstmove << currentPosition[0] << 4;
    return firstmove.str();
}

std::string Pawn::forwardPositionBlack(const std::string &currentPosition){
    std::stringstream forwardposition;

    forwardposition << currentPosition[0] << (currentPosition[1]-'0') - 1;
    return forwardposition.str();
}

std::string Pawn::forwardPositionWhite(const std::string &currentPosition){
    std::stringstream forwardposition;

    forwardposition << currentPosition[0] << (currentPosition[1]-'0') + 1;
    return forwardposition.str();
}

std::string Pawn::captureLeftBlack(const std::string &currentPosition){
    std::stringstream captureleft;

    captureleft << (char)(currentPosition[0] + 1) << (currentPosition[1]-'0') - 1;
    return captureleft.str();
}

std::string Pawn::captureRightBlack(const std::string &currentPosition){
    std::stringstream captureright;

    captureright << (char)(currentPosition[0] - 1) << (currentPosition[1]-'0') - 1;
    return captureright.str();
}

std::string Pawn::captureLeftWhite(const std::string &currentPosition){
    std::stringstream captureleft;

    captureleft << (char)(currentPosition[0] - 1) << (currentPosition[1]-'0') + 1;
    return captureleft.str();
}

std::string Pawn::captureRightWhite(const std::string &currentPosition){
    std::stringstream captureright;

    captureright << (char)(currentPosition[0] + 1) << (currentPosition[1]-'0') + 1;
    return captureright.str();
}
