#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h> 
#include <time.h>

int main(){

    int fp = open("./Pipes/FIFO21",1)

    Close(fp);

    int fp = open("./Pipes/FIFO21",0);

    Close(fp);

}