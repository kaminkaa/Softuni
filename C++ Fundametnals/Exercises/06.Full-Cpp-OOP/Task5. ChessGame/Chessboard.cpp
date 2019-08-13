#include "Chessboard.h"

void printChessboard(Figure ** figures){
    char chessBoard[10][10];
        bool letterMatch = false, numberMatch = false;
        char rChar;
        for(int r=0; r<10; r++){
            if(r==0 || r==9){
                for(int c=0; c<10; c++){
                    if(c==0 || c==9){
                        chessBoard[r][c]=' ';
                    } else {
                        switch(c){
                            case 1: chessBoard[r][c] = 'A';
                                    break;
                            case 2: chessBoard[r][c] = 'B';
                                    break;
                            case 3: chessBoard[r][c] = 'C';
                                    break;
                            case 4: chessBoard[r][c] = 'D';
                                    break;
                            case 5: chessBoard[r][c] = 'E';
                                    break;
                            case 6: chessBoard[r][c] = 'F';
                                    break;
                            case 7: chessBoard[r][c] = 'G';
                                    break;
                            case 8: chessBoard[r][c] = 'H';
                                    break;

                                    default: chessBoard[r][c]=' ';
                        }
                    }
                }
            } else {
                switch(r){
                case 1: rChar = '1';
                        break;
                case 2: rChar = '2';
                        break;
                case 3: rChar = '3';
                        break;
                case 4: rChar = '4';
                        break;
                case 5: rChar = '5';
                        break;
                case 6: rChar = '6';
                        break;
                case 7: rChar = '7';
                        break;
                case 8: rChar = '8';
                        break;
                }

                chessBoard[r][0] = rChar;
                chessBoard[r][9] = rChar;

                for(int c=1; c<=8; c++){
                    switch(c){
                    case 1:
                        {
                            letterMatch = false;
                            numberMatch = false;
                            for(int i=0; i<32; i++){
                                if(figures[i]->position[0] == 'A'){
                                letterMatch = true;
                                }
                                if(figures[i]->position[1] == rChar){
                                    numberMatch = true;
                                }
                                if(letterMatch==1 && numberMatch==1){
                                    chessBoard[r][c]=figures[i]->symbol;
                                    break;
                                }  else {
                                    chessBoard[r][c]='*';
                                    letterMatch = false;
                                    numberMatch = false;
                                    }
                            }
                            break;
                        }


                    case 2:
                        {
                            letterMatch = false;
                            numberMatch = false;
                            for(int i=0; i<32; i++){
                                if(figures[i]->position[0] == 'B'){
                                letterMatch = true;
                                }
                                if(figures[i]->position[1] == rChar){
                                    numberMatch = true;
                                }
                                if(letterMatch==1 && numberMatch==1){
                                    chessBoard[r][c]=figures[i]->symbol;
                                    break;
                                }  else {
                                    chessBoard[r][c]='*';
                                    letterMatch = false;
                                    numberMatch = false;
                                    }
                            }
                            break;
                        }


                    case 3:
                        {
                            letterMatch = false;
                            numberMatch = false;
                            for(int i=0; i<32; i++){
                                if(figures[i]->position[0] == 'C'){
                                letterMatch = true;
                                }
                                if(figures[i]->position[1] == rChar){
                                    numberMatch = true;
                                }
                                if(letterMatch==1 && numberMatch==1){
                                    chessBoard[r][c]=figures[i]->symbol;
                                    break;
                                }  else {
                                    chessBoard[r][c]='*';
                                    letterMatch = false;
                                    numberMatch = false;
                                    }
                            }
                            break;
                        }


                    case 4:
                        {
                            letterMatch = false;
                            numberMatch = false;
                            for(int i=0; i<32; i++){
                                if(figures[i]->position[0] == 'D'){
                                letterMatch = true;
                                }
                                if(figures[i]->position[1] == rChar){
                                    numberMatch = true;
                                }
                                if(letterMatch==1 && numberMatch==1){
                                    chessBoard[r][c]=figures[i]->symbol;
                                    break;
                                }  else {
                                    chessBoard[r][c]='*';
                                    letterMatch = false;
                                    numberMatch = false;
                                    }
                            }
                            break;
                        }


                    case 5:
                        {
                            letterMatch = false;
                            numberMatch = false;
                            for(int i=0; i<32; i++){
                                if(figures[i]->position[0] == 'E'){
                                letterMatch = true;
                                }
                                if(figures[i]->position[1] == rChar){
                                    numberMatch = true;
                                }
                                if(letterMatch==1 && numberMatch==1){
                                    chessBoard[r][c]=figures[i]->symbol;
                                    break;
                                }  else {
                                    chessBoard[r][c]='*';
                                    letterMatch = false;
                                    numberMatch = false;
                                    }
                            }
                            break;
                        }


                    case 6:
                        {
                            letterMatch = false;
                            numberMatch = false;
                            for(int i=0; i<32; i++){
                                if(figures[i]->position[0] == 'F'){
                                letterMatch = true;
                                }
                                if(figures[i]->position[1] == rChar){
                                    numberMatch = true;
                                }
                                if(letterMatch==1 && numberMatch==1){
                                    chessBoard[r][c]=figures[i]->symbol;
                                    break;
                                }  else {
                                    chessBoard[r][c]='*';
                                    letterMatch = false;
                                    numberMatch = false;
                                    }
                            }
                            break;
                        }


                    case 7:
                        {
                            letterMatch = false;
                            numberMatch = false;
                            for(int i=0; i<32; i++){
                                if(figures[i]->position[0] == 'G'){
                                letterMatch = true;
                                }
                                if(figures[i]->position[1] == rChar){
                                    numberMatch = true;
                                }
                                if(letterMatch==1 && numberMatch==1){
                                    chessBoard[r][c]=figures[i]->symbol;
                                    break;
                                }  else {
                                    chessBoard[r][c]='*';
                                    letterMatch = false;
                                    numberMatch = false;
                                    }
                            }
                            break;
                        }


                    case 8:
                        {
                            letterMatch = false;
                            numberMatch = false;
                            for(int i=0; i<32; i++){
                                if(figures[i]->position[0] == 'H'){
                                letterMatch = true;
                                }
                                if(figures[i]->position[1] == rChar){
                                    numberMatch = true;
                                }
                                if(letterMatch==1 && numberMatch==1){
                                    chessBoard[r][c]=figures[i]->symbol;
                                    break;
                                }  else {
                                    chessBoard[r][c]='*';
                                    letterMatch = false;
                                    numberMatch = false;
                                    }
                            }
                            break;
                        }
                    }
                }
            }
        }

    for(int r=0; r<10; r++){
        for(int c=0; c<10; c++){
            std::cout << chessBoard[r][c];
        }
        std::cout << std::endl;
    }
    return;
}
