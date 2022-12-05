#include "pch.h"
#include <iostream>
//#define NDEBUG
#include <assert.h>
#include "Plik.h"
#include "Zamien.h"
#include "lista.h"
using namespace std;

int main(int argc, char* argv[])
{
	Plik* plik = new Plik();
	assert(plik != nullptr);
	// Operacje na args
	string nazwaPliku = argv[1];
	//Wybór przedzia³u
	double od_ = Zamien<double>::ToValue(argv[2]);
	double _do = Zamien<double>::ToValue(argv[3]);
	double wartosc;

	//Otwarcie pliku
	plik->otworzPlik(nazwaPliku);
	cout << "Otworzono plik: " << nazwaPliku << " zakres od " << od_ << " do " << _do << endl;

	List *lista = new List();

	// Czytanie pliku
	while (!plik->koniecPliku()) {
		wartosc = plik->nastepnaWartosc<double>();
		assert(wartosc <= _do && wartosc >= od_);
		if (wartosc <= _do && wartosc >= od_)
		{
			cout << wartosc << " ";
			assert(wartosc != NULL);
			lista->add(wartosc);

		}
	}

	cout << endl << endl << "Show left to right:" << endl;
	lista->showLeftToRight();

	cout << endl << "Show right to left:" << endl;
	lista->showRightToLeft();

	lista->removeList();
	plik->zamknijPlik();
	delete lista;
	delete plik;

	getchar();
	return 0;
}
