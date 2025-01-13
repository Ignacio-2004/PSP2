#include <stdio.h>  
#include <stdlib.h> 
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h> 
#include <time.h>
#include <signal.h>
#include <sys/wait.h>

int fd;

void reading(){
    
    fd = open("./FIFO",0);

    char txt[1];

    while(read(fd,txt,sizeof(txt))!=0){
        
        printf("%s",txt);

    }
    
    printf("\n");

}

int main(){
    
    mkfifo("./FIFO",0666);

    reading();
    
    return 1;
}