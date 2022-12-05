#pragma once

#include "element.h"

class List
{
	El *head;
	El *tail;
	void addHead(double val);
	void addTail(double val);
	void removeHead();
	void removeTail();
public:
	List();
	virtual ~List();
	void add(double val);
	void removeList();
	void showRightToLeft();
	void showLeftToRight();
};