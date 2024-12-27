INCLUDE Irvine32.inc

.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword

.data

	counter DWORD 0
	msg1 BYTE "Enter a number of number of times the loop will run then press enter: ",0
	msg2 BYTE "The loop ran ",0
	msg3 BYTE " times.",0

.code
main proc

	mov	edx, OFFSET msg1     ; "Enter a number of number of times the loop will run then press enter: "
	call WriteString
	call ReadDec
	mov ecx, eax			 ; Put input in ecx
	call Crlf

	call recursive			 ; Call procedure

	mov	edx, OFFSET msg2     ; "The loop ran "
	call WriteString

	call WriteDec			 ; Print counter

	mov	edx, OFFSET msg3     ; " times."
	call WriteString
	call CrlF				 ; Move to next line

	invoke ExitProcess,0
main endp



recursive proc
	loop increment
	loop exitRecursive

	increment: 
		inc counter
		call recursive

	exitRecursive:
		mov ecx, 0
		ret

recursive endp

end main