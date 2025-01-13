#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h> 
#include <time.h>

void main(){
	
	int fd[2];
	char buffer[100];
	
	pipe(fd);

	if(fork()==0){
		//Hijo
		close(fd[1]);
		read(fd[0],buffer,30);
		printf("H: Mensaje recibido.\nH: %s",buffer);
	
	}else{
		//Padre
		
		time_t hora;
		char *fecha;
		
		time(&hora);
		fecha=ctime(&hora);
		
		close(fd[0]);
		write(fd[1],fecha,30);
		
		printf("P: Mensaje enviado\n");
		
		wait(NULL);
	
	}

}
