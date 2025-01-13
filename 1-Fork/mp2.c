#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>

void main() {

  pid_t pidF1, pidF2;
  
  pidF1 = fork(); 
  if(pidF1==0){ //Hijo1
  
  	pidF2=fork(); //Se crea Hijo2
  	
  	if (pidF2==0){
  		printf("Soy P3(Nieto) y mi pid es: %d y el de mi padre es: %d \n",getpid(),getppid());
  	}
  	else{
		wait(NULL);
  		printf("Soy P2(Hijo) y mi pid es: %d y el de mi padre es: %d \n",getpid(), getppid());
  	}
  }
  else{ //Padre
  	wait(NULL);
  	printf("Soy P1(Padre) y mi pid es: %d y el de mi hijo es: %d \n",getpid(),pidF1);
  }
}
