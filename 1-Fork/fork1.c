#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
void main()
{
	pid_t pid1, pid2;
	
	pid1=fork();
	pid2=fork();

	if(getpid()%2==0){
		printf("Mi pid es: %d y el de mi padre es: %d \n",getpid(),getppid());
	}else{
		printf("Mi pid es: %d \n",getpid());
	}
	if (pid2!=0){wait(NULL);}
	if (pid1!=0){wait(NULL);}
}
