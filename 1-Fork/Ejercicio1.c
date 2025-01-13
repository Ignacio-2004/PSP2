#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>

void main() {

  pid_t pidF1;
  
  pidF1 = fork();
  if(pidF1==0){
  	printf("Ignacio Pezuela\n");
  }
  else{
  	wait(NULL);
  	printf("Soy el proceso padre: %d y mi hijo: %d ha terminado \n",getpid(),pidF1);
  }
}
