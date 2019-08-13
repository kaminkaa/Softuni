#include <iostream>
#include <vector>
#include <sstream>

std::vector < std::string > printNumbers() {

std::vector <std::string> v;
std::stringstream n;

for (int i=1; i<=100; i++){
    if(i%3==0 && i%5==0){
        v.push_back("FizzBuzz");
    } else if (i%3==0){
        v.push_back("Fizz");
    } else if (i%5==0){
        v.push_back("Buzz");
    } else {
        n << i;
        v.push_back(n.str());
        n.str("");
    }
}
return v;
}

int main(){

std::vector<std::string> r;

r = printNumbers();

for (int i=0; i<100; i++){
    std::cout << r[i];
}

}
