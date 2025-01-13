#include <stdio.h>  //F
#include <stdlib.h> //F
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h> 
#include <time.h>
#include <signal.h>
#include <sys/wait.h>

void cathTry(){

    time_t t;
    char *date;

    time(&t);
    date=ctime(&t);

    FILE *file = fopen("./tries.txt","a");

    if (file == NULL) {
        perror("Error al abrir el archivo");
        return;
    }

    fprintf(file,"Señal SIGNT recogida a las: %s \n",date);

    fclose(file);

}

void main(){
    
    signal(2,cathTry);

    while(1){}

}