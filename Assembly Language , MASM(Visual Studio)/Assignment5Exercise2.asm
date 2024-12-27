INCLUDE Irvine32.inc

.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword

.data
			   
	int1 BYTE 34h,12h,98h,74h,06h,0A4h,0B2h,0A2h,19h,68h			
	int2 BYTE 02h,45h,23h,00h,00h,87h,10h,80h,0ADh,0A7h				
	int3 BYTE 91h,0A4h,82h,15h,29h,0DAh,71h,09Ah,01h,24h 
	int4 BYTE 01h,02h,03h,04h,05h,06h,07h,08h,09h,10h
	msg1 BYTE "The difference is: ",0
	difference BYTE 11 DUP(0)

.code
main proc

	mov	esi, OFFSET int1			; first operand
	mov	edi, OFFSET int2			; second operand
	mov	ebx, OFFSET difference		; difference operand
	mov	ecx, LENGTHOF int1   		; number of bytes
	call Extended_Sub

									; Display the difference.
	mov edx, OFFSET msg1
	call WriteString
	mov esi, OFFSET difference
	mov ecx,LENGTHOF difference
	call Display_Sub
	call Crlf

	;-------------------------------------------------------------

	mov	esi, OFFSET int3			; first operand
	mov	edi, OFFSET int4			; second operand
	mov	ebx, OFFSET difference		; difference operand
	mov	ecx, LENGTHOF int3   		; number of bytes
	call Extended_Sub

									; Display the difference.
	mov edx, OFFSET msg1
	call WriteString
	mov esi, OFFSET difference
	mov ecx,LENGTHOF difference
	call Display_Sub
	call Crlf

	invoke ExitProcess,0
main endp



;--------------------------------------------------------
Extended_Sub PROC
;
; Calculates the difference of two extended integers stored 
; as arrays of bytes.
; Receives: ESI and EDI point to the two integers,
; EBX points to a variable that will hold the difference, and
; ECX indicates the number of bytes to be added.
; Storage for the difference must be one byte longer than the
; input operands.
; Returns: nothing
;--------------------------------------------------------
	pushad
	clc

	L1:	
		mov	al, [esi]      			; get the first integer
		sbb	al, [edi]      			; add the second integer
		pushfd              		; save the Carry flag
		mov	[ebx], al      			; store partial sum
		add	esi, 1         			; advance all 3 pointers
		add	edi, 1
		add	ebx, 1
		popfd               		; restore the Carry flag
		loop L1           			; repeat the loop

	mov	byte ptr [ebx],0		; clear high byte of sum
	adc	byte ptr [ebx],0		; add any leftover carry
	popad
	ret
Extended_Sub ENDP



;-----------------------------------------------------------
Display_Sub PROC
;
; Displays a large integer that is stored in little endian 
; order (LSB to MSB). The output displays the array in 
; hexadecimal, starting with the most significant byte.
; Receives: ESI points to the array, ECX is the array size
; Returns: nothing
;-----------------------------------------------------------
	pushad
	
					; point to the last array element
	add esi,ecx
	sub esi,TYPE BYTE
	mov ebx,TYPE BYTE
	
	L1:	
		mov eax,[esi]			; get an array byte
		call WriteHexB			; display it
		sub esi,TYPE BYTE		; point to previous byte
		loop L1

	popad
	ret
Display_Sub ENDP



end main