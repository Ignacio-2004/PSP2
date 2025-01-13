// Clase HiloSacarDinero
class HiloSacarDinero extends Thread {

 private CuentaBancaria cuenta;
 private String nombre;
 private int cantidad;
 private Scanner keyboard;

 // Constructor de la clase
 HiloSacarDinero(CuentaBancaria micuenta, String nombre, int cantidad)
 {
    this.cuenta=micuenta;
    this.nombre=nombre;
    this.cantidad=cantidad;
    keyboard= new Scanner(System.in);
 }

 public void run() {
    cuenta.sacarDinero(nombre,cantidad);
 }
}