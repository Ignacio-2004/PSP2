// Incluye las bibliotecas necesarias para la entrada/salida, creación de archivos, y manipulación de pipes FIFO
#include <stdio.h>      // Para operaciones de entrada/salida como printf
#include <stdlib.h>     // Para funciones generales de propósito como exit
#include <fcntl.h>      // Para operaciones de control de archivos (e.g., open)
#include <string.h>     // Para operaciones con strings (aunque no se usa en este código)
#include <unistd.h>     // Para funciones POSIX como read y close
#include <sys/stat.h>   // Para manipular propiedades de archivos como permisos

int main(void) {
    int fp;                // Descriptor de archivo para el FIFO
    int p, bytesleidos;    // `p` para el resultado de la creación de FIFO y `bytesleidos` para contar los bytes leídos
    char saludo[] = "Un saludo!!!\n", buffer[10];  // `saludo` es un mensaje que no se usa en el código; `buffer` almacena los datos leídos
    // Crea un archivo FIFO llamado "FIFO2" con permisos de lectura y escritura (0666)
    p = mkfifo("FIFO2", S_IFIFO | 0666);  // S_IFIFO indica que es un FIFO y 0666 establece permisos
    // `mkfifo` devuelve 0 si tiene éxito y -1 si hay un error (por ejemplo, si el FIFO ya existe)
    // Bucle infinito para leer continuamente del FIFO
    while(1) {
        // Abre el FIFO para lectura (`0` equivale a O_RDONLY)
        fp = open("FIFO2", 0);  // Si no hay datos, `open` se bloqueará hasta que otro proceso escriba en "FIFO2"
        
        // Lee un byte del FIFO y almacena el resultado en `buffer`
        bytesleidos = read(fp, buffer, 1);  // `read` devuelve el número de bytes leídos; aquí, lee un solo byte (1)
        
        // Mensaje indicando que se está leyendo del FIFO
        printf("Leyendo informacion del pipe FIFO2...");
        
        // Bucle para seguir leyendo mientras `bytesleidos` no sea cero
        while (bytesleidos != 0) {      
            printf("%1c", buffer[0]);  // Imprime el carácter leído (`buffer[0]`), que es el primer byte de `buffer`
            
            // Lee otro byte del FIFO
            bytesleidos = read(fp, buffer, 1);  // Continúa leyendo un byte a la vez hasta que no haya más datos
        }
        
        // Cierra el descriptor de archivo `fp` después de leer todos los datos
        close(fp);  
    }
    return(0);
}
