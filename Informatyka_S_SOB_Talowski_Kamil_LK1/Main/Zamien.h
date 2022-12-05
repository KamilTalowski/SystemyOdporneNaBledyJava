#pragma once
#ifndef zamien_h
#define zamien_h

#include <iostream>
#include <sstream>
#include <string>

using namespace std;

template<class T>
class Zamien {
public:
	static T ToValue(string str);
	static string ToString(T value);
};

template<class T>
T Zamien<T>::ToValue(string str) {
	istringstream iss(str);
	T value;
	iss >> value;
	return value;
}

template<class T>
string Zamien<T>::ToString(T value) {
	ostringstream oss;
	oss << value;
	return oss.str();
}
#endif // !zamien_h