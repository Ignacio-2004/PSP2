#include <stdio.h>  
#include <stdlib.h> 
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h> 
#include <time.h>
#include <signal.h>
#include <sys/wait.h>

int fd[2];
int num;

void catchAlarm(){

    read(fd[0],&num,sizeof(int));
                
    printf("%d : %d \n",getpid(),num);
}

void main(){

    
    pipe(fd);
    pid_t p1,p2;

    p1=fork();

    if(p1!=0){

        p2=fork();

        if(p2!=0){//P1

            close(fd[0]); //cierro el leer

            printf("Introduzca numeros, el programa terminara al escribir 0.\n");

            do{
                
                scanf("%d",&num);
                
                write(fd[1],&num,sizeof(int));

                if(num==0){
                    kill(p1, SIGKILL);
                    kill(p2, SIGKILL);
                    break;
                }else{
                    if(num%2==0){
                    kill(p1,14);
                }else{
                    kill(p2,14);
                }
                }

            }while(1);

        }else{ //P3

            signal(14,catchAlarm);

            do{

            }while(1);
        }

    }else{ //P2

        close(fd[1]); //cierro el escribir

        signal(14,catchAlarm);

        do{

        }while(1);
        
    }

}