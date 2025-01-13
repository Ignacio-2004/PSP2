#include <stdio.h>  
#include <stdlib.h> 
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h> 
#include <time.h>
#include <signal.h>
#include <sys/wait.h>

int fn;
int num;

void writeProcess(){

    srand(time(NULL));

    num = rand() % 10;

    printf("%d",num);

    fn = open("./FIFO1",1);

    printf("Send.\n");
    
    write(fn,&num,sizeof(int));

    close(fn);

}

void reading(){

    fn = open("./FIFO1",0);

    read(fn,&num,sizeof(int));

    printf("R: %d\n",num);
}

void main(){

    mkfifo("./FIFO1",0666);
    
    writeProcess();

    printf("Waiting ... \n");

    reading();


}