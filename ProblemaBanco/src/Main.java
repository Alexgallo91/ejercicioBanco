import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Persona persona1 = new Persona();
		persona1.setCuenta("1");
		persona1.setMonto(4000);
		persona1.setNombre("Abraham");

		Persona persona2 = new Persona();
		persona2.setCuenta("2");
		persona2.setMonto(5000);
		persona2.setNombre("Brenda");

		Persona persona3 = new Persona();
		persona3.setCuenta("3");
		persona3.setMonto(3000);
		persona3.setNombre("Jose");

		Scanner sc = new Scanner(System.in);
		int cuenta;
		Persona arregloPersona[] = new Persona[3];
		Persona personaActual = null;
		int opcionPrincipal;
		double montoFinal = 0;
		arregloPersona[0] = persona1;
		arregloPersona[1] = persona2;
		arregloPersona[2] = persona3;

		while (true) {
			System.out.println("----------------------------");
			System.out.println("Bienvenido al banco elija una opcion\n"+
						       "1. ingresar numero de cuenta:\n" + 
							   "2. salir");
			opcionPrincipal = sc.nextInt();
			
			if(opcionPrincipal == 2)
			{
				System.out.println("Monto final del dia: ");
				for(int i = 0; i < arregloPersona.length; i++)
				{
					montoFinal += arregloPersona[i].getMonto();
				}
				System.out.print(montoFinal);
				break;
			}
			
			if(opcionPrincipal != 1 && opcionPrincipal != 2)
			{
				System.out.println("Intente de nuevo");
			}
			
			if(opcionPrincipal == 1)
			{
				System.out.println("Ingrese el numero de cuenta: ");
				cuenta = sc.nextInt();
				
				for (int i = 0; i < arregloPersona.length; i++) {
					if (String.valueOf(cuenta).equals(arregloPersona[i].getCuenta())) {
						personaActual = arregloPersona[i];
						System.out.println("Bienvenido " + arregloPersona[i].getNombre());
						break;
					} else {
						personaActual = null;
					}
				}

				if (personaActual == null) {
					System.out.println("lo sentimos, esa cuenta no existe\n");
				} else {
					do {
						int opcion = 0;
						double monto = 0;
						System.out.println("Que operacion desea realizar?\n");
						System.out.println("\n1. Deposito\n" + 
										   "2. Retiro\n" + 
										   "3. Salir\n" + 
										   "opcion: ");

						opcion = sc.nextInt();

						switch (opcion) {
						case 1: // Deposito
							System.out.println("Ingrese el monto a depositar: ");
							monto = sc.nextDouble();
							System.out.println("Monto actual: " + personaActual.getMonto());
							System.out.println("Monto ingresado: " + monto);
							personaActual.setMonto(personaActual.getMonto() + monto);
							System.out.println("Monto actual: " + personaActual.getMonto());
							break;

						case 2: // Retiro
							System.out.println("Ingrese el monto a retirar: ");
							System.out.println("Monto actual: " + personaActual.getMonto());
							monto = sc.nextDouble();
							if(monto > personaActual.getMonto())
							{
								System.out.println("Tiene que se un monto menor a lo ahorrado");
							}
							else
							{
								System.out.println("Monto ingresado: " + monto);
								personaActual.setMonto(personaActual.getMonto() - monto);
								System.out.println("Monto actual: " + personaActual.getMonto());
							}
							break;
						case 3: 
							System.out.println("Muchas gracias por su preferencia. Vuelva pronto.");
							break;
						}
						if(opcion == 3)
						{
							break;
						}
					} while (true);//fin de ciclo

				}//fin de else
			}

		}//fin de ciclo

	}

}
