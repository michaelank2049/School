INCLUDE Irvine32.inc

.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword

.data
	TRUE = 1
	FALSE = 0
	gradeAverage  DWORD ?
	credits       DWORD ?
	OkToRegister  BYTE ?

	msg1 BYTE "Enter grade average: ",0
	msg2 BYTE "Enter credits: ",0

	str1 BYTE "The student can register",0
	str2 BYTE "The student cannot register",0
	str3 BYTE "Invalid Credit Entry "


.code
main PROC

	mov	edx, OFFSET msg1     ; "Enter grade average: "
	call WriteString
	call ReadDec
	mov gradeAverage, eax
	call Crlf
	
	mov	edx, OFFSET msg2    ; "Enter credits: "
	call WriteString
	call ReadDec
	mov credits, eax
	call Crlf

	.IF (credits >= 1) && (credits <=30)	; See if credits are between 1 and 30
		mov ecx, 1
		call mainLoop
	.ELSE									; If not then say invalid
		mov edx, OFFSET str3
		call WriteString
		call Crlf

		exit

	.ENDIF

	mainLoop:
		mov OkToRegister,FALSE

		cmp gradeAverage, 350			; Recoded logic statements
		ja L1
		cmp gradeAverage, 250
		ja L2
		cmp credits, 12
		jbe L1
		jmp L4

		L1:
			mov OkToRegister, TRUE
			jmp L3
			exit
			
		L2:
			cmp credits, 16
			jbe L1
			jmp L4

		L3:
			mov edx, OFFSET str1		; The student can register
			call WriteString
			call Crlf
			exit

		L4:
			mov edx, OFFSET str2		; The student can't register
			call WriteString
			call Crlf
			exit
		exit
		

	invoke ExitProcess,0
main endp
end main