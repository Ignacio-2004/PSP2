#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
void main(){
	
	pid_t acumulador=getpid();
	
	if(fork()!=0){ //P1
	
		
		if(getpid()%2==0){
			printf("P1: %d \n",acumulador+=100);
		}else{
			printf("P1: %d \n",acumulador-=100);
		}
		
		wait(NULL);
		
		if(fork()!=0){//P1
		
			wait(NULL);
			
			}else{ //P3
			
				if(fork()!=0){//P3
				
					if(getpid()%2==0){
						printf("P3: %d \n",acumulador+=100);
					}else{
						printf("P3: %d \n",acumulador-=100);
					}
					wait(NULL);
				
				}else{ //P4
				
					if(getpid()%2==0){
						printf("P4: %d \n",acumulador+=100);
					}else{
						printf("P4: %d \n",acumulador-=100);
					}
					sleep(10);
				
				}
			
			}
	}else{ //P2
		if(fork()!=0){//P2
		
			if(getpid()%2==0){
				printf("P2: %d \n",acumulador+=100);
			}else{
				printf("P2: %d \n",acumulador-=100);
			}
			
			wait(NULL);
			
		}else{ //P5
			
			if(getpid()%2==0){
				printf("P5: %d \n",acumulador+=100);
			}else{
				printf("P5: %d \n",acumulador-=100);
			}
			sleep(10);
			
		}
		
	}

}
