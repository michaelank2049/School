INCLUDE Irvine32.inc

.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword

Str_nextWord proto, targetString:PTR BYTE, char:BYTE

.data
	target BYTE "Johnson,Calvin",0

.code
main proc
	

	INVOKE Str_nextWord, ADDR target, ','
	

	invoke ExitProcess,0
main endp



;---------------------------------------------------------
Str_nextWord proc uses esi, targetString:PTR BYTE, char:BYTE
;
; Concatenates a string.
; Receives: source and target strings to be concatenated
; Returns: nothing but now the strings are concatenated
;---------------------------------------------------------

	mov al, char
	mov esi, targetString
	cld

	L1:
		lodsb
		cmp al, 0
		je L3
		cmp al, char
		jne L1

	L2:
		mov BYTE PTR [esi-1], 0
		mov eax, esi
		jmp Exitprocedure

	L3:
		or al, 1

	Exitprocedure:
		ret


Str_nextWord endp


end main
