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
int number;

void catch12Dad(){}

void catch12 (){

    close(fd[1]); //Write

    read(fd[0],&number,sizeof(number));

    if (number%2==0){

        printf("Número par %d recibido por el proceso P2 con pid %d \n",number,getpid());

    }else{

         printf("Número impar %d recibido por el proceso P3 con pid %d \n",number,getpid());

    }

    kill(getppid(),12);

}


int main (){

    pid_t pidH2, pidH3;

    pipe(fd);

    pidH2=fork();
    switch(pidH2){

        case 0: //Son2

        signal(12,catch12);

        while(1){

            pause();

        }

        break;

        default: //Dad

            pidH3=fork();
            switch(pidH3){

                case 0: //Son3

                signal(12,catch12);

                while(1){

                    pause();

                }

                break;

                default: //Dad

                    close(fd[0]); //READ

                    do{

                        signal(12,catch12Dad);

                        printf("Write a number: ");
                        scanf("%d",&number);
                        write(fd[1],&number,sizeof(number)); //write in the pipe

                        switch(number){

                            case 0: //Send the signal to finish both sons

                                printf("Mandando señal de terminación al proceso hijo P2 con pid %d \n",pidH2);
                                printf("Mandando señal de terminación al proceso hijo P3 con pid %d \n",pidH3);

                                kill(pidH2,9);
                                kill(pidH3,9);

                            break;

                            default:
                                if(number%2==0){ //Send a signal to the child 

                                    kill(pidH2,SIGUSR2);

                                }else{

                                    kill(pidH3,SIGUSR2);

                                }
                                pause(); //To avoid overloap of printf

                        }


                    }while(number!=0);

            }

    }

    printf("Fin del proceso padre con pid %d \n",getpid());
    
    return 0;

}