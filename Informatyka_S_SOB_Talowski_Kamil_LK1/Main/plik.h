#pragma once
#ifndef plik_h
#define plik_h

//#define NDEBUG
#include <iostream>
#include <fstream>
#include <string>
#include <assert.h>
#include "Zamien.h"

using namespace std;

class Plik {
private:
	filebuf* plikbuf;
	istream* plik;
public:
	Plik();
	virtual ~Plik();
	int ignorujBialeZnaki(istream* in);
	template<typename T>
	T nastepnaWartosc();
	bool koniecPliku();
	void otworzPlik(string nazwaPliku);
	void zamknijPlik();
};

template <typename T>
T Plik::nastepnaWartosc() {
	string wartosc;
	while (!plik->eof()) {
		ignorujBialeZnaki(plik);
		*plik >> wartosc;
		return Zamien<T>::ToValue(wartosc);
	}
	return 0;
}
#endif // !plik_h