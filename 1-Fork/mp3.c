#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>

void main() {
	
	pid_t pidP2, pidP3;
	
	pidP2=fork();
	if(pidP2==0){
		sleep(10);
		printf("P2:Despierto \n");
	}
	else{
		pidP3=fork();
		if(pidP3!=0){
			wait(NULL);
			wait(NULL);
		}else{
			printf("Soy P3 y mi pid es %d y el pid de mi  padre es: %d \n",getpid(),getppid());
		}
	}
}
