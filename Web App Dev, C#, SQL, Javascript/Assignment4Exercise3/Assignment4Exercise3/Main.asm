INCLUDE Irvine32.inc

.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword

.data
	str1 BYTE " in letter grade form is: "

.code
main proc
	mov ecx, 10
	L1:
		mov eax, 50
		mov ebx, 100
		dec ebx
		sub ebx, eax
		xchg ebx, eax
		call RandomRange
		neg ebx
		sub eax, ebx
		call WriteDec
		mov edx, OFFSET str1
		call WriteString
		call CalcGrade

		loop L1

	invoke ExitProcess,0
main endp



CalcGrade proc
	.IF (eax >= 90) && (eax <= 100)
		mov al, 'A'

	.ELSEIF (eax >= 80) && (eax <= 89)
		mov al, 'B'

	.ELSEIF (eax >= 70) && (eax <= 79)
		mov al, 'C'

	.ELSEIF (eax >= 60) && (eax <= 69)
		mov al, 'D'

	.ELSE
		mov al, 'F'

	.ENDIF

	call WriteChar
	call Crlf

	ret

CalcGrade endp

end main

