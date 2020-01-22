package datos;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @autor Juan C. Ramos P Inovabiz
 */
public enum Clientes {

    CLIENTE_BUSQUEDA(
            "15361838-0",
            "Julian",
            "Martinez",
            "Prieto",
            "9-08-1991",
            "987654321",
            "correo@correo.com"
    ),
    CLIENTE_1(
            "10239468-2",
            "Jose",
            "Ramos",
            "Tua",
            "2-02-1987",
            "987654321",
            "correo@correo.com"
    ),
    CLIENTE_2(
            "10301655-k",
            "Patricio",
            "Villanueva",
            "Quintanilla",
            "1-08-1978",
            "987654321",
            "correo@correo.com"
    ),
    CLIENTE_3(
            "10367149-3",
            "Armando",
            "Figueredo",
            "Mujica",
            "28-08-1992",
            "987654321",
            "correo@correo.com"
    ),
    CLIENTE_4(
            "15629958-8",
            "Pedro",
            "Jerez",
            "Valenzuela",
            "3-12-1994",
            "987654321",
            "correo@correo.com"
    ),
    CLIENTE_5(
            "15737827-9",
            "Maria",
            "Romina",
            "Gutierrez",
            "16-07-1991",
            "987654321",
            "correo@correo.com"
    ),
    CLIENTE_6(
            "20433627-k",
            "Marta",
            "Santeliz",
            "del Toro",
            "20-07-1990",
            "987654321",
            "correo@correo.com"


    ),
    CLIENTE_7(
            "20503307-6",
            "Pedro",
            "Angulo",
            "Ramirez",
            "20-07-1990",
            "987654321",
            "correo@correo.com"


    ),
    CLIENTE_8(
            "20566535-8",
            "Juan",
            "Jose",
            "Perez",
            "20-07-1990",
            "987654321",
            "correo@correo.com"


    ),
    CLIENTE_9(
            "15336473-7",
            "Mireya",
            "Valderrama",
            "de Andreis",
            "20-07-1990",
            "987654321",
            "correo@correo.com"


    ),
    CLIENTE_10(
            "12951466-3",
            "Josefina",
            "Moraga",
            "Venegas",
            "20-07-1990",
            "987654321",
            "correo@correo.com"


    ),
    CLIENTE_11(
            "15018602-1",
            "Luis",
            "Martinez",
            "Prieto",
            "20-07-1990",
            "987654321",
            "correo@correo.com"


    ),
    CLIENTE_12(
            "13989061-2",
            "Ramon",
            "Ramirez",
            "Ramos",
            "20-07-1990",
            "987654321",
            "correo@correo.com"


    ),
    CLIENTE_13(
            "20433627-k",
            "Rolando",
            "Santeliz",
            "Villanueva",
            "20-07-1990",
            "987654321",
            "correo@correo.com"


    ),
    CLIENTE_14(
            "13908778-k",
            "Patricio",
            "San Martin",
            "Miranda",
            "20-07-1990",
            "987654321",
            "correo@correo.com"


    ),
    CLIENTE_15(
            "13850930-3",
            "Luis",
            "Santeliz",
            "Valenzuela",
            "20-07-1990",
            "987654321",
            "correo@correo.com"


    ),
    CLIENTE_16(
            "13787794-5",
            "Carlos",
            "Santeliz",
            "Holanda",
            "20-07-1990",
            "987654321",
            "correo@correo.com"


    ),
    CLIENTE_17(
            "13635657-7",
            "Marta",
            "Santeliz",
            "Tua",
            "20-07-1990",
            "987654321",
            "correo@correo.com"


    ),
    CLIENTE_18(
            "13240533-6",
            "Roberto",
            "Figueroa",
            "Colmenarez",
            "20-07-1990",
            "987654321",
            "correo@correo.com"


    ),
    CLIENTE_19(
            "13130570-2",
            "Luisa",
            "Santeliz",
            "Quintanilla",
            "20-07-1990",
            "987654321",
            "correo@correo.com"


    );

    public String rutCliente;
    public String nombreCliente;
    public String apellidoP;
    public String apellidoM;
    public String fechaNacimiento;
    public String telefono;
    public String email;

    Clientes(String rutCliente, String nombreCliente, String apellidoP, String apellidoM, String fechaNacimiento, String telefono, String email) {
        this.rutCliente = rutCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.email = email;
    }

    private static final List<Clientes> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Clientes randomLetterClient()  {

        return VALUES.get(RANDOM.nextInt(SIZE));

    }

}
