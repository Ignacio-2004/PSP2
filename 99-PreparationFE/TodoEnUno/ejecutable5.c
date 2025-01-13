#include <stdio.h>  
#include <stdlib.h> 
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h> 
#include <time.h>
#include <signal.h>
#include <sys/wait.h>

void cathAlrm(){

    printf("\nSignal recived.\n");

}

int main(){

    //kill -l
    //kill mand signal
    //SIGINT ctrl+c

    signal(SIGINT,cathAlrm);

    while(1){
        
    }

}