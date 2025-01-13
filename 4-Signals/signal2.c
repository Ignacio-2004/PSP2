#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h> 
#include <time.h>
#include <signal.h>
#include <sys/wait.h>

int nv = 5;

void wakeUp(){
    
    printf("Han trasncurrido: %d\'\' \n",nv);
    
    nv +=5;

}

void main(){

    signal(SIGALRM,wakeUp);

    while(1){
        
        alarm(5);
        pause();

    }

    exit(0);

}