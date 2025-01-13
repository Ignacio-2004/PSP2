// Incluye las bibliotecas necesarias para entrada/salida, manipulación de archivos y manipulación de pipes FIFO.
#include <stdio.h>      // Para operaciones de entrada/salida como printf
#include <stdlib.h>     // Para funciones generales como exit
#include <fcntl.h>      // Para operaciones de control de archivos (e.g., open)
#include <string.h>     // Para operaciones con strings como strlen
#include <unistd.h>     // Para funciones POSIX como write y close
#include <sys/stat.h>   // Para manipular propiedades de archivos como permisos

int main() {
    int fp;                 // Descriptor de archivo para el FIFO
    char saludo[] = "Un saludo!!!\n";  // Mensaje que se va a enviar al FIFO
    // Abre el FIFO llamado "FIFO2" en modo de solo escritura (1 es equivalente a O_WRONLY)
    fp = open("FIFO2", 1); // Identificador del fichero
    // La función open() retorna un descriptor de archivo. Si el FIFO no existe o no se puede abrir, retorna -1.
    // Muestra un mensaje para indicar que se está enviando información al FIFO
    printf("Mandando información al pipe FIFO...\n");
    
    // Escribe el contenido del mensaje `saludo` en el FIFO
    write(fp, saludo, strlen(saludo));  // `strlen(saludo)` indica el número de bytes que se escriben
    // `write` envía el contenido de `saludo` al FIFO, donde otro proceso puede leerlo.
    // Cierra el descriptor de archivo `fp` después de la escritura
    close(fp);  // Esto libera el descriptor de archivo, permitiendo a otros procesos acceder al FIFO.
    
    return 0;  // Termina el programa con éxito
}
