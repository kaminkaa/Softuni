#include<iostream>
#include "Fraction.h"

static int greatestCommonDivisor(const int &a, const int &b) {
    int divisorCand = a < b ? a : b;

    // NOTE: there is a better algorithm for gcd, but we're trying to keep things simple
    while((a % divisorCand != 0) || (b % divisorCand != 0)) {
        divisorCand--;
    }

    return divisorCand;
}

class LowestTermsFraction : public Fraction {
public:
    LowestTermsFraction() :
    Fraction(){}

    LowestTermsFraction(int nominator, int denominator) :
        Fraction(nominator / greatestCommonDivisor(nominator, denominator),
                 denominator / greatestCommonDivisor(nominator, denominator)) {
    }

    friend LowestTermsFraction operator*(const LowestTermsFraction &a, const LowestTermsFraction &b);
    friend LowestTermsFraction operator*(const LowestTermsFraction &a, int b);
    friend LowestTermsFraction& operator*=(LowestTermsFraction &a, const LowestTermsFraction &b);
    friend LowestTermsFraction& operator*=(LowestTermsFraction &a, int b);
    friend LowestTermsFraction operator/(const LowestTermsFraction &a, const LowestTermsFraction &b);
    friend LowestTermsFraction operator/(const LowestTermsFraction &a, int b);
    friend LowestTermsFraction& operator/=(LowestTermsFraction &a, const LowestTermsFraction &b);
    friend LowestTermsFraction& operator/=(LowestTermsFraction &a, int b);
public:
    friend LowestTermsFraction getReciprocal(const LowestTermsFraction &a);
};

    LowestTermsFraction operator*(const LowestTermsFraction &a, const LowestTermsFraction &b) {
        int n = a.nominator*b.nominator;
        int d = a.denominator*b.denominator;
        return LowestTermsFraction(n,d);
    }

    LowestTermsFraction operator*(const LowestTermsFraction &a, int b) {
        int n = a.nominator*b;
        return LowestTermsFraction(n,a.denominator);
    }

    LowestTermsFraction& operator*=(LowestTermsFraction &a, const LowestTermsFraction &b) {
        a = a * b;
        return a;
    }

    LowestTermsFraction& operator*=(LowestTermsFraction &a, int b) {
        a = a * b;
        return a;
    }

        LowestTermsFraction operator/(const LowestTermsFraction &a, const LowestTermsFraction &b) {
        int n = a.nominator*b.denominator;
        int d = a.denominator*b.nominator;
        return LowestTermsFraction(n,d);
    }

    LowestTermsFraction operator/(const LowestTermsFraction &a, int b) {
        int d = a.denominator*b;
        return LowestTermsFraction(a.nominator,d);
    }

    LowestTermsFraction& operator/=(LowestTermsFraction &a, const LowestTermsFraction &b) {
        a = a / b;
        return a;
    }

    LowestTermsFraction& operator/=(LowestTermsFraction &a, int b) {
        a = a / b;
        return a;
    }

    LowestTermsFraction getReciprocal(const LowestTermsFraction &a) {
        return LowestTermsFraction(a.denominator, a.nominator);
    }

int main() {
    LowestTermsFraction a,b;
    std::cin >> a >> b;

    a *= 3;
    a /= 3;
    a *= b;
    a /= b;
    LowestTermsFraction multBy3 = a * 3;
    LowestTermsFraction multByB = a * b;
    LowestTermsFraction divBy3 = a / 3;
    LowestTermsFraction divByB = a / b;
    LowestTermsFraction reciprocalA;

    std::cout << a << " " << b << " " << multBy3 << " " << multByB << " " << divBy3 << " " << divByB;

    return 0;
}
