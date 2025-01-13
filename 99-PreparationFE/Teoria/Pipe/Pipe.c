#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h> 

void main(){

    int fd[2];
    pipe(fd);
    int num;

    if(fork()==0){//Dad

        close(fd[1]);//Cerramos el escribir
        read(fd[0],&num,sizeof(int));
        printf("%d \n",num);
        wait(NULL);

    }else{//Son

        num=4;
        close(fd[0]);//Cerramos el leer
        write(fd[1],&num,sizeof(int));
        sleep(1);
    }

}