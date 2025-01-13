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

void writing(){
    
    fd = open("./FIFO",1);

    write(fd,"HOLA MUNDO",sizeof("HOLA MUNDO"));

    close(fd);

}

int main(){

    writing();
    
    return 1;
}