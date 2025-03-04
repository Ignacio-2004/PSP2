#include <stdio.h>
#include <signal.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>

/* Función para gestión de señales*/
void manejador( int numsenal )
{
 printf("Proceso hijo con pid %d recibe señal número..%d\n", getpid(),numsenal);
 
}

int main()
{
  int pid_hijo;  
  pid_hijo = fork(); //creamos proceso hijo   
  
  
  switch(pid_hijo)
  {
     case -1:
          printf( "Error al crear el proceso hijo...\n");
          exit(-1);        
     case 0:   //HIJO     	         
          signal(10, manejador); //Función manejadora de la señal
          pause(); //Para un segundo
          break;    
     default: //Proceso PADRE envia 2 señales
          sleep(1);
          kill(pid_hijo, 10);//Envío de señal
          sleep(1);
          break;
  } 
  return 0;
}
