#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h> 
#include <time.h>

int main(){

	mkfifo("./Pipes/FIFO1",0666); 
	
	srand(time(NULL));
	int fp=open("./Pipes/FIFO1",1); //fp 
	
	char chars[2];
	int rdm = rand()%10;
	sprintf(chars,"%d",rdm); //chars
	
	write(fp,chars,sizeof(chars));

	printf("Sent\n");

	close(fp);

	/*LEEMOS FIFIO2*/

	int num = -1;

	printf("Waiting ...");

	while( num == -1){
		
		fp=open("./Pipes/FIFO2",0);

		if(read(fp,chars,sizeof(chars))!=-1){
			num=atoi(chars);
		}

	}

	printf("\n* Factorial %d:  %d\n",rdm,num);

	execl("/bin/rm", "rm", "./Pipes/FIFO1", NULL);
	return 0;
}
