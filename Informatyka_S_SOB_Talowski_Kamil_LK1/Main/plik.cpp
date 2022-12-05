#include "pch.h"
#include "Plik.h"
#include "Zamien.h"

Plik::Plik() {
	plikbuf = new filebuf();
	assert(plikbuf != NULL);
	plik = nullptr;
}

Plik::~Plik() {
	zamknijPlik();
	delete plikbuf;
	delete plik;
}

int Plik::ignorujBialeZnaki(istream* in) {
	int howMany = 0;
	while (in->peek() == 10 || in->peek() == 32) {
		in->ignore();
	}
	return howMany;
}

void Plik::otworzPlik(string nazwaPliku) {
	plikbuf->open(nazwaPliku, ios::in);
	assert(plikbuf->is_open());
	plik = new istream(plikbuf);
}

bool Plik::koniecPliku() {
	return plik->eof();
}

void Plik::zamknijPlik() {
	if (plikbuf->is_open()) {
		plikbuf->close();
	}
}