#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h>

void main(){

    int fp;
    int num=0;

    fp = open("../fifos/FIFO",0);

    while(num==0){

        read(fp,&num,sizeof(int));

    }

    printf("%d",num);

}