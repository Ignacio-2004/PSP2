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

void reading(){

    fn = open("./FIFO1",0);

    read(fn,&num,sizeof(int));

    close(fn);
}

int calc(int num2){

    if(num2==1){
        return 1;
    }else{
        return calc(num2-1)*num2;
    }

}

void writing(){

    fn=open("./FIFO1",1);

    write(fn,&num,sizeof(int));

}

void main(){

    reading();

    num=calc(num);

    writing();

}