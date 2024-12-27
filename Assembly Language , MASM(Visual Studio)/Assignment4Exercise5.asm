INCLUDE Irvine32.inc

.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword

.data
CaseTable  BYTE   'A'				; lookup value
           DWORD   Process_A		; address of procedure
           BYTE   'B'
           DWORD   Process_B
           BYTE   'C'
           DWORD   Process_C
           BYTE   'D'
           DWORD   Process_D
		   BYTE   'E'
		   DWORD   Process_E
NumberOfEntries = 5

prompt BYTE "Press capital A for 'x AND y', B for 'x OR y', C for 'NOT x', D for 'x XOR y', or E to exit the program: ",0
msgA BYTE "x AND y",0
msgB BYTE "x OR y",0
msgC BYTE "NOT x",0
msgD BYTE "x XOR y",0
msgE BYTE "Exit the program",0

.code
main PROC
	mov  edx,OFFSET prompt		; ask user for input
	call WriteString
	call ReadChar				; read one character
	mov  ebx,OFFSET CaseTable	; point EBX to the table
	mov  ecx,NumberOfEntries 	; loop counter
L1:
	cmp  al,[ebx]				; match found?
	jne  L2						; no: continue
	call NEAR PTR [ebx + 1]		; yes: call the procedure
	call WriteString			; display message
	call Crlf
	jmp  L3						; exit the search
L2:
	add  ebx,5					; point to the next entry
	loop L1						; repeat until ECX = 0

L3:
	exit
main ENDP

Process_A PROC
	mov  edx,OFFSET msgA
	call WriteString
	call Crlf
	ret
Process_A ENDP

Process_B PROC
	mov  edx,OFFSET msgB
	call WriteString
	call Crlf
	ret
Process_B ENDP

Process_C PROC
	mov  edx,OFFSET msgC
	call WriteString
	call Crlf
	ret
Process_C ENDP

Process_D PROC
	mov  edx,OFFSET msgD
	call WriteString
	call Crlf
	ret
Process_D ENDP

Process_E PROC
	mov  edx,OFFSET msgE
	call WriteString
	call Crlf
	ret
Process_E ENDP

END main