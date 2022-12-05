#include "pch.h"
#include "lista.h"
#include <iostream>

List::List() {
	head = nullptr;
	tail = nullptr;
}

void List::addHead(double val) {
	El *element = new El(val);
	if (head == nullptr)
	{
		head = element;
		tail = element;
	}
	else
	{
		head->prev = element;
		element->next = head;
		head = element;
	}
}

void List::addTail(double val) {
	El *element = new El(val);
	if (tail == nullptr)
	{
		head = element;
		tail = element;
	}
	else
	{
		tail->next = element;
		element->prev = tail;
		tail = element;
	}
}

void List::removeHead() {
	if (head->next != nullptr)
	{
		El *tempHead = head;
		El *nextTemp = head->next;
		nextTemp->prev = nullptr;
		head = nextTemp;
		delete tempHead;
	}
	else if (head != nullptr)
	{
		El *tempHead = head;
		head = nullptr;
		tail = nullptr;
		delete tempHead;
	}
}

void List::removeTail() {
	if (tail->prev != nullptr)
	{
		El *tempTail = tail;
		El *prevTemp = tail->prev;
		prevTemp->next = nullptr;
		tail = prevTemp;
		delete tempTail;
	}
	else if (tail != nullptr)
	{
		El *tempTail = tail;
		tail = nullptr;
		head = nullptr;
		delete tempTail;
	}
}

void List::add(double val) {

	El *temp = head;
	if ((head == nullptr) || (val <= head->val))
	{
		addHead(val);
	}
	else if ((tail == nullptr) || (val > tail->val))
	{
		addTail(val);
	}
	else
	{
		while (temp != nullptr)
		{
			if ((val > temp->val) && (val <= temp->next->val))
			{
				El *newEl = new El(val);
				El *nextTemp = temp->next;
				newEl->next = nextTemp;
				nextTemp->prev = newEl;
				temp->next = newEl;
				newEl->prev = temp;
				break;
			}
			temp = temp->next;
		}
	}
}

void List::removeList() {
	while (head != nullptr)
		removeHead();
}

void List::showRightToLeft() {
	El *temp = tail;
	while (temp != nullptr)
	{
		std::cout << temp->val << " ";
		temp = temp->prev;
	}
	std::cout << std::endl;
}

void List::showLeftToRight() {
	El *temp = head;
	while (temp != nullptr)
	{
		std::cout << temp->val << " ";
		temp = temp->next;
	}
	std::cout << std::endl;
}

List::~List() {
	removeList();
}
