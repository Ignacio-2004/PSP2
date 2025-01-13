#include <stdio.h>  
#include <stdlib.h> 
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h> 
#include <time.h>
#include <signal.h>
#include <sys/wait.h>

int ra; //RepeatAlarm
int sba; //SecondsBeetwenAlarms

void ask(){

    printf("¿Cuantas alarmas quieres que suenen? : ");
    scanf("%d",&ra);

    printf("¿Cuantos segundnos quieres que haya de intervalo? : ");
    scanf("%d",&sba);

}

void catchAlarm(){

    time_t t = time(NULL);
    char *date;

    date = ctime(&t);

    printf("Alarma recibida a las: %s",date);

}

void main(){
    
    signal(14,catchAlarm);
    
    ask();

    for(int i=0;i<ra;i++){
        
        alarm(sba);
        pause();

    }

    exit(0);
}