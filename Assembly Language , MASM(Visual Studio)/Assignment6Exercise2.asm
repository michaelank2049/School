INCLUDE Irvine32.inc

.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword

Str_concat proto, source:PTR BYTE, target:PTR BYTE

.data
	targetStr BYTE "ABCDE", 10 DUP(0)
	sourceStr BYTE "FGH", 0
	
	msg1 BYTE " & ",0
	msg2 BYTE " concatenated is: ",0

.code
main proc
	
	mov edx, OFFSET targetStr			; Print message
	call WriteString
	mov edx, OFFSET msg1
	call WriteString
	mov edx, OFFSET sourceStr
	call WriteString
	mov edx, OFFSET msg2
	call WriteString

	INVOKE Str_concat, ADDR sourceStr, ADDR targetStr			; Call Str_concat

	mov edx, OFFSET targetStr			; Print concatenated strings
	call WriteString
	call crlf

	invoke ExitProcess,0
main endp



;---------------------------------------------------------
Str_concat proc uses esi edi, source:PTR BYTE, target:PTR BYTE
;
; Concatenates a string.
; Receives: source and target strings to be concatenated
; Returns: nothing but now the strings are concatenated
;---------------------------------------------------------

	mov ecx, LENGTHOF sourceStr				; Set counter

	mov esi, source
	mov edi, target
	add edi, 5
	cld
	rep movsb					; Concatenate source string to target string

	ret

Str_concat endp




end main