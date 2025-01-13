#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h> 
#include <time.h>

void main(){

	int fd[2];
	int numVueltas=7;
	int contador=0;
	char chars[10];
	
	pipe(fd);
	
	if(fork()==0){
		//Hijo
		
		close(fd[1]);
		int cesta =0;
		
		while (contador<numVueltas){
			
			read(fd[0],chars,sizeof(chars)); //Cojemos el ancho justo del array
			
			contador++;	
			cesta+=atoi(chars);
			
			printf("%s \n",chars);
		}
		printf("----\n%d\n",cesta);
		
	}else{
		//Padre
		
		close(fd[0]);
		
		srand(time(NULL));
		int rdm = rand() % 100;
		
		while (contador<numVueltas){
			
			sprintf(chars,"%d",rdm); //Convertimos el int en char[]
			write(fd[1],chars,sizeof(chars));
			
			rdm=rand() % 100;
			
			contador++;	
			
		}
		
		write(fd[1],"+",sizeof(chars));
		wait(NULL);
	}

}
