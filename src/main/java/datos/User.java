package datos;

public enum User {

    USUARIO_GERENTE(
            "H500176",
            "Admin1234",
            "CID SALAZAR JESSICA (GERENTE FORUM)"
    ),
    USUARIO_GERENTE2(

            "H510768",
            "Admin1234",
            "LOBOS MORENO CAMILO IGNACIO (GERENTE FORUM)"
    ),
    USUARIO_SUBGERENTE(

            "H500103",
            "Admin1234",
            "HERNANDEZ GONZALEZ CRISTIAN (SUBGERENTE FORUM)"
    ),
    USUARIO_EJECUTIVOPOMPEYO(

            "H500086",
            "Admin1234",
            "ROJAS SANTIBANEZ JOSE JACOB (EJECUTIVO)"
    ),
    USUARIO_EJECUTIVOPORTILLOSA(

            "H502810",
            "Admin1234",
            "LLANOS MARTELL JUAN CARLOS (EJECUTIVO)"
    ),
    USUARIO_JEFECOMERCIAL2(

            "H500267",
            "Admin1234",
            "MACAYA TAPIA JOHANNA DENISSE (JEFE COMERCIAL)"
    ),
    USUARIO_JEFECOMERCIAL3(

            "H500292",
            "Admin1234",
            "PARADA LUENGO RODRIGO CRISTIAN (JEFE COMERCIAL)"
    ),
    USUARIO_JEFECOMERCIAL4(

            "H500310",
            "Admin1234",
            "PAILAHUAL ZAMORANO PABLA CRISTINA (JEFE COMERCIAL)"
    ),
    USUARIO_RECUPERACLAVE(
            "",
            "",
            ""
    ),
    USUARIO_INVALIDO(
            "H23422",
            "LRq3424",
            ""
    ),
    USUARIO_POLO(
            "H500061",
            "Admin1234",
            "REYES REBOLLEDO JUAN LEONIDAS"
    ),
    USUARIO_POLO2(
            "H500244",
            "Admin1234",
            "AMPUERO LARENAS ALEJANDRA LORETO"
    ),
    USUARIO_POLO3(
            "H502681",
            "Admin1234",
            "VILLANUEVA BARRERA DANIELA IVONNE"
    ),
    USUARIO_POLO4(
            "H513808",
            "Admin1234",
            "MURILLO GONZALEZ MICHEL BASTIAN"
    ),
    USUARIO_CURSEWEB(

            "H500176",
            "Admin1234",
            "CID SALAZAR JESSICA ( GERENTE FORUM )"
    );

    public String rutUsuario;
    public String password;
    public String nombre;

    User(String rutUsuario, String password, String nombre) {
        this.rutUsuario = rutUsuario;
        this.password = password;
        this.nombre = nombre;
    }


}
