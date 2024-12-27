;Michael Lankford
;CSCI 2331
;Assignment 2 Exercise 5


INCLUDE Irvine32.inc

.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword

.data

	intVal DWORD ?		;Number input(****USE HEXADECIMAL VALUES****)
						;(****Input 14 for first 20 fibonacci numbers****)

.code
main proc

	call ReadHex
	mov ecx, eax	;Put input in ecx
	dec ecx			;decrement down 1

	mov eax, 1		;Fibonacci value 1
	call WriteInt	;print value 1
	call CrlF		;move to next line

	mov ebx, 1		;Fibonacci value 2

	L1:
		mov edx, eax		;Move value 1 into edx
		add edx, ebx		;Add value 1 to value 2
		mov eax, ebx		;Replace value 1 with value 2
		mov ebx, edx		;Replace value 2 with the calculated sum

		call WriteInt	;Print sum
		call CrlF		;Move to next line

		loop L1

	invoke ExitProcess,0
main endp
end main