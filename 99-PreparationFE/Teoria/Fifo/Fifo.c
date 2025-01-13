#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h>

void main(){

    int fp; //Para poder 
    int num = 4;

    mkfifo("../fifos/FIFO",0666);

    fp = open("../fifos/FIFO", 1);

    write(fp,&num,sizeof(int));

}