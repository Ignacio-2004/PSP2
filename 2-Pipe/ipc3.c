#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h> 
#include <time.h>

void main(){

	int fd[2];
	char chars[10];
	int nums[2];
	
	pipe(fd);
	
	if(fork()!=0){
		//Padre
		
		close(fd[1]);
		
		for(int i=0;i<2;i++){

			read(fd[0],chars,sizeof(chars));
			
			nums[i]= atoi(chars);
		}
		
		printf("%d + %d = %d \n",nums[0],nums[1],nums[0]+nums[1]);
		printf("%d - %d = %d \n",nums[0],nums[1],nums[0]-nums[1]);
		printf("%d * %d = %d \n",nums[0],nums[1],nums[0]*nums[1]);
		printf("%d / %d = %d \n",nums[0],nums[1],nums[0]/nums[1]);
		
		wait(NULL);
		
	}else{
		//Hijo
		
		srand(time(NULL));
		
		for (int i=0;i<2;i++){
			nums[i]=rand()%50;
			
			sprintf(chars,"%d",nums[i]);
			write(fd[1],chars,sizeof(chars));
		}
		
		close(fd[0]);
		
	}
}
