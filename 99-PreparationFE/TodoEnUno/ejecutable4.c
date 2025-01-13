#include <stdio.h>  
#include <stdlib.h> 
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h> 
#include <time.h>
#include <signal.h>
#include <sys/wait.h>

void signalRecived(){
    printf("Hi!!!\n");
}

int main(){

    pid_t sp = fork();

    switch(sp){
        
        case 0:

            signal(12,signalRecived);
            while(1){

                pause();

            }
            
        break;

        default:

            while(1){

                sleep(5);
                kill(sp,12);

            }



    }


    return 1;
}