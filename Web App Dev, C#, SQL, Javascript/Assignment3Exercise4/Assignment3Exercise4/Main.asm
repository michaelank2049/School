INCLUDE Irvine32.inc

.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword

.data
	msg1 BYTE "Enter an integer then press enter: ",0
	msg2 BYTE "Enter an integer then press enter: ",0
	val1 DWORD ?
	val2 DWORD ?
	sum DWORD ?
	Loop_Count = 3

.code
main proc

	mov ecx, Loop_Count
	L1:

		call Clrscr				 ; Clear the screen

		mov dh, 12				 ; move cursor to middle of screen
		mov dl, 35
		call Gotoxy

		mov	edx, OFFSET msg1     ; "Enter an integer then press enter: "
		call WriteString
		call ReadDec
		mov val1, eax
		call Crlf

		mov	edx, OFFSET msg2     ; "Enter an integer then press enter: "
		call WriteString
		call ReadDec
		mov val2, eax
		Call Crlf

		mov eax, val1			 ; Add integers
		add eax, val2
		mov sum, eax
			
		call WriteDec			 ; Displays integers sum

		mov eax, 2000			 ; wait 5 seconds
		call Delay

		call Clrscr				 ; Clear the screen

		loop L1

	invoke ExitProcess,0
main endp
end main