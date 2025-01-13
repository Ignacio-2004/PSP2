#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h> 
#include <time.h>

int main(){
	
	char looking[1];
	int num=-1;
	int fp;
	
	printf("Waiting ... \n");
	
	while(num==-1){
		fp = open ("./Pipes/FIFO1",0);
		
		if(read(fp,looking,sizeof(looking))!=-1){
			num=atoi(looking);
		}
	}

	close(fp);

	printf("Cheked.\n");

	/*ENVIO EL RESULTADO*/
	int factorial=1;
	int i = 2;
	while(i<=num){
		factorial=factorial*i;
		i++;
	}
    
	mkfifo("./Pipes/FIFO2",0666);
	
	fp=open("./Pipes/FIFO2",1);

	char chars[7];

	sprintf(chars,"%d",factorial);

	write(fp,chars,sizeof(chars));
	printf("Sent. \n");

	execl("/bin/rm", "rm", "./Pipes/FIFO2", NULL);
	return 0;
}

