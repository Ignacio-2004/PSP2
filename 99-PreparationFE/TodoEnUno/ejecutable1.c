#include <stdio.h>  
#include <stdlib.h> 
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h> 
#include <time.h>
#include <signal.h>
#include <sys/wait.h>

void newPipe(){

    int fd[2];
    pipe(fd);

    if(fork()==0){

        close(fd[0]); //Lectura


        write(fd[1],"Hola",sizeof("Hola"));

        close(fd[1]); //Escritura

    }else{

        close(fd[1]); //Escritura

        char txt[15] ;

        read(fd[0],txt,sizeof(txt));
        printf("%s",txt);

        printf("\n");

        close(fd[0]); //Lectura

    }

}

int main(){

    newPipe();
    
    return 1;
}