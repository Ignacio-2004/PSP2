// Clase CuentaBancaria
// Definición de la cuenta con un saldo inicial y de las operaciones para
//ingresar dinero (método ingresarDinero) y sacar dinero (método sacarDinero)
//de la cuenta
class CuentaBancaria {
 //Saldo inicial de la cuenta
    int saldo = 1000;

    //método sacarDinero:
    // nombre -> persona que realiza la operación
    //importe -> cantidad a retirar
    synchronized void sacarDinero (String nombre, int importe){

        if  (saldo>=importe){
            saldo -= importe;
            system.out.println(nombre+" ha sacado: "+importe+"€");

            //Después de la operación dormir el hilo
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

        }else{

            system.out.println("No se puede realizar la operacion");

        }

    }

    //método ingresarDinero
    //nombre -> persona que realiza la operación
    //importe -> cantidad a retirar
    synchronized void ingresarDinero (String nombre, int importe){

        saldo+=importe;
        system.out.println(nombre+" ha ingresado: "+importe"€");

        //Después de la operación dormir el hilo
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}