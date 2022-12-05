#pragma once
#ifndef El_h
#define El_h
struct El
{
	double val;
	El *next;
	El *prev;
	El();
	El(double x);
	virtual ~El() {};
};
#endif