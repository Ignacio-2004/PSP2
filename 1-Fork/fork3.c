#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
void main(){
	
	pid_t P1, P2;
	
	P1=getpid();
	printf("P1: %d \n",getpid());
	
	if(fork()!=0){
		//P1
		
		wait(NULL);
	}else{
		//P2
		printf("P2: %d \n",getpid());
		P2=getpid();
		
		if(fork()!=0){
			//P2
			
			wait(NULL);
				
				
			if(fork()!=0){
				//P2
					
				wait(NULL);
			}else{
				//P4
				printf("P4: %d \n P1: %d \n",getpid(),P1);
				
				if(fork()!=0){
					//P4
					wait(NULL);
				}else{
					//P6
					printf("P6: %d \n P2: %d \n",getpid(),P2);
				}
					
			}
			
		}else{
			//P3
			
			printf("P3: %d \n P1: %d \n",getpid(),P1);
			
			if(fork()!=0){
				//P3
				wait(NULL);
			}else{
				//P5
					
				printf("P5: %d \n P2: %d \n",getpid(),P2);
			}
			
		}
	}
}
