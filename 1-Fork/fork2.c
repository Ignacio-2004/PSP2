#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
void main()
{
	pid_t pid1, pid2, pid3, pid4;

	pid1=fork();
	printf("PID: %d PPID: %d \n",getpid(),getppid());
	if(pid1==0){
		pid2=fork();
		if(pid2==0){
			pid3=fork();
			printf("PID: %d PPID: %d \n",getpid(),getppid());
			if(pid3!=0){wait(NULL);}
		}else{wait(NULL);}
	}else{wait(NULL);}
}
