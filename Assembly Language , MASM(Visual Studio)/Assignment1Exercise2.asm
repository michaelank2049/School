;Michael Lankford
;CSCI 2331
;Assignment 1 Exercise 2

INCLUDE Irvine32.inc

.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword

.data
	Monday    = 1
	Tuesday   = 2
	Wednesday = 3
	Thursday  = 4
	Friday    = 5
	Saturday  = 6
	Sunday    = 7

	DayOfTheWeekArray BYTE Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday

.code
main proc			

	invoke ExitProcess,0
main endp
end main