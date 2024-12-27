Include Irvine32.inc

.data
    n = 1000                        ; 1000 is max
    n_terminal = 31                 ; terminal case because 32 * 32 is 1024 and outside array
    prime BYTE n DUP(?)             ; initiliaze array

.code
main PROC
    mov edi, OFFSET prime+2         ; start at 2
    mov ecx, n-2                    ; mov 998 into ecx
    mov eax, 1                      ; use this to compare values

    L1:                             ; copy all 998 values into array 
        mov prime[edi], al           
        inc edi
        dec ecx
        jnz L1

    mov WORD PTR [prime], cx  
    mov esi, eax   

    loopSieve:                      ; sieve through values to find primes
        inc esi                 
        cmp esi, n_terminal    
        ja  endSieve               
        cmp prime[esi], al         
        jne loopSieve     
        mov edi, esi               
        imul edi, edi   

    endSieve:                       ; mov 1 to esi if esi is above the terminal case
        mov esi,eax            

    printLoop:                      ; prints the primes
        inc esi
        cmp esi, n
        jae endLoop
        cmp BYTE PTR prime[esi], 1 
        jne printLoop  
        mov eax, esi
        call WriteDec               
        call Crlf
        jmp printLoop

    endLoop:
        exit

main ENDP
END main