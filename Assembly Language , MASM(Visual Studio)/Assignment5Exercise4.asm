INCLUDE Irvine32.inc

.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword

.data
	key BYTE -2,4,1,0,-3,5,2,-4,-4,6
	keySize = $ - key
	plainText BYTE "Avengers Infinity War is better than Endgame",0
	msg1 BYTE "The cyphertext text is: ",0
	msg2 BYTE "The encrypted text is: ",0
	plainText2 BYTE "Dogs are the best animal",0

.code
main proc
	call clrscr

	mov	edx,OFFSET msg1				; Prints message 1 and original text
	call WriteString
	mov edx, OFFSET plainText
	call WriteString
	call Crlf

	mov esi, OFFSET plainText

	L1:
		mov edi, OFFSET key
		mov ecx, keySize
		call Encryption
		jnz L1

	mov edx, OFFSET msg2			; Prints message 2 and encrypted text 
	call WriteString
	mov edx,OFFSET plainText
	call WriteString
	call Crlf

	;-------------------------------------------------------------------------

	mov	edx,OFFSET msg1				; Prints message 1 and original text
	call WriteString
	mov edx, OFFSET plainText2
	call WriteString
	call Crlf

	mov esi, OFFSET plainText2

	L2:
		mov edi, OFFSET key
		mov ecx, keySize
		call Encryption
		jnz L2

	mov edx, OFFSET msg2			; Prints message 2 and encrypted text 
	call WriteString
	mov edx,OFFSET plainText2
	call WriteString
	call Crlf



	invoke ExitProcess,0
main endp




;---------------------------------------------------------
Encryption PROC
;
; Encrypts/Decrypts a string.
; Receives: ESI points to string, EDI points to key array
; Returns: nothing, but buffer is encrypted
;---------------------------------------------------------
	
	L1:								; Find procedure for each key value 
		push ecx
		
		cmp BYTE PTR[esi], 0		; See if key value is 0
		je L4

		mov cl, [edi]				; See if key value is positive 
		cmp cl, 0
		jge L2

		rol BYTE PTR[esi], cl		; Negative key value rotates text left
		jmp L3

		L2:							; Positive key value rotates text right
			ror BYTE PTR[esi], cl

		L3:							; Continue moving through text and key till done 
			inc esi
			inc edi
			pop ecx

			loop L1

			or eax, 1
			jmp L5

		L4:							; pop keySize if no text movement
			pop ecx

		L5:							; return to main
			ret



Encryption endp

end main
