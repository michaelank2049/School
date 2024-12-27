INCLUDE Irvine32.inc

.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword

.data

.code
main proc
	mov	eax,5				
	mov ebx,8
	mov ecx,3
	mov edx,1

	add	eax,ebx	
	add ecx,edx
	sub eax,ecx			

	invoke ExitProcess,0
main endp
end main