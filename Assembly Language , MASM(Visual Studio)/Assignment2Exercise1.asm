;Michael Lankford
;CSCI 2331
;Assignment 2 Exercise 1

INCLUDE Irvine32.inc

.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword

.data
	bigEndian BYTE 12h,34h,56h,78h
	littleEndian DWORD ?

.code
main proc

	mov eax, DWORD PTR bigEndian
	mov littleEndian, eax
	
	mov esi, OFFSET littleEndian
	mov ecx, LENGTHOF littleEndian
	mov ebx, TYPE littleEndian

	call DumpMem

	invoke ExitProcess,0
main endp
end main
