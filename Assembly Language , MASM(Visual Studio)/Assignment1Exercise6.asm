;Michael Lankford
;CSCI 2331
;Assignment 1 Exercise 6

ExitProcess proto

.data
	firstval  qword 20002000h
	secondval qword 11111111h
	thirdval  qword 22222222h
	sum qword 0

.code
main proc
	mov	rax,firstval				
	add	rax,secondval		
	add rax,thirdval
	mov sum,rax				

	call ExitProcess
main endp
end