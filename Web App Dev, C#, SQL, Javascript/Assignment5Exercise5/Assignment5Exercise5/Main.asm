Include Irvine32.inc
n=1000
n_terminal=31
    

.data
    prime BYTE n DUP(?)

.code
main PROC
    mov edi,OFFSET prime+2
    mov ecx,n-2
    mov eax,1
    L1:
        mov [edi], al
        inc edi
        dec ecx
        jnz L1
    mov WORD PTR [prime],cx  
    mov esi,eax   

    sieve_loop:
        inc esi  
        cmp esi,n_terminal
        ja  sieve_end    
        cmp prime[esi],al 
        jne sieve_loop   
        mov edi,esi     
        imul edi,edi   

    flip_loop:
        cmp edi,n     
        jae sieve_loop  
        mov prime[edi],ah 
        add edi,esi      
        jmp flip_loop

    sieve_end:
        mov esi,eax      

    print_loop:
        inc esi
        cmp esi, n
        jae end_print_loop
        cmp BYTE PTR prime[esi], 1 
        jne print_loop   
        mov eax, esi
        call WriteDec      
        call Crlf
        jmp print_loop

    end_print_loop:
        exit

main ENDP
END main