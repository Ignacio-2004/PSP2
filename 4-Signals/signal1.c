#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h> 
#include <time.h>
#include <signal.h>
#include <sys/wait.h>

void smensaje(){

    time_t t;
    char *date;

    time(&t);
    date = ctime(&t);

    printf("(S): Fin del proceso %d: %s",getpid(),date);

    exit(0);
    
}

void dActivities (){
    
    time_t t;
    char *date;

    time(&t);
    date = ctime(&t);

    printf("(D): Inicio del proceso %d: %s",getpid(),date);

    wait(NULL);

}

void sActivities (){

    signal(SIGINT,smensaje);
    while(1){}
    
}

void main(){

    
    pid_t sp; //son's pid
    
    sp=fork();

    if (sp==0) {
        
        sActivities();

    }else{

        dActivities();

    }
    exit(0);
}
