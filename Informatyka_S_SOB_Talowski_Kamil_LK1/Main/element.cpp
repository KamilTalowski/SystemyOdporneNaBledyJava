#include "pch.h"

#include "element.h"

El::El()
{
	val = 0;
	next = nullptr;
	prev = nullptr;
}

El::El(double x)
{
	val = x;
	next = nullptr;
	prev = nullptr;
}